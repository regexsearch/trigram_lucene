package de.abrandl.regex.cli;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.cli.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.ExhaustiveSearchEngine;
import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.SearchFailedException;
import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;
import de.abrandl.regex.lucene.LuceneRegexSearchEngine;
import static com.google.common.base.Preconditions.checkNotNull;

public class RegexSearchCli {

	private final RegexSearchEngine engine;
	private final File docsPath;

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

		RecursiveFileContentIterator docs = new RecursiveFileContentIterator(docsPath,
				RecursiveFileContentIterator.Strategy.LAZY, null);

		try (RegexSearchEngine.Writer writer = engine.getWriter()) {
			writer.add(docs);
		}

	}

	/**
	 * search matching documents
	 * 
	 * @param regex
	 * @throws IOException
	 * @throws SearchFailedException
	 */
	public void query(String regex) throws SearchFailedException, IOException {
		Collection<SimpleDocument> result = engine.search(regex);

		System.out.printf("matching documents: %d\n", result.size());
	}

	/**
	 * 
	 * index: -engine (lucene|exhaustive) -index /tmp/emptydir -docs /tmp/mydocs
	 * -action index query: -engine (lucene|exhaustive) -index /tmp/index -docs
	 * /tmp/mydocs -action query -query "hello?( world)*"
	 * 
	 * 
	 * @return
	 */
	public static void main(String[] args) throws IOException, SearchFailedException {
		// create the parser
		CommandLineParser parser = new GnuParser();
		Options options = commandLineOptions();

		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);

			RegexSearchEngine engine = createEngine(line);

			File docs = new File(line.getOptionValue("docs"));
			RegexSearchCli cli = new RegexSearchCli(engine, docs);

			String action = line.getOptionValue("action");
			switch (action) {
			case "index":

				cli.index();
				break;

			case "query":

				cli.query(line.getOptionValue("query"));
				break;

			default:
				throw new IllegalArgumentException("unknown action: " + action);
			}
		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing cli options failed.  Reason: " + exp.getMessage());

			final HelpFormatter formater = new HelpFormatter();
			formater.printHelp("The SampleCLI demonstrates the use of CLI.", options);
		}
	}

	private static RegexSearchEngine createEngine(CommandLine line) throws IOException {
		String name = line.getOptionValue("engine");

		switch (name) {
		case "exhaustive":
			return new ExhaustiveSearchEngine();
		case "lucene":
			File index = new File(line.getOptionValue("index"));
			Directory directory = FSDirectory.open(index);
			return new LuceneRegexSearchEngine(Version.LUCENE_44, directory);
		default:
			throw new IllegalArgumentException("unknown engine: " + name);
		}
	}

	private static Options commandLineOptions() {

		Options options = new Options();

		Option engine = OptionBuilder.withArgName("engine").hasArg().isRequired()
				.withDescription("select either 'exhaustive' or 'lucene' regex search engine").create("engine");

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
