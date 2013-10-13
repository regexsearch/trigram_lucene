package de.abrandl.regex.query;

import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.query.bool.Expression;

public interface QueryTransformation {

	Expression expressionFor(RegexNode regex);

}
