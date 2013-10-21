grammar Regex;

options {
  language  = Java;
  backtrack = true;
  output    = AST;
}

tokens {
  LITERAL;
  EOF;
  ALTERNATIVE;
  GROUP;
  CONCATENATION;
  ONEORMORE;
  ELEMENT;
  ZEROORMORE;
  DOTANY;
  OPTIONAL;
  CHARACTER_CLASS;
  RANGE;
}

@parser::header {
package de.abrandl.regex.grammar;
import de.abrandl.regex.grammar.tree.RegexNode;

/*
* Based on insights (and partly also grammar code) taken from
* https://github.com/bkiers/PCREParser
*/
}

@lexer::header {
package de.abrandl.regex.grammar;
}

@parser::members {
private RegexParsingException exception = null;

@Override
public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	String hdr = getErrorHeader(e);
	String msg = getErrorMessage(e, tokenNames);
	exception = new RegexParsingException(hdr + ":" + msg);
}

public void checkErrors() throws RegexParsingException {
	if (exception != null) {
		throw exception;
	}
}

/**
 * Parses a given regex into an abstract parse tree.
 * @param regex regular expression
 * @returns parse tree of given regex
 * @throws RegexParsingException when an invalid/unrecognized regex was given
 **/
public static RegexNode parse(String regex) throws RegexParsingException {
	return RegexTreeTransformer.parse(regex).getRegexTree();
}
}

@lexer::members {
private RegexParsingException exception = null;

@Override
public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	String hdr = getErrorHeader(e);
	String msg = getErrorMessage(e, tokenNames);
	exception = new RegexParsingException(hdr + ":" + msg);
}

public void checkErrors() throws RegexParsingException {
	if (exception != null) {
		throw exception;
	}
}
}

parse
  :
  regex EOF
    -> regex
  | subject_boundary
  ;

// ALTERNATION
//
//         expr|expr|expr...

regex
  :
  (first_alternative
      -> first_alternative)
  (
    ('|' concatenation)+
      ->
        ^(ALTERNATIVE first_alternative concatenation+)
  )?
  ;

first_alternative
  :
  concatenation
  ;

concatenation
  :
  element*
    ->
      ^(CONCATENATION element*)
  ;

element
  :
  atom '+'
    ->
      ^(ONEORMORE atom)
  | atom '*'
    ->
      ^(ZEROORMORE atom)
  | atom '?'
    ->
      ^(OPTIONAL atom)
  | atom
    ->
      ^(ELEMENT atom)
  ;

quantifier
  :
  '+'
    ->
      ^(ONEORMORE)
  | '*'
    ->
      ^(ZEROORMORE)
  ;

group
  :
  '(' regex ')'
    ->
      ^(GROUP regex)
  ;

atom
  :
  literal
  | group
  | dotany
  | character_class
  ;

dotany
  :
  Dot
    ->
      ^(DOTANY)
  ;

// CHARACTER CLASSES
//
//         [...]       positive character class
//         [x-y]       range

character_class
  :
  OpenBracket cc_atom+ CloseBracket
    ->
      ^(CHARACTER_CLASS cc_atom+)
  ;

cc_atom
  :
  literal Hyphen literal
    ->
      ^(RANGE literal literal)
  | literal
  ;

// END character class

// boundaries
// just ignore subject boundary for the time being

subject_boundary
  :
  '^' regex
    -> regex
  | regex '$' EOF
    -> regex
  | '^' regex '$' EOF
    -> regex
  ;
// END boundaries

literal
  :
  letter
    -> LITERAL[$letter.text]
  | digit
    -> LITERAL[$digit.text]
  | other_chars
    -> LITERAL[$other_chars.text]
  | whitespace
    -> LITERAL[$whitespace.text]
  | Quoted
    -> LITERAL[$Quoted.text]
  | BlockQuoted
    -> LITERAL[$BlockQuoted.text]
  ;

whitespace
  :
  WHITESPACE
  | Tab
  | NewLine
  | CarriageReturn
  ;

digit
  :
  D0
  | D1
  | D2
  | D3
  | D4
  | D5
  | D6
  | D7
  | D8
  | D9
  ;

non_close_parens
  :
  non_close_paren+
  ;

non_close_paren
  :
  ~CloseParen
  ;

letter
  :
  ALC
  | BLC
  | CLC
  | DLC
  | ELC
  | FLC
  | GLC
  | HLC
  | ILC
  | JLC
  | KLC
  | LLC
  | MLC
  | NLC
  | OLC
  | PLC
  | QLC
  | RLC
  | SLC
  | TLC
  | ULC
  | VLC
  | WLC
  | XLC
  | YLC
  | ZLC
  | AUC
  | BUC
  | CUC
  | DUC
  | EUC
  | FUC
  | GUC
  | HUC
  | IUC
  | JUC
  | KUC
  | LUC
  | MUC
  | NUC
  | OUC
  | PUC
  | QUC
  | RUC
  | SUC
  | TUC
  | UUC
  | VUC
  | WUC
  | XUC
  | YUC
  | ZUC
  ;

other_chars
  :
  Exclamation
  | DoubleQuote
  | Hash
  | Ampersand
  | SingleQuote
  | Comma
  | Hyphen
  | Slash
  | Colon
  | Semicolon
  | LessThan
  | Equals
  | GreaterThan
  | At
  | Backslash
  | Underscore
  | GraveAccent
  | Tilde
  ;

special_chars
  :
  Dollar
  | OpenParen
  | CloseParen
  | Star
  | Plus
  | Dot
  | QuestionMark
  | OpenBracket
  | CloseBracket
  | Caret
  | OpenBrace
  | Pipe
  | CloseBrace
  ;

/*****************************************************************************************
 *                                                                                       *
 *                                   LEXER RULES                                         *
 *                                                                                       *
 *****************************************************************************************/

// QUOTING
//
//         \x         where x is non-alphanumeric is a literal x
//         \Q...\E    treat enclosed characters as literal
Quoted
  :
  '\\' NonAlphaNumeric 
                      {
                       setText($text.substring(1));
                      }
  ;

BlockQuoted
  :
  '\\Q' .* '\\E' 
                {
                 setText($text.substring(2, $text.length() - 2));
                }
  ;

NewLine
  :
  '\n' 
      {
       setText("\n");
      }
  ;

CarriageReturn
  :
  '\r' 
      {
       setText("\r");
      }
  ;

Tab
  :
  '\t' 
      {
       setText("\t");
      }
  ;

//  printable ASCII starts here

WHITESPACE
  :
  ' '
  ;

Exclamation
  :
  '!'
  ;

DoubleQuote
  :
  '"'
  ;

Hash
  :
  '#'
  ;

Dollar
  :
  '$'
  ;

Percent
  :
  '%'
  ;

Ampersand
  :
  '&'
  ;

SingleQuote
  :
  '\''
  ;

OpenParen
  :
  '('
  ;

CloseParen
  :
  ')'
  ;

Star
  :
  '*'
  ;

Plus
  :
  '+'
  ;

Comma
  :
  ','
  ;

Hyphen
  :
  '-'
  ;

Dot
  :
  '.'
  ;

Slash
  :
  '/'
  ;

D0
  :
  '0'
  ;

D1
  :
  '1'
  ;

D2
  :
  '2'
  ;

D3
  :
  '3'
  ;

D4
  :
  '4'
  ;

D5
  :
  '5'
  ;

D6
  :
  '6'
  ;

D7
  :
  '7'
  ;

D8
  :
  '8'
  ;

D9
  :
  '9'
  ;

Colon
  :
  ':'
  ;

Semicolon
  :
  ';'
  ;

LessThan
  :
  '<'
  ;

Equals
  :
  '='
  ;

GreaterThan
  :
  '>'
  ;

QuestionMark
  :
  '?'
  ;

At
  :
  '@'
  ;

AUC
  :
  'A'
  ;

BUC
  :
  'B'
  ;

CUC
  :
  'C'
  ;

DUC
  :
  'D'
  ;

EUC
  :
  'E'
  ;

FUC
  :
  'F'
  ;

GUC
  :
  'G'
  ;

HUC
  :
  'H'
  ;

IUC
  :
  'I'
  ;

JUC
  :
  'J'
  ;

KUC
  :
  'K'
  ;

LUC
  :
  'L'
  ;

MUC
  :
  'M'
  ;

NUC
  :
  'N'
  ;

OUC
  :
  'O'
  ;

PUC
  :
  'P'
  ;

QUC
  :
  'Q'
  ;

RUC
  :
  'R'
  ;

SUC
  :
  'S'
  ;

TUC
  :
  'T'
  ;

UUC
  :
  'U'
  ;

VUC
  :
  'V'
  ;

WUC
  :
  'W'
  ;

XUC
  :
  'X'
  ;

YUC
  :
  'Y'
  ;

ZUC
  :
  'Z'
  ;

OpenBracket
  :
  '['
  ;

Backslash
  :
  '\\'
  ;

CloseBracket
  :
  ']'
  ;

Caret
  :
  '^'
  ;

Underscore
  :
  '_'
  ;

GraveAccent
  :
  '`'
  ;

ALC
  :
  'a'
  ;

BLC
  :
  'b'
  ;

CLC
  :
  'c'
  ;

DLC
  :
  'd'
  ;

ELC
  :
  'e'
  ;

FLC
  :
  'f'
  ;

GLC
  :
  'g'
  ;

HLC
  :
  'h'
  ;

ILC
  :
  'i'
  ;

JLC
  :
  'j'
  ;

KLC
  :
  'k'
  ;

LLC
  :
  'l'
  ;

MLC
  :
  'm'
  ;

NLC
  :
  'n'
  ;

OLC
  :
  'o'
  ;

PLC
  :
  'p'
  ;

QLC
  :
  'q'
  ;

RLC
  :
  'r'
  ;

SLC
  :
  's'
  ;

TLC
  :
  't'
  ;

ULC
  :
  'u'
  ;

VLC
  :
  'v'
  ;

WLC
  :
  'w'
  ;

XLC
  :
  'x'
  ;

YLC
  :
  'y'
  ;

ZLC
  :
  'z'
  ;

OpenBrace
  :
  '{'
  ;

Pipe
  :
  '|'
  ;

CloseBrace
  :
  '}'
  ;

Tilde
  :
  '~'
  ;

// printable ASCII stops here

// fragments

fragment
AlphaNumeric
  :
  'a'..'z'
  | 'A'..'Z'
  | '0'..'9'
  ;

fragment
NonAlphaNumeric
  :
  ~AlphaNumeric
  ;
