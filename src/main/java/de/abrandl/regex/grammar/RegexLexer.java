// $ANTLR 3.4 /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g 2013-10-21 16:01:44

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
    public static final int At=11;
    public static final int BLC=12;
    public static final int BUC=13;
    public static final int Backslash=14;
    public static final int BlockQuoted=15;
    public static final int CHARACTER_CLASS=16;
    public static final int CLC=17;
    public static final int CONCATENATION=18;
    public static final int CUC=19;
    public static final int Caret=20;
    public static final int CarriageReturn=21;
    public static final int CloseBrace=22;
    public static final int CloseBracket=23;
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
    public static final int Dollar=40;
    public static final int Dot=41;
    public static final int DoubleQuote=42;
    public static final int ELC=43;
    public static final int ELEMENT=44;
    public static final int EUC=45;
    public static final int Equals=46;
    public static final int Exclamation=47;
    public static final int FLC=48;
    public static final int FUC=49;
    public static final int GLC=50;
    public static final int GROUP=51;
    public static final int GUC=52;
    public static final int GraveAccent=53;
    public static final int GreaterThan=54;
    public static final int HLC=55;
    public static final int HUC=56;
    public static final int Hash=57;
    public static final int HexDigit=58;
    public static final int Hyphen=59;
    public static final int ILC=60;
    public static final int IUC=61;
    public static final int JLC=62;
    public static final int JUC=63;
    public static final int KLC=64;
    public static final int KUC=65;
    public static final int LITERAL=66;
    public static final int LLC=67;
    public static final int LUC=68;
    public static final int LessThan=69;
    public static final int MLC=70;
    public static final int MUC=71;
    public static final int NAME=72;
    public static final int NLC=73;
    public static final int NUC=74;
    public static final int NUMBER=75;
    public static final int NewLine=76;
    public static final int NonAlphaNumeric=77;
    public static final int OLC=78;
    public static final int ONEORMORE=79;
    public static final int OPTIONAL=80;
    public static final int OUC=81;
    public static final int OpenBrace=82;
    public static final int OpenBracket=83;
    public static final int OpenParen=84;
    public static final int OtherChar=85;
    public static final int PLC=86;
    public static final int PUC=87;
    public static final int Percent=88;
    public static final int Pipe=89;
    public static final int Plus=90;
    public static final int QLC=91;
    public static final int QUC=92;
    public static final int QuestionMark=93;
    public static final int Quoted=94;
    public static final int RANGE=95;
    public static final int RLC=96;
    public static final int RUC=97;
    public static final int SLC=98;
    public static final int SUC=99;
    public static final int Semicolon=100;
    public static final int SingleQuote=101;
    public static final int Slash=102;
    public static final int Star=103;
    public static final int TLC=104;
    public static final int TUC=105;
    public static final int Tab=106;
    public static final int Tilde=107;
    public static final int ULC=108;
    public static final int UUC=109;
    public static final int Underscore=110;
    public static final int UnderscoreAlphaNumerics=111;
    public static final int VLC=112;
    public static final int VUC=113;
    public static final int WHITESPACE=114;
    public static final int WLC=115;
    public static final int WUC=116;
    public static final int XLC=117;
    public static final int XUC=118;
    public static final int YLC=119;
    public static final int YUC=120;
    public static final int ZEROORMORE=121;
    public static final int ZLC=122;
    public static final int ZUC=123;

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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:347:3: ( '\\\\' NonAlphaNumeric )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:348:3: '\\\\' NonAlphaNumeric
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:345:3: ( '\\\\Q' ( . )* '\\\\E' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:346:3: '\\\\Q' ( . )* '\\\\E'
            {
            match("\\Q"); 



            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:346:9: ( . )*
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
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:346:9: .
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:353:3: ( '\\n' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:354:3: '\\n'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:361:3: ( '\\r' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:362:3: '\\r'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:369:3: ( '\\t' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:370:3: '\\t'
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:379:3: ( ' ' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:380:3: ' '
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

    // $ANTLR start "Exclamation"
    public final void mExclamation() throws RecognitionException {
        try {
            int _type = Exclamation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:384:3: ( '!' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:385:3: '!'
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

    // $ANTLR start "DoubleQuote"
    public final void mDoubleQuote() throws RecognitionException {
        try {
            int _type = DoubleQuote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:389:3: ( '\"' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:390:3: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DoubleQuote"

    // $ANTLR start "Hash"
    public final void mHash() throws RecognitionException {
        try {
            int _type = Hash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:394:3: ( '#' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:395:3: '#'
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

    // $ANTLR start "Dollar"
    public final void mDollar() throws RecognitionException {
        try {
            int _type = Dollar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:399:3: ( '$' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:400:3: '$'
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
    // $ANTLR end "Dollar"

    // $ANTLR start "Percent"
    public final void mPercent() throws RecognitionException {
        try {
            int _type = Percent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:404:3: ( '%' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:405:3: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Percent"

    // $ANTLR start "Ampersand"
    public final void mAmpersand() throws RecognitionException {
        try {
            int _type = Ampersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:409:3: ( '&' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:410:3: '&'
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

    // $ANTLR start "SingleQuote"
    public final void mSingleQuote() throws RecognitionException {
        try {
            int _type = SingleQuote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:414:3: ( '\\'' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:415:3: '\\''
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

    // $ANTLR start "OpenParen"
    public final void mOpenParen() throws RecognitionException {
        try {
            int _type = OpenParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:419:3: ( '(' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:420:3: '('
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:424:3: ( ')' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:425:3: ')'
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

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:429:3: ( '*' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:430:3: '*'
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

    // $ANTLR start "Plus"
    public final void mPlus() throws RecognitionException {
        try {
            int _type = Plus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:434:3: ( '+' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:435:3: '+'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:439:3: ( ',' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:440:3: ','
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

    // $ANTLR start "Hyphen"
    public final void mHyphen() throws RecognitionException {
        try {
            int _type = Hyphen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:444:3: ( '-' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:445:3: '-'
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

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:449:3: ( '.' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:450:3: '.'
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

    // $ANTLR start "Slash"
    public final void mSlash() throws RecognitionException {
        try {
            int _type = Slash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:454:3: ( '/' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:455:3: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Slash"

    // $ANTLR start "D0"
    public final void mD0() throws RecognitionException {
        try {
            int _type = D0;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:459:3: ( '0' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:460:3: '0'
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

    // $ANTLR start "D1"
    public final void mD1() throws RecognitionException {
        try {
            int _type = D1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:464:3: ( '1' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:465:3: '1'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:469:3: ( '2' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:470:3: '2'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:474:3: ( '3' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:475:3: '3'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:479:3: ( '4' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:480:3: '4'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:484:3: ( '5' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:485:3: '5'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:489:3: ( '6' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:490:3: '6'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:494:3: ( '7' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:495:3: '7'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:499:3: ( '8' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:500:3: '8'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:504:3: ( '9' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:505:3: '9'
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:509:3: ( ':' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:510:3: ':'
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

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:514:3: ( ';' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:515:3: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "LessThan"
    public final void mLessThan() throws RecognitionException {
        try {
            int _type = LessThan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:519:3: ( '<' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:520:3: '<'
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

    // $ANTLR start "Equals"
    public final void mEquals() throws RecognitionException {
        try {
            int _type = Equals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:524:3: ( '=' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:525:3: '='
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

    // $ANTLR start "GreaterThan"
    public final void mGreaterThan() throws RecognitionException {
        try {
            int _type = GreaterThan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:529:3: ( '>' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:530:3: '>'
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

    // $ANTLR start "QuestionMark"
    public final void mQuestionMark() throws RecognitionException {
        try {
            int _type = QuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:534:3: ( '?' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:535:3: '?'
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

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:539:3: ( '@' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:540:3: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "At"

    // $ANTLR start "AUC"
    public final void mAUC() throws RecognitionException {
        try {
            int _type = AUC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:544:3: ( 'A' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:545:3: 'A'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:549:3: ( 'B' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:550:3: 'B'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:554:3: ( 'C' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:555:3: 'C'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:559:3: ( 'D' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:560:3: 'D'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:564:3: ( 'E' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:565:3: 'E'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:569:3: ( 'F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:570:3: 'F'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:574:3: ( 'G' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:575:3: 'G'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:579:3: ( 'H' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:580:3: 'H'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:584:3: ( 'I' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:585:3: 'I'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:589:3: ( 'J' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:590:3: 'J'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:594:3: ( 'K' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:595:3: 'K'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:599:3: ( 'L' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:600:3: 'L'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:604:3: ( 'M' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:605:3: 'M'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:609:3: ( 'N' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:610:3: 'N'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:614:3: ( 'O' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:615:3: 'O'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:619:3: ( 'P' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:620:3: 'P'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:624:3: ( 'Q' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:625:3: 'Q'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:629:3: ( 'R' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:630:3: 'R'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:634:3: ( 'S' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:635:3: 'S'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:639:3: ( 'T' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:640:3: 'T'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:644:3: ( 'U' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:645:3: 'U'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:649:3: ( 'V' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:650:3: 'V'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:654:3: ( 'W' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:655:3: 'W'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:659:3: ( 'X' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:660:3: 'X'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:664:3: ( 'Y' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:665:3: 'Y'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:669:3: ( 'Z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:670:3: 'Z'
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

    // $ANTLR start "OpenBracket"
    public final void mOpenBracket() throws RecognitionException {
        try {
            int _type = OpenBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:674:3: ( '[' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:675:3: '['
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
    // $ANTLR end "OpenBracket"

    // $ANTLR start "Backslash"
    public final void mBackslash() throws RecognitionException {
        try {
            int _type = Backslash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:679:3: ( '\\\\' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:680:3: '\\\\'
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

    // $ANTLR start "CloseBracket"
    public final void mCloseBracket() throws RecognitionException {
        try {
            int _type = CloseBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:684:3: ( ']' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:685:3: ']'
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
    // $ANTLR end "CloseBracket"

    // $ANTLR start "Caret"
    public final void mCaret() throws RecognitionException {
        try {
            int _type = Caret;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:689:3: ( '^' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:690:3: '^'
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

    // $ANTLR start "Underscore"
    public final void mUnderscore() throws RecognitionException {
        try {
            int _type = Underscore;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:694:3: ( '_' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:695:3: '_'
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

    // $ANTLR start "GraveAccent"
    public final void mGraveAccent() throws RecognitionException {
        try {
            int _type = GraveAccent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:699:3: ( '`' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:700:3: '`'
            {
            match('`'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GraveAccent"

    // $ANTLR start "ALC"
    public final void mALC() throws RecognitionException {
        try {
            int _type = ALC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:704:3: ( 'a' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:705:3: 'a'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:709:3: ( 'b' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:710:3: 'b'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:714:3: ( 'c' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:715:3: 'c'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:719:3: ( 'd' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:720:3: 'd'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:724:3: ( 'e' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:725:3: 'e'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:729:3: ( 'f' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:730:3: 'f'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:734:3: ( 'g' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:735:3: 'g'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:739:3: ( 'h' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:740:3: 'h'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:744:3: ( 'i' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:745:3: 'i'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:749:3: ( 'j' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:750:3: 'j'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:754:3: ( 'k' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:755:3: 'k'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:759:3: ( 'l' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:760:3: 'l'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:764:3: ( 'm' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:765:3: 'm'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:769:3: ( 'n' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:770:3: 'n'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:774:3: ( 'o' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:775:3: 'o'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:779:3: ( 'p' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:780:3: 'p'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:784:3: ( 'q' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:785:3: 'q'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:789:3: ( 'r' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:790:3: 'r'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:794:3: ( 's' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:795:3: 's'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:799:3: ( 't' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:800:3: 't'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:804:3: ( 'u' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:805:3: 'u'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:809:3: ( 'v' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:810:3: 'v'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:814:3: ( 'w' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:815:3: 'w'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:819:3: ( 'x' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:820:3: 'x'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:824:3: ( 'y' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:825:3: 'y'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:829:3: ( 'z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:830:3: 'z'
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

    // $ANTLR start "OpenBrace"
    public final void mOpenBrace() throws RecognitionException {
        try {
            int _type = OpenBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:834:3: ( '{' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:835:3: '{'
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

    // $ANTLR start "Pipe"
    public final void mPipe() throws RecognitionException {
        try {
            int _type = Pipe;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:839:3: ( '|' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:840:3: '|'
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

    // $ANTLR start "CloseBrace"
    public final void mCloseBrace() throws RecognitionException {
        try {
            int _type = CloseBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:844:3: ( '}' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:845:3: '}'
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

    // $ANTLR start "Tilde"
    public final void mTilde() throws RecognitionException {
        try {
            int _type = Tilde;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:849:3: ( '~' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:850:3: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Tilde"

    // $ANTLR start "OtherChar"
    public final void mOtherChar() throws RecognitionException {
        try {
            int _type = OtherChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:856:3: ( . )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:857:3: .
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:865:3: ( ( '_' | AlphaNumeric )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:866:3: ( '_' | AlphaNumeric )+
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:866:3: ( '_' | AlphaNumeric )+
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:874:3: ( ( AlphaNumeric )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:875:3: ( AlphaNumeric )+
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:875:3: ( AlphaNumeric )+
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:880:3: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:888:3: (~ AlphaNumeric )
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:894:3: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:902:3: ( '\\u0000' .. '\\u007F' )
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
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:8: ( Quoted | BlockQuoted | NewLine | CarriageReturn | Tab | WHITESPACE | Exclamation | DoubleQuote | Hash | Dollar | Percent | Ampersand | SingleQuote | OpenParen | CloseParen | Star | Plus | Comma | Hyphen | Dot | Slash | D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | Colon | Semicolon | LessThan | Equals | GreaterThan | QuestionMark | At | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | OpenBracket | Backslash | CloseBracket | Caret | Underscore | GraveAccent | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | OpenBrace | Pipe | CloseBrace | Tilde | OtherChar )
        int alt4=101;
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
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:56: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 7 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:67: Exclamation
                {
                mExclamation(); 


                }
                break;
            case 8 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:79: DoubleQuote
                {
                mDoubleQuote(); 


                }
                break;
            case 9 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:91: Hash
                {
                mHash(); 


                }
                break;
            case 10 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:96: Dollar
                {
                mDollar(); 


                }
                break;
            case 11 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:103: Percent
                {
                mPercent(); 


                }
                break;
            case 12 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:111: Ampersand
                {
                mAmpersand(); 


                }
                break;
            case 13 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:121: SingleQuote
                {
                mSingleQuote(); 


                }
                break;
            case 14 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:133: OpenParen
                {
                mOpenParen(); 


                }
                break;
            case 15 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:143: CloseParen
                {
                mCloseParen(); 


                }
                break;
            case 16 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:154: Star
                {
                mStar(); 


                }
                break;
            case 17 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:159: Plus
                {
                mPlus(); 


                }
                break;
            case 18 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:164: Comma
                {
                mComma(); 


                }
                break;
            case 19 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:170: Hyphen
                {
                mHyphen(); 


                }
                break;
            case 20 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:177: Dot
                {
                mDot(); 


                }
                break;
            case 21 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:181: Slash
                {
                mSlash(); 


                }
                break;
            case 22 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:187: D0
                {
                mD0(); 


                }
                break;
            case 23 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:190: D1
                {
                mD1(); 


                }
                break;
            case 24 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:193: D2
                {
                mD2(); 


                }
                break;
            case 25 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:196: D3
                {
                mD3(); 


                }
                break;
            case 26 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:199: D4
                {
                mD4(); 


                }
                break;
            case 27 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:202: D5
                {
                mD5(); 


                }
                break;
            case 28 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:205: D6
                {
                mD6(); 


                }
                break;
            case 29 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:208: D7
                {
                mD7(); 


                }
                break;
            case 30 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:211: D8
                {
                mD8(); 


                }
                break;
            case 31 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:214: D9
                {
                mD9(); 


                }
                break;
            case 32 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:217: Colon
                {
                mColon(); 


                }
                break;
            case 33 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:223: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 34 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:233: LessThan
                {
                mLessThan(); 


                }
                break;
            case 35 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:242: Equals
                {
                mEquals(); 


                }
                break;
            case 36 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:249: GreaterThan
                {
                mGreaterThan(); 


                }
                break;
            case 37 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:261: QuestionMark
                {
                mQuestionMark(); 


                }
                break;
            case 38 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:274: At
                {
                mAt(); 


                }
                break;
            case 39 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:277: AUC
                {
                mAUC(); 


                }
                break;
            case 40 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:281: BUC
                {
                mBUC(); 


                }
                break;
            case 41 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:285: CUC
                {
                mCUC(); 


                }
                break;
            case 42 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:289: DUC
                {
                mDUC(); 


                }
                break;
            case 43 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:293: EUC
                {
                mEUC(); 


                }
                break;
            case 44 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:297: FUC
                {
                mFUC(); 


                }
                break;
            case 45 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:301: GUC
                {
                mGUC(); 


                }
                break;
            case 46 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:305: HUC
                {
                mHUC(); 


                }
                break;
            case 47 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:309: IUC
                {
                mIUC(); 


                }
                break;
            case 48 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:313: JUC
                {
                mJUC(); 


                }
                break;
            case 49 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:317: KUC
                {
                mKUC(); 


                }
                break;
            case 50 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:321: LUC
                {
                mLUC(); 


                }
                break;
            case 51 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:325: MUC
                {
                mMUC(); 


                }
                break;
            case 52 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:329: NUC
                {
                mNUC(); 


                }
                break;
            case 53 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:333: OUC
                {
                mOUC(); 


                }
                break;
            case 54 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:337: PUC
                {
                mPUC(); 


                }
                break;
            case 55 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:341: QUC
                {
                mQUC(); 


                }
                break;
            case 56 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:345: RUC
                {
                mRUC(); 


                }
                break;
            case 57 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:349: SUC
                {
                mSUC(); 


                }
                break;
            case 58 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:353: TUC
                {
                mTUC(); 


                }
                break;
            case 59 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:357: UUC
                {
                mUUC(); 


                }
                break;
            case 60 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:361: VUC
                {
                mVUC(); 


                }
                break;
            case 61 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:365: WUC
                {
                mWUC(); 


                }
                break;
            case 62 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:369: XUC
                {
                mXUC(); 


                }
                break;
            case 63 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:373: YUC
                {
                mYUC(); 


                }
                break;
            case 64 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:377: ZUC
                {
                mZUC(); 


                }
                break;
            case 65 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:381: OpenBracket
                {
                mOpenBracket(); 


                }
                break;
            case 66 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:393: Backslash
                {
                mBackslash(); 


                }
                break;
            case 67 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:403: CloseBracket
                {
                mCloseBracket(); 


                }
                break;
            case 68 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:416: Caret
                {
                mCaret(); 


                }
                break;
            case 69 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:422: Underscore
                {
                mUnderscore(); 


                }
                break;
            case 70 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:433: GraveAccent
                {
                mGraveAccent(); 


                }
                break;
            case 71 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:445: ALC
                {
                mALC(); 


                }
                break;
            case 72 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:449: BLC
                {
                mBLC(); 


                }
                break;
            case 73 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:453: CLC
                {
                mCLC(); 


                }
                break;
            case 74 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:457: DLC
                {
                mDLC(); 


                }
                break;
            case 75 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:461: ELC
                {
                mELC(); 


                }
                break;
            case 76 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:465: FLC
                {
                mFLC(); 


                }
                break;
            case 77 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:469: GLC
                {
                mGLC(); 


                }
                break;
            case 78 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:473: HLC
                {
                mHLC(); 


                }
                break;
            case 79 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:477: ILC
                {
                mILC(); 


                }
                break;
            case 80 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:481: JLC
                {
                mJLC(); 


                }
                break;
            case 81 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:485: KLC
                {
                mKLC(); 


                }
                break;
            case 82 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:489: LLC
                {
                mLLC(); 


                }
                break;
            case 83 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:493: MLC
                {
                mMLC(); 


                }
                break;
            case 84 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:497: NLC
                {
                mNLC(); 


                }
                break;
            case 85 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:501: OLC
                {
                mOLC(); 


                }
                break;
            case 86 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:505: PLC
                {
                mPLC(); 


                }
                break;
            case 87 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:509: QLC
                {
                mQLC(); 


                }
                break;
            case 88 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:513: RLC
                {
                mRLC(); 


                }
                break;
            case 89 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:517: SLC
                {
                mSLC(); 


                }
                break;
            case 90 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:521: TLC
                {
                mTLC(); 


                }
                break;
            case 91 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:525: ULC
                {
                mULC(); 


                }
                break;
            case 92 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:529: VLC
                {
                mVLC(); 


                }
                break;
            case 93 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:533: WLC
                {
                mWLC(); 


                }
                break;
            case 94 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:537: XLC
                {
                mXLC(); 


                }
                break;
            case 95 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:541: YLC
                {
                mYLC(); 


                }
                break;
            case 96 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:545: ZLC
                {
                mZLC(); 


                }
                break;
            case 97 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:549: OpenBrace
                {
                mOpenBrace(); 


                }
                break;
            case 98 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:559: Pipe
                {
                mPipe(); 


                }
                break;
            case 99 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:564: CloseBrace
                {
                mCloseBrace(); 


                }
                break;
            case 100 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:575: Tilde
                {
                mTilde(); 


                }
                break;
            case 101 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:1:581: OtherChar
                {
                mOtherChar(); 


                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\1\146\u00c6\uffff";
    static final String DFA4_eofS =
        "\u00c8\uffff";
    static final String DFA4_minS =
        "\2\0\u00c6\uffff";
    static final String DFA4_maxS =
        "\2\uffff\u00c6\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
        "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
        "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50"+
        "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65"+
        "\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1"+
        "\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115"+
        "\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130"+
        "\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\143"+
        "\1\144\1\145\1\2\1\1\1\102\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1"+
        "\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
        "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
        "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
        "\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76"+
        "\1\77\1\100\1\101\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125"+
        "\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140"+
        "\1\141\1\142\1\143\1\144";
    static final String DFA4_specialS =
        "\1\0\1\1\u00c6\uffff}>";
    static final String[] DFA4_transitionS = {
            "\11\143\1\4\1\2\2\143\1\3\22\143\1\5\1\6\1\7\1\10\1\11\1\12"+
            "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
            "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
            "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
            "\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72"+
            "\1\73\1\74\1\75\1\76\1\77\1\100\1\1\1\101\1\102\1\103\1\104"+
            "\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116"+
            "\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130"+
            "\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1\142"+
            "\uff81\143",
            "\60\145\12\uffff\7\145\20\uffff\1\144\11\uffff\6\145\32\uffff"+
            "\uff85\145",
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
            return "1:1: Tokens : ( Quoted | BlockQuoted | NewLine | CarriageReturn | Tab | WHITESPACE | Exclamation | DoubleQuote | Hash | Dollar | Percent | Ampersand | SingleQuote | OpenParen | CloseParen | Star | Plus | Comma | Hyphen | Dot | Slash | D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | Colon | Semicolon | LessThan | Equals | GreaterThan | QuestionMark | At | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | OpenBracket | Backslash | CloseBracket | Caret | Underscore | GraveAccent | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | OpenBrace | Pipe | CloseBrace | Tilde | OtherChar );";
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

                        else if ( (LA4_0==' ') ) {s = 5;}

                        else if ( (LA4_0=='!') ) {s = 6;}

                        else if ( (LA4_0=='\"') ) {s = 7;}

                        else if ( (LA4_0=='#') ) {s = 8;}

                        else if ( (LA4_0=='$') ) {s = 9;}

                        else if ( (LA4_0=='%') ) {s = 10;}

                        else if ( (LA4_0=='&') ) {s = 11;}

                        else if ( (LA4_0=='\'') ) {s = 12;}

                        else if ( (LA4_0=='(') ) {s = 13;}

                        else if ( (LA4_0==')') ) {s = 14;}

                        else if ( (LA4_0=='*') ) {s = 15;}

                        else if ( (LA4_0=='+') ) {s = 16;}

                        else if ( (LA4_0==',') ) {s = 17;}

                        else if ( (LA4_0=='-') ) {s = 18;}

                        else if ( (LA4_0=='.') ) {s = 19;}

                        else if ( (LA4_0=='/') ) {s = 20;}

                        else if ( (LA4_0=='0') ) {s = 21;}

                        else if ( (LA4_0=='1') ) {s = 22;}

                        else if ( (LA4_0=='2') ) {s = 23;}

                        else if ( (LA4_0=='3') ) {s = 24;}

                        else if ( (LA4_0=='4') ) {s = 25;}

                        else if ( (LA4_0=='5') ) {s = 26;}

                        else if ( (LA4_0=='6') ) {s = 27;}

                        else if ( (LA4_0=='7') ) {s = 28;}

                        else if ( (LA4_0=='8') ) {s = 29;}

                        else if ( (LA4_0=='9') ) {s = 30;}

                        else if ( (LA4_0==':') ) {s = 31;}

                        else if ( (LA4_0==';') ) {s = 32;}

                        else if ( (LA4_0=='<') ) {s = 33;}

                        else if ( (LA4_0=='=') ) {s = 34;}

                        else if ( (LA4_0=='>') ) {s = 35;}

                        else if ( (LA4_0=='?') ) {s = 36;}

                        else if ( (LA4_0=='@') ) {s = 37;}

                        else if ( (LA4_0=='A') ) {s = 38;}

                        else if ( (LA4_0=='B') ) {s = 39;}

                        else if ( (LA4_0=='C') ) {s = 40;}

                        else if ( (LA4_0=='D') ) {s = 41;}

                        else if ( (LA4_0=='E') ) {s = 42;}

                        else if ( (LA4_0=='F') ) {s = 43;}

                        else if ( (LA4_0=='G') ) {s = 44;}

                        else if ( (LA4_0=='H') ) {s = 45;}

                        else if ( (LA4_0=='I') ) {s = 46;}

                        else if ( (LA4_0=='J') ) {s = 47;}

                        else if ( (LA4_0=='K') ) {s = 48;}

                        else if ( (LA4_0=='L') ) {s = 49;}

                        else if ( (LA4_0=='M') ) {s = 50;}

                        else if ( (LA4_0=='N') ) {s = 51;}

                        else if ( (LA4_0=='O') ) {s = 52;}

                        else if ( (LA4_0=='P') ) {s = 53;}

                        else if ( (LA4_0=='Q') ) {s = 54;}

                        else if ( (LA4_0=='R') ) {s = 55;}

                        else if ( (LA4_0=='S') ) {s = 56;}

                        else if ( (LA4_0=='T') ) {s = 57;}

                        else if ( (LA4_0=='U') ) {s = 58;}

                        else if ( (LA4_0=='V') ) {s = 59;}

                        else if ( (LA4_0=='W') ) {s = 60;}

                        else if ( (LA4_0=='X') ) {s = 61;}

                        else if ( (LA4_0=='Y') ) {s = 62;}

                        else if ( (LA4_0=='Z') ) {s = 63;}

                        else if ( (LA4_0=='[') ) {s = 64;}

                        else if ( (LA4_0==']') ) {s = 65;}

                        else if ( (LA4_0=='^') ) {s = 66;}

                        else if ( (LA4_0=='_') ) {s = 67;}

                        else if ( (LA4_0=='`') ) {s = 68;}

                        else if ( (LA4_0=='a') ) {s = 69;}

                        else if ( (LA4_0=='b') ) {s = 70;}

                        else if ( (LA4_0=='c') ) {s = 71;}

                        else if ( (LA4_0=='d') ) {s = 72;}

                        else if ( (LA4_0=='e') ) {s = 73;}

                        else if ( (LA4_0=='f') ) {s = 74;}

                        else if ( (LA4_0=='g') ) {s = 75;}

                        else if ( (LA4_0=='h') ) {s = 76;}

                        else if ( (LA4_0=='i') ) {s = 77;}

                        else if ( (LA4_0=='j') ) {s = 78;}

                        else if ( (LA4_0=='k') ) {s = 79;}

                        else if ( (LA4_0=='l') ) {s = 80;}

                        else if ( (LA4_0=='m') ) {s = 81;}

                        else if ( (LA4_0=='n') ) {s = 82;}

                        else if ( (LA4_0=='o') ) {s = 83;}

                        else if ( (LA4_0=='p') ) {s = 84;}

                        else if ( (LA4_0=='q') ) {s = 85;}

                        else if ( (LA4_0=='r') ) {s = 86;}

                        else if ( (LA4_0=='s') ) {s = 87;}

                        else if ( (LA4_0=='t') ) {s = 88;}

                        else if ( (LA4_0=='u') ) {s = 89;}

                        else if ( (LA4_0=='v') ) {s = 90;}

                        else if ( (LA4_0=='w') ) {s = 91;}

                        else if ( (LA4_0=='x') ) {s = 92;}

                        else if ( (LA4_0=='y') ) {s = 93;}

                        else if ( (LA4_0=='z') ) {s = 94;}

                        else if ( (LA4_0=='{') ) {s = 95;}

                        else if ( (LA4_0=='|') ) {s = 96;}

                        else if ( (LA4_0=='}') ) {s = 97;}

                        else if ( (LA4_0=='~') ) {s = 98;}

                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\b')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\u001F')||(LA4_0 >= '\u007F' && LA4_0 <= '\uFFFF')) ) {s = 99;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_1 = input.LA(1);

                        s = -1;
                        if ( (LA4_1=='Q') ) {s = 100;}

                        else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '/')||(LA4_1 >= ':' && LA4_1 <= '@')||(LA4_1 >= '[' && LA4_1 <= '`')||(LA4_1 >= '{' && LA4_1 <= '\uFFFF')) ) {s = 101;}

                        else s = 102;

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