package de.abrandl.regex.grammar;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import de.abrandl.regex.grammar.tree.*;

class RegexTreeTransformer {

	static RegexTreeTransformer parse(String regex) throws RegexParsingException {
		return new RegexTreeTransformer(regex);
	}

	private final RegexParser parser;
	private CommonTree tree;

	private RegexTreeTransformer(String input) throws RegexParsingException {
		super();
		RegexLexer regexLexer = new RegexLexer(new ANTLRStringStream(input));
		parser = new RegexParser(new CommonTokenStream(regexLexer));

		try {
			tree = (CommonTree) parser.parse().getTree();
		} catch (RecognitionException e) {
			throw new RegexParsingException(e);
		}

		regexLexer.checkErrors();
		parser.checkErrors();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		walk(tree, builder);

		return builder.toString();
	}

	public RegexNode getRegexTree() throws RegexParsingException {
		RegexNode result = buildRegexTree(tree);
		if (result instanceof Concatenation && result.getChildren().isEmpty()) {
			// special case: use Empty
			result = new Empty();
		}
		return result;
	}

	private RegexNode buildRegexTree(CommonTree inputTree) throws RegexParsingException {
		final int childCount = inputTree.getChildCount();
		final int tokenType = inputTree.getType();

		RegexNode[] childTrees = new RegexNode[childCount];
		buildRegexTreeForChildren(inputTree, childTrees);

		switch (tokenType) {
		case RegexParser.ALTERNATIVE:
			return new Alternative(childTrees);
		case RegexParser.GROUP:
			return new MatchGroup(childTrees);
		case RegexParser.CONCATENATION:
			return new Concatenation(childTrees);
		case RegexParser.ONEORMORE:
			return new OneOrMore(childTrees[0]);
		case RegexParser.ZEROORMORE:
			return new ZeroOrMore(childTrees[0]);
		case RegexParser.DOTANY:
			return new DotAny();
		case RegexParser.OPTIONAL:
			return new Optional(childTrees[0]);
		case RegexParser.CHARACTER_CLASS:
			CharacterRange[] ranges = new CharacterRange[childCount];
			for (int i = 0; i < childTrees.length; i++) {
				if (!(childTrees[i] instanceof CharacterRange)) {
					throw new RegexParsingException("Only expected children of type CharacterRange here, others given:"
							+ childTrees[i].getClass());
				}
				ranges[i] = (CharacterRange) childTrees[i];
			}
			return new CharacterClass(ranges);
		case RegexParser.RANGE:

			char start = ((Literal) childTrees[0]).getChars().charAt(0);
			char end = ((Literal) childTrees[1]).getChars().charAt(0);

			return new CharacterRange(start, end);

		case RegexParser.ELEMENT:
			if (childCount == 1) {
				// only atom given
				return childTrees[0];
			} else {
				throw new RuntimeException("unexpected amount of children");
			}
		case RegexParser.LITERAL:
			return new Literal(inputTree.getText());
		default:
			throw new RuntimeException("not yet implemented type: " + inputTree.getType() + ", "
					+ RegexParser.tokenNames[inputTree.getType()]);
		}
	}

	@SuppressWarnings("unchecked")
	private void buildRegexTreeForChildren(CommonTree parent, RegexNode[] childTrees) throws RegexParsingException {
		if (parent.getChildren() != null) {
			int childIndex = 0;
			for (CommonTree child : (List<CommonTree>) parent.getChildren()) {
				RegexNode childTree = buildRegexTree(child);
				childTrees[childIndex] = childTree;
				childIndex++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void walk(CommonTree tree, StringBuilder builder) {

		List<CommonTree> firstStack = new ArrayList<CommonTree>();
		firstStack.add(tree);

		List<List<CommonTree>> childListStack = new ArrayList<List<CommonTree>>();
		childListStack.add(firstStack);

		while (!childListStack.isEmpty()) {

			List<CommonTree> childStack = childListStack.get(childListStack.size() - 1);

			if (childStack.isEmpty()) {
				childListStack.remove(childListStack.size() - 1);
			} else {
				tree = childStack.remove(0);

				String indent = "";

				for (int i = 0; i < childListStack.size() - 1; i++) {
					indent += (childListStack.get(i).size() > 0) ? "|  " : "   ";
				}

				String tokenName = RegexParser.tokenNames[tree.getType()];
				String tokenText = tree.getText();

				builder.append(indent).append(childStack.isEmpty() ? "'- " : "|- ").append(tokenName)
						.append(!tokenName.equals(tokenText) ? "='" + tree.getText() + "'" : "").append("\n");

				if (tree.getChildCount() > 0) {
					childListStack.add(new ArrayList<CommonTree>(tree.getChildren()));
				}
			}
		}
	}

}
