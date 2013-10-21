// $ANTLR 3.4 /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g 2013-10-21 15:35:44

package de.abrandl.regex.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class RegexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ALC=4;
    public static final int ALTERNATIVE=5;
    public static final int ASCII=6;
    public static final int AUC=7;
    public static final int AlphaNumeric=8;
    public static final int AlphaNumerics=9;
    public static final int Ampersand=10;
    public static final int BLC=11;
    public static final int BUC=12;
    public static final int Backslash=13;
    public static final int BlockQuoted=14;
    public static final int CHARACTER_CLASS=15;
    public static final int CLC=16;
    public static final int CONCATENATION=17;
    public static final int CUC=18;
    public static final int Caret=19;
    public static final int CarriageReturn=20;
    public static final int CharacterClassEnd=21;
    public static final int CharacterClassStart=22;
    public static final int CloseBrace=23;
    public static final int CloseParen=24;
    public static final int Colon=25;
    public static final int Comma=26;
    public static final int D0=27;
    public static final int D1=28;
    public static final int D2=29;
    public static final int D3=30;
    public static final int D4=31;
    public static final int D5=32;
    public static final int D6=33;
    public static final int D7=34;
    public static final int D8=35;
    public static final int D9=36;
    public static final int DLC=37;
    public static final int DOTANY=38;
    public static final int DUC=39;
    public static final int Dot=40;
    public static final int ELC=41;
    public static final int ELEMENT=42;
    public static final int EUC=43;
    public static final int EndOfSubjectOrLine=44;
    public static final int Equals=45;
    public static final int Exclamation=46;
    public static final int FLC=47;
    public static final int FUC=48;
    public static final int GLC=49;
    public static final int GROUP=50;
    public static final int GUC=51;
    public static final int GreaterThan=52;
    public static final int HLC=53;
    public static final int HUC=54;
    public static final int Hash=55;
    public static final int HexDigit=56;
    public static final int Hyphen=57;
    public static final int ILC=58;
    public static final int IUC=59;
    public static final int JLC=60;
    public static final int JUC=61;
    public static final int KLC=62;
    public static final int KUC=63;
    public static final int LITERAL=64;
    public static final int LLC=65;
    public static final int LUC=66;
    public static final int LessThan=67;
    public static final int MLC=68;
    public static final int MUC=69;
    public static final int NAME=70;
    public static final int NLC=71;
    public static final int NUC=72;
    public static final int NUMBER=73;
    public static final int NewLine=74;
    public static final int NonAlphaNumeric=75;
    public static final int OLC=76;
    public static final int ONEORMORE=77;
    public static final int OPTIONAL=78;
    public static final int OUC=79;
    public static final int OpenBrace=80;
    public static final int OpenParen=81;
    public static final int OtherChar=82;
    public static final int PLC=83;
    public static final int PUC=84;
    public static final int Pipe=85;
    public static final int Plus=86;
    public static final int QLC=87;
    public static final int QUC=88;
    public static final int QuestionMark=89;
    public static final int Quoted=90;
    public static final int RANGE=91;
    public static final int RLC=92;
    public static final int RUC=93;
    public static final int SLC=94;
    public static final int SUC=95;
    public static final int SingleQuote=96;
    public static final int Star=97;
    public static final int TLC=98;
    public static final int TUC=99;
    public static final int Tab=100;
    public static final int ULC=101;
    public static final int UUC=102;
    public static final int Underscore=103;
    public static final int UnderscoreAlphaNumerics=104;
    public static final int VLC=105;
    public static final int VUC=106;
    public static final int WHITESPACE=107;
    public static final int WLC=108;
    public static final int WUC=109;
    public static final int XLC=110;
    public static final int XUC=111;
    public static final int YLC=112;
    public static final int YUC=113;
    public static final int ZEROORMORE=114;
    public static final int ZLC=115;
    public static final int ZUC=116;

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


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public RegexLexer() {} 
    public RegexLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RegexLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g"; }

    // $ANTLR start "Quoted"
    public final void mQuoted() throws RecognitionException {
        try {
            int _type = Quoted;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:346:3: ( '\\\\' NonAlphaNumeric )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:347:3: '\\\\' NonAlphaNumeric
            {
            match('\\'); 

            mNonAlphaNumeric(); 



                                   setText(getText().substring(1));
                                  

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Quoted"

    // $ANTLR start "BlockQuoted"
    public final void mBlockQuoted() throws RecognitionException {
        try {
            int _type = BlockQuoted;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:344:3: ( '\\\\Q' ( . )* '\\\\E' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:345:3: '\\\\Q' ( . )* '\\\\E'
            {
            match("\\Q"); 



            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:345:9: ( . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='E') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= 'D')||(LA1_1 >= 'F' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:345:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("\\E"); 




                             setText(getText().substring(2, getText().length() - 2));
                            

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BlockQuoted"

    // $ANTLR start "NewLine"
    public final void mNewLine() throws RecognitionException {
        try {
            int _type = NewLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:352:3: ( '\\n' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:353:3: '\\n'
            {
            match('\n'); 


                   setText("\n");
                  

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NewLine"

    // $ANTLR start "CarriageReturn"
    public final void mCarriageReturn() throws RecognitionException {
        try {
            int _type = CarriageReturn;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:360:3: ( '\\r' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:361:3: '\\r'
            {
            match('\r'); 


                   setText("\r");
                  

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CarriageReturn"

    // $ANTLR start "Tab"
    public final void mTab() throws RecognitionException {
        try {
            int _type = Tab;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:368:3: ( '\\t' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:369:3: '\\t'
            {
            match('\t'); 


                   setText("\t");
                  

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Tab"

    // $ANTLR start "Backslash"
    public final void mBackslash() throws RecognitionException {
        try {
            int _type = Backslash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:376:3: ( '\\\\' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:377:3: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Backslash"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:381:3: ( '.' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:382:3: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Dot"

    // $ANTLR start "CharacterClassStart"
    public final void mCharacterClassStart() throws RecognitionException {
        try {
            int _type = CharacterClassStart;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:386:3: ( '[' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:387:3: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CharacterClassStart"

    // $ANTLR start "CharacterClassEnd"
    public final void mCharacterClassEnd() throws RecognitionException {
        try {
            int _type = CharacterClassEnd;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:391:3: ( ']' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:392:3: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CharacterClassEnd"

    // $ANTLR start "Caret"
    public final void mCaret() throws RecognitionException {
        try {
            int _type = Caret;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:396:3: ( '^' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:397:3: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Caret"

    // $ANTLR start "Hyphen"
    public final void mHyphen() throws RecognitionException {
        try {
            int _type = Hyphen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:401:3: ( '-' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:402:3: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Hyphen"

    // $ANTLR start "QuestionMark"
    public final void mQuestionMark() throws RecognitionException {
        try {
            int _type = QuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:406:3: ( '?' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:407:3: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QuestionMark"

    // $ANTLR start "Plus"
    public final void mPlus() throws RecognitionException {
        try {
            int _type = Plus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:411:3: ( '+' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:412:3: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Plus"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:416:3: ( '*' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:417:3: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Star"

    // $ANTLR start "OpenBrace"
    public final void mOpenBrace() throws RecognitionException {
        try {
            int _type = OpenBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:421:3: ( '{' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:422:3: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OpenBrace"

    // $ANTLR start "CloseBrace"
    public final void mCloseBrace() throws RecognitionException {
        try {
            int _type = CloseBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:426:3: ( '}' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:427:3: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CloseBrace"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:431:3: ( ',' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:432:3: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "EndOfSubjectOrLine"
    public final void mEndOfSubjectOrLine() throws RecognitionException {
        try {
            int _type = EndOfSubjectOrLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:436:3: ( '$' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:437:3: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EndOfSubjectOrLine"

    // $ANTLR start "Pipe"
    public final void mPipe() throws RecognitionException {
        try {
            int _type = Pipe;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:441:3: ( '|' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:442:3: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Pipe"

    // $ANTLR start "OpenParen"
    public final void mOpenParen() throws RecognitionException {
        try {
            int _type = OpenParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:446:3: ( '(' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:447:3: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OpenParen"

    // $ANTLR start "CloseParen"
    public final void mCloseParen() throws RecognitionException {
        try {
            int _type = CloseParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:451:3: ( ')' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:452:3: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CloseParen"

    // $ANTLR start "LessThan"
    public final void mLessThan() throws RecognitionException {
        try {
            int _type = LessThan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:456:3: ( '<' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:457:3: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LessThan"

    // $ANTLR start "GreaterThan"
    public final void mGreaterThan() throws RecognitionException {
        try {
            int _type = GreaterThan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:461:3: ( '>' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:462:3: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GreaterThan"

    // $ANTLR start "SingleQuote"
    public final void mSingleQuote() throws RecognitionException {
        try {
            int _type = SingleQuote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:466:3: ( '\\'' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:467:3: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SingleQuote"

    // $ANTLR start "Underscore"
    public final void mUnderscore() throws RecognitionException {
        try {
            int _type = Underscore;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:471:3: ( '_' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:472:3: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Underscore"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:476:3: ( ':' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:477:3: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Hash"
    public final void mHash() throws RecognitionException {
        try {
            int _type = Hash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:481:3: ( '#' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:482:3: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Hash"

    // $ANTLR start "Equals"
    public final void mEquals() throws RecognitionException {
        try {
            int _type = Equals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:486:3: ( '=' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:487:3: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Equals"

    // $ANTLR start "Exclamation"
    public final void mExclamation() throws RecognitionException {
        try {
            int _type = Exclamation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:491:3: ( '!' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:492:3: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Exclamation"

    // $ANTLR start "Ampersand"
    public final void mAmpersand() throws RecognitionException {
        try {
            int _type = Ampersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:496:3: ( '&' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:497:3: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ampersand"

    // $ANTLR start "ALC"
    public final void mALC() throws RecognitionException {
        try {
            int _type = ALC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:501:3: ( 'a' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:502:3: 'a'
            {
            match('a'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALC"

    // $ANTLR start "BLC"
    public final void mBLC() throws RecognitionException {
        try {
            int _type = BLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:506:3: ( 'b' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:507:3: 'b'
            {
            match('b'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BLC"

    // $ANTLR start "CLC"
    public final void mCLC() throws RecognitionException {
        try {
            int _type = CLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:511:3: ( 'c' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:512:3: 'c'
            {
            match('c'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLC"

    // $ANTLR start "DLC"
    public final void mDLC() throws RecognitionException {
        try {
            int _type = DLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:516:3: ( 'd' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:517:3: 'd'
            {
            match('d'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DLC"

    // $ANTLR start "ELC"
    public final void mELC() throws RecognitionException {
        try {
            int _type = ELC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:521:3: ( 'e' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:522:3: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELC"

    // $ANTLR start "FLC"
    public final void mFLC() throws RecognitionException {
        try {
            int _type = FLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:526:3: ( 'f' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:527:3: 'f'
            {
            match('f'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLC"

    // $ANTLR start "GLC"
    public final void mGLC() throws RecognitionException {
        try {
            int _type = GLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:531:3: ( 'g' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:532:3: 'g'
            {
            match('g'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GLC"

    // $ANTLR start "HLC"
    public final void mHLC() throws RecognitionException {
        try {
            int _type = HLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:536:3: ( 'h' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:537:3: 'h'
            {
            match('h'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HLC"

    // $ANTLR start "ILC"
    public final void mILC() throws RecognitionException {
        try {
            int _type = ILC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:541:3: ( 'i' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:542:3: 'i'
            {
            match('i'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ILC"

    // $ANTLR start "JLC"
    public final void mJLC() throws RecognitionException {
        try {
            int _type = JLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:546:3: ( 'j' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:547:3: 'j'
            {
            match('j'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JLC"

    // $ANTLR start "KLC"
    public final void mKLC() throws RecognitionException {
        try {
            int _type = KLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:551:3: ( 'k' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:552:3: 'k'
            {
            match('k'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KLC"

    // $ANTLR start "LLC"
    public final void mLLC() throws RecognitionException {
        try {
            int _type = LLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:556:3: ( 'l' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:557:3: 'l'
            {
            match('l'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LLC"

    // $ANTLR start "MLC"
    public final void mMLC() throws RecognitionException {
        try {
            int _type = MLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:561:3: ( 'm' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:562:3: 'm'
            {
            match('m'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MLC"

    // $ANTLR start "NLC"
    public final void mNLC() throws RecognitionException {
        try {
            int _type = NLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:566:3: ( 'n' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:567:3: 'n'
            {
            match('n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NLC"

    // $ANTLR start "OLC"
    public final void mOLC() throws RecognitionException {
        try {
            int _type = OLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:571:3: ( 'o' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:572:3: 'o'
            {
            match('o'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OLC"

    // $ANTLR start "PLC"
    public final void mPLC() throws RecognitionException {
        try {
            int _type = PLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:576:3: ( 'p' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:577:3: 'p'
            {
            match('p'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLC"

    // $ANTLR start "QLC"
    public final void mQLC() throws RecognitionException {
        try {
            int _type = QLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:581:3: ( 'q' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:582:3: 'q'
            {
            match('q'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QLC"

    // $ANTLR start "RLC"
    public final void mRLC() throws RecognitionException {
        try {
            int _type = RLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:586:3: ( 'r' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:587:3: 'r'
            {
            match('r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RLC"

    // $ANTLR start "SLC"
    public final void mSLC() throws RecognitionException {
        try {
            int _type = SLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:591:3: ( 's' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:592:3: 's'
            {
            match('s'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SLC"

    // $ANTLR start "TLC"
    public final void mTLC() throws RecognitionException {
        try {
            int _type = TLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:596:3: ( 't' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:597:3: 't'
            {
            match('t'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TLC"

    // $ANTLR start "ULC"
    public final void mULC() throws RecognitionException {
        try {
            int _type = ULC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:601:3: ( 'u' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:602:3: 'u'
            {
            match('u'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ULC"

    // $ANTLR start "VLC"
    public final void mVLC() throws RecognitionException {
        try {
            int _type = VLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:606:3: ( 'v' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:607:3: 'v'
            {
            match('v'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VLC"

    // $ANTLR start "WLC"
    public final void mWLC() throws RecognitionException {
        try {
            int _type = WLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:611:3: ( 'w' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:612:3: 'w'
            {
            match('w'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WLC"

    // $ANTLR start "XLC"
    public final void mXLC() throws RecognitionException {
        try {
            int _type = XLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:616:3: ( 'x' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:617:3: 'x'
            {
            match('x'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XLC"

    // $ANTLR start "YLC"
    public final void mYLC() throws RecognitionException {
        try {
            int _type = YLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:621:3: ( 'y' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:622:3: 'y'
            {
            match('y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "YLC"

    // $ANTLR start "ZLC"
    public final void mZLC() throws RecognitionException {
        try {
            int _type = ZLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:626:3: ( 'z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:627:3: 'z'
            {
            match('z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ZLC"

    // $ANTLR start "AUC"
    public final void mAUC() throws RecognitionException {
        try {
            int _type = AUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:631:3: ( 'A' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:632:3: 'A'
            {
            match('A'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AUC"

    // $ANTLR start "BUC"
    public final void mBUC() throws RecognitionException {
        try {
            int _type = BUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:636:3: ( 'B' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:637:3: 'B'
            {
            match('B'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BUC"

    // $ANTLR start "CUC"
    public final void mCUC() throws RecognitionException {
        try {
            int _type = CUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:641:3: ( 'C' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:642:3: 'C'
            {
            match('C'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CUC"

    // $ANTLR start "DUC"
    public final void mDUC() throws RecognitionException {
        try {
            int _type = DUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:646:3: ( 'D' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:647:3: 'D'
            {
            match('D'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DUC"

    // $ANTLR start "EUC"
    public final void mEUC() throws RecognitionException {
        try {
            int _type = EUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:651:3: ( 'E' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:652:3: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EUC"

    // $ANTLR start "FUC"
    public final void mFUC() throws RecognitionException {
        try {
            int _type = FUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:656:3: ( 'F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:657:3: 'F'
            {
            match('F'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUC"

    // $ANTLR start "GUC"
    public final void mGUC() throws RecognitionException {
        try {
            int _type = GUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:661:3: ( 'G' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:662:3: 'G'
            {
            match('G'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GUC"

    // $ANTLR start "HUC"
    public final void mHUC() throws RecognitionException {
        try {
            int _type = HUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:666:3: ( 'H' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:667:3: 'H'
            {
            match('H'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HUC"

    // $ANTLR start "IUC"
    public final void mIUC() throws RecognitionException {
        try {
            int _type = IUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:671:3: ( 'I' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:672:3: 'I'
            {
            match('I'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IUC"

    // $ANTLR start "JUC"
    public final void mJUC() throws RecognitionException {
        try {
            int _type = JUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:676:3: ( 'J' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:677:3: 'J'
            {
            match('J'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JUC"

    // $ANTLR start "KUC"
    public final void mKUC() throws RecognitionException {
        try {
            int _type = KUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:681:3: ( 'K' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:682:3: 'K'
            {
            match('K'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KUC"

    // $ANTLR start "LUC"
    public final void mLUC() throws RecognitionException {
        try {
            int _type = LUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:686:3: ( 'L' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:687:3: 'L'
            {
            match('L'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LUC"

    // $ANTLR start "MUC"
    public final void mMUC() throws RecognitionException {
        try {
            int _type = MUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:691:3: ( 'M' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:692:3: 'M'
            {
            match('M'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MUC"

    // $ANTLR start "NUC"
    public final void mNUC() throws RecognitionException {
        try {
            int _type = NUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:696:3: ( 'N' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:697:3: 'N'
            {
            match('N'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUC"

    // $ANTLR start "OUC"
    public final void mOUC() throws RecognitionException {
        try {
            int _type = OUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:701:3: ( 'O' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:702:3: 'O'
            {
            match('O'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUC"

    // $ANTLR start "PUC"
    public final void mPUC() throws RecognitionException {
        try {
            int _type = PUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:706:3: ( 'P' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:707:3: 'P'
            {
            match('P'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUC"

    // $ANTLR start "QUC"
    public final void mQUC() throws RecognitionException {
        try {
            int _type = QUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:711:3: ( 'Q' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:712:3: 'Q'
            {
            match('Q'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUC"

    // $ANTLR start "RUC"
    public final void mRUC() throws RecognitionException {
        try {
            int _type = RUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:716:3: ( 'R' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:717:3: 'R'
            {
            match('R'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RUC"

    // $ANTLR start "SUC"
    public final void mSUC() throws RecognitionException {
        try {
            int _type = SUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:721:3: ( 'S' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:722:3: 'S'
            {
            match('S'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUC"

    // $ANTLR start "TUC"
    public final void mTUC() throws RecognitionException {
        try {
            int _type = TUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:726:3: ( 'T' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:727:3: 'T'
            {
            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TUC"

    // $ANTLR start "UUC"
    public final void mUUC() throws RecognitionException {
        try {
            int _type = UUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:731:3: ( 'U' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:732:3: 'U'
            {
            match('U'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UUC"

    // $ANTLR start "VUC"
    public final void mVUC() throws RecognitionException {
        try {
            int _type = VUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:736:3: ( 'V' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:737:3: 'V'
            {
            match('V'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VUC"

    // $ANTLR start "WUC"
    public final void mWUC() throws RecognitionException {
        try {
            int _type = WUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:741:3: ( 'W' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:742:3: 'W'
            {
            match('W'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WUC"

    // $ANTLR start "XUC"
    public final void mXUC() throws RecognitionException {
        try {
            int _type = XUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:746:3: ( 'X' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:747:3: 'X'
            {
            match('X'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XUC"

    // $ANTLR start "YUC"
    public final void mYUC() throws RecognitionException {
        try {
            int _type = YUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:751:3: ( 'Y' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:752:3: 'Y'
            {
            match('Y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "YUC"

    // $ANTLR start "ZUC"
    public final void mZUC() throws RecognitionException {
        try {
            int _type = ZUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:756:3: ( 'Z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:757:3: 'Z'
            {
            match('Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ZUC"

    // $ANTLR start "D1"
    public final void mD1() throws RecognitionException {
        try {
            int _type = D1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:761:3: ( '1' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:762:3: '1'
            {
            match('1'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D1"

    // $ANTLR start "D2"
    public final void mD2() throws RecognitionException {
        try {
            int _type = D2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:766:3: ( '2' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:767:3: '2'
            {
            match('2'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D2"

    // $ANTLR start "D3"
    public final void mD3() throws RecognitionException {
        try {
            int _type = D3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:771:3: ( '3' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:772:3: '3'
            {
            match('3'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D3"

    // $ANTLR start "D4"
    public final void mD4() throws RecognitionException {
        try {
            int _type = D4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:776:3: ( '4' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:777:3: '4'
            {
            match('4'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D4"

    // $ANTLR start "D5"
    public final void mD5() throws RecognitionException {
        try {
            int _type = D5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:781:3: ( '5' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:782:3: '5'
            {
            match('5'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D5"

    // $ANTLR start "D6"
    public final void mD6() throws RecognitionException {
        try {
            int _type = D6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:786:3: ( '6' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:787:3: '6'
            {
            match('6'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D6"

    // $ANTLR start "D7"
    public final void mD7() throws RecognitionException {
        try {
            int _type = D7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:791:3: ( '7' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:792:3: '7'
            {
            match('7'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D7"

    // $ANTLR start "D8"
    public final void mD8() throws RecognitionException {
        try {
            int _type = D8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:796:3: ( '8' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:797:3: '8'
            {
            match('8'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D8"

    // $ANTLR start "D9"
    public final void mD9() throws RecognitionException {
        try {
            int _type = D9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:801:3: ( '9' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:802:3: '9'
            {
            match('9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D9"

    // $ANTLR start "D0"
    public final void mD0() throws RecognitionException {
        try {
            int _type = D0;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:806:3: ( '0' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:807:3: '0'
            {
            match('0'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D0"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:811:3: ( ' ' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:812:3: ' '
            {
            match(' '); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "OtherChar"
    public final void mOtherChar() throws RecognitionException {
        try {
            int _type = OtherChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:816:3: ( . )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:817:3: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OtherChar"

    // $ANTLR start "UnderscoreAlphaNumerics"
    public final void mUnderscoreAlphaNumerics() throws RecognitionException {
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:825:3: ( ( '_' | AlphaNumeric )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:826:3: ( '_' | AlphaNumeric )+
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:826:3: ( '_' | AlphaNumeric )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UnderscoreAlphaNumerics"

    // $ANTLR start "AlphaNumerics"
    public final void mAlphaNumerics() throws RecognitionException {
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:834:3: ( ( AlphaNumeric )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:835:3: ( AlphaNumeric )+
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:835:3: ( AlphaNumeric )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AlphaNumerics"

    // $ANTLR start "AlphaNumeric"
    public final void mAlphaNumeric() throws RecognitionException {
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:840:3: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AlphaNumeric"

    // $ANTLR start "NonAlphaNumeric"
    public final void mNonAlphaNumeric() throws RecognitionException {
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:848:3: (~ AlphaNumeric )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '/')||(input.LA(1) >= ':' && input.LA(1) <= '@')||(input.LA(1) >= '[' && input.LA(1) <= '`')||(input.LA(1) >= '{' && input.LA(1) <= '\uFFFF') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NonAlphaNumeric"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:854:3: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "ASCII"
    public final void mASCII() throws RecognitionException {
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:862:3: ( '\\u0000' .. '\\u007F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\u007F') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASCII"

    public void mTokens() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:8: ( Quoted | BlockQuoted | NewLine | CarriageReturn | Tab | Backslash | Dot | CharacterClassStart | CharacterClassEnd | Caret | Hyphen | QuestionMark | Plus | Star | OpenBrace | CloseBrace | Comma | EndOfSubjectOrLine | Pipe | OpenParen | CloseParen | LessThan | GreaterThan | SingleQuote | Underscore | Colon | Hash | Equals | Exclamation | Ampersand | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D0 | WHITESPACE | OtherChar )
        int alt4=94;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:10: Quoted
                {
                mQuoted(); 


                }
                break;
            case 2 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:17: BlockQuoted
                {
                mBlockQuoted(); 


                }
                break;
            case 3 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:29: NewLine
                {
                mNewLine(); 


                }
                break;
            case 4 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:37: CarriageReturn
                {
                mCarriageReturn(); 


                }
                break;
            case 5 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:52: Tab
                {
                mTab(); 


                }
                break;
            case 6 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:56: Backslash
                {
                mBackslash(); 


                }
                break;
            case 7 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:66: Dot
                {
                mDot(); 


                }
                break;
            case 8 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:70: CharacterClassStart
                {
                mCharacterClassStart(); 


                }
                break;
            case 9 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:90: CharacterClassEnd
                {
                mCharacterClassEnd(); 


                }
                break;
            case 10 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:108: Caret
                {
                mCaret(); 


                }
                break;
            case 11 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:114: Hyphen
                {
                mHyphen(); 


                }
                break;
            case 12 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:121: QuestionMark
                {
                mQuestionMark(); 


                }
                break;
            case 13 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:134: Plus
                {
                mPlus(); 


                }
                break;
            case 14 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:139: Star
                {
                mStar(); 


                }
                break;
            case 15 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:144: OpenBrace
                {
                mOpenBrace(); 


                }
                break;
            case 16 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:154: CloseBrace
                {
                mCloseBrace(); 


                }
                break;
            case 17 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:165: Comma
                {
                mComma(); 


                }
                break;
            case 18 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:171: EndOfSubjectOrLine
                {
                mEndOfSubjectOrLine(); 


                }
                break;
            case 19 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:190: Pipe
                {
                mPipe(); 


                }
                break;
            case 20 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:195: OpenParen
                {
                mOpenParen(); 


                }
                break;
            case 21 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:205: CloseParen
                {
                mCloseParen(); 


                }
                break;
            case 22 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:216: LessThan
                {
                mLessThan(); 


                }
                break;
            case 23 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:225: GreaterThan
                {
                mGreaterThan(); 


                }
                break;
            case 24 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:237: SingleQuote
                {
                mSingleQuote(); 


                }
                break;
            case 25 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:249: Underscore
                {
                mUnderscore(); 


                }
                break;
            case 26 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:260: Colon
                {
                mColon(); 


                }
                break;
            case 27 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:266: Hash
                {
                mHash(); 


                }
                break;
            case 28 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:271: Equals
                {
                mEquals(); 


                }
                break;
            case 29 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:278: Exclamation
                {
                mExclamation(); 


                }
                break;
            case 30 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:290: Ampersand
                {
                mAmpersand(); 


                }
                break;
            case 31 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:300: ALC
                {
                mALC(); 


                }
                break;
            case 32 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:304: BLC
                {
                mBLC(); 


                }
                break;
            case 33 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:308: CLC
                {
                mCLC(); 


                }
                break;
            case 34 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:312: DLC
                {
                mDLC(); 


                }
                break;
            case 35 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:316: ELC
                {
                mELC(); 


                }
                break;
            case 36 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:320: FLC
                {
                mFLC(); 


                }
                break;
            case 37 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:324: GLC
                {
                mGLC(); 


                }
                break;
            case 38 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:328: HLC
                {
                mHLC(); 


                }
                break;
            case 39 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:332: ILC
                {
                mILC(); 


                }
                break;
            case 40 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:336: JLC
                {
                mJLC(); 


                }
                break;
            case 41 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:340: KLC
                {
                mKLC(); 


                }
                break;
            case 42 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:344: LLC
                {
                mLLC(); 


                }
                break;
            case 43 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:348: MLC
                {
                mMLC(); 


                }
                break;
            case 44 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:352: NLC
                {
                mNLC(); 


                }
                break;
            case 45 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:356: OLC
                {
                mOLC(); 


                }
                break;
            case 46 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:360: PLC
                {
                mPLC(); 


                }
                break;
            case 47 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:364: QLC
                {
                mQLC(); 


                }
                break;
            case 48 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:368: RLC
                {
                mRLC(); 


                }
                break;
            case 49 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:372: SLC
                {
                mSLC(); 


                }
                break;
            case 50 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:376: TLC
                {
                mTLC(); 


                }
                break;
            case 51 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:380: ULC
                {
                mULC(); 


                }
                break;
            case 52 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:384: VLC
                {
                mVLC(); 


                }
                break;
            case 53 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:388: WLC
                {
                mWLC(); 


                }
                break;
            case 54 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:392: XLC
                {
                mXLC(); 


                }
                break;
            case 55 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:396: YLC
                {
                mYLC(); 


                }
                break;
            case 56 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:400: ZLC
                {
                mZLC(); 


                }
                break;
            case 57 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:404: AUC
                {
                mAUC(); 


                }
                break;
            case 58 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:408: BUC
                {
                mBUC(); 


                }
                break;
            case 59 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:412: CUC
                {
                mCUC(); 


                }
                break;
            case 60 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:416: DUC
                {
                mDUC(); 


                }
                break;
            case 61 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:420: EUC
                {
                mEUC(); 


                }
                break;
            case 62 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:424: FUC
                {
                mFUC(); 


                }
                break;
            case 63 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:428: GUC
                {
                mGUC(); 


                }
                break;
            case 64 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:432: HUC
                {
                mHUC(); 


                }
                break;
            case 65 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:436: IUC
                {
                mIUC(); 


                }
                break;
            case 66 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:440: JUC
                {
                mJUC(); 


                }
                break;
            case 67 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:444: KUC
                {
                mKUC(); 


                }
                break;
            case 68 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:448: LUC
                {
                mLUC(); 


                }
                break;
            case 69 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:452: MUC
                {
                mMUC(); 


                }
                break;
            case 70 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:456: NUC
                {
                mNUC(); 


                }
                break;
            case 71 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:460: OUC
                {
                mOUC(); 


                }
                break;
            case 72 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:464: PUC
                {
                mPUC(); 


                }
                break;
            case 73 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:468: QUC
                {
                mQUC(); 


                }
                break;
            case 74 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:472: RUC
                {
                mRUC(); 


                }
                break;
            case 75 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:476: SUC
                {
                mSUC(); 


                }
                break;
            case 76 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:480: TUC
                {
                mTUC(); 


                }
                break;
            case 77 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:484: UUC
                {
                mUUC(); 


                }
                break;
            case 78 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:488: VUC
                {
                mVUC(); 


                }
                break;
            case 79 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:492: WUC
                {
                mWUC(); 


                }
                break;
            case 80 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:496: XUC
                {
                mXUC(); 


                }
                break;
            case 81 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:500: YUC
                {
                mYUC(); 


                }
                break;
            case 82 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:504: ZUC
                {
                mZUC(); 


                }
                break;
            case 83 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:508: D1
                {
                mD1(); 


                }
                break;
            case 84 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:511: D2
                {
                mD2(); 


                }
                break;
            case 85 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:514: D3
                {
                mD3(); 


                }
                break;
            case 86 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:517: D4
                {
                mD4(); 


                }
                break;
            case 87 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:520: D5
                {
                mD5(); 


                }
                break;
            case 88 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:523: D6
                {
                mD6(); 


                }
                break;
            case 89 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:526: D7
                {
                mD7(); 


                }
                break;
            case 90 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:529: D8
                {
                mD8(); 


                }
                break;
            case 91 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:532: D9
                {
                mD9(); 


                }
                break;
            case 92 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:535: D0
                {
                mD0(); 


                }
                break;
            case 93 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:538: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 94 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:549: OtherChar
                {
                mOtherChar(); 


                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\1\137\u00b8\uffff";
    static final String DFA4_eofS =
        "\u00ba\uffff";
    static final String DFA4_minS =
        "\2\0\u00b8\uffff";
    static final String DFA4_maxS =
        "\2\uffff\u00b8\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
        "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
        "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
        "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66"+
        "\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102"+
        "\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115"+
        "\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130"+
        "\1\131\1\132\1\133\1\134\1\135\1\136\1\2\1\1\1\6\1\3\1\4\1\5\1\7"+
        "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
        "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
        "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
        "\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73"+
        "\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1"+
        "\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
        "\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\1\132\1\133\1\134"+
        "\1\135";
    static final String DFA4_specialS =
        "\1\0\1\1\u00b8\uffff}>";
    static final String[] DFA4_transitionS = {
            "\11\134\1\4\1\2\2\134\1\3\22\134\1\133\1\33\1\134\1\31\1\20"+
            "\1\134\1\34\1\26\1\22\1\23\1\14\1\13\1\17\1\11\1\5\1\134\1\132"+
            "\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\1\30"+
            "\1\134\1\24\1\32\1\25\1\12\1\134\1\67\1\70\1\71\1\72\1\73\1"+
            "\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106"+
            "\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120"+
            "\1\6\1\1\1\7\1\10\1\27\1\134\1\35\1\36\1\37\1\40\1\41\1\42\1"+
            "\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1"+
            "\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\15\1\21\1\16\uff82"+
            "\134",
            "\60\136\12\uffff\7\136\20\uffff\1\135\11\uffff\6\136\32\uffff"+
            "\uff85\136",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Quoted | BlockQuoted | NewLine | CarriageReturn | Tab | Backslash | Dot | CharacterClassStart | CharacterClassEnd | Caret | Hyphen | QuestionMark | Plus | Star | OpenBrace | CloseBrace | Comma | EndOfSubjectOrLine | Pipe | OpenParen | CloseParen | LessThan | GreaterThan | SingleQuote | Underscore | Colon | Hash | Equals | Exclamation | Ampersand | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D0 | WHITESPACE | OtherChar );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='\\') ) {s = 1;}

                        else if ( (LA4_0=='\n') ) {s = 2;}

                        else if ( (LA4_0=='\r') ) {s = 3;}

                        else if ( (LA4_0=='\t') ) {s = 4;}

                        else if ( (LA4_0=='.') ) {s = 5;}

                        else if ( (LA4_0=='[') ) {s = 6;}

                        else if ( (LA4_0==']') ) {s = 7;}

                        else if ( (LA4_0=='^') ) {s = 8;}

                        else if ( (LA4_0=='-') ) {s = 9;}

                        else if ( (LA4_0=='?') ) {s = 10;}

                        else if ( (LA4_0=='+') ) {s = 11;}

                        else if ( (LA4_0=='*') ) {s = 12;}

                        else if ( (LA4_0=='{') ) {s = 13;}

                        else if ( (LA4_0=='}') ) {s = 14;}

                        else if ( (LA4_0==',') ) {s = 15;}

                        else if ( (LA4_0=='$') ) {s = 16;}

                        else if ( (LA4_0=='|') ) {s = 17;}

                        else if ( (LA4_0=='(') ) {s = 18;}

                        else if ( (LA4_0==')') ) {s = 19;}

                        else if ( (LA4_0=='<') ) {s = 20;}

                        else if ( (LA4_0=='>') ) {s = 21;}

                        else if ( (LA4_0=='\'') ) {s = 22;}

                        else if ( (LA4_0=='_') ) {s = 23;}

                        else if ( (LA4_0==':') ) {s = 24;}

                        else if ( (LA4_0=='#') ) {s = 25;}

                        else if ( (LA4_0=='=') ) {s = 26;}

                        else if ( (LA4_0=='!') ) {s = 27;}

                        else if ( (LA4_0=='&') ) {s = 28;}

                        else if ( (LA4_0=='a') ) {s = 29;}

                        else if ( (LA4_0=='b') ) {s = 30;}

                        else if ( (LA4_0=='c') ) {s = 31;}

                        else if ( (LA4_0=='d') ) {s = 32;}

                        else if ( (LA4_0=='e') ) {s = 33;}

                        else if ( (LA4_0=='f') ) {s = 34;}

                        else if ( (LA4_0=='g') ) {s = 35;}

                        else if ( (LA4_0=='h') ) {s = 36;}

                        else if ( (LA4_0=='i') ) {s = 37;}

                        else if ( (LA4_0=='j') ) {s = 38;}

                        else if ( (LA4_0=='k') ) {s = 39;}

                        else if ( (LA4_0=='l') ) {s = 40;}

                        else if ( (LA4_0=='m') ) {s = 41;}

                        else if ( (LA4_0=='n') ) {s = 42;}

                        else if ( (LA4_0=='o') ) {s = 43;}

                        else if ( (LA4_0=='p') ) {s = 44;}

                        else if ( (LA4_0=='q') ) {s = 45;}

                        else if ( (LA4_0=='r') ) {s = 46;}

                        else if ( (LA4_0=='s') ) {s = 47;}

                        else if ( (LA4_0=='t') ) {s = 48;}

                        else if ( (LA4_0=='u') ) {s = 49;}

                        else if ( (LA4_0=='v') ) {s = 50;}

                        else if ( (LA4_0=='w') ) {s = 51;}

                        else if ( (LA4_0=='x') ) {s = 52;}

                        else if ( (LA4_0=='y') ) {s = 53;}

                        else if ( (LA4_0=='z') ) {s = 54;}

                        else if ( (LA4_0=='A') ) {s = 55;}

                        else if ( (LA4_0=='B') ) {s = 56;}

                        else if ( (LA4_0=='C') ) {s = 57;}

                        else if ( (LA4_0=='D') ) {s = 58;}

                        else if ( (LA4_0=='E') ) {s = 59;}

                        else if ( (LA4_0=='F') ) {s = 60;}

                        else if ( (LA4_0=='G') ) {s = 61;}

                        else if ( (LA4_0=='H') ) {s = 62;}

                        else if ( (LA4_0=='I') ) {s = 63;}

                        else if ( (LA4_0=='J') ) {s = 64;}

                        else if ( (LA4_0=='K') ) {s = 65;}

                        else if ( (LA4_0=='L') ) {s = 66;}

                        else if ( (LA4_0=='M') ) {s = 67;}

                        else if ( (LA4_0=='N') ) {s = 68;}

                        else if ( (LA4_0=='O') ) {s = 69;}

                        else if ( (LA4_0=='P') ) {s = 70;}

                        else if ( (LA4_0=='Q') ) {s = 71;}

                        else if ( (LA4_0=='R') ) {s = 72;}

                        else if ( (LA4_0=='S') ) {s = 73;}

                        else if ( (LA4_0=='T') ) {s = 74;}

                        else if ( (LA4_0=='U') ) {s = 75;}

                        else if ( (LA4_0=='V') ) {s = 76;}

                        else if ( (LA4_0=='W') ) {s = 77;}

                        else if ( (LA4_0=='X') ) {s = 78;}

                        else if ( (LA4_0=='Y') ) {s = 79;}

                        else if ( (LA4_0=='Z') ) {s = 80;}

                        else if ( (LA4_0=='1') ) {s = 81;}

                        else if ( (LA4_0=='2') ) {s = 82;}

                        else if ( (LA4_0=='3') ) {s = 83;}

                        else if ( (LA4_0=='4') ) {s = 84;}

                        else if ( (LA4_0=='5') ) {s = 85;}

                        else if ( (LA4_0=='6') ) {s = 86;}

                        else if ( (LA4_0=='7') ) {s = 87;}

                        else if ( (LA4_0=='8') ) {s = 88;}

                        else if ( (LA4_0=='9') ) {s = 89;}

                        else if ( (LA4_0=='0') ) {s = 90;}

                        else if ( (LA4_0==' ') ) {s = 91;}

                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\b')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\u001F')||LA4_0=='\"'||LA4_0=='%'||LA4_0=='/'||LA4_0==';'||LA4_0=='@'||LA4_0=='`'||(LA4_0 >= '~' && LA4_0 <= '\uFFFF')) ) {s = 92;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_1 = input.LA(1);

                        s = -1;
                        if ( (LA4_1=='Q') ) {s = 93;}

                        else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '/')||(LA4_1 >= ':' && LA4_1 <= '@')||(LA4_1 >= '[' && LA4_1 <= '`')||(LA4_1 >= '{' && LA4_1 <= '\uFFFF')) ) {s = 94;}

                        else s = 95;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}