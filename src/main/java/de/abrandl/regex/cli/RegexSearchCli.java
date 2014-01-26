package de.abrandl.regex.cli;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.*;
import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.grammar.RegexParsingException;
import de.abrandl.regex.helpers.DetailsCollector;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;
import de.abrandl.regex.helpers.Timer;
import de.abrandl.regex.lucene.InMemoryLuceneRegexSearchEngine;
import de.abrandl.regex.lucene.LuceneRegexSearchEngine;
import de.abrandl.regex.lucene.LuceneRegexpEngine;
import static com.google.common.base.Preconditions.checkNotNull;

public class RegexSearchCli {

	private final RegexSearchEngine engine;
	private final File docsPath;
	private final Timer timer = new Timer();

	public RegexSearchCli(RegexSearchEngine engine, File docsPath) {
		super();
		this.engine = checkNotNull(engine);
		this.docsPath = checkNotNull(docsPath);
	}

	/**
	 * (re-)create index
	 * 
	 * @throws IOException
	 */
	public void index() throws IOException {
		timer.reset();

		RecursiveFileContentIterator docs = new RecursiveFileContentIterator(docsPath,
				RecursiveFileContentIterator.Strategy.LAZY, null);

		long runtime;
		try (RegexSearchEngine.Writer writer = engine.getWriter()) {

			writer.open();

			timer.start();

			writer.add(docs);

			runtime = timer.stop();
		}

		writeIndexResults(runtime);

	}

	private void writeIndexResults(long runtime) {
		DetailsCollector dc = DetailsCollector.instance;
		dc.put("overall_runtime", runtime);
		dc.put("action", "index");
	}

	private void writeQueryResults(long runtime, Collection<SimpleDocument> docs) {
		DetailsCollector dc = DetailsCollector.instance;

		dc.put("action", "query");
		dc.put("overall_runtime", runtime);
		dc.put("matches", docs.size());
		dc.put("docs_sha1", hash(docs));
	}

	private String hash(Collection<SimpleDocument> docs) {
		List<SimpleDocument> sorted = new ArrayList<SimpleDocument>(docs.size());
		sorted.addAll(docs);
		Collections.sort(sorted, new Comparator<SimpleDocument>() {

			@Override
			public int compare(SimpleDocument arg0, SimpleDocument arg1) {
				return arg0.getIdentifier().compareTo(arg1.getIdentifier());
			}

		});

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");

			for (SimpleDocument doc : sorted) {
				md.update(doc.getIdentifier().getBytes());
			}

			return byteArrayToHexString(md.digest());

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

	private static String byteArrayToHexString(byte[] b) {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

	/**
	 * search matching documents
	 * 
	 * @param regex
	 * @throws IOException
	 * @throws SearchFailedException
	 */
	public void query(String regex) throws SearchFailedException, IOException {
		timer.reset();
		timer.start();
		Collection<SimpleDocument> result = engine.search(regex);

		long runtime = timer.stop();

		writeQueryResults(runtime, result);
	}

	public void explain(String query) throws RegexParsingException, UnsupportedRegexException {
		String explain = engine.explain(query);
		System.out.println(explain);

		RegexComplexity rc = new RegexComplexity(query);

		DetailsCollector.instance.put("explain_plan", explain);
		DetailsCollector.instance.put("automaton_dots", rc.automatonDots());
		DetailsCollector.instance.put("number_of_states", rc.getNumberOfStates());
		DetailsCollector.instance.put("number_of_transitions", rc.getNumberOfTransitions());
		DetailsCollector.instance.put("length", rc.getLength());
		DetailsCollector.instance.put("width", rc.getWidth());
	}

	/**
	 * 
	 * index: -engine (lucene|jgrep|inmemory) -index /tmp/emptydir -docs
	 * /tmp/mydocs -action index query: -engine (lucene|jgrep|inmemory) -index
	 * /tmp/index -docs /tmp/mydocs -action query -query "hello?( world)*"
	 * 
	 * 
	 * @return
	 * @throws RegexParsingException
	 */
	public static void main(String[] args) throws IOException, SearchFailedException, RegexParsingException {
		// create the parser
		CommandLineParser parser = new GnuParser();
		Options options = commandLineOptions();

		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);

			String engineName = line.getOptionValue("engine");
			File index = new File(line.getOptionValue("index"));
			File docs = new File(line.getOptionValue("docs"));

			RegexSearchEngine engine = createEngine(engineName, index, docs);

			RegexSearchCli cli = new RegexSearchCli(engine, docs);

			String action = line.getOptionValue("action");
			switch (action) {
			case "index":

				if (index.isDirectory()) {
					FileUtils.deleteDirectory(index);
					index.mkdirs();
				}

				cli.index();
				break;

			case "query":

				cli.query(line.getOptionValue("query"));
				break;

			case "explain":

				cli.explain(line.getOptionValue("query"));
				break;

			default:
				throw new IllegalArgumentException("unknown action: " + action);
			}

			DetailsCollector.instance.put("heap_size", Runtime.getRuntime().totalMemory());
			DetailsCollector.instance.put("heap_size_max", Runtime.getRuntime().maxMemory());
			DetailsCollector.instance.put("heap_size_free", Runtime.getRuntime().freeMemory());

		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing cli options failed.  Reason: " + exp.getMessage());

			final HelpFormatter formater = new HelpFormatter();
			formater.printHelp("The SampleCLI demonstrates the use of CLI.", options);
		}
	}

	private static RegexSearchEngine createEngine(String name, File index, File docs) throws IOException {
		switch (name) {
		case "jgrep":
			return new ExhaustiveSearchEngine(index);
		case "jgrep-tar":
			return new TarSearchEngine(index);
		case "lucene":
			return new LuceneRegexSearchEngine(Version.LUCENE_46, FSDirectory.open(index));
		case "lucene_regexp":
			return new LuceneRegexpEngine(Version.LUCENE_46, FSDirectory.open(index));
		case "inmemory":
			return new InMemorySearchEngine(docs);
		case "lucene_ram":
			return new InMemoryLuceneRegexSearchEngine(Version.LUCENE_46, docs);
		default:
			throw new IllegalArgumentException("unknown engine: " + name);
		}
	}

	private static Options commandLineOptions() {

		Options options = new Options();

		Option engine = OptionBuilder.withArgName("engine").hasArg().isRequired()
				.withDescription("select either 'jgrep', 'lucene' or 'inmemory' regex search engine").create("engine");

		options.addOption(engine);

		Option index = OptionBuilder.withArgName("index").hasArg().isRequired()
				.withDescription("local path to index directory").create("index");

		options.addOption(index);

		Option action = OptionBuilder.withArgName("action").hasArg().isRequired()
				.withDescription("action is either 'index' or 'query'").create("action");

		options.addOption(action);

		Option query = OptionBuilder.withArgName("query").hasArg()
				.withDescription("if action is 'query' supply regex here").create("query");

		options.addOption(query);

		Option docs = OptionBuilder.withArgName("docs").hasArg()
				.withDescription("if action is 'index' supply path to documents here").create("docs");

		options.addOption(docs);

		return options;

	}

}
