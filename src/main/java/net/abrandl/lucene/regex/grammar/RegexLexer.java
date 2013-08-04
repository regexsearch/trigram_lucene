// $ANTLR 3.4 /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g 2013-08-04 15:39:44

package net.abrandl.lucene.regex.grammar;


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
    public static final int BellChar=14;
    public static final int BlockQuoted=15;
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
    public static final int ControlChar=27;
    public static final int D0=28;
    public static final int D1=29;
    public static final int D2=30;
    public static final int D3=31;
    public static final int D4=32;
    public static final int D5=33;
    public static final int D6=34;
    public static final int D7=35;
    public static final int D8=36;
    public static final int D9=37;
    public static final int DLC=38;
    public static final int DOTANY=39;
    public static final int DUC=40;
    public static final int DecimalDigit=41;
    public static final int Dot=42;
    public static final int ELC=43;
    public static final int ELEMENT=44;
    public static final int EUC=45;
    public static final int EndOfSubject=46;
    public static final int EndOfSubjectOrLine=47;
    public static final int EndOfSubjectOrLineEndOfSubject=48;
    public static final int Equals=49;
    public static final int EscapeChar=50;
    public static final int Exclamation=51;
    public static final int ExtendedUnicodeChar=52;
    public static final int FLC=53;
    public static final int FUC=54;
    public static final int FormFeed=55;
    public static final int GLC=56;
    public static final int GROUP=57;
    public static final int GUC=58;
    public static final int GreaterThan=59;
    public static final int HLC=60;
    public static final int HUC=61;
    public static final int Hash=62;
    public static final int HexChar=63;
    public static final int HexDigit=64;
    public static final int HorizontalWhiteSpace=65;
    public static final int Hyphen=66;
    public static final int ILC=67;
    public static final int IUC=68;
    public static final int JLC=69;
    public static final int JUC=70;
    public static final int KLC=71;
    public static final int KUC=72;
    public static final int LITERAL=73;
    public static final int LLC=74;
    public static final int LUC=75;
    public static final int LessThan=76;
    public static final int MLC=77;
    public static final int MUC=78;
    public static final int NAME=79;
    public static final int NLC=80;
    public static final int NUC=81;
    public static final int NUMBER=82;
    public static final int NamedReferenceStartK=83;
    public static final int NewLine=84;
    public static final int NewLineSequence=85;
    public static final int NonAlphaNumeric=86;
    public static final int NonWordBoundary=87;
    public static final int NotDecimalDigit=88;
    public static final int NotHorizontalWhiteSpace=89;
    public static final int NotNewLine=90;
    public static final int NotVerticalWhiteSpace=91;
    public static final int NotWhiteSpace=92;
    public static final int NotWordChar=93;
    public static final int OLC=94;
    public static final int ONEORMORE=95;
    public static final int OPTIONAL=96;
    public static final int OUC=97;
    public static final int OneDataUnit=98;
    public static final int OpenBrace=99;
    public static final int OpenParen=100;
    public static final int OtherChar=101;
    public static final int PLC=102;
    public static final int PUC=103;
    public static final int Pipe=104;
    public static final int Plus=105;
    public static final int PreviousMatchInSubject=106;
    public static final int QLC=107;
    public static final int QUC=108;
    public static final int QuestionMark=109;
    public static final int Quoted=110;
    public static final int RLC=111;
    public static final int RUC=112;
    public static final int ResetStartMatch=113;
    public static final int SLC=114;
    public static final int SUC=115;
    public static final int SingleQuote=116;
    public static final int Star=117;
    public static final int StartOfSubject=118;
    public static final int SubroutineOrNamedReferenceStartG=119;
    public static final int TLC=120;
    public static final int TUC=121;
    public static final int Tab=122;
    public static final int ULC=123;
    public static final int UUC=124;
    public static final int Underscore=125;
    public static final int UnderscoreAlphaNumerics=126;
    public static final int VLC=127;
    public static final int VUC=128;
    public static final int VerticalWhiteSpace=129;
    public static final int WLC=130;
    public static final int WUC=131;
    public static final int WhiteSpace=132;
    public static final int WordBoundary=133;
    public static final int WordChar=134;
    public static final int XLC=135;
    public static final int XUC=136;
    public static final int YLC=137;
    public static final int YUC=138;
    public static final int ZEROORMORE=139;
    public static final int ZLC=140;
    public static final int ZUC=141;

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
    public String getGrammarFileName() { return "/home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g"; }

    // $ANTLR start "Quoted"
    public final void mQuoted() throws RecognitionException {
        try {
            int _type = Quoted;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:250:3: ( '\\\\' NonAlphaNumeric )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:251:3: '\\\\' NonAlphaNumeric
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:248:3: ( '\\\\Q' ( . )* '\\\\E' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:249:3: '\\\\Q' ( . )* '\\\\E'
            {
            match("\\Q"); 



            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:249:9: ( . )*
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
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:249:9: .
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

    // $ANTLR start "BellChar"
    public final void mBellChar() throws RecognitionException {
        try {
            int _type = BellChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:269:3: ( '\\\\a' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:270:3: '\\\\a'
            {
            match("\\a"); 




                    setText("\u0007");
                   

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BellChar"

    // $ANTLR start "ControlChar"
    public final void mControlChar() throws RecognitionException {
        try {
            int _type = ControlChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken ASCII1=null;

            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:277:3: ( '\\\\c' ASCII )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:278:3: '\\\\c' ASCII
            {
            match("\\c"); 



            int ASCII1Start147 = getCharIndex();
            int ASCII1StartLine147 = getLine();
            int ASCII1StartCharPos147 = getCharPositionInLine();
            mASCII(); 
            ASCII1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ASCII1Start147, getCharIndex()-1);
            ASCII1.setLine(ASCII1StartLine147);
            ASCII1.setCharPositionInLine(ASCII1StartCharPos147);



                          setText((ASCII1!=null?ASCII1.getText():null));
                         

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ControlChar"

    // $ANTLR start "EscapeChar"
    public final void mEscapeChar() throws RecognitionException {
        try {
            int _type = EscapeChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:285:3: ( '\\\\e' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:286:3: '\\\\e'
            {
            match("\\e"); 




                    setText(String.valueOf((char) 0x1B));
                   

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeChar"

    // $ANTLR start "FormFeed"
    public final void mFormFeed() throws RecognitionException {
        try {
            int _type = FormFeed;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:293:3: ( '\\\\f' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:294:3: '\\\\f'
            {
            match("\\f"); 




                    setText(String.valueOf((char) 0x0C));
                   

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FormFeed"

    // $ANTLR start "NewLine"
    public final void mNewLine() throws RecognitionException {
        try {
            int _type = NewLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:301:3: ( '\\\\n' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:302:3: '\\\\n'
            {
            match("\\n"); 




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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:309:3: ( '\\\\r' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:310:3: '\\\\r'
            {
            match("\\r"); 




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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:317:3: ( '\\\\t' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:318:3: '\\\\t'
            {
            match("\\t"); 




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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:325:3: ( '\\\\' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:326:3: '\\\\'
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

    // $ANTLR start "HexChar"
    public final void mHexChar() throws RecognitionException {
        try {
            int _type = HexChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:330:3: ( '\\\\x' ( HexDigit HexDigit | '{' HexDigit HexDigit ( HexDigit )+ '}' ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:331:3: '\\\\x' ( HexDigit HexDigit | '{' HexDigit HexDigit ( HexDigit )+ '}' )
            {
            match("\\x"); 



            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:332:3: ( HexDigit HexDigit | '{' HexDigit HexDigit ( HexDigit )+ '}' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'F')||(LA3_0 >= 'a' && LA3_0 <= 'f')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='{') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:333:5: HexDigit HexDigit
                    {
                    mHexDigit(); 


                    mHexDigit(); 



                                          int hex = Integer.valueOf(getText().substring(2), 16);
                                          setText(Character.valueOf((char) hex).toString());
                                         

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:338:7: '{' HexDigit HexDigit ( HexDigit )+ '}'
                    {
                    match('{'); 

                    mHexDigit(); 


                    mHexDigit(); 


                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:338:29: ( HexDigit )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'F')||(LA2_0 >= 'a' && LA2_0 <= 'f')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match('}'); 


                                                              int hex = Integer.valueOf(getText().substring(3, getText().length() - 1), 16);
                                                              char[] utf16 = Character.toChars(hex);
                                                              setText(new String(utf16));
                                                             

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HexChar"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:371:3: ( '.' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:372:3: '.'
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

    // $ANTLR start "OneDataUnit"
    public final void mOneDataUnit() throws RecognitionException {
        try {
            int _type = OneDataUnit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:376:3: ( '\\\\C' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:377:3: '\\\\C'
            {
            match("\\C"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OneDataUnit"

    // $ANTLR start "DecimalDigit"
    public final void mDecimalDigit() throws RecognitionException {
        try {
            int _type = DecimalDigit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:381:3: ( '\\\\d' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:382:3: '\\\\d'
            {
            match("\\d"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DecimalDigit"

    // $ANTLR start "NotDecimalDigit"
    public final void mNotDecimalDigit() throws RecognitionException {
        try {
            int _type = NotDecimalDigit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:386:3: ( '\\\\D' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:387:3: '\\\\D'
            {
            match("\\D"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NotDecimalDigit"

    // $ANTLR start "HorizontalWhiteSpace"
    public final void mHorizontalWhiteSpace() throws RecognitionException {
        try {
            int _type = HorizontalWhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:391:3: ( '\\\\h' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:392:3: '\\\\h'
            {
            match("\\h"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HorizontalWhiteSpace"

    // $ANTLR start "NotHorizontalWhiteSpace"
    public final void mNotHorizontalWhiteSpace() throws RecognitionException {
        try {
            int _type = NotHorizontalWhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:396:3: ( '\\\\H' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:397:3: '\\\\H'
            {
            match("\\H"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NotHorizontalWhiteSpace"

    // $ANTLR start "NotNewLine"
    public final void mNotNewLine() throws RecognitionException {
        try {
            int _type = NotNewLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:401:3: ( '\\\\N' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:402:3: '\\\\N'
            {
            match("\\N"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NotNewLine"

    // $ANTLR start "NewLineSequence"
    public final void mNewLineSequence() throws RecognitionException {
        try {
            int _type = NewLineSequence;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:406:3: ( '\\\\R' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:407:3: '\\\\R'
            {
            match("\\R"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NewLineSequence"

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:411:3: ( '\\\\s' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:412:3: '\\\\s'
            {
            match("\\s"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WhiteSpace"

    // $ANTLR start "NotWhiteSpace"
    public final void mNotWhiteSpace() throws RecognitionException {
        try {
            int _type = NotWhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:416:3: ( '\\\\S' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:417:3: '\\\\S'
            {
            match("\\S"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NotWhiteSpace"

    // $ANTLR start "VerticalWhiteSpace"
    public final void mVerticalWhiteSpace() throws RecognitionException {
        try {
            int _type = VerticalWhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:421:3: ( '\\\\v' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:422:3: '\\\\v'
            {
            match("\\v"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VerticalWhiteSpace"

    // $ANTLR start "NotVerticalWhiteSpace"
    public final void mNotVerticalWhiteSpace() throws RecognitionException {
        try {
            int _type = NotVerticalWhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:426:3: ( '\\\\V' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:427:3: '\\\\V'
            {
            match("\\V"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NotVerticalWhiteSpace"

    // $ANTLR start "WordChar"
    public final void mWordChar() throws RecognitionException {
        try {
            int _type = WordChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:431:3: ( '\\\\w' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:432:3: '\\\\w'
            {
            match("\\w"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WordChar"

    // $ANTLR start "NotWordChar"
    public final void mNotWordChar() throws RecognitionException {
        try {
            int _type = NotWordChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:436:3: ( '\\\\W' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:437:3: '\\\\W'
            {
            match("\\W"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NotWordChar"

    // $ANTLR start "ExtendedUnicodeChar"
    public final void mExtendedUnicodeChar() throws RecognitionException {
        try {
            int _type = ExtendedUnicodeChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:441:3: ( '\\\\X' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:442:3: '\\\\X'
            {
            match("\\X"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ExtendedUnicodeChar"

    // $ANTLR start "CharacterClassStart"
    public final void mCharacterClassStart() throws RecognitionException {
        try {
            int _type = CharacterClassStart;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:473:3: ( '[' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:474:3: '['
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:478:3: ( ']' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:479:3: ']'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:483:3: ( '^' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:484:3: '^'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:488:3: ( '-' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:489:3: '-'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:493:3: ( '?' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:494:3: '?'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:498:3: ( '+' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:499:3: '+'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:503:3: ( '*' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:504:3: '*'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:508:3: ( '{' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:509:3: '{'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:513:3: ( '}' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:514:3: '}'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:518:3: ( ',' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:519:3: ','
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

    // $ANTLR start "WordBoundary"
    public final void mWordBoundary() throws RecognitionException {
        try {
            int _type = WordBoundary;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:538:3: ( '\\\\b' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:539:3: '\\\\b'
            {
            match("\\b"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WordBoundary"

    // $ANTLR start "NonWordBoundary"
    public final void mNonWordBoundary() throws RecognitionException {
        try {
            int _type = NonWordBoundary;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:543:3: ( '\\\\B' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:544:3: '\\\\B'
            {
            match("\\B"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NonWordBoundary"

    // $ANTLR start "StartOfSubject"
    public final void mStartOfSubject() throws RecognitionException {
        try {
            int _type = StartOfSubject;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:548:3: ( '\\\\A' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:549:3: '\\\\A'
            {
            match("\\A"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "StartOfSubject"

    // $ANTLR start "EndOfSubjectOrLine"
    public final void mEndOfSubjectOrLine() throws RecognitionException {
        try {
            int _type = EndOfSubjectOrLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:553:3: ( '$' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:554:3: '$'
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

    // $ANTLR start "EndOfSubjectOrLineEndOfSubject"
    public final void mEndOfSubjectOrLineEndOfSubject() throws RecognitionException {
        try {
            int _type = EndOfSubjectOrLineEndOfSubject;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:558:3: ( '\\\\Z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:559:3: '\\\\Z'
            {
            match("\\Z"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EndOfSubjectOrLineEndOfSubject"

    // $ANTLR start "EndOfSubject"
    public final void mEndOfSubject() throws RecognitionException {
        try {
            int _type = EndOfSubject;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:563:3: ( '\\\\z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:564:3: '\\\\z'
            {
            match("\\z"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EndOfSubject"

    // $ANTLR start "PreviousMatchInSubject"
    public final void mPreviousMatchInSubject() throws RecognitionException {
        try {
            int _type = PreviousMatchInSubject;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:568:3: ( '\\\\G' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:569:3: '\\\\G'
            {
            match("\\G"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PreviousMatchInSubject"

    // $ANTLR start "ResetStartMatch"
    public final void mResetStartMatch() throws RecognitionException {
        try {
            int _type = ResetStartMatch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:577:3: ( '\\\\K' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:578:3: '\\\\K'
            {
            match("\\K"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ResetStartMatch"

    // $ANTLR start "SubroutineOrNamedReferenceStartG"
    public final void mSubroutineOrNamedReferenceStartG() throws RecognitionException {
        try {
            int _type = SubroutineOrNamedReferenceStartG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:582:3: ( '\\\\g' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:583:3: '\\\\g'
            {
            match("\\g"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SubroutineOrNamedReferenceStartG"

    // $ANTLR start "NamedReferenceStartK"
    public final void mNamedReferenceStartK() throws RecognitionException {
        try {
            int _type = NamedReferenceStartK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:587:3: ( '\\\\k' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:588:3: '\\\\k'
            {
            match("\\k"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NamedReferenceStartK"

    // $ANTLR start "Pipe"
    public final void mPipe() throws RecognitionException {
        try {
            int _type = Pipe;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:592:3: ( '|' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:593:3: '|'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:597:3: ( '(' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:598:3: '('
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:602:3: ( ')' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:603:3: ')'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:607:3: ( '<' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:608:3: '<'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:612:3: ( '>' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:613:3: '>'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:617:3: ( '\\'' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:618:3: '\\''
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:622:3: ( '_' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:623:3: '_'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:627:3: ( ':' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:628:3: ':'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:632:3: ( '#' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:633:3: '#'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:637:3: ( '=' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:638:3: '='
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:642:3: ( '!' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:643:3: '!'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:647:3: ( '&' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:648:3: '&'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:652:3: ( 'a' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:653:3: 'a'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:657:3: ( 'b' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:658:3: 'b'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:662:3: ( 'c' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:663:3: 'c'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:667:3: ( 'd' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:668:3: 'd'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:672:3: ( 'e' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:673:3: 'e'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:677:3: ( 'f' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:678:3: 'f'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:682:3: ( 'g' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:683:3: 'g'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:687:3: ( 'h' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:688:3: 'h'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:692:3: ( 'i' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:693:3: 'i'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:697:3: ( 'j' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:698:3: 'j'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:702:3: ( 'k' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:703:3: 'k'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:707:3: ( 'l' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:708:3: 'l'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:712:3: ( 'm' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:713:3: 'm'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:717:3: ( 'n' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:718:3: 'n'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:722:3: ( 'o' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:723:3: 'o'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:727:3: ( 'p' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:728:3: 'p'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:732:3: ( 'q' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:733:3: 'q'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:737:3: ( 'r' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:738:3: 'r'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:742:3: ( 's' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:743:3: 's'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:747:3: ( 't' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:748:3: 't'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:752:3: ( 'u' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:753:3: 'u'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:757:3: ( 'v' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:758:3: 'v'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:762:3: ( 'w' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:763:3: 'w'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:767:3: ( 'x' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:768:3: 'x'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:772:3: ( 'y' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:773:3: 'y'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:777:3: ( 'z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:778:3: 'z'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:782:3: ( 'A' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:783:3: 'A'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:787:3: ( 'B' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:788:3: 'B'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:792:3: ( 'C' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:793:3: 'C'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:797:3: ( 'D' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:798:3: 'D'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:802:3: ( 'E' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:803:3: 'E'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:807:3: ( 'F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:808:3: 'F'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:812:3: ( 'G' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:813:3: 'G'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:817:3: ( 'H' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:818:3: 'H'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:822:3: ( 'I' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:823:3: 'I'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:827:3: ( 'J' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:828:3: 'J'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:832:3: ( 'K' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:833:3: 'K'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:837:3: ( 'L' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:838:3: 'L'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:842:3: ( 'M' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:843:3: 'M'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:847:3: ( 'N' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:848:3: 'N'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:852:3: ( 'O' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:853:3: 'O'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:857:3: ( 'P' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:858:3: 'P'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:862:3: ( 'Q' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:863:3: 'Q'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:867:3: ( 'R' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:868:3: 'R'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:872:3: ( 'S' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:873:3: 'S'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:877:3: ( 'T' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:878:3: 'T'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:882:3: ( 'U' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:883:3: 'U'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:887:3: ( 'V' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:888:3: 'V'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:892:3: ( 'W' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:893:3: 'W'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:897:3: ( 'X' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:898:3: 'X'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:902:3: ( 'Y' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:903:3: 'Y'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:907:3: ( 'Z' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:908:3: 'Z'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:912:3: ( '1' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:913:3: '1'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:917:3: ( '2' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:918:3: '2'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:922:3: ( '3' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:923:3: '3'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:927:3: ( '4' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:928:3: '4'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:932:3: ( '5' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:933:3: '5'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:937:3: ( '6' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:938:3: '6'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:942:3: ( '7' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:943:3: '7'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:947:3: ( '8' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:948:3: '8'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:952:3: ( '9' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:953:3: '9'
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:957:3: ( '0' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:958:3: '0'
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

    // $ANTLR start "OtherChar"
    public final void mOtherChar() throws RecognitionException {
        try {
            int _type = OtherChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:962:3: ( . )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:963:3: .
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:971:3: ( ( '_' | AlphaNumeric )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:972:3: ( '_' | AlphaNumeric )+
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:972:3: ( '_' | AlphaNumeric )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:980:3: ( ( AlphaNumeric )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:981:3: ( AlphaNumeric )+
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:981:3: ( AlphaNumeric )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:986:3: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:994:3: (~ AlphaNumeric )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1000:3: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1008:3: ( '\\u0000' .. '\\u007F' )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
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
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:8: ( Quoted | BlockQuoted | BellChar | ControlChar | EscapeChar | FormFeed | NewLine | CarriageReturn | Tab | Backslash | HexChar | Dot | OneDataUnit | DecimalDigit | NotDecimalDigit | HorizontalWhiteSpace | NotHorizontalWhiteSpace | NotNewLine | NewLineSequence | WhiteSpace | NotWhiteSpace | VerticalWhiteSpace | NotVerticalWhiteSpace | WordChar | NotWordChar | ExtendedUnicodeChar | CharacterClassStart | CharacterClassEnd | Caret | Hyphen | QuestionMark | Plus | Star | OpenBrace | CloseBrace | Comma | WordBoundary | NonWordBoundary | StartOfSubject | EndOfSubjectOrLine | EndOfSubjectOrLineEndOfSubject | EndOfSubject | PreviousMatchInSubject | ResetStartMatch | SubroutineOrNamedReferenceStartG | NamedReferenceStartK | Pipe | OpenParen | CloseParen | LessThan | GreaterThan | SingleQuote | Underscore | Colon | Hash | Equals | Exclamation | Ampersand | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D0 | OtherChar )
        int alt6=121;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:10: Quoted
                {
                mQuoted(); 


                }
                break;
            case 2 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:17: BlockQuoted
                {
                mBlockQuoted(); 


                }
                break;
            case 3 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:29: BellChar
                {
                mBellChar(); 


                }
                break;
            case 4 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:38: ControlChar
                {
                mControlChar(); 


                }
                break;
            case 5 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:50: EscapeChar
                {
                mEscapeChar(); 


                }
                break;
            case 6 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:61: FormFeed
                {
                mFormFeed(); 


                }
                break;
            case 7 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:70: NewLine
                {
                mNewLine(); 


                }
                break;
            case 8 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:78: CarriageReturn
                {
                mCarriageReturn(); 


                }
                break;
            case 9 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:93: Tab
                {
                mTab(); 


                }
                break;
            case 10 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:97: Backslash
                {
                mBackslash(); 


                }
                break;
            case 11 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:107: HexChar
                {
                mHexChar(); 


                }
                break;
            case 12 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:115: Dot
                {
                mDot(); 


                }
                break;
            case 13 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:119: OneDataUnit
                {
                mOneDataUnit(); 


                }
                break;
            case 14 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:131: DecimalDigit
                {
                mDecimalDigit(); 


                }
                break;
            case 15 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:144: NotDecimalDigit
                {
                mNotDecimalDigit(); 


                }
                break;
            case 16 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:160: HorizontalWhiteSpace
                {
                mHorizontalWhiteSpace(); 


                }
                break;
            case 17 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:181: NotHorizontalWhiteSpace
                {
                mNotHorizontalWhiteSpace(); 


                }
                break;
            case 18 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:205: NotNewLine
                {
                mNotNewLine(); 


                }
                break;
            case 19 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:216: NewLineSequence
                {
                mNewLineSequence(); 


                }
                break;
            case 20 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:232: WhiteSpace
                {
                mWhiteSpace(); 


                }
                break;
            case 21 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:243: NotWhiteSpace
                {
                mNotWhiteSpace(); 


                }
                break;
            case 22 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:257: VerticalWhiteSpace
                {
                mVerticalWhiteSpace(); 


                }
                break;
            case 23 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:276: NotVerticalWhiteSpace
                {
                mNotVerticalWhiteSpace(); 


                }
                break;
            case 24 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:298: WordChar
                {
                mWordChar(); 


                }
                break;
            case 25 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:307: NotWordChar
                {
                mNotWordChar(); 


                }
                break;
            case 26 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:319: ExtendedUnicodeChar
                {
                mExtendedUnicodeChar(); 


                }
                break;
            case 27 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:339: CharacterClassStart
                {
                mCharacterClassStart(); 


                }
                break;
            case 28 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:359: CharacterClassEnd
                {
                mCharacterClassEnd(); 


                }
                break;
            case 29 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:377: Caret
                {
                mCaret(); 


                }
                break;
            case 30 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:383: Hyphen
                {
                mHyphen(); 


                }
                break;
            case 31 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:390: QuestionMark
                {
                mQuestionMark(); 


                }
                break;
            case 32 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:403: Plus
                {
                mPlus(); 


                }
                break;
            case 33 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:408: Star
                {
                mStar(); 


                }
                break;
            case 34 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:413: OpenBrace
                {
                mOpenBrace(); 


                }
                break;
            case 35 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:423: CloseBrace
                {
                mCloseBrace(); 


                }
                break;
            case 36 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:434: Comma
                {
                mComma(); 


                }
                break;
            case 37 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:440: WordBoundary
                {
                mWordBoundary(); 


                }
                break;
            case 38 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:453: NonWordBoundary
                {
                mNonWordBoundary(); 


                }
                break;
            case 39 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:469: StartOfSubject
                {
                mStartOfSubject(); 


                }
                break;
            case 40 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:484: EndOfSubjectOrLine
                {
                mEndOfSubjectOrLine(); 


                }
                break;
            case 41 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:503: EndOfSubjectOrLineEndOfSubject
                {
                mEndOfSubjectOrLineEndOfSubject(); 


                }
                break;
            case 42 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:534: EndOfSubject
                {
                mEndOfSubject(); 


                }
                break;
            case 43 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:547: PreviousMatchInSubject
                {
                mPreviousMatchInSubject(); 


                }
                break;
            case 44 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:570: ResetStartMatch
                {
                mResetStartMatch(); 


                }
                break;
            case 45 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:586: SubroutineOrNamedReferenceStartG
                {
                mSubroutineOrNamedReferenceStartG(); 


                }
                break;
            case 46 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:619: NamedReferenceStartK
                {
                mNamedReferenceStartK(); 


                }
                break;
            case 47 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:640: Pipe
                {
                mPipe(); 


                }
                break;
            case 48 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:645: OpenParen
                {
                mOpenParen(); 


                }
                break;
            case 49 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:655: CloseParen
                {
                mCloseParen(); 


                }
                break;
            case 50 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:666: LessThan
                {
                mLessThan(); 


                }
                break;
            case 51 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:675: GreaterThan
                {
                mGreaterThan(); 


                }
                break;
            case 52 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:687: SingleQuote
                {
                mSingleQuote(); 


                }
                break;
            case 53 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:699: Underscore
                {
                mUnderscore(); 


                }
                break;
            case 54 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:710: Colon
                {
                mColon(); 


                }
                break;
            case 55 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:716: Hash
                {
                mHash(); 


                }
                break;
            case 56 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:721: Equals
                {
                mEquals(); 


                }
                break;
            case 57 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:728: Exclamation
                {
                mExclamation(); 


                }
                break;
            case 58 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:740: Ampersand
                {
                mAmpersand(); 


                }
                break;
            case 59 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:750: ALC
                {
                mALC(); 


                }
                break;
            case 60 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:754: BLC
                {
                mBLC(); 


                }
                break;
            case 61 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:758: CLC
                {
                mCLC(); 


                }
                break;
            case 62 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:762: DLC
                {
                mDLC(); 


                }
                break;
            case 63 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:766: ELC
                {
                mELC(); 


                }
                break;
            case 64 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:770: FLC
                {
                mFLC(); 


                }
                break;
            case 65 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:774: GLC
                {
                mGLC(); 


                }
                break;
            case 66 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:778: HLC
                {
                mHLC(); 


                }
                break;
            case 67 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:782: ILC
                {
                mILC(); 


                }
                break;
            case 68 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:786: JLC
                {
                mJLC(); 


                }
                break;
            case 69 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:790: KLC
                {
                mKLC(); 


                }
                break;
            case 70 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:794: LLC
                {
                mLLC(); 


                }
                break;
            case 71 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:798: MLC
                {
                mMLC(); 


                }
                break;
            case 72 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:802: NLC
                {
                mNLC(); 


                }
                break;
            case 73 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:806: OLC
                {
                mOLC(); 


                }
                break;
            case 74 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:810: PLC
                {
                mPLC(); 


                }
                break;
            case 75 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:814: QLC
                {
                mQLC(); 


                }
                break;
            case 76 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:818: RLC
                {
                mRLC(); 


                }
                break;
            case 77 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:822: SLC
                {
                mSLC(); 


                }
                break;
            case 78 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:826: TLC
                {
                mTLC(); 


                }
                break;
            case 79 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:830: ULC
                {
                mULC(); 


                }
                break;
            case 80 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:834: VLC
                {
                mVLC(); 


                }
                break;
            case 81 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:838: WLC
                {
                mWLC(); 


                }
                break;
            case 82 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:842: XLC
                {
                mXLC(); 


                }
                break;
            case 83 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:846: YLC
                {
                mYLC(); 


                }
                break;
            case 84 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:850: ZLC
                {
                mZLC(); 


                }
                break;
            case 85 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:854: AUC
                {
                mAUC(); 


                }
                break;
            case 86 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:858: BUC
                {
                mBUC(); 


                }
                break;
            case 87 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:862: CUC
                {
                mCUC(); 


                }
                break;
            case 88 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:866: DUC
                {
                mDUC(); 


                }
                break;
            case 89 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:870: EUC
                {
                mEUC(); 


                }
                break;
            case 90 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:874: FUC
                {
                mFUC(); 


                }
                break;
            case 91 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:878: GUC
                {
                mGUC(); 


                }
                break;
            case 92 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:882: HUC
                {
                mHUC(); 


                }
                break;
            case 93 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:886: IUC
                {
                mIUC(); 


                }
                break;
            case 94 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:890: JUC
                {
                mJUC(); 


                }
                break;
            case 95 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:894: KUC
                {
                mKUC(); 


                }
                break;
            case 96 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:898: LUC
                {
                mLUC(); 


                }
                break;
            case 97 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:902: MUC
                {
                mMUC(); 


                }
                break;
            case 98 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:906: NUC
                {
                mNUC(); 


                }
                break;
            case 99 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:910: OUC
                {
                mOUC(); 


                }
                break;
            case 100 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:914: PUC
                {
                mPUC(); 


                }
                break;
            case 101 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:918: QUC
                {
                mQUC(); 


                }
                break;
            case 102 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:922: RUC
                {
                mRUC(); 


                }
                break;
            case 103 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:926: SUC
                {
                mSUC(); 


                }
                break;
            case 104 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:930: TUC
                {
                mTUC(); 


                }
                break;
            case 105 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:934: UUC
                {
                mUUC(); 


                }
                break;
            case 106 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:938: VUC
                {
                mVUC(); 


                }
                break;
            case 107 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:942: WUC
                {
                mWUC(); 


                }
                break;
            case 108 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:946: XUC
                {
                mXUC(); 


                }
                break;
            case 109 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:950: YUC
                {
                mYUC(); 


                }
                break;
            case 110 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:954: ZUC
                {
                mZUC(); 


                }
                break;
            case 111 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:958: D1
                {
                mD1(); 


                }
                break;
            case 112 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:961: D2
                {
                mD2(); 


                }
                break;
            case 113 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:964: D3
                {
                mD3(); 


                }
                break;
            case 114 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:967: D4
                {
                mD4(); 


                }
                break;
            case 115 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:970: D5
                {
                mD5(); 


                }
                break;
            case 116 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:973: D6
                {
                mD6(); 


                }
                break;
            case 117 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:976: D7
                {
                mD7(); 


                }
                break;
            case 118 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:979: D8
                {
                mD8(); 


                }
                break;
            case 119 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:982: D9
                {
                mD9(); 


                }
                break;
            case 120 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:985: D0
                {
                mD0(); 


                }
                break;
            case 121 :
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:1:988: OtherChar
                {
                mOtherChar(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\1\172\u00cf\uffff";
    static final String DFA6_eofS =
        "\u00d1\uffff";
    static final String DFA6_minS =
        "\2\0\u00cf\uffff";
    static final String DFA6_maxS =
        "\2\uffff\u00cf\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\14\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
        "\1\50\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72"+
        "\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1"+
        "\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120"+
        "\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\1\132\1\133"+
        "\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\145\1\146"+
        "\1\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160\1\161"+
        "\1\162\1\163\1\164\1\165\1\166\1\167\1\170\1\171\1\2\1\3\1\4\1\5"+
        "\1\6\1\7\1\10\1\11\1\13\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
        "\1\25\1\26\1\27\1\30\1\31\1\32\1\45\1\46\1\47\1\51\1\52\1\53\1\54"+
        "\1\55\1\56\1\1\1\12\1\14\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
        "\1\43\1\44\1\50\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70"+
        "\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104"+
        "\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117"+
        "\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\1\132"+
        "\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\145"+
        "\1\146\1\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160"+
        "\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\170";
    static final String DFA6_specialS =
        "\1\1\1\0\u00cf\uffff}>";
    static final String[] DFA6_transitionS = {
            "\41\130\1\30\1\130\1\26\1\15\1\130\1\31\1\23\1\17\1\20\1\11"+
            "\1\10\1\14\1\6\1\2\1\130\1\127\1\116\1\117\1\120\1\121\1\122"+
            "\1\123\1\124\1\125\1\126\1\25\1\130\1\21\1\27\1\22\1\7\1\130"+
            "\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
            "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111"+
            "\1\112\1\113\1\114\1\115\1\3\1\1\1\4\1\5\1\24\1\130\1\32\1\33"+
            "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
            "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
            "\1\12\1\16\1\13\uff82\130",
            "\60\171\12\uffff\7\171\1\162\1\161\1\142\1\144\2\uffff\1\165"+
            "\1\146\2\uffff\1\166\2\uffff\1\147\2\uffff\1\131\1\150\1\152"+
            "\2\uffff\1\154\1\156\1\157\1\uffff\1\163\6\171\1\132\1\160\1"+
            "\133\1\143\1\134\1\135\1\167\1\145\2\uffff\1\170\2\uffff\1\136"+
            "\3\uffff\1\137\1\151\1\140\1\uffff\1\153\1\155\1\141\1\uffff"+
            "\1\164\uff85\171",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Quoted | BlockQuoted | BellChar | ControlChar | EscapeChar | FormFeed | NewLine | CarriageReturn | Tab | Backslash | HexChar | Dot | OneDataUnit | DecimalDigit | NotDecimalDigit | HorizontalWhiteSpace | NotHorizontalWhiteSpace | NotNewLine | NewLineSequence | WhiteSpace | NotWhiteSpace | VerticalWhiteSpace | NotVerticalWhiteSpace | WordChar | NotWordChar | ExtendedUnicodeChar | CharacterClassStart | CharacterClassEnd | Caret | Hyphen | QuestionMark | Plus | Star | OpenBrace | CloseBrace | Comma | WordBoundary | NonWordBoundary | StartOfSubject | EndOfSubjectOrLine | EndOfSubjectOrLineEndOfSubject | EndOfSubject | PreviousMatchInSubject | ResetStartMatch | SubroutineOrNamedReferenceStartG | NamedReferenceStartK | Pipe | OpenParen | CloseParen | LessThan | GreaterThan | SingleQuote | Underscore | Colon | Hash | Equals | Exclamation | Ampersand | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D0 | OtherChar );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_1 = input.LA(1);

                        s = -1;
                        if ( (LA6_1=='Q') ) {s = 89;}

                        else if ( (LA6_1=='a') ) {s = 90;}

                        else if ( (LA6_1=='c') ) {s = 91;}

                        else if ( (LA6_1=='e') ) {s = 92;}

                        else if ( (LA6_1=='f') ) {s = 93;}

                        else if ( (LA6_1=='n') ) {s = 94;}

                        else if ( (LA6_1=='r') ) {s = 95;}

                        else if ( (LA6_1=='t') ) {s = 96;}

                        else if ( (LA6_1=='x') ) {s = 97;}

                        else if ( (LA6_1=='C') ) {s = 98;}

                        else if ( (LA6_1=='d') ) {s = 99;}

                        else if ( (LA6_1=='D') ) {s = 100;}

                        else if ( (LA6_1=='h') ) {s = 101;}

                        else if ( (LA6_1=='H') ) {s = 102;}

                        else if ( (LA6_1=='N') ) {s = 103;}

                        else if ( (LA6_1=='R') ) {s = 104;}

                        else if ( (LA6_1=='s') ) {s = 105;}

                        else if ( (LA6_1=='S') ) {s = 106;}

                        else if ( (LA6_1=='v') ) {s = 107;}

                        else if ( (LA6_1=='V') ) {s = 108;}

                        else if ( (LA6_1=='w') ) {s = 109;}

                        else if ( (LA6_1=='W') ) {s = 110;}

                        else if ( (LA6_1=='X') ) {s = 111;}

                        else if ( (LA6_1=='b') ) {s = 112;}

                        else if ( (LA6_1=='B') ) {s = 113;}

                        else if ( (LA6_1=='A') ) {s = 114;}

                        else if ( (LA6_1=='Z') ) {s = 115;}

                        else if ( (LA6_1=='z') ) {s = 116;}

                        else if ( (LA6_1=='G') ) {s = 117;}

                        else if ( (LA6_1=='K') ) {s = 118;}

                        else if ( (LA6_1=='g') ) {s = 119;}

                        else if ( (LA6_1=='k') ) {s = 120;}

                        else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '/')||(LA6_1 >= ':' && LA6_1 <= '@')||(LA6_1 >= '[' && LA6_1 <= '`')||(LA6_1 >= '{' && LA6_1 <= '\uFFFF')) ) {s = 121;}

                        else s = 122;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_0 = input.LA(1);

                        s = -1;
                        if ( (LA6_0=='\\') ) {s = 1;}

                        else if ( (LA6_0=='.') ) {s = 2;}

                        else if ( (LA6_0=='[') ) {s = 3;}

                        else if ( (LA6_0==']') ) {s = 4;}

                        else if ( (LA6_0=='^') ) {s = 5;}

                        else if ( (LA6_0=='-') ) {s = 6;}

                        else if ( (LA6_0=='?') ) {s = 7;}

                        else if ( (LA6_0=='+') ) {s = 8;}

                        else if ( (LA6_0=='*') ) {s = 9;}

                        else if ( (LA6_0=='{') ) {s = 10;}

                        else if ( (LA6_0=='}') ) {s = 11;}

                        else if ( (LA6_0==',') ) {s = 12;}

                        else if ( (LA6_0=='$') ) {s = 13;}

                        else if ( (LA6_0=='|') ) {s = 14;}

                        else if ( (LA6_0=='(') ) {s = 15;}

                        else if ( (LA6_0==')') ) {s = 16;}

                        else if ( (LA6_0=='<') ) {s = 17;}

                        else if ( (LA6_0=='>') ) {s = 18;}

                        else if ( (LA6_0=='\'') ) {s = 19;}

                        else if ( (LA6_0=='_') ) {s = 20;}

                        else if ( (LA6_0==':') ) {s = 21;}

                        else if ( (LA6_0=='#') ) {s = 22;}

                        else if ( (LA6_0=='=') ) {s = 23;}

                        else if ( (LA6_0=='!') ) {s = 24;}

                        else if ( (LA6_0=='&') ) {s = 25;}

                        else if ( (LA6_0=='a') ) {s = 26;}

                        else if ( (LA6_0=='b') ) {s = 27;}

                        else if ( (LA6_0=='c') ) {s = 28;}

                        else if ( (LA6_0=='d') ) {s = 29;}

                        else if ( (LA6_0=='e') ) {s = 30;}

                        else if ( (LA6_0=='f') ) {s = 31;}

                        else if ( (LA6_0=='g') ) {s = 32;}

                        else if ( (LA6_0=='h') ) {s = 33;}

                        else if ( (LA6_0=='i') ) {s = 34;}

                        else if ( (LA6_0=='j') ) {s = 35;}

                        else if ( (LA6_0=='k') ) {s = 36;}

                        else if ( (LA6_0=='l') ) {s = 37;}

                        else if ( (LA6_0=='m') ) {s = 38;}

                        else if ( (LA6_0=='n') ) {s = 39;}

                        else if ( (LA6_0=='o') ) {s = 40;}

                        else if ( (LA6_0=='p') ) {s = 41;}

                        else if ( (LA6_0=='q') ) {s = 42;}

                        else if ( (LA6_0=='r') ) {s = 43;}

                        else if ( (LA6_0=='s') ) {s = 44;}

                        else if ( (LA6_0=='t') ) {s = 45;}

                        else if ( (LA6_0=='u') ) {s = 46;}

                        else if ( (LA6_0=='v') ) {s = 47;}

                        else if ( (LA6_0=='w') ) {s = 48;}

                        else if ( (LA6_0=='x') ) {s = 49;}

                        else if ( (LA6_0=='y') ) {s = 50;}

                        else if ( (LA6_0=='z') ) {s = 51;}

                        else if ( (LA6_0=='A') ) {s = 52;}

                        else if ( (LA6_0=='B') ) {s = 53;}

                        else if ( (LA6_0=='C') ) {s = 54;}

                        else if ( (LA6_0=='D') ) {s = 55;}

                        else if ( (LA6_0=='E') ) {s = 56;}

                        else if ( (LA6_0=='F') ) {s = 57;}

                        else if ( (LA6_0=='G') ) {s = 58;}

                        else if ( (LA6_0=='H') ) {s = 59;}

                        else if ( (LA6_0=='I') ) {s = 60;}

                        else if ( (LA6_0=='J') ) {s = 61;}

                        else if ( (LA6_0=='K') ) {s = 62;}

                        else if ( (LA6_0=='L') ) {s = 63;}

                        else if ( (LA6_0=='M') ) {s = 64;}

                        else if ( (LA6_0=='N') ) {s = 65;}

                        else if ( (LA6_0=='O') ) {s = 66;}

                        else if ( (LA6_0=='P') ) {s = 67;}

                        else if ( (LA6_0=='Q') ) {s = 68;}

                        else if ( (LA6_0=='R') ) {s = 69;}

                        else if ( (LA6_0=='S') ) {s = 70;}

                        else if ( (LA6_0=='T') ) {s = 71;}

                        else if ( (LA6_0=='U') ) {s = 72;}

                        else if ( (LA6_0=='V') ) {s = 73;}

                        else if ( (LA6_0=='W') ) {s = 74;}

                        else if ( (LA6_0=='X') ) {s = 75;}

                        else if ( (LA6_0=='Y') ) {s = 76;}

                        else if ( (LA6_0=='Z') ) {s = 77;}

                        else if ( (LA6_0=='1') ) {s = 78;}

                        else if ( (LA6_0=='2') ) {s = 79;}

                        else if ( (LA6_0=='3') ) {s = 80;}

                        else if ( (LA6_0=='4') ) {s = 81;}

                        else if ( (LA6_0=='5') ) {s = 82;}

                        else if ( (LA6_0=='6') ) {s = 83;}

                        else if ( (LA6_0=='7') ) {s = 84;}

                        else if ( (LA6_0=='8') ) {s = 85;}

                        else if ( (LA6_0=='9') ) {s = 86;}

                        else if ( (LA6_0=='0') ) {s = 87;}

                        else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ' ')||LA6_0=='\"'||LA6_0=='%'||LA6_0=='/'||LA6_0==';'||LA6_0=='@'||LA6_0=='`'||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 88;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}