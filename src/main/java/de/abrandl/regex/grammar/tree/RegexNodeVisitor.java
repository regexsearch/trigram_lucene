package de.abrandl.regex.grammar.tree;

public interface RegexNodeVisitor<A> {

	A visit(Literal literal);

	A visit(Alternative alternative);

	A visit(ZeroOrMore zeroOrMore);

	A visit(Optional optional);

	A visit(Concatenation concatenation);

	A visit(MatchGroup matchGroup);

	A visit(OneOrMore oneOrMore);

	A visit(DotAny dotAny);

	A visit(CharacterClass characterClass);

	A visit(CharacterRange characterRange);

	A visit(Empty empty);

}
