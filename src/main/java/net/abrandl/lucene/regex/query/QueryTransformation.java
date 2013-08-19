package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.query.bool.Expression;

public interface QueryTransformation {

	Expression expressionFor(RegexNode regex);

}
