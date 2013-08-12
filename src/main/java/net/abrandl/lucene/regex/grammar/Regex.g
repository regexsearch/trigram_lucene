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
  NUMBER;
  NAME;
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
package net.abrandl.lucene.regex.grammar;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;

/*
* Based on insights (and partly also grammar code) taken from
* https://github.com/bkiers/PCREParser
*/
}

@lexer::header {
package net.abrandl.lucene.regex.grammar;
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
//         [x-y]       range (can be used for hex characters)

character_class
  :
  CharacterClassStart cc_atom+ CharacterClassEnd
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
  | regex '$'
    -> regex
  | '^' regex '$'
    -> regex
  ;

// END boundaries

literal
  :
  letter
    -> LITERAL[$letter.text]
  | digit
    -> LITERAL[$digit.text]
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

number
  :
  digits
    -> NUMBER[$digits.text]
  ;

digits
  :
  digit+
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

name
  :
  letters
    -> NAME[$letters.text]
  ;

letters
  :
  letter+
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

// CHARACTERS
//
//         \a         alarm, that is, the BEL character (hex 07)
//         \cx        "control-x", where x is any ASCII character
//         \e         escape (hex 1B)
//         \f         form feed (hex 0C)
//         \n         newline (hex 0A)
//         \r         carriage return (hex 0D)
//         \t         tab (hex 09)
//         \ddd       character with octal code ddd, or backreference
//         \xhh       character with hex code hh
//         \x{hhh..}  character with hex code hhh..

BellChar
  :
  '\\a' 
       {
        setText("\u0007");
       }
  ;

ControlChar
  :
  '\\c' ASCII 
             {
              setText($ASCII.text);
             }
  ;

EscapeChar
  :
  '\\e' 
       {
        setText(String.valueOf((char) 0x1B));
       }
  ;

FormFeed
  :
  '\\f' 
       {
        setText(String.valueOf((char) 0x0C));
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

Backslash
  :
  '\\'
  ;

HexChar
  :
  '\\x'
  (
    HexDigit HexDigit 
                     {
                      int hex = Integer.valueOf($text.substring(2), 16);
                      setText(Character.valueOf((char) hex).toString());
                     }
    | '{' HexDigit HexDigit HexDigit+ '}' 
                                         {
                                          int hex = Integer.valueOf($text.substring(3, $text.length() - 1), 16);
                                          char[] utf16 = Character.toChars(hex);
                                          setText(new String(utf16));
                                         }
  )
  ;

// CHARACTER TYPES
//
//         .          any character except newline;
//                      in dotall mode, any character whatsoever
//         \C         one data unit, even in UTF mode (best avoided)
//         \d         a decimal digit
//         \D         a character that is not a decimal digit
//         \h         a horizontal white space character
//         \H         a character that is not a horizontal white space character
//         \N         a character that is not a newline
//         \R         a newline sequence
//         \s         a white space character
//         \S         a character that is not a white space character
//         \v         a vertical white space character
//         \V         a character that is not a vertical white space character
//         \w         a "word" character
//         \W         a "non-word" character
//         \X         an extended Unicode sequence
//
//       In  PCRE,  by  default, \d, \D, \s, \S, \w, and \W recognize only ASCII
//       characters, even in a UTF mode. However, this can be changed by setting
//       the PCRE_UCP option.

Dot
  :
  '.'
  ;

OneDataUnit
  :
  '\\C'
  ;

DecimalDigit
  :
  '\\d'
  ;

NotDecimalDigit
  :
  '\\D'
  ;

HorizontalWhiteSpace
  :
  '\\h'
  ;

NotHorizontalWhiteSpace
  :
  '\\H'
  ;

NotNewLine
  :
  '\\N'
  ;

NewLineSequence
  :
  '\\R'
  ;

WhiteSpace
  :
  '\\s'
  ;

NotWhiteSpace
  :
  '\\S'
  ;

VerticalWhiteSpace
  :
  '\\v'
  ;

NotVerticalWhiteSpace
  :
  '\\V'
  ;

WordChar
  :
  '\\w'
  ;

NotWordChar
  :
  '\\W'
  ;

ExtendedUnicodeChar
  :
  '\\X'
  ;

// CHARACTER CLASSES
//
//         [...]       positive character class
//         [^...]      negative character class
//         [x-y]       range (can be used for hex characters)
//         [[:xxx:]]   positive POSIX named set
//         [[:^xxx:]]  negative POSIX named set
//
//         alnum       alphanumeric
//         alpha       alphabetic
//         ascii       0-127
//         blank       space or tab
//         cntrl       control character
//         digit       decimal digit
//         graph       printing, excluding space
//         lower       lower case letter
//         print       printing, including space
//         punct       printing, excluding alphanumeric
//         space       white space
//         upper       upper case letter
//         word        same as \w
//         xdigit      hexadecimal digit
//
//       In PCRE, POSIX character set names recognize only ASCII  characters  by
//       default,  but  some  of them use Unicode properties if PCRE_UCP is set.
//       You can use \Q...\E inside a character class.

CharacterClassStart
  :
  '['
  ;

CharacterClassEnd
  :
  ']'
  ;

Caret
  :
  '^'
  ;

Hyphen
  :
  '-'
  ;

QuestionMark
  :
  '?'
  ;

Plus
  :
  '+'
  ;

Star
  :
  '*'
  ;

OpenBrace
  :
  '{'
  ;

CloseBrace
  :
  '}'
  ;

Comma
  :
  ','
  ;

// ANCHORS AND SIMPLE ASSERTIONS
//
//         \b          word boundary
//         \B          not a word boundary
//         ^           start of subject
//                      also after internal newline in multiline mode
//         \A          start of subject
//         $           end of subject
//                      also before newline at end of subject
//                      also before internal newline in multiline mode
//         \Z          end of subject
//                      also before newline at end of subject
//         \z          end of subject
//         \G          first matching position in subject

WordBoundary
  :
  '\\b'
  ;

NonWordBoundary
  :
  '\\B'
  ;

StartOfSubject
  :
  '\\A'
  ;

EndOfSubjectOrLine
  :
  '$'
  ;

EndOfSubjectOrLineEndOfSubject
  :
  '\\Z'
  ;

EndOfSubject
  :
  '\\z'
  ;

PreviousMatchInSubject
  :
  '\\G'
  ;

// MATCH POINT RESET
//
//         \K          reset start of match

ResetStartMatch
  :
  '\\K'
  ;

SubroutineOrNamedReferenceStartG
  :
  '\\g'
  ;

NamedReferenceStartK
  :
  '\\k'
  ;

Pipe
  :
  '|'
  ;

OpenParen
  :
  '('
  ;

CloseParen
  :
  ')'
  ;

LessThan
  :
  '<'
  ;

GreaterThan
  :
  '>'
  ;

SingleQuote
  :
  '\''
  ;

Underscore
  :
  '_'
  ;

Colon
  :
  ':'
  ;

Hash
  :
  '#'
  ;

Equals
  :
  '='
  ;

Exclamation
  :
  '!'
  ;

Ampersand
  :
  '&'
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

D0
  :
  '0'
  ;

WHITESPACE
  :
  ' '
  ;

OtherChar
  :
  .
  ;

// fragments

fragment
UnderscoreAlphaNumerics
  :
  (
    '_'
    | AlphaNumeric
  )+
  ;

fragment
AlphaNumerics
  :
  AlphaNumeric+
  ;

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

fragment
HexDigit
  :
  '0'..'9'
  | 'a'..'f'
  | 'A'..'F'
  ;

fragment
ASCII
  :
  '\u0000'..'\u007F'
  ;
