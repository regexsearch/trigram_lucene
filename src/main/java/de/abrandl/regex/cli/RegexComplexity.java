package de.abrandl.regex.cli;

import java.util.Collection;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import de.abrandl.regex.grammar.RegexParser;
import de.abrandl.regex.grammar.RegexParsingException;
import de.abrandl.regex.grammar.tree.*;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import static com.google.common.base.Preconditions.checkNotNull;

public class RegexComplexity {

	private final Automaton automaton;
	private final String regex;

	public RegexComplexity(String regex) {
		this.regex = checkNotNull(regex);
		this.automaton = new RegExp(regex).toAutomaton();

		automaton.reduce();
		automaton.minimize();
		automaton.removeDeadTransitions();
	}

	public String automatonDots() {
		return automaton.toDot();
	}

	public int getNumberOfStates() {
		return automaton.getNumberOfStates();
	}

	public int getNumberOfTransitions() {
		return automaton.getNumberOfTransitions();
	}

	public static void main(String[] args) {

		RegExp re = new RegExp("linux/k.+\\.h");
		Automaton automaton = re.toAutomaton();

		System.out.println(automaton.getNumberOfStates());
		System.out.println(automaton.getNumberOfTransitions());

		automaton.minimize();
		System.out.println(automaton.toDot());

		System.out.println(automaton.getNumberOfStates());
		System.out.println(automaton.getNumberOfTransitions());

	}

	public int getLength() throws RegexParsingException {

		RegexNode ast = RegexParser.parse(regex);

		return ast.accept(new RegexNodeVisitor<Integer>() {

			@Override
			public Integer visit(Literal literal) {
				return literal.getChars().length();
			}

			@Override
			public Integer visit(Alternative alternative) {
				final RegexNodeVisitor<Integer> visitor = this;

				Collection<Integer> it = Collections2.transform(alternative.getChildren(),
						new Function<RegexNode, Integer>() {
							@Override
							public Integer apply(final RegexNode input) {
								return input.accept(visitor);
							}
						});

				int max = Integer.MIN_VALUE;

				for (Integer i : it) {
					if (i > max) {
						max = i;
					}
				}
				return max;
			}

			@Override
			public Integer visit(ZeroOrMore zeroOrMore) {
				return zeroOrMore.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(Optional optional) {
				return optional.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(Concatenation concatenation) {

				int sum = 0;
				for (RegexNode node : concatenation.getChildren()) {
					sum += node.accept(this);
				}
				return sum;

			}

			@Override
			public Integer visit(MatchGroup matchGroup) {
				return matchGroup.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(OneOrMore oneOrMore) {
				return oneOrMore.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(DotAny dotAny) {
				return 1;
			}

			@Override
			public Integer visit(CharacterClass characterClass) {
				return 1;
			}

			@Override
			public Integer visit(CharacterRange characterRange) {
				return 0;
			}

			@Override
			public Integer visit(Empty empty) {
				return 0;
			}

		});

	}

	public int getWidth() throws RegexParsingException {
		RegexNode ast = RegexParser.parse(regex);

		return ast.accept(new RegexNodeVisitor<Integer>() {

			@Override
			public Integer visit(Literal literal) {
				return literal.getChars().length();
			}

			@Override
			public Integer visit(Alternative alternative) {
				int sum = 0;
				for (RegexNode node : alternative.getChildren()) {
					sum += node.accept(this);
				}
				return sum;
			}

			@Override
			public Integer visit(ZeroOrMore zeroOrMore) {
				return zeroOrMore.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(Optional optional) {
				return optional.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(Concatenation concatenation) {

				final RegexNodeVisitor<Integer> visitor = this;

				Collection<Integer> it = Collections2.transform(concatenation.getChildren(),
						new Function<RegexNode, Integer>() {
							@Override
							public Integer apply(final RegexNode input) {
								return input.accept(visitor);
							}
						});

				int max = Integer.MIN_VALUE;

				for (Integer i : it) {
					if (i > max) {
						max = i;
					}
				}
				return max;

			}

			@Override
			public Integer visit(MatchGroup matchGroup) {
				return matchGroup.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(OneOrMore oneOrMore) {
				return oneOrMore.getFirstChild().accept(this);
			}

			@Override
			public Integer visit(DotAny dotAny) {
				return 1;
			}

			@Override
			public Integer visit(CharacterClass characterClass) {
				return 1;
			}

			@Override
			public Integer visit(CharacterRange characterRange) {
				return 0;
			}

			@Override
			public Integer visit(Empty empty) {
				return 0;
			}

		});
	}
}
