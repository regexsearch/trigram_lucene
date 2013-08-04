// $ANTLR 3.4 /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g 2013-08-04 21:10:34

package net.abrandl.lucene.regex.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class RegexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALC", "ALTERNATIVE", "ASCII", "AUC", "AlphaNumeric", "AlphaNumerics", "Ampersand", "BLC", "BUC", "Backslash", "BellChar", "BlockQuoted", "CHARACTER_CLASS", "CLC", "CONCATENATION", "CUC", "Caret", "CarriageReturn", "CharacterClassEnd", "CharacterClassStart", "CloseBrace", "CloseParen", "Colon", "Comma", "ControlChar", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DLC", "DOTANY", "DUC", "DecimalDigit", "Dot", "ELC", "ELEMENT", "EUC", "EndOfSubject", "EndOfSubjectOrLine", "EndOfSubjectOrLineEndOfSubject", "Equals", "EscapeChar", "Exclamation", "ExtendedUnicodeChar", "FLC", "FUC", "FormFeed", "GLC", "GROUP", "GUC", "GreaterThan", "HLC", "HUC", "Hash", "HexChar", "HexDigit", "HorizontalWhiteSpace", "Hyphen", "ILC", "IUC", "JLC", "JUC", "KLC", "KUC", "LITERAL", "LLC", "LUC", "LessThan", "MLC", "MUC", "NAME", "NLC", "NUC", "NUMBER", "NamedReferenceStartK", "NewLine", "NewLineSequence", "NonAlphaNumeric", "NonWordBoundary", "NotDecimalDigit", "NotHorizontalWhiteSpace", "NotNewLine", "NotVerticalWhiteSpace", "NotWhiteSpace", "NotWordChar", "OLC", "ONEORMORE", "OPTIONAL", "OUC", "OneDataUnit", "OpenBrace", "OpenParen", "OtherChar", "PLC", "PUC", "Pipe", "Plus", "PreviousMatchInSubject", "QLC", "QUC", "QuestionMark", "Quoted", "RANGE", "RLC", "RUC", "ResetStartMatch", "SLC", "SUC", "SingleQuote", "Star", "StartOfSubject", "SubroutineOrNamedReferenceStartG", "TLC", "TUC", "Tab", "ULC", "UUC", "Underscore", "UnderscoreAlphaNumerics", "VLC", "VUC", "VerticalWhiteSpace", "WLC", "WUC", "WhiteSpace", "WordBoundary", "WordChar", "XLC", "XUC", "YLC", "YUC", "ZEROORMORE", "ZLC", "ZUC"
    };

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
    public static final int CHARACTER_CLASS=16;
    public static final int CLC=17;
    public static final int CONCATENATION=18;
    public static final int CUC=19;
    public static final int Caret=20;
    public static final int CarriageReturn=21;
    public static final int CharacterClassEnd=22;
    public static final int CharacterClassStart=23;
    public static final int CloseBrace=24;
    public static final int CloseParen=25;
    public static final int Colon=26;
    public static final int Comma=27;
    public static final int ControlChar=28;
    public static final int D0=29;
    public static final int D1=30;
    public static final int D2=31;
    public static final int D3=32;
    public static final int D4=33;
    public static final int D5=34;
    public static final int D6=35;
    public static final int D7=36;
    public static final int D8=37;
    public static final int D9=38;
    public static final int DLC=39;
    public static final int DOTANY=40;
    public static final int DUC=41;
    public static final int DecimalDigit=42;
    public static final int Dot=43;
    public static final int ELC=44;
    public static final int ELEMENT=45;
    public static final int EUC=46;
    public static final int EndOfSubject=47;
    public static final int EndOfSubjectOrLine=48;
    public static final int EndOfSubjectOrLineEndOfSubject=49;
    public static final int Equals=50;
    public static final int EscapeChar=51;
    public static final int Exclamation=52;
    public static final int ExtendedUnicodeChar=53;
    public static final int FLC=54;
    public static final int FUC=55;
    public static final int FormFeed=56;
    public static final int GLC=57;
    public static final int GROUP=58;
    public static final int GUC=59;
    public static final int GreaterThan=60;
    public static final int HLC=61;
    public static final int HUC=62;
    public static final int Hash=63;
    public static final int HexChar=64;
    public static final int HexDigit=65;
    public static final int HorizontalWhiteSpace=66;
    public static final int Hyphen=67;
    public static final int ILC=68;
    public static final int IUC=69;
    public static final int JLC=70;
    public static final int JUC=71;
    public static final int KLC=72;
    public static final int KUC=73;
    public static final int LITERAL=74;
    public static final int LLC=75;
    public static final int LUC=76;
    public static final int LessThan=77;
    public static final int MLC=78;
    public static final int MUC=79;
    public static final int NAME=80;
    public static final int NLC=81;
    public static final int NUC=82;
    public static final int NUMBER=83;
    public static final int NamedReferenceStartK=84;
    public static final int NewLine=85;
    public static final int NewLineSequence=86;
    public static final int NonAlphaNumeric=87;
    public static final int NonWordBoundary=88;
    public static final int NotDecimalDigit=89;
    public static final int NotHorizontalWhiteSpace=90;
    public static final int NotNewLine=91;
    public static final int NotVerticalWhiteSpace=92;
    public static final int NotWhiteSpace=93;
    public static final int NotWordChar=94;
    public static final int OLC=95;
    public static final int ONEORMORE=96;
    public static final int OPTIONAL=97;
    public static final int OUC=98;
    public static final int OneDataUnit=99;
    public static final int OpenBrace=100;
    public static final int OpenParen=101;
    public static final int OtherChar=102;
    public static final int PLC=103;
    public static final int PUC=104;
    public static final int Pipe=105;
    public static final int Plus=106;
    public static final int PreviousMatchInSubject=107;
    public static final int QLC=108;
    public static final int QUC=109;
    public static final int QuestionMark=110;
    public static final int Quoted=111;
    public static final int RANGE=112;
    public static final int RLC=113;
    public static final int RUC=114;
    public static final int ResetStartMatch=115;
    public static final int SLC=116;
    public static final int SUC=117;
    public static final int SingleQuote=118;
    public static final int Star=119;
    public static final int StartOfSubject=120;
    public static final int SubroutineOrNamedReferenceStartG=121;
    public static final int TLC=122;
    public static final int TUC=123;
    public static final int Tab=124;
    public static final int ULC=125;
    public static final int UUC=126;
    public static final int Underscore=127;
    public static final int UnderscoreAlphaNumerics=128;
    public static final int VLC=129;
    public static final int VUC=130;
    public static final int VerticalWhiteSpace=131;
    public static final int WLC=132;
    public static final int WUC=133;
    public static final int WhiteSpace=134;
    public static final int WordBoundary=135;
    public static final int WordChar=136;
    public static final int XLC=137;
    public static final int XUC=138;
    public static final int YLC=139;
    public static final int YUC=140;
    public static final int ZEROORMORE=141;
    public static final int ZLC=142;
    public static final int ZUC=143;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public RegexParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public RegexParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return RegexParser.tokenNames; }
    public String getGrammarFileName() { return "/home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g"; }


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


    public static class parse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:68:1: parse : regex EOF -> regex ;
    public final RegexParser.parse_return parse() throws RecognitionException {
        RegexParser.parse_return retval = new RegexParser.parse_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        RegexParser.regex_return regex1 =null;


        Object EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:69:3: ( regex EOF -> regex )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:70:3: regex EOF
            {
            pushFollow(FOLLOW_regex_in_parse161);
            regex1=regex();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_regex.add(regex1.getTree());

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse163); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF2);


            // AST REWRITE
            // elements: regex
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 71:5: -> regex
            {
                adaptor.addChild(root_0, stream_regex.nextTree());

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parse"


    public static class regex_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "regex"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:78:1: regex : ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )? ;
    public final RegexParser.regex_return regex() throws RecognitionException {
        RegexParser.regex_return retval = new RegexParser.regex_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal4=null;
        RegexParser.first_alternative_return first_alternative3 =null;

        RegexParser.concatenation_return concatenation5 =null;


        Object char_literal4_tree=null;
        RewriteRuleTokenStream stream_Pipe=new RewriteRuleTokenStream(adaptor,"token Pipe");
        RewriteRuleSubtreeStream stream_first_alternative=new RewriteRuleSubtreeStream(adaptor,"rule first_alternative");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:79:3: ( ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )? )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:80:3: ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )?
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:80:3: ( first_alternative -> first_alternative )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:80:4: first_alternative
            {
            pushFollow(FOLLOW_first_alternative_in_regex191);
            first_alternative3=first_alternative();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_first_alternative.add(first_alternative3.getTree());

            // AST REWRITE
            // elements: first_alternative
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 81:7: -> first_alternative
            {
                adaptor.addChild(root_0, stream_first_alternative.nextTree());

            }


            retval.tree = root_0;
            }

            }


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:82:3: ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Pipe) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:83:5: ( '|' concatenation )+
                    {
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:83:5: ( '|' concatenation )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==Pipe) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:83:6: '|' concatenation
                    	    {
                    	    char_literal4=(Token)match(input,Pipe,FOLLOW_Pipe_in_regex213); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Pipe.add(char_literal4);


                    	    pushFollow(FOLLOW_concatenation_in_regex215);
                    	    concatenation5=concatenation();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_concatenation.add(concatenation5.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    // AST REWRITE
                    // elements: concatenation, first_alternative
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:7: -> ^( ALTERNATIVE first_alternative ( concatenation )+ )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:85:9: ^( ALTERNATIVE first_alternative ( concatenation )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ALTERNATIVE, "ALTERNATIVE")
                        , root_1);

                        adaptor.addChild(root_1, stream_first_alternative.nextTree());

                        if ( !(stream_concatenation.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_concatenation.hasNext() ) {
                            adaptor.addChild(root_1, stream_concatenation.nextTree());

                        }
                        stream_concatenation.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "regex"


    public static class first_alternative_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "first_alternative"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:89:1: first_alternative : concatenation ;
    public final RegexParser.first_alternative_return first_alternative() throws RecognitionException {
        RegexParser.first_alternative_return retval = new RegexParser.first_alternative_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.concatenation_return concatenation6 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:90:3: ( concatenation )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:91:3: concatenation
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_concatenation_in_first_alternative262);
            concatenation6=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, concatenation6.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "first_alternative"


    public static class concatenation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "concatenation"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:94:1: concatenation : ( element )* -> ^( CONCATENATION ( element )* ) ;
    public final RegexParser.concatenation_return concatenation() throws RecognitionException {
        RegexParser.concatenation_return retval = new RegexParser.concatenation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.element_return element7 =null;


        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:95:3: ( ( element )* -> ^( CONCATENATION ( element )* ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:96:3: ( element )*
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:96:3: ( element )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ALC||LA3_0==AUC||(LA3_0 >= BLC && LA3_0 <= BUC)||LA3_0==CLC||LA3_0==CUC||LA3_0==CharacterClassStart||(LA3_0 >= D0 && LA3_0 <= DLC)||LA3_0==DUC||(LA3_0 >= Dot && LA3_0 <= ELC)||LA3_0==EUC||(LA3_0 >= FLC && LA3_0 <= FUC)||LA3_0==GLC||LA3_0==GUC||(LA3_0 >= HLC && LA3_0 <= HUC)||(LA3_0 >= ILC && LA3_0 <= KUC)||(LA3_0 >= LLC && LA3_0 <= LUC)||(LA3_0 >= MLC && LA3_0 <= MUC)||(LA3_0 >= NLC && LA3_0 <= NUC)||LA3_0==OLC||LA3_0==OUC||LA3_0==OpenParen||(LA3_0 >= PLC && LA3_0 <= PUC)||(LA3_0 >= QLC && LA3_0 <= QUC)||(LA3_0 >= RLC && LA3_0 <= RUC)||(LA3_0 >= SLC && LA3_0 <= SUC)||(LA3_0 >= TLC && LA3_0 <= TUC)||(LA3_0 >= ULC && LA3_0 <= UUC)||(LA3_0 >= VLC && LA3_0 <= VUC)||(LA3_0 >= WLC && LA3_0 <= WUC)||(LA3_0 >= XLC && LA3_0 <= YUC)||(LA3_0 >= ZLC && LA3_0 <= ZUC)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:96:3: element
            	    {
            	    pushFollow(FOLLOW_element_in_concatenation277);
            	    element7=element();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_element.add(element7.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // AST REWRITE
            // elements: element
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 97:5: -> ^( CONCATENATION ( element )* )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:98:7: ^( CONCATENATION ( element )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONCATENATION, "CONCATENATION")
                , root_1);

                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:98:23: ( element )*
                while ( stream_element.hasNext() ) {
                    adaptor.addChild(root_1, stream_element.nextTree());

                }
                stream_element.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "concatenation"


    public static class element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "element"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:101:1: element : ( atom '+' -> ^( ONEORMORE atom ) | atom '*' -> ^( ZEROORMORE atom ) | atom '?' -> ^( OPTIONAL atom ) | atom -> ^( ELEMENT atom ) );
    public final RegexParser.element_return element() throws RecognitionException {
        RegexParser.element_return retval = new RegexParser.element_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal11=null;
        Token char_literal13=null;
        RegexParser.atom_return atom8 =null;

        RegexParser.atom_return atom10 =null;

        RegexParser.atom_return atom12 =null;

        RegexParser.atom_return atom14 =null;


        Object char_literal9_tree=null;
        Object char_literal11_tree=null;
        Object char_literal13_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:102:3: ( atom '+' -> ^( ONEORMORE atom ) | atom '*' -> ^( ZEROORMORE atom ) | atom '?' -> ^( OPTIONAL atom ) | atom -> ^( ELEMENT atom ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case ALC:
            case AUC:
            case BLC:
            case BUC:
            case CLC:
            case CUC:
            case DLC:
            case DUC:
            case ELC:
            case EUC:
            case FLC:
            case FUC:
            case GLC:
            case GUC:
            case HLC:
            case HUC:
            case ILC:
            case IUC:
            case JLC:
            case JUC:
            case KLC:
            case KUC:
            case LLC:
            case LUC:
            case MLC:
            case MUC:
            case NLC:
            case NUC:
            case OLC:
            case OUC:
            case PLC:
            case PUC:
            case QLC:
            case QUC:
            case RLC:
            case RUC:
            case SLC:
            case SUC:
            case TLC:
            case TUC:
            case ULC:
            case UUC:
            case VLC:
            case VUC:
            case WLC:
            case WUC:
            case XLC:
            case XUC:
            case YLC:
            case YUC:
            case ZLC:
            case ZUC:
                {
                int LA4_1 = input.LA(2);

                if ( (synpred4_Regex()) ) {
                    alt4=1;
                }
                else if ( (synpred5_Regex()) ) {
                    alt4=2;
                }
                else if ( (synpred6_Regex()) ) {
                    alt4=3;
                }
                else if ( (true) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
                }
                break;
            case D0:
            case D1:
            case D2:
            case D3:
            case D4:
            case D5:
            case D6:
            case D7:
            case D8:
            case D9:
                {
                int LA4_2 = input.LA(2);

                if ( (synpred4_Regex()) ) {
                    alt4=1;
                }
                else if ( (synpred5_Regex()) ) {
                    alt4=2;
                }
                else if ( (synpred6_Regex()) ) {
                    alt4=3;
                }
                else if ( (true) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }
                }
                break;
            case OpenParen:
                {
                int LA4_3 = input.LA(2);

                if ( (synpred4_Regex()) ) {
                    alt4=1;
                }
                else if ( (synpred5_Regex()) ) {
                    alt4=2;
                }
                else if ( (synpred6_Regex()) ) {
                    alt4=3;
                }
                else if ( (true) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;

                }
                }
                break;
            case Dot:
                {
                int LA4_4 = input.LA(2);

                if ( (synpred4_Regex()) ) {
                    alt4=1;
                }
                else if ( (synpred5_Regex()) ) {
                    alt4=2;
                }
                else if ( (synpred6_Regex()) ) {
                    alt4=3;
                }
                else if ( (true) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 4, input);

                    throw nvae;

                }
                }
                break;
            case CharacterClassStart:
                {
                int LA4_5 = input.LA(2);

                if ( (synpred4_Regex()) ) {
                    alt4=1;
                }
                else if ( (synpred5_Regex()) ) {
                    alt4=2;
                }
                else if ( (synpred6_Regex()) ) {
                    alt4=3;
                }
                else if ( (true) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 5, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:103:3: atom '+'
                    {
                    pushFollow(FOLLOW_atom_in_element312);
                    atom8=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom8.getTree());

                    char_literal9=(Token)match(input,Plus,FOLLOW_Plus_in_element314); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Plus.add(char_literal9);


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 104:5: -> ^( ONEORMORE atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:105:7: ^( ONEORMORE atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ONEORMORE, "ONEORMORE")
                        , root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:106:5: atom '*'
                    {
                    pushFollow(FOLLOW_atom_in_element338);
                    atom10=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom10.getTree());

                    char_literal11=(Token)match(input,Star,FOLLOW_Star_in_element340); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Star.add(char_literal11);


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 107:5: -> ^( ZEROORMORE atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:108:7: ^( ZEROORMORE atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ZEROORMORE, "ZEROORMORE")
                        , root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:109:5: atom '?'
                    {
                    pushFollow(FOLLOW_atom_in_element364);
                    atom12=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom12.getTree());

                    char_literal13=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_element366); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal13);


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 110:5: -> ^( OPTIONAL atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:111:7: ^( OPTIONAL atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(OPTIONAL, "OPTIONAL")
                        , root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:112:5: atom
                    {
                    pushFollow(FOLLOW_atom_in_element390);
                    atom14=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom14.getTree());

                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 113:5: -> ^( ELEMENT atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:114:7: ^( ELEMENT atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ELEMENT, "ELEMENT")
                        , root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "element"


    public static class quantifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "quantifier"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:117:1: quantifier : ( '+' -> ^( ONEORMORE ) | '*' -> ^( ZEROORMORE ) );
    public final RegexParser.quantifier_return quantifier() throws RecognitionException {
        RegexParser.quantifier_return retval = new RegexParser.quantifier_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal15=null;
        Token char_literal16=null;

        Object char_literal15_tree=null;
        Object char_literal16_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:118:3: ( '+' -> ^( ONEORMORE ) | '*' -> ^( ZEROORMORE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Plus) ) {
                alt5=1;
            }
            else if ( (LA5_0==Star) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:119:3: '+'
                    {
                    char_literal15=(Token)match(input,Plus,FOLLOW_Plus_in_quantifier423); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Plus.add(char_literal15);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 120:5: -> ^( ONEORMORE )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:121:7: ^( ONEORMORE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ONEORMORE, "ONEORMORE")
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:122:5: '*'
                    {
                    char_literal16=(Token)match(input,Star,FOLLOW_Star_in_quantifier445); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Star.add(char_literal16);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 123:5: -> ^( ZEROORMORE )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:124:7: ^( ZEROORMORE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ZEROORMORE, "ZEROORMORE")
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "quantifier"


    public static class group_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:127:1: group : '(' regex ')' -> ^( GROUP regex ) ;
    public final RegexParser.group_return group() throws RecognitionException {
        RegexParser.group_return retval = new RegexParser.group_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal17=null;
        Token char_literal19=null;
        RegexParser.regex_return regex18 =null;


        Object char_literal17_tree=null;
        Object char_literal19_tree=null;
        RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
        RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:128:3: ( '(' regex ')' -> ^( GROUP regex ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:129:3: '(' regex ')'
            {
            char_literal17=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_group476); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OpenParen.add(char_literal17);


            pushFollow(FOLLOW_regex_in_group478);
            regex18=regex();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_regex.add(regex18.getTree());

            char_literal19=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_group480); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CloseParen.add(char_literal19);


            // AST REWRITE
            // elements: regex
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 130:5: -> ^( GROUP regex )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:131:7: ^( GROUP regex )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(GROUP, "GROUP")
                , root_1);

                adaptor.addChild(root_1, stream_regex.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group"


    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:134:1: atom : ( literal | group | dotany | character_class );
    public final RegexParser.atom_return atom() throws RecognitionException {
        RegexParser.atom_return retval = new RegexParser.atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.literal_return literal20 =null;

        RegexParser.group_return group21 =null;

        RegexParser.dotany_return dotany22 =null;

        RegexParser.character_class_return character_class23 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:135:3: ( literal | group | dotany | character_class )
            int alt6=4;
            switch ( input.LA(1) ) {
            case ALC:
            case AUC:
            case BLC:
            case BUC:
            case CLC:
            case CUC:
            case D0:
            case D1:
            case D2:
            case D3:
            case D4:
            case D5:
            case D6:
            case D7:
            case D8:
            case D9:
            case DLC:
            case DUC:
            case ELC:
            case EUC:
            case FLC:
            case FUC:
            case GLC:
            case GUC:
            case HLC:
            case HUC:
            case ILC:
            case IUC:
            case JLC:
            case JUC:
            case KLC:
            case KUC:
            case LLC:
            case LUC:
            case MLC:
            case MUC:
            case NLC:
            case NUC:
            case OLC:
            case OUC:
            case PLC:
            case PUC:
            case QLC:
            case QUC:
            case RLC:
            case RUC:
            case SLC:
            case SUC:
            case TLC:
            case TUC:
            case ULC:
            case UUC:
            case VLC:
            case VUC:
            case WLC:
            case WUC:
            case XLC:
            case XUC:
            case YLC:
            case YUC:
            case ZLC:
            case ZUC:
                {
                alt6=1;
                }
                break;
            case OpenParen:
                {
                alt6=2;
                }
                break;
            case Dot:
                {
                alt6=3;
                }
                break;
            case CharacterClassStart:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:136:3: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom513);
                    literal20=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal20.getTree());

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:137:5: group
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_group_in_atom519);
                    group21=group();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, group21.getTree());

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:138:5: dotany
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dotany_in_atom525);
                    dotany22=dotany();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dotany22.getTree());

                    }
                    break;
                case 4 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:139:5: character_class
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_character_class_in_atom531);
                    character_class23=character_class();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, character_class23.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class dotany_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dotany"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:142:1: dotany : Dot -> ^( DOTANY ) ;
    public final RegexParser.dotany_return dotany() throws RecognitionException {
        RegexParser.dotany_return retval = new RegexParser.dotany_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Dot24=null;

        Object Dot24_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:143:3: ( Dot -> ^( DOTANY ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:144:3: Dot
            {
            Dot24=(Token)match(input,Dot,FOLLOW_Dot_in_dotany546); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Dot.add(Dot24);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 145:5: -> ^( DOTANY )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:146:7: ^( DOTANY )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DOTANY, "DOTANY")
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dotany"


    public static class character_class_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "character_class"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:154:1: character_class : CharacterClassStart ( cc_atom )+ CharacterClassEnd -> ^( CHARACTER_CLASS ( cc_atom )+ ) ;
    public final RegexParser.character_class_return character_class() throws RecognitionException {
        RegexParser.character_class_return retval = new RegexParser.character_class_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CharacterClassStart25=null;
        Token CharacterClassEnd27=null;
        RegexParser.cc_atom_return cc_atom26 =null;


        Object CharacterClassStart25_tree=null;
        Object CharacterClassEnd27_tree=null;
        RewriteRuleTokenStream stream_CharacterClassStart=new RewriteRuleTokenStream(adaptor,"token CharacterClassStart");
        RewriteRuleTokenStream stream_CharacterClassEnd=new RewriteRuleTokenStream(adaptor,"token CharacterClassEnd");
        RewriteRuleSubtreeStream stream_cc_atom=new RewriteRuleSubtreeStream(adaptor,"rule cc_atom");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:155:3: ( CharacterClassStart ( cc_atom )+ CharacterClassEnd -> ^( CHARACTER_CLASS ( cc_atom )+ ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:156:3: CharacterClassStart ( cc_atom )+ CharacterClassEnd
            {
            CharacterClassStart25=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class582); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CharacterClassStart.add(CharacterClassStart25);


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:156:23: ( cc_atom )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ALC||LA7_0==AUC||(LA7_0 >= BLC && LA7_0 <= BUC)||LA7_0==CLC||LA7_0==CUC||(LA7_0 >= D0 && LA7_0 <= DLC)||LA7_0==DUC||LA7_0==ELC||LA7_0==EUC||(LA7_0 >= FLC && LA7_0 <= FUC)||LA7_0==GLC||LA7_0==GUC||(LA7_0 >= HLC && LA7_0 <= HUC)||(LA7_0 >= ILC && LA7_0 <= KUC)||(LA7_0 >= LLC && LA7_0 <= LUC)||(LA7_0 >= MLC && LA7_0 <= MUC)||(LA7_0 >= NLC && LA7_0 <= NUC)||LA7_0==OLC||LA7_0==OUC||(LA7_0 >= PLC && LA7_0 <= PUC)||(LA7_0 >= QLC && LA7_0 <= QUC)||(LA7_0 >= RLC && LA7_0 <= RUC)||(LA7_0 >= SLC && LA7_0 <= SUC)||(LA7_0 >= TLC && LA7_0 <= TUC)||(LA7_0 >= ULC && LA7_0 <= UUC)||(LA7_0 >= VLC && LA7_0 <= VUC)||(LA7_0 >= WLC && LA7_0 <= WUC)||(LA7_0 >= XLC && LA7_0 <= YUC)||(LA7_0 >= ZLC && LA7_0 <= ZUC)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:156:23: cc_atom
            	    {
            	    pushFollow(FOLLOW_cc_atom_in_character_class584);
            	    cc_atom26=cc_atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom26.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            CharacterClassEnd27=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class587); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CharacterClassEnd.add(CharacterClassEnd27);


            // AST REWRITE
            // elements: cc_atom
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 157:5: -> ^( CHARACTER_CLASS ( cc_atom )+ )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:158:7: ^( CHARACTER_CLASS ( cc_atom )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CHARACTER_CLASS, "CHARACTER_CLASS")
                , root_1);

                if ( !(stream_cc_atom.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cc_atom.hasNext() ) {
                    adaptor.addChild(root_1, stream_cc_atom.nextTree());

                }
                stream_cc_atom.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "character_class"


    public static class cc_atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cc_atom"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:161:1: cc_atom : ( literal Hyphen literal -> ^( RANGE literal literal ) | literal );
    public final RegexParser.cc_atom_return cc_atom() throws RecognitionException {
        RegexParser.cc_atom_return retval = new RegexParser.cc_atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Hyphen29=null;
        RegexParser.literal_return literal28 =null;

        RegexParser.literal_return literal30 =null;

        RegexParser.literal_return literal31 =null;


        Object Hyphen29_tree=null;
        RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:162:3: ( literal Hyphen literal -> ^( RANGE literal literal ) | literal )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ALC||LA8_0==AUC||(LA8_0 >= BLC && LA8_0 <= BUC)||LA8_0==CLC||LA8_0==CUC||LA8_0==DLC||LA8_0==DUC||LA8_0==ELC||LA8_0==EUC||(LA8_0 >= FLC && LA8_0 <= FUC)||LA8_0==GLC||LA8_0==GUC||(LA8_0 >= HLC && LA8_0 <= HUC)||(LA8_0 >= ILC && LA8_0 <= KUC)||(LA8_0 >= LLC && LA8_0 <= LUC)||(LA8_0 >= MLC && LA8_0 <= MUC)||(LA8_0 >= NLC && LA8_0 <= NUC)||LA8_0==OLC||LA8_0==OUC||(LA8_0 >= PLC && LA8_0 <= PUC)||(LA8_0 >= QLC && LA8_0 <= QUC)||(LA8_0 >= RLC && LA8_0 <= RUC)||(LA8_0 >= SLC && LA8_0 <= SUC)||(LA8_0 >= TLC && LA8_0 <= TUC)||(LA8_0 >= ULC && LA8_0 <= UUC)||(LA8_0 >= VLC && LA8_0 <= VUC)||(LA8_0 >= WLC && LA8_0 <= WUC)||(LA8_0 >= XLC && LA8_0 <= YUC)||(LA8_0 >= ZLC && LA8_0 <= ZUC)) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==Hyphen) ) {
                    alt8=1;
                }
                else if ( (LA8_1==EOF||LA8_1==ALC||LA8_1==AUC||(LA8_1 >= BLC && LA8_1 <= BUC)||LA8_1==CLC||LA8_1==CUC||LA8_1==CharacterClassEnd||(LA8_1 >= D0 && LA8_1 <= DLC)||LA8_1==DUC||LA8_1==ELC||LA8_1==EUC||(LA8_1 >= FLC && LA8_1 <= FUC)||LA8_1==GLC||LA8_1==GUC||(LA8_1 >= HLC && LA8_1 <= HUC)||(LA8_1 >= ILC && LA8_1 <= KUC)||(LA8_1 >= LLC && LA8_1 <= LUC)||(LA8_1 >= MLC && LA8_1 <= MUC)||(LA8_1 >= NLC && LA8_1 <= NUC)||LA8_1==OLC||LA8_1==OUC||(LA8_1 >= PLC && LA8_1 <= PUC)||(LA8_1 >= QLC && LA8_1 <= QUC)||(LA8_1 >= RLC && LA8_1 <= RUC)||(LA8_1 >= SLC && LA8_1 <= SUC)||(LA8_1 >= TLC && LA8_1 <= TUC)||(LA8_1 >= ULC && LA8_1 <= UUC)||(LA8_1 >= VLC && LA8_1 <= VUC)||(LA8_1 >= WLC && LA8_1 <= WUC)||(LA8_1 >= XLC && LA8_1 <= YUC)||(LA8_1 >= ZLC && LA8_1 <= ZUC)) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA8_0 >= D0 && LA8_0 <= D9)) ) {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==Hyphen) ) {
                    alt8=1;
                }
                else if ( (LA8_2==EOF||LA8_2==ALC||LA8_2==AUC||(LA8_2 >= BLC && LA8_2 <= BUC)||LA8_2==CLC||LA8_2==CUC||LA8_2==CharacterClassEnd||(LA8_2 >= D0 && LA8_2 <= DLC)||LA8_2==DUC||LA8_2==ELC||LA8_2==EUC||(LA8_2 >= FLC && LA8_2 <= FUC)||LA8_2==GLC||LA8_2==GUC||(LA8_2 >= HLC && LA8_2 <= HUC)||(LA8_2 >= ILC && LA8_2 <= KUC)||(LA8_2 >= LLC && LA8_2 <= LUC)||(LA8_2 >= MLC && LA8_2 <= MUC)||(LA8_2 >= NLC && LA8_2 <= NUC)||LA8_2==OLC||LA8_2==OUC||(LA8_2 >= PLC && LA8_2 <= PUC)||(LA8_2 >= QLC && LA8_2 <= QUC)||(LA8_2 >= RLC && LA8_2 <= RUC)||(LA8_2 >= SLC && LA8_2 <= SUC)||(LA8_2 >= TLC && LA8_2 <= TUC)||(LA8_2 >= ULC && LA8_2 <= UUC)||(LA8_2 >= VLC && LA8_2 <= VUC)||(LA8_2 >= WLC && LA8_2 <= WUC)||(LA8_2 >= XLC && LA8_2 <= YUC)||(LA8_2 >= ZLC && LA8_2 <= ZUC)) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:163:3: literal Hyphen literal
                    {
                    pushFollow(FOLLOW_literal_in_cc_atom621);
                    literal28=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal28.getTree());

                    Hyphen29=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_cc_atom623); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen29);


                    pushFollow(FOLLOW_literal_in_cc_atom625);
                    literal30=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal30.getTree());

                    // AST REWRITE
                    // elements: literal, literal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 164:5: -> ^( RANGE literal literal )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:165:7: ^( RANGE literal literal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(RANGE, "RANGE")
                        , root_1);

                        adaptor.addChild(root_1, stream_literal.nextTree());

                        adaptor.addChild(root_1, stream_literal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:166:5: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_cc_atom651);
                    literal31=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal31.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cc_atom"


    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:171:1: literal : ( letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] );
    public final RegexParser.literal_return literal() throws RecognitionException {
        RegexParser.literal_return retval = new RegexParser.literal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.letter_return letter32 =null;

        RegexParser.digit_return digit33 =null;


        RewriteRuleSubtreeStream stream_digit=new RewriteRuleSubtreeStream(adaptor,"rule digit");
        RewriteRuleSubtreeStream stream_letter=new RewriteRuleSubtreeStream(adaptor,"rule letter");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:172:3: ( letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ALC||LA9_0==AUC||(LA9_0 >= BLC && LA9_0 <= BUC)||LA9_0==CLC||LA9_0==CUC||LA9_0==DLC||LA9_0==DUC||LA9_0==ELC||LA9_0==EUC||(LA9_0 >= FLC && LA9_0 <= FUC)||LA9_0==GLC||LA9_0==GUC||(LA9_0 >= HLC && LA9_0 <= HUC)||(LA9_0 >= ILC && LA9_0 <= KUC)||(LA9_0 >= LLC && LA9_0 <= LUC)||(LA9_0 >= MLC && LA9_0 <= MUC)||(LA9_0 >= NLC && LA9_0 <= NUC)||LA9_0==OLC||LA9_0==OUC||(LA9_0 >= PLC && LA9_0 <= PUC)||(LA9_0 >= QLC && LA9_0 <= QUC)||(LA9_0 >= RLC && LA9_0 <= RUC)||(LA9_0 >= SLC && LA9_0 <= SUC)||(LA9_0 >= TLC && LA9_0 <= TUC)||(LA9_0 >= ULC && LA9_0 <= UUC)||(LA9_0 >= VLC && LA9_0 <= VUC)||(LA9_0 >= WLC && LA9_0 <= WUC)||(LA9_0 >= XLC && LA9_0 <= YUC)||(LA9_0 >= ZLC && LA9_0 <= ZUC)) ) {
                alt9=1;
            }
            else if ( ((LA9_0 >= D0 && LA9_0 <= D9)) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:173:3: letter
                    {
                    pushFollow(FOLLOW_letter_in_literal668);
                    letter32=letter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_letter.add(letter32.getTree());

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 174:5: -> LITERAL[$letter.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (letter32!=null?input.toString(letter32.start,letter32.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:175:5: digit
                    {
                    pushFollow(FOLLOW_digit_in_literal683);
                    digit33=digit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_digit.add(digit33.getTree());

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 176:5: -> LITERAL[$digit.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (digit33!=null?input.toString(digit33.start,digit33.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class number_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "number"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:179:1: number : digits -> NUMBER[$digits.text] ;
    public final RegexParser.number_return number() throws RecognitionException {
        RegexParser.number_return retval = new RegexParser.number_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.digits_return digits34 =null;


        RewriteRuleSubtreeStream stream_digits=new RewriteRuleSubtreeStream(adaptor,"rule digits");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:180:3: ( digits -> NUMBER[$digits.text] )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:181:3: digits
            {
            pushFollow(FOLLOW_digits_in_number707);
            digits34=digits();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_digits.add(digits34.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 182:5: -> NUMBER[$digits.text]
            {
                adaptor.addChild(root_0, 
                (Object)adaptor.create(NUMBER, (digits34!=null?input.toString(digits34.start,digits34.stop):null))
                );

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "number"


    public static class digits_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "digits"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:185:1: digits : ( digit )+ ;
    public final RegexParser.digits_return digits() throws RecognitionException {
        RegexParser.digits_return retval = new RegexParser.digits_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.digit_return digit35 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:186:3: ( ( digit )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:187:3: ( digit )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:187:3: ( digit )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= D0 && LA10_0 <= D9)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:187:3: digit
            	    {
            	    pushFollow(FOLLOW_digit_in_digits731);
            	    digit35=digit();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, digit35.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "digits"


    public static class digit_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "digit"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:190:1: digit : ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 );
    public final RegexParser.digit_return digit() throws RecognitionException {
        RegexParser.digit_return retval = new RegexParser.digit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set36=null;

        Object set36_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:191:3: ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set36=(Token)input.LT(1);

            if ( (input.LA(1) >= D0 && input.LA(1) <= D9) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set36)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "digit"


    public static class name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "name"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:204:1: name : letters -> NAME[$letters.text] ;
    public final RegexParser.name_return name() throws RecognitionException {
        RegexParser.name_return retval = new RegexParser.name_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.letters_return letters37 =null;


        RewriteRuleSubtreeStream stream_letters=new RewriteRuleSubtreeStream(adaptor,"rule letters");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:205:3: ( letters -> NAME[$letters.text] )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:206:3: letters
            {
            pushFollow(FOLLOW_letters_in_name816);
            letters37=letters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_letters.add(letters37.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 207:5: -> NAME[$letters.text]
            {
                adaptor.addChild(root_0, 
                (Object)adaptor.create(NAME, (letters37!=null?input.toString(letters37.start,letters37.stop):null))
                );

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "name"


    public static class letters_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "letters"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:210:1: letters : ( letter )+ ;
    public final RegexParser.letters_return letters() throws RecognitionException {
        RegexParser.letters_return retval = new RegexParser.letters_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.letter_return letter38 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:211:3: ( ( letter )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:212:3: ( letter )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:212:3: ( letter )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ALC||LA11_0==AUC||(LA11_0 >= BLC && LA11_0 <= BUC)||LA11_0==CLC||LA11_0==CUC||LA11_0==DLC||LA11_0==DUC||LA11_0==ELC||LA11_0==EUC||(LA11_0 >= FLC && LA11_0 <= FUC)||LA11_0==GLC||LA11_0==GUC||(LA11_0 >= HLC && LA11_0 <= HUC)||(LA11_0 >= ILC && LA11_0 <= KUC)||(LA11_0 >= LLC && LA11_0 <= LUC)||(LA11_0 >= MLC && LA11_0 <= MUC)||(LA11_0 >= NLC && LA11_0 <= NUC)||LA11_0==OLC||LA11_0==OUC||(LA11_0 >= PLC && LA11_0 <= PUC)||(LA11_0 >= QLC && LA11_0 <= QUC)||(LA11_0 >= RLC && LA11_0 <= RUC)||(LA11_0 >= SLC && LA11_0 <= SUC)||(LA11_0 >= TLC && LA11_0 <= TUC)||(LA11_0 >= ULC && LA11_0 <= UUC)||(LA11_0 >= VLC && LA11_0 <= VUC)||(LA11_0 >= WLC && LA11_0 <= WUC)||(LA11_0 >= XLC && LA11_0 <= YUC)||(LA11_0 >= ZLC && LA11_0 <= ZUC)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:212:3: letter
            	    {
            	    pushFollow(FOLLOW_letter_in_letters840);
            	    letter38=letter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, letter38.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "letters"


    public static class non_close_parens_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "non_close_parens"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:215:1: non_close_parens : ( non_close_paren )+ ;
    public final RegexParser.non_close_parens_return non_close_parens() throws RecognitionException {
        RegexParser.non_close_parens_return retval = new RegexParser.non_close_parens_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.non_close_paren_return non_close_paren39 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:216:3: ( ( non_close_paren )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:217:3: ( non_close_paren )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:217:3: ( non_close_paren )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= ALC && LA12_0 <= CloseBrace)||(LA12_0 >= Colon && LA12_0 <= ZUC)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:217:3: non_close_paren
            	    {
            	    pushFollow(FOLLOW_non_close_paren_in_non_close_parens856);
            	    non_close_paren39=non_close_paren();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, non_close_paren39.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "non_close_parens"


    public static class non_close_paren_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "non_close_paren"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:220:1: non_close_paren : ~ CloseParen ;
    public final RegexParser.non_close_paren_return non_close_paren() throws RecognitionException {
        RegexParser.non_close_paren_return retval = new RegexParser.non_close_paren_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set40=null;

        Object set40_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:221:3: (~ CloseParen )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set40=(Token)input.LT(1);

            if ( (input.LA(1) >= ALC && input.LA(1) <= CloseBrace)||(input.LA(1) >= Colon && input.LA(1) <= ZUC) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set40)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "non_close_paren"


    public static class letter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "letter"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:225:1: letter : ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC );
    public final RegexParser.letter_return letter() throws RecognitionException {
        RegexParser.letter_return retval = new RegexParser.letter_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set41=null;

        Object set41_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:226:3: ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set41=(Token)input.LT(1);

            if ( input.LA(1)==ALC||input.LA(1)==AUC||(input.LA(1) >= BLC && input.LA(1) <= BUC)||input.LA(1)==CLC||input.LA(1)==CUC||input.LA(1)==DLC||input.LA(1)==DUC||input.LA(1)==ELC||input.LA(1)==EUC||(input.LA(1) >= FLC && input.LA(1) <= FUC)||input.LA(1)==GLC||input.LA(1)==GUC||(input.LA(1) >= HLC && input.LA(1) <= HUC)||(input.LA(1) >= ILC && input.LA(1) <= KUC)||(input.LA(1) >= LLC && input.LA(1) <= LUC)||(input.LA(1) >= MLC && input.LA(1) <= MUC)||(input.LA(1) >= NLC && input.LA(1) <= NUC)||input.LA(1)==OLC||input.LA(1)==OUC||(input.LA(1) >= PLC && input.LA(1) <= PUC)||(input.LA(1) >= QLC && input.LA(1) <= QUC)||(input.LA(1) >= RLC && input.LA(1) <= RUC)||(input.LA(1) >= SLC && input.LA(1) <= SUC)||(input.LA(1) >= TLC && input.LA(1) <= TUC)||(input.LA(1) >= ULC && input.LA(1) <= UUC)||(input.LA(1) >= VLC && input.LA(1) <= VUC)||(input.LA(1) >= WLC && input.LA(1) <= WUC)||(input.LA(1) >= XLC && input.LA(1) <= YUC)||(input.LA(1) >= ZLC && input.LA(1) <= ZUC) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set41)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "letter"

    // $ANTLR start synpred4_Regex
    public final void synpred4_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:103:3: ( atom '+' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:103:3: atom '+'
        {
        pushFollow(FOLLOW_atom_in_synpred4_Regex312);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,Plus,FOLLOW_Plus_in_synpred4_Regex314); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_Regex

    // $ANTLR start synpred5_Regex
    public final void synpred5_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:106:5: ( atom '*' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:106:5: atom '*'
        {
        pushFollow(FOLLOW_atom_in_synpred5_Regex338);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,Star,FOLLOW_Star_in_synpred5_Regex340); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Regex

    // $ANTLR start synpred6_Regex
    public final void synpred6_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:109:5: ( atom '?' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/net/abrandl/lucene/regex/grammar/Regex.g:109:5: atom '?'
        {
        pushFollow(FOLLOW_atom_in_synpred6_Regex364);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred6_Regex366); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Regex

    // Delegated rules

    public final boolean synpred5_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_regex_in_parse161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_first_alternative_in_regex191 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_Pipe_in_regex213 = new BitSet(new long[]{0x6AC05AFFE08A1890L,0x6C3633A48006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_concatenation_in_regex215 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_concatenation_in_first_alternative262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_concatenation277 = new BitSet(new long[]{0x6AC05AFFE08A1892L,0x6C3631A48006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_atom_in_element312 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_Plus_in_element314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element338 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_Star_in_element340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element364 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_QuestionMark_in_element366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_quantifier423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_quantifier445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OpenParen_in_group476 = new BitSet(new long[]{0x6AC05AFFE08A1890L,0x6C3631A48006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_regex_in_group478 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_CloseParen_in_group480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_atom519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotany_in_atom525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_character_class_in_atom531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_dotany546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CharacterClassStart_in_character_class582 = new BitSet(new long[]{0x6AC052FFE00A1890L,0x6C3631848006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_cc_atom_in_character_class584 = new BitSet(new long[]{0x6AC052FFE04A1890L,0x6C3631848006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_CharacterClassEnd_in_character_class587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_cc_atom621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_Hyphen_in_cc_atom623 = new BitSet(new long[]{0x6AC052FFE00A1890L,0x6C3631848006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_literal_in_cc_atom625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_cc_atom651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letter_in_literal668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digit_in_literal683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digits_in_number707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digit_in_digits731 = new BitSet(new long[]{0x0000007FE0000002L});
    public static final BitSet FOLLOW_letters_in_name816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letter_in_letters840 = new BitSet(new long[]{0x6AC05280000A1892L,0x6C3631848006DBF0L,0x000000000000DE36L});
    public static final BitSet FOLLOW_non_close_paren_in_non_close_parens856 = new BitSet(new long[]{0xFFFFFFFFFDFFFFF2L,0xFFFFFFFFFFFFFFFFL,0x000000000000FFFFL});
    public static final BitSet FOLLOW_atom_in_synpred4_Regex312 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_Plus_in_synpred4_Regex314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred5_Regex338 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_Star_in_synpred5_Regex340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred6_Regex364 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_QuestionMark_in_synpred6_Regex366 = new BitSet(new long[]{0x0000000000000002L});

}