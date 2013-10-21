// $ANTLR 3.4 /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g 2013-10-21 16:14:03

package de.abrandl.regex.grammar;
import de.abrandl.regex.grammar.tree.RegexNode;

/*
* Based on insights (and partly also grammar code) taken from
* https://github.com/bkiers/PCREParser
*/


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALC", "ALTERNATIVE", "AUC", "AlphaNumeric", "Ampersand", "At", "BLC", "BUC", "Backslash", "BlockQuoted", "CHARACTER_CLASS", "CLC", "CONCATENATION", "CUC", "Caret", "CarriageReturn", "CloseBrace", "CloseBracket", "CloseParen", "Colon", "Comma", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DLC", "DOTANY", "DUC", "Dollar", "Dot", "DoubleQuote", "ELC", "ELEMENT", "EUC", "Equals", "Exclamation", "FLC", "FUC", "GLC", "GROUP", "GUC", "GraveAccent", "GreaterThan", "HLC", "HUC", "Hash", "Hyphen", "ILC", "IUC", "JLC", "JUC", "KLC", "KUC", "LITERAL", "LLC", "LUC", "LessThan", "MLC", "MUC", "NAME", "NLC", "NUC", "NUMBER", "NewLine", "NonAlphaNumeric", "OLC", "ONEORMORE", "OPTIONAL", "OUC", "OpenBrace", "OpenBracket", "OpenParen", "PLC", "PUC", "Percent", "Pipe", "Plus", "QLC", "QUC", "QuestionMark", "Quoted", "RANGE", "RLC", "RUC", "SLC", "SUC", "Semicolon", "SingleQuote", "Slash", "Star", "TLC", "TUC", "Tab", "Tilde", "ULC", "UUC", "Underscore", "VLC", "VUC", "WHITESPACE", "WLC", "WUC", "XLC", "XUC", "YLC", "YUC", "ZEROORMORE", "ZLC", "ZUC"
    };

    public static final int EOF=-1;
    public static final int ALC=4;
    public static final int ALTERNATIVE=5;
    public static final int AUC=6;
    public static final int AlphaNumeric=7;
    public static final int Ampersand=8;
    public static final int At=9;
    public static final int BLC=10;
    public static final int BUC=11;
    public static final int Backslash=12;
    public static final int BlockQuoted=13;
    public static final int CHARACTER_CLASS=14;
    public static final int CLC=15;
    public static final int CONCATENATION=16;
    public static final int CUC=17;
    public static final int Caret=18;
    public static final int CarriageReturn=19;
    public static final int CloseBrace=20;
    public static final int CloseBracket=21;
    public static final int CloseParen=22;
    public static final int Colon=23;
    public static final int Comma=24;
    public static final int D0=25;
    public static final int D1=26;
    public static final int D2=27;
    public static final int D3=28;
    public static final int D4=29;
    public static final int D5=30;
    public static final int D6=31;
    public static final int D7=32;
    public static final int D8=33;
    public static final int D9=34;
    public static final int DLC=35;
    public static final int DOTANY=36;
    public static final int DUC=37;
    public static final int Dollar=38;
    public static final int Dot=39;
    public static final int DoubleQuote=40;
    public static final int ELC=41;
    public static final int ELEMENT=42;
    public static final int EUC=43;
    public static final int Equals=44;
    public static final int Exclamation=45;
    public static final int FLC=46;
    public static final int FUC=47;
    public static final int GLC=48;
    public static final int GROUP=49;
    public static final int GUC=50;
    public static final int GraveAccent=51;
    public static final int GreaterThan=52;
    public static final int HLC=53;
    public static final int HUC=54;
    public static final int Hash=55;
    public static final int Hyphen=56;
    public static final int ILC=57;
    public static final int IUC=58;
    public static final int JLC=59;
    public static final int JUC=60;
    public static final int KLC=61;
    public static final int KUC=62;
    public static final int LITERAL=63;
    public static final int LLC=64;
    public static final int LUC=65;
    public static final int LessThan=66;
    public static final int MLC=67;
    public static final int MUC=68;
    public static final int NAME=69;
    public static final int NLC=70;
    public static final int NUC=71;
    public static final int NUMBER=72;
    public static final int NewLine=73;
    public static final int NonAlphaNumeric=74;
    public static final int OLC=75;
    public static final int ONEORMORE=76;
    public static final int OPTIONAL=77;
    public static final int OUC=78;
    public static final int OpenBrace=79;
    public static final int OpenBracket=80;
    public static final int OpenParen=81;
    public static final int PLC=82;
    public static final int PUC=83;
    public static final int Percent=84;
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
    public static final int Semicolon=96;
    public static final int SingleQuote=97;
    public static final int Slash=98;
    public static final int Star=99;
    public static final int TLC=100;
    public static final int TUC=101;
    public static final int Tab=102;
    public static final int Tilde=103;
    public static final int ULC=104;
    public static final int UUC=105;
    public static final int Underscore=106;
    public static final int VLC=107;
    public static final int VUC=108;
    public static final int WHITESPACE=109;
    public static final int WLC=110;
    public static final int WUC=111;
    public static final int XLC=112;
    public static final int XUC=113;
    public static final int YLC=114;
    public static final int YUC=115;
    public static final int ZEROORMORE=116;
    public static final int ZLC=117;
    public static final int ZUC=118;

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
    public String getGrammarFileName() { return "/home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g"; }


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


    public static class parse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:84:1: parse : ( regex EOF -> regex | subject_boundary );
    public final RegexParser.parse_return parse() throws RecognitionException {
        RegexParser.parse_return retval = new RegexParser.parse_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        RegexParser.regex_return regex1 =null;

        RegexParser.subject_boundary_return subject_boundary3 =null;


        Object EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:85:3: ( regex EOF -> regex | subject_boundary )
            int alt1=2;
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
                int LA1_1 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

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
                int LA1_2 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;

                }
                }
                break;
            case Backslash:
                {
                int LA1_3 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;

                }
                }
                break;
            case Ampersand:
            case At:
            case Colon:
            case Comma:
            case DoubleQuote:
            case Equals:
            case Exclamation:
            case GraveAccent:
            case GreaterThan:
            case Hash:
            case Hyphen:
            case LessThan:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
                {
                int LA1_4 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;

                }
                }
                break;
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
                {
                int LA1_5 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 5, input);

                    throw nvae;

                }
                }
                break;
            case Quoted:
                {
                int LA1_6 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 6, input);

                    throw nvae;

                }
                }
                break;
            case BlockQuoted:
                {
                int LA1_7 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 7, input);

                    throw nvae;

                }
                }
                break;
            case OpenParen:
                {
                int LA1_8 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 8, input);

                    throw nvae;

                }
                }
                break;
            case Dot:
                {
                int LA1_9 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 9, input);

                    throw nvae;

                }
                }
                break;
            case OpenBracket:
                {
                int LA1_10 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 10, input);

                    throw nvae;

                }
                }
                break;
            case Pipe:
                {
                int LA1_11 = input.LA(2);

                if ( (synpred1_Regex()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 11, input);

                    throw nvae;

                }
                }
                break;
            case EOF:
                {
                alt1=1;
                }
                break;
            case Caret:
            case Dollar:
                {
                alt1=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:86:3: regex EOF
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
                    // 87:5: -> regex
                    {
                        adaptor.addChild(root_0, stream_regex.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:88:5: subject_boundary
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_subject_boundary_in_parse177);
                    subject_boundary3=subject_boundary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subject_boundary3.getTree());

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
    // $ANTLR end "parse"


    public static class regex_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "regex"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:95:1: regex : ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )? ;
    public final RegexParser.regex_return regex() throws RecognitionException {
        RegexParser.regex_return retval = new RegexParser.regex_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal5=null;
        RegexParser.first_alternative_return first_alternative4 =null;

        RegexParser.concatenation_return concatenation6 =null;


        Object char_literal5_tree=null;
        RewriteRuleTokenStream stream_Pipe=new RewriteRuleTokenStream(adaptor,"token Pipe");
        RewriteRuleSubtreeStream stream_first_alternative=new RewriteRuleSubtreeStream(adaptor,"rule first_alternative");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:96:3: ( ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )? )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:97:3: ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )?
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:97:3: ( first_alternative -> first_alternative )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:97:4: first_alternative
            {
            pushFollow(FOLLOW_first_alternative_in_regex197);
            first_alternative4=first_alternative();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_first_alternative.add(first_alternative4.getTree());

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
            // 98:7: -> first_alternative
            {
                adaptor.addChild(root_0, stream_first_alternative.nextTree());

            }


            retval.tree = root_0;
            }

            }


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:99:3: ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Pipe) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:100:5: ( '|' concatenation )+
                    {
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:100:5: ( '|' concatenation )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==Pipe) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:100:6: '|' concatenation
                    	    {
                    	    char_literal5=(Token)match(input,Pipe,FOLLOW_Pipe_in_regex219); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Pipe.add(char_literal5);


                    	    pushFollow(FOLLOW_concatenation_in_regex221);
                    	    concatenation6=concatenation();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_concatenation.add(concatenation6.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
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
                    // 101:7: -> ^( ALTERNATIVE first_alternative ( concatenation )+ )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:102:9: ^( ALTERNATIVE first_alternative ( concatenation )+ )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:106:1: first_alternative : concatenation ;
    public final RegexParser.first_alternative_return first_alternative() throws RecognitionException {
        RegexParser.first_alternative_return retval = new RegexParser.first_alternative_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.concatenation_return concatenation7 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:107:3: ( concatenation )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:108:3: concatenation
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_concatenation_in_first_alternative268);
            concatenation7=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, concatenation7.getTree());

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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:111:1: concatenation : ( element )* -> ^( CONCATENATION ( element )* ) ;
    public final RegexParser.concatenation_return concatenation() throws RecognitionException {
        RegexParser.concatenation_return retval = new RegexParser.concatenation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.element_return element8 =null;


        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:112:3: ( ( element )* -> ^( CONCATENATION ( element )* ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:113:3: ( element )*
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:113:3: ( element )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ALC||LA4_0==AUC||(LA4_0 >= Ampersand && LA4_0 <= BlockQuoted)||LA4_0==CLC||LA4_0==CUC||LA4_0==CarriageReturn||(LA4_0 >= Colon && LA4_0 <= DLC)||LA4_0==DUC||(LA4_0 >= Dot && LA4_0 <= ELC)||(LA4_0 >= EUC && LA4_0 <= GLC)||(LA4_0 >= GUC && LA4_0 <= KUC)||(LA4_0 >= LLC && LA4_0 <= MUC)||(LA4_0 >= NLC && LA4_0 <= NUC)||LA4_0==NewLine||LA4_0==OLC||LA4_0==OUC||(LA4_0 >= OpenBracket && LA4_0 <= PUC)||(LA4_0 >= QLC && LA4_0 <= QUC)||LA4_0==Quoted||(LA4_0 >= RLC && LA4_0 <= Slash)||(LA4_0 >= TLC && LA4_0 <= YUC)||(LA4_0 >= ZLC && LA4_0 <= ZUC)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:113:3: element
            	    {
            	    pushFollow(FOLLOW_element_in_concatenation283);
            	    element8=element();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_element.add(element8.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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
            // 114:5: -> ^( CONCATENATION ( element )* )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:115:7: ^( CONCATENATION ( element )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONCATENATION, "CONCATENATION")
                , root_1);

                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:115:23: ( element )*
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:118:1: element : ( atom '+' -> ^( ONEORMORE atom ) | atom '*' -> ^( ZEROORMORE atom ) | atom '?' -> ^( OPTIONAL atom ) | atom -> ^( ELEMENT atom ) );
    public final RegexParser.element_return element() throws RecognitionException {
        RegexParser.element_return retval = new RegexParser.element_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        Token char_literal14=null;
        RegexParser.atom_return atom9 =null;

        RegexParser.atom_return atom11 =null;

        RegexParser.atom_return atom13 =null;

        RegexParser.atom_return atom15 =null;


        Object char_literal10_tree=null;
        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:119:3: ( atom '+' -> ^( ONEORMORE atom ) | atom '*' -> ^( ZEROORMORE atom ) | atom '?' -> ^( OPTIONAL atom ) | atom -> ^( ELEMENT atom ) )
            int alt5=4;
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
                int LA5_1 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

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
                int LA5_2 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;

                }
                }
                break;
            case Backslash:
                {
                int LA5_3 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 3, input);

                    throw nvae;

                }
                }
                break;
            case Ampersand:
            case At:
            case Colon:
            case Comma:
            case DoubleQuote:
            case Equals:
            case Exclamation:
            case GraveAccent:
            case GreaterThan:
            case Hash:
            case Hyphen:
            case LessThan:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
                {
                int LA5_4 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 4, input);

                    throw nvae;

                }
                }
                break;
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
                {
                int LA5_5 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 5, input);

                    throw nvae;

                }
                }
                break;
            case Quoted:
                {
                int LA5_6 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 6, input);

                    throw nvae;

                }
                }
                break;
            case BlockQuoted:
                {
                int LA5_7 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 7, input);

                    throw nvae;

                }
                }
                break;
            case OpenParen:
                {
                int LA5_8 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 8, input);

                    throw nvae;

                }
                }
                break;
            case Dot:
                {
                int LA5_9 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 9, input);

                    throw nvae;

                }
                }
                break;
            case OpenBracket:
                {
                int LA5_10 = input.LA(2);

                if ( (synpred5_Regex()) ) {
                    alt5=1;
                }
                else if ( (synpred6_Regex()) ) {
                    alt5=2;
                }
                else if ( (synpred7_Regex()) ) {
                    alt5=3;
                }
                else if ( (true) ) {
                    alt5=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 10, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:120:3: atom '+'
                    {
                    pushFollow(FOLLOW_atom_in_element318);
                    atom9=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom9.getTree());

                    char_literal10=(Token)match(input,Plus,FOLLOW_Plus_in_element320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Plus.add(char_literal10);


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
                    // 121:5: -> ^( ONEORMORE atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:122:7: ^( ONEORMORE atom )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:123:5: atom '*'
                    {
                    pushFollow(FOLLOW_atom_in_element344);
                    atom11=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom11.getTree());

                    char_literal12=(Token)match(input,Star,FOLLOW_Star_in_element346); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Star.add(char_literal12);


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
                    // 124:5: -> ^( ZEROORMORE atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:125:7: ^( ZEROORMORE atom )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:126:5: atom '?'
                    {
                    pushFollow(FOLLOW_atom_in_element370);
                    atom13=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom13.getTree());

                    char_literal14=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_element372); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal14);


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
                    // 127:5: -> ^( OPTIONAL atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:128:7: ^( OPTIONAL atom )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:129:5: atom
                    {
                    pushFollow(FOLLOW_atom_in_element396);
                    atom15=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom15.getTree());

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
                    // 130:5: -> ^( ELEMENT atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:131:7: ^( ELEMENT atom )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:134:1: quantifier : ( '+' -> ^( ONEORMORE ) | '*' -> ^( ZEROORMORE ) );
    public final RegexParser.quantifier_return quantifier() throws RecognitionException {
        RegexParser.quantifier_return retval = new RegexParser.quantifier_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal16=null;
        Token char_literal17=null;

        Object char_literal16_tree=null;
        Object char_literal17_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:135:3: ( '+' -> ^( ONEORMORE ) | '*' -> ^( ZEROORMORE ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Plus) ) {
                alt6=1;
            }
            else if ( (LA6_0==Star) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:136:3: '+'
                    {
                    char_literal16=(Token)match(input,Plus,FOLLOW_Plus_in_quantifier429); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Plus.add(char_literal16);


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
                    // 137:5: -> ^( ONEORMORE )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:138:7: ^( ONEORMORE )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:139:5: '*'
                    {
                    char_literal17=(Token)match(input,Star,FOLLOW_Star_in_quantifier451); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Star.add(char_literal17);


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
                    // 140:5: -> ^( ZEROORMORE )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:141:7: ^( ZEROORMORE )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:144:1: group : '(' regex ')' -> ^( GROUP regex ) ;
    public final RegexParser.group_return group() throws RecognitionException {
        RegexParser.group_return retval = new RegexParser.group_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal18=null;
        Token char_literal20=null;
        RegexParser.regex_return regex19 =null;


        Object char_literal18_tree=null;
        Object char_literal20_tree=null;
        RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
        RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:145:3: ( '(' regex ')' -> ^( GROUP regex ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:146:3: '(' regex ')'
            {
            char_literal18=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_group482); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OpenParen.add(char_literal18);


            pushFollow(FOLLOW_regex_in_group484);
            regex19=regex();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_regex.add(regex19.getTree());

            char_literal20=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_group486); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CloseParen.add(char_literal20);


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
            // 147:5: -> ^( GROUP regex )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:148:7: ^( GROUP regex )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:151:1: atom : ( literal | group | dotany | character_class );
    public final RegexParser.atom_return atom() throws RecognitionException {
        RegexParser.atom_return retval = new RegexParser.atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.literal_return literal21 =null;

        RegexParser.group_return group22 =null;

        RegexParser.dotany_return dotany23 =null;

        RegexParser.character_class_return character_class24 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:152:3: ( literal | group | dotany | character_class )
            int alt7=4;
            switch ( input.LA(1) ) {
            case ALC:
            case AUC:
            case Ampersand:
            case At:
            case BLC:
            case BUC:
            case Backslash:
            case BlockQuoted:
            case CLC:
            case CUC:
            case CarriageReturn:
            case Colon:
            case Comma:
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
            case DoubleQuote:
            case ELC:
            case EUC:
            case Equals:
            case Exclamation:
            case FLC:
            case FUC:
            case GLC:
            case GUC:
            case GraveAccent:
            case GreaterThan:
            case HLC:
            case HUC:
            case Hash:
            case Hyphen:
            case ILC:
            case IUC:
            case JLC:
            case JUC:
            case KLC:
            case KUC:
            case LLC:
            case LUC:
            case LessThan:
            case MLC:
            case MUC:
            case NLC:
            case NUC:
            case NewLine:
            case OLC:
            case OUC:
            case PLC:
            case PUC:
            case QLC:
            case QUC:
            case Quoted:
            case RLC:
            case RUC:
            case SLC:
            case SUC:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case TLC:
            case TUC:
            case Tab:
            case Tilde:
            case ULC:
            case UUC:
            case Underscore:
            case VLC:
            case VUC:
            case WHITESPACE:
            case WLC:
            case WUC:
            case XLC:
            case XUC:
            case YLC:
            case YUC:
            case ZLC:
            case ZUC:
                {
                alt7=1;
                }
                break;
            case OpenParen:
                {
                alt7=2;
                }
                break;
            case Dot:
                {
                alt7=3;
                }
                break;
            case OpenBracket:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:153:3: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom519);
                    literal21=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal21.getTree());

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:154:5: group
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_group_in_atom525);
                    group22=group();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, group22.getTree());

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:155:5: dotany
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dotany_in_atom531);
                    dotany23=dotany();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dotany23.getTree());

                    }
                    break;
                case 4 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:156:5: character_class
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_character_class_in_atom537);
                    character_class24=character_class();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, character_class24.getTree());

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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:159:1: dotany : Dot -> ^( DOTANY ) ;
    public final RegexParser.dotany_return dotany() throws RecognitionException {
        RegexParser.dotany_return retval = new RegexParser.dotany_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Dot25=null;

        Object Dot25_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:160:3: ( Dot -> ^( DOTANY ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:161:3: Dot
            {
            Dot25=(Token)match(input,Dot,FOLLOW_Dot_in_dotany552); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Dot.add(Dot25);


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
            // 162:5: -> ^( DOTANY )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:163:7: ^( DOTANY )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:171:1: character_class : OpenBracket ( cc_atom )+ CloseBracket -> ^( CHARACTER_CLASS ( cc_atom )+ ) ;
    public final RegexParser.character_class_return character_class() throws RecognitionException {
        RegexParser.character_class_return retval = new RegexParser.character_class_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token OpenBracket26=null;
        Token CloseBracket28=null;
        RegexParser.cc_atom_return cc_atom27 =null;


        Object OpenBracket26_tree=null;
        Object CloseBracket28_tree=null;
        RewriteRuleTokenStream stream_CloseBracket=new RewriteRuleTokenStream(adaptor,"token CloseBracket");
        RewriteRuleTokenStream stream_OpenBracket=new RewriteRuleTokenStream(adaptor,"token OpenBracket");
        RewriteRuleSubtreeStream stream_cc_atom=new RewriteRuleSubtreeStream(adaptor,"rule cc_atom");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:172:3: ( OpenBracket ( cc_atom )+ CloseBracket -> ^( CHARACTER_CLASS ( cc_atom )+ ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:173:3: OpenBracket ( cc_atom )+ CloseBracket
            {
            OpenBracket26=(Token)match(input,OpenBracket,FOLLOW_OpenBracket_in_character_class588); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OpenBracket.add(OpenBracket26);


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:173:15: ( cc_atom )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ALC||LA8_0==AUC||(LA8_0 >= Ampersand && LA8_0 <= BlockQuoted)||LA8_0==CLC||LA8_0==CUC||LA8_0==CarriageReturn||(LA8_0 >= Colon && LA8_0 <= DLC)||LA8_0==DUC||(LA8_0 >= DoubleQuote && LA8_0 <= ELC)||(LA8_0 >= EUC && LA8_0 <= GLC)||(LA8_0 >= GUC && LA8_0 <= KUC)||(LA8_0 >= LLC && LA8_0 <= MUC)||(LA8_0 >= NLC && LA8_0 <= NUC)||LA8_0==NewLine||LA8_0==OLC||LA8_0==OUC||(LA8_0 >= PLC && LA8_0 <= PUC)||(LA8_0 >= QLC && LA8_0 <= QUC)||LA8_0==Quoted||(LA8_0 >= RLC && LA8_0 <= Slash)||(LA8_0 >= TLC && LA8_0 <= YUC)||(LA8_0 >= ZLC && LA8_0 <= ZUC)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:173:15: cc_atom
            	    {
            	    pushFollow(FOLLOW_cc_atom_in_character_class590);
            	    cc_atom27=cc_atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom27.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            CloseBracket28=(Token)match(input,CloseBracket,FOLLOW_CloseBracket_in_character_class593); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CloseBracket.add(CloseBracket28);


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
            // 174:5: -> ^( CHARACTER_CLASS ( cc_atom )+ )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:175:7: ^( CHARACTER_CLASS ( cc_atom )+ )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:178:1: cc_atom : ( literal Hyphen literal -> ^( RANGE literal literal ) | literal );
    public final RegexParser.cc_atom_return cc_atom() throws RecognitionException {
        RegexParser.cc_atom_return retval = new RegexParser.cc_atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Hyphen30=null;
        RegexParser.literal_return literal29 =null;

        RegexParser.literal_return literal31 =null;

        RegexParser.literal_return literal32 =null;


        Object Hyphen30_tree=null;
        RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:179:3: ( literal Hyphen literal -> ^( RANGE literal literal ) | literal )
            int alt9=2;
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
                int LA9_1 = input.LA(2);

                if ( (LA9_1==Hyphen) ) {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_1==EOF||LA9_1==ALC||LA9_1==AUC||(LA9_1 >= Ampersand && LA9_1 <= BlockQuoted)||LA9_1==CLC||LA9_1==CUC||LA9_1==CarriageReturn||LA9_1==CloseBracket||(LA9_1 >= Colon && LA9_1 <= DLC)||LA9_1==DUC||(LA9_1 >= DoubleQuote && LA9_1 <= ELC)||(LA9_1 >= EUC && LA9_1 <= GLC)||(LA9_1 >= GUC && LA9_1 <= Hash)||(LA9_1 >= ILC && LA9_1 <= KUC)||(LA9_1 >= LLC && LA9_1 <= MUC)||(LA9_1 >= NLC && LA9_1 <= NUC)||LA9_1==NewLine||LA9_1==OLC||LA9_1==OUC||(LA9_1 >= PLC && LA9_1 <= PUC)||(LA9_1 >= QLC && LA9_1 <= QUC)||LA9_1==Quoted||(LA9_1 >= RLC && LA9_1 <= Slash)||(LA9_1 >= TLC && LA9_1 <= YUC)||(LA9_1 >= ZLC && LA9_1 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

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
                int LA9_2 = input.LA(2);

                if ( (LA9_2==Hyphen) ) {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_2==EOF||LA9_2==ALC||LA9_2==AUC||(LA9_2 >= Ampersand && LA9_2 <= BlockQuoted)||LA9_2==CLC||LA9_2==CUC||LA9_2==CarriageReturn||LA9_2==CloseBracket||(LA9_2 >= Colon && LA9_2 <= DLC)||LA9_2==DUC||(LA9_2 >= DoubleQuote && LA9_2 <= ELC)||(LA9_2 >= EUC && LA9_2 <= GLC)||(LA9_2 >= GUC && LA9_2 <= Hash)||(LA9_2 >= ILC && LA9_2 <= KUC)||(LA9_2 >= LLC && LA9_2 <= MUC)||(LA9_2 >= NLC && LA9_2 <= NUC)||LA9_2==NewLine||LA9_2==OLC||LA9_2==OUC||(LA9_2 >= PLC && LA9_2 <= PUC)||(LA9_2 >= QLC && LA9_2 <= QUC)||LA9_2==Quoted||(LA9_2 >= RLC && LA9_2 <= Slash)||(LA9_2 >= TLC && LA9_2 <= YUC)||(LA9_2 >= ZLC && LA9_2 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;

                }
                }
                break;
            case Backslash:
                {
                switch ( input.LA(2) ) {
                case CloseBracket:
                    {
                    int LA9_10 = input.LA(3);

                    if ( (LA9_10==Hyphen) ) {
                        switch ( input.LA(4) ) {
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
                            int LA9_22 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 22, input);

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
                            int LA9_23 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 23, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Backslash:
                            {
                            int LA9_24 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 24, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Hyphen:
                            {
                            int LA9_25 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 25, input);

                                throw nvae;

                            }
                            }
                            break;
                        case CarriageReturn:
                        case NewLine:
                        case Tab:
                        case WHITESPACE:
                            {
                            int LA9_26 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 26, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Quoted:
                            {
                            int LA9_27 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 27, input);

                                throw nvae;

                            }
                            }
                            break;
                        case BlockQuoted:
                            {
                            int LA9_28 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 28, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Ampersand:
                        case At:
                        case Colon:
                        case Comma:
                        case DoubleQuote:
                        case Equals:
                        case Exclamation:
                        case GraveAccent:
                        case GreaterThan:
                        case Hash:
                        case LessThan:
                        case Semicolon:
                        case SingleQuote:
                        case Slash:
                        case Tilde:
                        case Underscore:
                            {
                            int LA9_29 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 29, input);

                                throw nvae;

                            }
                            }
                            break;
                        case EOF:
                        case CloseBracket:
                        case CloseParen:
                        case Dollar:
                        case Dot:
                        case OpenBracket:
                        case OpenParen:
                        case Pipe:
                        case Plus:
                        case QuestionMark:
                        case Star:
                            {
                            alt9=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 20, input);

                            throw nvae;

                        }

                    }
                    else if ( (LA9_10==EOF||LA9_10==ALC||LA9_10==AUC||(LA9_10 >= Ampersand && LA9_10 <= BlockQuoted)||LA9_10==CLC||LA9_10==CUC||LA9_10==CarriageReturn||(LA9_10 >= CloseBracket && LA9_10 <= DLC)||(LA9_10 >= DUC && LA9_10 <= ELC)||(LA9_10 >= EUC && LA9_10 <= GLC)||(LA9_10 >= GUC && LA9_10 <= Hash)||(LA9_10 >= ILC && LA9_10 <= KUC)||(LA9_10 >= LLC && LA9_10 <= MUC)||(LA9_10 >= NLC && LA9_10 <= NUC)||LA9_10==NewLine||LA9_10==OLC||LA9_10==OUC||(LA9_10 >= OpenBracket && LA9_10 <= PUC)||(LA9_10 >= Pipe && LA9_10 <= Quoted)||(LA9_10 >= RLC && LA9_10 <= YUC)||(LA9_10 >= ZLC && LA9_10 <= ZUC)) ) {
                        alt9=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 10, input);

                        throw nvae;

                    }
                    }
                    break;
                case Hyphen:
                    {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                    }
                    break;
                case Caret:
                case CloseBrace:
                case CloseParen:
                case Dollar:
                case Dot:
                case OpenBrace:
                case OpenBracket:
                case OpenParen:
                case Pipe:
                case Plus:
                case QuestionMark:
                case Star:
                    {
                    int LA9_11 = input.LA(3);

                    if ( (LA9_11==Hyphen) ) {
                        switch ( input.LA(4) ) {
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
                            int LA9_12 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 12, input);

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
                            int LA9_13 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 13, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Backslash:
                            {
                            int LA9_14 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 14, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Hyphen:
                            {
                            int LA9_15 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 15, input);

                                throw nvae;

                            }
                            }
                            break;
                        case CarriageReturn:
                        case NewLine:
                        case Tab:
                        case WHITESPACE:
                            {
                            int LA9_16 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 16, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Quoted:
                            {
                            int LA9_17 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 17, input);

                                throw nvae;

                            }
                            }
                            break;
                        case BlockQuoted:
                            {
                            int LA9_18 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 18, input);

                                throw nvae;

                            }
                            }
                            break;
                        case Ampersand:
                        case At:
                        case Colon:
                        case Comma:
                        case DoubleQuote:
                        case Equals:
                        case Exclamation:
                        case GraveAccent:
                        case GreaterThan:
                        case Hash:
                        case LessThan:
                        case Semicolon:
                        case SingleQuote:
                        case Slash:
                        case Tilde:
                        case Underscore:
                            {
                            int LA9_19 = input.LA(5);

                            if ( (synpred13_Regex()) ) {
                                alt9=1;
                            }
                            else if ( (true) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 19, input);

                                throw nvae;

                            }
                            }
                            break;
                        case CloseBracket:
                            {
                            alt9=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 8, input);

                            throw nvae;

                        }

                    }
                    else if ( (LA9_11==EOF||LA9_11==ALC||LA9_11==AUC||(LA9_11 >= Ampersand && LA9_11 <= BlockQuoted)||LA9_11==CLC||LA9_11==CUC||LA9_11==CarriageReturn||LA9_11==CloseBracket||(LA9_11 >= Colon && LA9_11 <= DLC)||LA9_11==DUC||(LA9_11 >= DoubleQuote && LA9_11 <= ELC)||(LA9_11 >= EUC && LA9_11 <= GLC)||(LA9_11 >= GUC && LA9_11 <= Hash)||(LA9_11 >= ILC && LA9_11 <= KUC)||(LA9_11 >= LLC && LA9_11 <= MUC)||(LA9_11 >= NLC && LA9_11 <= NUC)||LA9_11==NewLine||LA9_11==OLC||LA9_11==OUC||(LA9_11 >= PLC && LA9_11 <= PUC)||(LA9_11 >= QLC && LA9_11 <= QUC)||LA9_11==Quoted||(LA9_11 >= RLC && LA9_11 <= Slash)||(LA9_11 >= TLC && LA9_11 <= YUC)||(LA9_11 >= ZLC && LA9_11 <= ZUC)) ) {
                        alt9=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 11, input);

                        throw nvae;

                    }
                    }
                    break;
                case EOF:
                case ALC:
                case AUC:
                case Ampersand:
                case At:
                case BLC:
                case BUC:
                case Backslash:
                case BlockQuoted:
                case CLC:
                case CUC:
                case CarriageReturn:
                case Colon:
                case Comma:
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
                case DoubleQuote:
                case ELC:
                case EUC:
                case Equals:
                case Exclamation:
                case FLC:
                case FUC:
                case GLC:
                case GUC:
                case GraveAccent:
                case GreaterThan:
                case HLC:
                case HUC:
                case Hash:
                case ILC:
                case IUC:
                case JLC:
                case JUC:
                case KLC:
                case KUC:
                case LLC:
                case LUC:
                case LessThan:
                case MLC:
                case MUC:
                case NLC:
                case NUC:
                case NewLine:
                case OLC:
                case OUC:
                case PLC:
                case PUC:
                case QLC:
                case QUC:
                case Quoted:
                case RLC:
                case RUC:
                case SLC:
                case SUC:
                case Semicolon:
                case SingleQuote:
                case Slash:
                case TLC:
                case TUC:
                case Tab:
                case Tilde:
                case ULC:
                case UUC:
                case Underscore:
                case VLC:
                case VUC:
                case WHITESPACE:
                case WLC:
                case WUC:
                case XLC:
                case XUC:
                case YLC:
                case YUC:
                case ZLC:
                case ZUC:
                    {
                    alt9=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;

                }

                }
                break;
            case Ampersand:
            case At:
            case Colon:
            case Comma:
            case DoubleQuote:
            case Equals:
            case Exclamation:
            case GraveAccent:
            case GreaterThan:
            case Hash:
            case Hyphen:
            case LessThan:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
                {
                int LA9_4 = input.LA(2);

                if ( (LA9_4==Hyphen) ) {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_4==EOF||LA9_4==ALC||LA9_4==AUC||(LA9_4 >= Ampersand && LA9_4 <= BlockQuoted)||LA9_4==CLC||LA9_4==CUC||LA9_4==CarriageReturn||LA9_4==CloseBracket||(LA9_4 >= Colon && LA9_4 <= DLC)||LA9_4==DUC||(LA9_4 >= DoubleQuote && LA9_4 <= ELC)||(LA9_4 >= EUC && LA9_4 <= GLC)||(LA9_4 >= GUC && LA9_4 <= Hash)||(LA9_4 >= ILC && LA9_4 <= KUC)||(LA9_4 >= LLC && LA9_4 <= MUC)||(LA9_4 >= NLC && LA9_4 <= NUC)||LA9_4==NewLine||LA9_4==OLC||LA9_4==OUC||(LA9_4 >= PLC && LA9_4 <= PUC)||(LA9_4 >= QLC && LA9_4 <= QUC)||LA9_4==Quoted||(LA9_4 >= RLC && LA9_4 <= Slash)||(LA9_4 >= TLC && LA9_4 <= YUC)||(LA9_4 >= ZLC && LA9_4 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 4, input);

                    throw nvae;

                }
                }
                break;
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
                {
                int LA9_5 = input.LA(2);

                if ( (LA9_5==Hyphen) ) {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_5==EOF||LA9_5==ALC||LA9_5==AUC||(LA9_5 >= Ampersand && LA9_5 <= BlockQuoted)||LA9_5==CLC||LA9_5==CUC||LA9_5==CarriageReturn||LA9_5==CloseBracket||(LA9_5 >= Colon && LA9_5 <= DLC)||LA9_5==DUC||(LA9_5 >= DoubleQuote && LA9_5 <= ELC)||(LA9_5 >= EUC && LA9_5 <= GLC)||(LA9_5 >= GUC && LA9_5 <= Hash)||(LA9_5 >= ILC && LA9_5 <= KUC)||(LA9_5 >= LLC && LA9_5 <= MUC)||(LA9_5 >= NLC && LA9_5 <= NUC)||LA9_5==NewLine||LA9_5==OLC||LA9_5==OUC||(LA9_5 >= PLC && LA9_5 <= PUC)||(LA9_5 >= QLC && LA9_5 <= QUC)||LA9_5==Quoted||(LA9_5 >= RLC && LA9_5 <= Slash)||(LA9_5 >= TLC && LA9_5 <= YUC)||(LA9_5 >= ZLC && LA9_5 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 5, input);

                    throw nvae;

                }
                }
                break;
            case Quoted:
                {
                int LA9_6 = input.LA(2);

                if ( (LA9_6==Hyphen) ) {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_6==EOF||LA9_6==ALC||LA9_6==AUC||(LA9_6 >= Ampersand && LA9_6 <= BlockQuoted)||LA9_6==CLC||LA9_6==CUC||LA9_6==CarriageReturn||LA9_6==CloseBracket||(LA9_6 >= Colon && LA9_6 <= DLC)||LA9_6==DUC||(LA9_6 >= DoubleQuote && LA9_6 <= ELC)||(LA9_6 >= EUC && LA9_6 <= GLC)||(LA9_6 >= GUC && LA9_6 <= Hash)||(LA9_6 >= ILC && LA9_6 <= KUC)||(LA9_6 >= LLC && LA9_6 <= MUC)||(LA9_6 >= NLC && LA9_6 <= NUC)||LA9_6==NewLine||LA9_6==OLC||LA9_6==OUC||(LA9_6 >= PLC && LA9_6 <= PUC)||(LA9_6 >= QLC && LA9_6 <= QUC)||LA9_6==Quoted||(LA9_6 >= RLC && LA9_6 <= Slash)||(LA9_6 >= TLC && LA9_6 <= YUC)||(LA9_6 >= ZLC && LA9_6 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 6, input);

                    throw nvae;

                }
                }
                break;
            case BlockQuoted:
                {
                int LA9_7 = input.LA(2);

                if ( (LA9_7==Hyphen) ) {
                    switch ( input.LA(3) ) {
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
                        int LA9_12 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 12, input);

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
                        int LA9_13 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Backslash:
                        {
                        int LA9_14 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 14, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Hyphen:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Quoted:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case BlockQuoted:
                        {
                        int LA9_18 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 18, input);

                            throw nvae;

                        }
                        }
                        break;
                    case Ampersand:
                    case At:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
                        {
                        int LA9_19 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 19, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_7==EOF||LA9_7==ALC||LA9_7==AUC||(LA9_7 >= Ampersand && LA9_7 <= BlockQuoted)||LA9_7==CLC||LA9_7==CUC||LA9_7==CarriageReturn||LA9_7==CloseBracket||(LA9_7 >= Colon && LA9_7 <= DLC)||LA9_7==DUC||(LA9_7 >= DoubleQuote && LA9_7 <= ELC)||(LA9_7 >= EUC && LA9_7 <= GLC)||(LA9_7 >= GUC && LA9_7 <= Hash)||(LA9_7 >= ILC && LA9_7 <= KUC)||(LA9_7 >= LLC && LA9_7 <= MUC)||(LA9_7 >= NLC && LA9_7 <= NUC)||LA9_7==NewLine||LA9_7==OLC||LA9_7==OUC||(LA9_7 >= PLC && LA9_7 <= PUC)||(LA9_7 >= QLC && LA9_7 <= QUC)||LA9_7==Quoted||(LA9_7 >= RLC && LA9_7 <= Slash)||(LA9_7 >= TLC && LA9_7 <= YUC)||(LA9_7 >= ZLC && LA9_7 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 7, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:180:3: literal Hyphen literal
                    {
                    pushFollow(FOLLOW_literal_in_cc_atom627);
                    literal29=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal29.getTree());

                    Hyphen30=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_cc_atom629); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen30);


                    pushFollow(FOLLOW_literal_in_cc_atom631);
                    literal31=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal31.getTree());

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
                    // 181:5: -> ^( RANGE literal literal )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:182:7: ^( RANGE literal literal )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:183:5: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_cc_atom657);
                    literal32=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal32.getTree());

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


    public static class subject_boundary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "subject_boundary"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:191:1: subject_boundary : ( '^' regex -> regex | regex '$' -> regex | '^' regex '$' -> regex );
    public final RegexParser.subject_boundary_return subject_boundary() throws RecognitionException {
        RegexParser.subject_boundary_return retval = new RegexParser.subject_boundary_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal33=null;
        Token char_literal36=null;
        Token char_literal37=null;
        Token char_literal39=null;
        RegexParser.regex_return regex34 =null;

        RegexParser.regex_return regex35 =null;

        RegexParser.regex_return regex38 =null;


        Object char_literal33_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;
        Object char_literal39_tree=null;
        RewriteRuleTokenStream stream_Dollar=new RewriteRuleTokenStream(adaptor,"token Dollar");
        RewriteRuleTokenStream stream_Caret=new RewriteRuleTokenStream(adaptor,"token Caret");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:192:3: ( '^' regex -> regex | regex '$' -> regex | '^' regex '$' -> regex )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Caret) ) {
                int LA10_1 = input.LA(2);

                if ( (synpred14_Regex()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA10_0==ALC||LA10_0==AUC||(LA10_0 >= Ampersand && LA10_0 <= BlockQuoted)||LA10_0==CLC||LA10_0==CUC||LA10_0==CarriageReturn||(LA10_0 >= Colon && LA10_0 <= DLC)||(LA10_0 >= DUC && LA10_0 <= ELC)||(LA10_0 >= EUC && LA10_0 <= GLC)||(LA10_0 >= GUC && LA10_0 <= KUC)||(LA10_0 >= LLC && LA10_0 <= MUC)||(LA10_0 >= NLC && LA10_0 <= NUC)||LA10_0==NewLine||LA10_0==OLC||LA10_0==OUC||(LA10_0 >= OpenBracket && LA10_0 <= PUC)||LA10_0==Pipe||(LA10_0 >= QLC && LA10_0 <= QUC)||LA10_0==Quoted||(LA10_0 >= RLC && LA10_0 <= Slash)||(LA10_0 >= TLC && LA10_0 <= YUC)||(LA10_0 >= ZLC && LA10_0 <= ZUC)) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:193:3: '^' regex
                    {
                    char_literal33=(Token)match(input,Caret,FOLLOW_Caret_in_subject_boundary677); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Caret.add(char_literal33);


                    pushFollow(FOLLOW_regex_in_subject_boundary679);
                    regex34=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex34.getTree());

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
                    // 194:5: -> regex
                    {
                        adaptor.addChild(root_0, stream_regex.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:195:5: regex '$'
                    {
                    pushFollow(FOLLOW_regex_in_subject_boundary693);
                    regex35=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex35.getTree());

                    char_literal36=(Token)match(input,Dollar,FOLLOW_Dollar_in_subject_boundary695); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Dollar.add(char_literal36);


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
                    // 196:5: -> regex
                    {
                        adaptor.addChild(root_0, stream_regex.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:197:5: '^' regex '$'
                    {
                    char_literal37=(Token)match(input,Caret,FOLLOW_Caret_in_subject_boundary709); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Caret.add(char_literal37);


                    pushFollow(FOLLOW_regex_in_subject_boundary711);
                    regex38=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex38.getTree());

                    char_literal39=(Token)match(input,Dollar,FOLLOW_Dollar_in_subject_boundary713); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Dollar.add(char_literal39);


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
                    // 198:5: -> regex
                    {
                        adaptor.addChild(root_0, stream_regex.nextTree());

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
    // $ANTLR end "subject_boundary"


    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:202:1: literal : ( letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] | special_chars -> LITERAL[$special_chars.text] | special_chars_with_quote -> LITERAL[$special_chars_with_quote.text] | whitespace -> LITERAL[$whitespace.text] | Quoted -> LITERAL[$Quoted.text] | BlockQuoted -> LITERAL[$BlockQuoted.text] );
    public final RegexParser.literal_return literal() throws RecognitionException {
        RegexParser.literal_return retval = new RegexParser.literal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Quoted45=null;
        Token BlockQuoted46=null;
        RegexParser.letter_return letter40 =null;

        RegexParser.digit_return digit41 =null;

        RegexParser.special_chars_return special_chars42 =null;

        RegexParser.special_chars_with_quote_return special_chars_with_quote43 =null;

        RegexParser.whitespace_return whitespace44 =null;


        Object Quoted45_tree=null;
        Object BlockQuoted46_tree=null;
        RewriteRuleTokenStream stream_Quoted=new RewriteRuleTokenStream(adaptor,"token Quoted");
        RewriteRuleTokenStream stream_BlockQuoted=new RewriteRuleTokenStream(adaptor,"token BlockQuoted");
        RewriteRuleSubtreeStream stream_special_chars=new RewriteRuleSubtreeStream(adaptor,"rule special_chars");
        RewriteRuleSubtreeStream stream_digit=new RewriteRuleSubtreeStream(adaptor,"rule digit");
        RewriteRuleSubtreeStream stream_letter=new RewriteRuleSubtreeStream(adaptor,"rule letter");
        RewriteRuleSubtreeStream stream_whitespace=new RewriteRuleSubtreeStream(adaptor,"rule whitespace");
        RewriteRuleSubtreeStream stream_special_chars_with_quote=new RewriteRuleSubtreeStream(adaptor,"rule special_chars_with_quote");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:203:3: ( letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] | special_chars -> LITERAL[$special_chars.text] | special_chars_with_quote -> LITERAL[$special_chars_with_quote.text] | whitespace -> LITERAL[$whitespace.text] | Quoted -> LITERAL[$Quoted.text] | BlockQuoted -> LITERAL[$BlockQuoted.text] )
            int alt11=7;
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
                alt11=1;
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
                alt11=2;
                }
                break;
            case Backslash:
                {
                switch ( input.LA(2) ) {
                case Plus:
                    {
                    int LA11_8 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 8, input);

                        throw nvae;

                    }
                    }
                    break;
                case Star:
                    {
                    int LA11_9 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 9, input);

                        throw nvae;

                    }
                    }
                    break;
                case QuestionMark:
                    {
                    int LA11_10 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 10, input);

                        throw nvae;

                    }
                    }
                    break;
                case CloseParen:
                    {
                    int LA11_11 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 11, input);

                        throw nvae;

                    }
                    }
                    break;
                case EOF:
                case ALC:
                case AUC:
                case Ampersand:
                case At:
                case BLC:
                case BUC:
                case Backslash:
                case BlockQuoted:
                case CLC:
                case CUC:
                case CarriageReturn:
                case Colon:
                case Comma:
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
                case DoubleQuote:
                case ELC:
                case EUC:
                case Equals:
                case Exclamation:
                case FLC:
                case FUC:
                case GLC:
                case GUC:
                case GraveAccent:
                case GreaterThan:
                case HLC:
                case HUC:
                case Hash:
                case Hyphen:
                case ILC:
                case IUC:
                case JLC:
                case JUC:
                case KLC:
                case KUC:
                case LLC:
                case LUC:
                case LessThan:
                case MLC:
                case MUC:
                case NLC:
                case NUC:
                case NewLine:
                case OLC:
                case OUC:
                case PLC:
                case PUC:
                case QLC:
                case QUC:
                case Quoted:
                case RLC:
                case RUC:
                case SLC:
                case SUC:
                case Semicolon:
                case SingleQuote:
                case Slash:
                case TLC:
                case TUC:
                case Tab:
                case Tilde:
                case ULC:
                case UUC:
                case Underscore:
                case VLC:
                case VUC:
                case WHITESPACE:
                case WLC:
                case WUC:
                case XLC:
                case XUC:
                case YLC:
                case YUC:
                case ZLC:
                case ZUC:
                    {
                    alt11=3;
                    }
                    break;
                case Dollar:
                    {
                    int LA11_12 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 12, input);

                        throw nvae;

                    }
                    }
                    break;
                case Pipe:
                    {
                    int LA11_13 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 13, input);

                        throw nvae;

                    }
                    }
                    break;
                case OpenParen:
                    {
                    int LA11_14 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 14, input);

                        throw nvae;

                    }
                    }
                    break;
                case Dot:
                    {
                    int LA11_15 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 15, input);

                        throw nvae;

                    }
                    }
                    break;
                case OpenBracket:
                    {
                    int LA11_16 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 16, input);

                        throw nvae;

                    }
                    }
                    break;
                case CloseBracket:
                    {
                    int LA11_17 = input.LA(3);

                    if ( (synpred18_Regex()) ) {
                        alt11=3;
                    }
                    else if ( (synpred19_Regex()) ) {
                        alt11=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 17, input);

                        throw nvae;

                    }
                    }
                    break;
                case Caret:
                case CloseBrace:
                case OpenBrace:
                    {
                    alt11=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;

                }

                }
                break;
            case Ampersand:
            case At:
            case Colon:
            case Comma:
            case DoubleQuote:
            case Equals:
            case Exclamation:
            case GraveAccent:
            case GreaterThan:
            case Hash:
            case Hyphen:
            case LessThan:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
                {
                alt11=3;
                }
                break;
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
                {
                alt11=5;
                }
                break;
            case Quoted:
                {
                alt11=6;
                }
                break;
            case BlockQuoted:
                {
                alt11=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:204:3: letter
                    {
                    pushFollow(FOLLOW_letter_in_literal737);
                    letter40=letter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_letter.add(letter40.getTree());

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
                    // 205:5: -> LITERAL[$letter.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (letter40!=null?input.toString(letter40.start,letter40.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:206:5: digit
                    {
                    pushFollow(FOLLOW_digit_in_literal752);
                    digit41=digit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_digit.add(digit41.getTree());

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
                    // 207:5: -> LITERAL[$digit.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (digit41!=null?input.toString(digit41.start,digit41.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:208:5: special_chars
                    {
                    pushFollow(FOLLOW_special_chars_in_literal767);
                    special_chars42=special_chars();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_special_chars.add(special_chars42.getTree());

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
                    // 209:5: -> LITERAL[$special_chars.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (special_chars42!=null?input.toString(special_chars42.start,special_chars42.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:210:5: special_chars_with_quote
                    {
                    pushFollow(FOLLOW_special_chars_with_quote_in_literal782);
                    special_chars_with_quote43=special_chars_with_quote();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_special_chars_with_quote.add(special_chars_with_quote43.getTree());

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
                    // 211:5: -> LITERAL[$special_chars_with_quote.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (special_chars_with_quote43!=null?input.toString(special_chars_with_quote43.start,special_chars_with_quote43.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:212:5: whitespace
                    {
                    pushFollow(FOLLOW_whitespace_in_literal797);
                    whitespace44=whitespace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_whitespace.add(whitespace44.getTree());

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
                    // 213:5: -> LITERAL[$whitespace.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (whitespace44!=null?input.toString(whitespace44.start,whitespace44.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:214:5: Quoted
                    {
                    Quoted45=(Token)match(input,Quoted,FOLLOW_Quoted_in_literal812); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Quoted.add(Quoted45);


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
                    // 215:5: -> LITERAL[$Quoted.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (Quoted45!=null?Quoted45.getText():null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:216:5: BlockQuoted
                    {
                    BlockQuoted46=(Token)match(input,BlockQuoted,FOLLOW_BlockQuoted_in_literal827); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BlockQuoted.add(BlockQuoted46);


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
                    // 217:5: -> LITERAL[$BlockQuoted.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (BlockQuoted46!=null?BlockQuoted46.getText():null))
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


    public static class whitespace_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whitespace"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:220:1: whitespace : ( WHITESPACE | Tab | NewLine | CarriageReturn );
    public final RegexParser.whitespace_return whitespace() throws RecognitionException {
        RegexParser.whitespace_return retval = new RegexParser.whitespace_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set47=null;

        Object set47_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:221:3: ( WHITESPACE | Tab | NewLine | CarriageReturn )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set47=(Token)input.LT(1);

            if ( input.LA(1)==CarriageReturn||input.LA(1)==NewLine||input.LA(1)==Tab||input.LA(1)==WHITESPACE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set47)
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
    // $ANTLR end "whitespace"


    public static class number_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "number"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:228:1: number : digits -> NUMBER[$digits.text] ;
    public final RegexParser.number_return number() throws RecognitionException {
        RegexParser.number_return retval = new RegexParser.number_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.digits_return digits48 =null;


        RewriteRuleSubtreeStream stream_digits=new RewriteRuleSubtreeStream(adaptor,"rule digits");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:229:3: ( digits -> NUMBER[$digits.text] )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:230:3: digits
            {
            pushFollow(FOLLOW_digits_in_number884);
            digits48=digits();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_digits.add(digits48.getTree());

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
            // 231:5: -> NUMBER[$digits.text]
            {
                adaptor.addChild(root_0, 
                (Object)adaptor.create(NUMBER, (digits48!=null?input.toString(digits48.start,digits48.stop):null))
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:234:1: digits : ( digit )+ ;
    public final RegexParser.digits_return digits() throws RecognitionException {
        RegexParser.digits_return retval = new RegexParser.digits_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.digit_return digit49 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:235:3: ( ( digit )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:236:3: ( digit )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:236:3: ( digit )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= D0 && LA12_0 <= D9)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:236:3: digit
            	    {
            	    pushFollow(FOLLOW_digit_in_digits908);
            	    digit49=digit();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, digit49.getTree());

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
    // $ANTLR end "digits"


    public static class digit_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "digit"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:239:1: digit : ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 );
    public final RegexParser.digit_return digit() throws RecognitionException {
        RegexParser.digit_return retval = new RegexParser.digit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set50=null;

        Object set50_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:240:3: ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set50=(Token)input.LT(1);

            if ( (input.LA(1) >= D0 && input.LA(1) <= D9) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set50)
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:253:1: name : letters -> NAME[$letters.text] ;
    public final RegexParser.name_return name() throws RecognitionException {
        RegexParser.name_return retval = new RegexParser.name_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.letters_return letters51 =null;


        RewriteRuleSubtreeStream stream_letters=new RewriteRuleSubtreeStream(adaptor,"rule letters");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:254:3: ( letters -> NAME[$letters.text] )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:255:3: letters
            {
            pushFollow(FOLLOW_letters_in_name993);
            letters51=letters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_letters.add(letters51.getTree());

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
            // 256:5: -> NAME[$letters.text]
            {
                adaptor.addChild(root_0, 
                (Object)adaptor.create(NAME, (letters51!=null?input.toString(letters51.start,letters51.stop):null))
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:259:1: letters : ( letter )+ ;
    public final RegexParser.letters_return letters() throws RecognitionException {
        RegexParser.letters_return retval = new RegexParser.letters_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.letter_return letter52 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:260:3: ( ( letter )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:261:3: ( letter )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:261:3: ( letter )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==ALC||LA13_0==AUC||(LA13_0 >= BLC && LA13_0 <= BUC)||LA13_0==CLC||LA13_0==CUC||LA13_0==DLC||LA13_0==DUC||LA13_0==ELC||LA13_0==EUC||(LA13_0 >= FLC && LA13_0 <= GLC)||LA13_0==GUC||(LA13_0 >= HLC && LA13_0 <= HUC)||(LA13_0 >= ILC && LA13_0 <= KUC)||(LA13_0 >= LLC && LA13_0 <= LUC)||(LA13_0 >= MLC && LA13_0 <= MUC)||(LA13_0 >= NLC && LA13_0 <= NUC)||LA13_0==OLC||LA13_0==OUC||(LA13_0 >= PLC && LA13_0 <= PUC)||(LA13_0 >= QLC && LA13_0 <= QUC)||(LA13_0 >= RLC && LA13_0 <= SUC)||(LA13_0 >= TLC && LA13_0 <= TUC)||(LA13_0 >= ULC && LA13_0 <= UUC)||(LA13_0 >= VLC && LA13_0 <= VUC)||(LA13_0 >= WLC && LA13_0 <= YUC)||(LA13_0 >= ZLC && LA13_0 <= ZUC)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:261:3: letter
            	    {
            	    pushFollow(FOLLOW_letter_in_letters1017);
            	    letter52=letter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, letter52.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:264:1: non_close_parens : ( non_close_paren )+ ;
    public final RegexParser.non_close_parens_return non_close_parens() throws RecognitionException {
        RegexParser.non_close_parens_return retval = new RegexParser.non_close_parens_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.non_close_paren_return non_close_paren53 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:265:3: ( ( non_close_paren )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:266:3: ( non_close_paren )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:266:3: ( non_close_paren )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= ALC && LA14_0 <= CloseBracket)||(LA14_0 >= Colon && LA14_0 <= ZUC)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:266:3: non_close_paren
            	    {
            	    pushFollow(FOLLOW_non_close_paren_in_non_close_parens1033);
            	    non_close_paren53=non_close_paren();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, non_close_paren53.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:269:1: non_close_paren : ~ CloseParen ;
    public final RegexParser.non_close_paren_return non_close_paren() throws RecognitionException {
        RegexParser.non_close_paren_return retval = new RegexParser.non_close_paren_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set54=null;

        Object set54_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:270:3: (~ CloseParen )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set54=(Token)input.LT(1);

            if ( (input.LA(1) >= ALC && input.LA(1) <= CloseBracket)||(input.LA(1) >= Colon && input.LA(1) <= ZUC) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set54)
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:274:1: letter : ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC );
    public final RegexParser.letter_return letter() throws RecognitionException {
        RegexParser.letter_return retval = new RegexParser.letter_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set55=null;

        Object set55_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:275:3: ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set55=(Token)input.LT(1);

            if ( input.LA(1)==ALC||input.LA(1)==AUC||(input.LA(1) >= BLC && input.LA(1) <= BUC)||input.LA(1)==CLC||input.LA(1)==CUC||input.LA(1)==DLC||input.LA(1)==DUC||input.LA(1)==ELC||input.LA(1)==EUC||(input.LA(1) >= FLC && input.LA(1) <= GLC)||input.LA(1)==GUC||(input.LA(1) >= HLC && input.LA(1) <= HUC)||(input.LA(1) >= ILC && input.LA(1) <= KUC)||(input.LA(1) >= LLC && input.LA(1) <= LUC)||(input.LA(1) >= MLC && input.LA(1) <= MUC)||(input.LA(1) >= NLC && input.LA(1) <= NUC)||input.LA(1)==OLC||input.LA(1)==OUC||(input.LA(1) >= PLC && input.LA(1) <= PUC)||(input.LA(1) >= QLC && input.LA(1) <= QUC)||(input.LA(1) >= RLC && input.LA(1) <= SUC)||(input.LA(1) >= TLC && input.LA(1) <= TUC)||(input.LA(1) >= ULC && input.LA(1) <= UUC)||(input.LA(1) >= VLC && input.LA(1) <= VUC)||(input.LA(1) >= WLC && input.LA(1) <= YUC)||(input.LA(1) >= ZLC && input.LA(1) <= ZUC) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set55)
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


    public static class special_chars_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "special_chars"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:330:1: special_chars : ( Exclamation | DoubleQuote | Hash | Ampersand | SingleQuote | Comma | Hyphen | Slash | Colon | Semicolon | LessThan | Equals | GreaterThan | At | Backslash | Underscore | GraveAccent | Tilde );
    public final RegexParser.special_chars_return special_chars() throws RecognitionException {
        RegexParser.special_chars_return retval = new RegexParser.special_chars_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set56=null;

        Object set56_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:331:3: ( Exclamation | DoubleQuote | Hash | Ampersand | SingleQuote | Comma | Hyphen | Slash | Colon | Semicolon | LessThan | Equals | GreaterThan | At | Backslash | Underscore | GraveAccent | Tilde )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set56=(Token)input.LT(1);

            if ( (input.LA(1) >= Ampersand && input.LA(1) <= At)||input.LA(1)==Backslash||(input.LA(1) >= Colon && input.LA(1) <= Comma)||input.LA(1)==DoubleQuote||(input.LA(1) >= Equals && input.LA(1) <= Exclamation)||(input.LA(1) >= GraveAccent && input.LA(1) <= GreaterThan)||(input.LA(1) >= Hash && input.LA(1) <= Hyphen)||input.LA(1)==LessThan||(input.LA(1) >= Semicolon && input.LA(1) <= Slash)||input.LA(1)==Tilde||input.LA(1)==Underscore ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set56)
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
    // $ANTLR end "special_chars"


    public static class special_chars_with_quote_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "special_chars_with_quote"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:352:1: special_chars_with_quote : '\\\\' ( Dollar | OpenParen | CloseParen | Star | Plus | Dot | QuestionMark | OpenBracket | CloseBracket | Caret | OpenBrace | Pipe | CloseBrace ) ;
    public final RegexParser.special_chars_with_quote_return special_chars_with_quote() throws RecognitionException {
        RegexParser.special_chars_with_quote_return retval = new RegexParser.special_chars_with_quote_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal57=null;
        Token set58=null;

        Object char_literal57_tree=null;
        Object set58_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:353:3: ( '\\\\' ( Dollar | OpenParen | CloseParen | Star | Plus | Dot | QuestionMark | OpenBracket | CloseBracket | Caret | OpenBrace | Pipe | CloseBrace ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:354:3: '\\\\' ( Dollar | OpenParen | CloseParen | Star | Plus | Dot | QuestionMark | OpenBracket | CloseBracket | Caret | OpenBrace | Pipe | CloseBrace )
            {
            root_0 = (Object)adaptor.nil();


            char_literal57=(Token)match(input,Backslash,FOLLOW_Backslash_in_special_chars_with_quote1503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal57_tree = 
            (Object)adaptor.create(char_literal57)
            ;
            adaptor.addChild(root_0, char_literal57_tree);
            }

            set58=(Token)input.LT(1);

            if ( input.LA(1)==Caret||(input.LA(1) >= CloseBrace && input.LA(1) <= CloseParen)||(input.LA(1) >= Dollar && input.LA(1) <= Dot)||(input.LA(1) >= OpenBrace && input.LA(1) <= OpenParen)||(input.LA(1) >= Pipe && input.LA(1) <= Plus)||input.LA(1)==QuestionMark||input.LA(1)==Star ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set58)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( state.backtracking==0 ) {
               setText(input.toString(retval.start,input.LT(-1)).substring(1));
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
    // $ANTLR end "special_chars_with_quote"

    // $ANTLR start synpred1_Regex
    public final void synpred1_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:86:3: ( regex EOF )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:86:3: regex EOF
        {
        pushFollow(FOLLOW_regex_in_synpred1_Regex161);
        regex();

        state._fsp--;
        if (state.failed) return ;

        match(input,EOF,FOLLOW_EOF_in_synpred1_Regex163); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Regex

    // $ANTLR start synpred5_Regex
    public final void synpred5_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:120:3: ( atom '+' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:120:3: atom '+'
        {
        pushFollow(FOLLOW_atom_in_synpred5_Regex318);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,Plus,FOLLOW_Plus_in_synpred5_Regex320); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Regex

    // $ANTLR start synpred6_Regex
    public final void synpred6_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:123:5: ( atom '*' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:123:5: atom '*'
        {
        pushFollow(FOLLOW_atom_in_synpred6_Regex344);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,Star,FOLLOW_Star_in_synpred6_Regex346); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Regex

    // $ANTLR start synpred7_Regex
    public final void synpred7_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:126:5: ( atom '?' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:126:5: atom '?'
        {
        pushFollow(FOLLOW_atom_in_synpred7_Regex370);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred7_Regex372); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Regex

    // $ANTLR start synpred13_Regex
    public final void synpred13_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:180:3: ( literal Hyphen literal )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:180:3: literal Hyphen literal
        {
        pushFollow(FOLLOW_literal_in_synpred13_Regex627);
        literal();

        state._fsp--;
        if (state.failed) return ;

        match(input,Hyphen,FOLLOW_Hyphen_in_synpred13_Regex629); if (state.failed) return ;

        pushFollow(FOLLOW_literal_in_synpred13_Regex631);
        literal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred13_Regex

    // $ANTLR start synpred14_Regex
    public final void synpred14_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:193:3: ( '^' regex )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:193:3: '^' regex
        {
        match(input,Caret,FOLLOW_Caret_in_synpred14_Regex677); if (state.failed) return ;

        pushFollow(FOLLOW_regex_in_synpred14_Regex679);
        regex();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred14_Regex

    // $ANTLR start synpred18_Regex
    public final void synpred18_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:208:5: ( special_chars )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:208:5: special_chars
        {
        pushFollow(FOLLOW_special_chars_in_synpred18_Regex767);
        special_chars();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred18_Regex

    // $ANTLR start synpred19_Regex
    public final void synpred19_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:210:5: ( special_chars_with_quote )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:210:5: special_chars_with_quote
        {
        pushFollow(FOLLOW_special_chars_with_quote_in_synpred19_Regex782);
        special_chars_with_quote();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred19_Regex

    // Delegated rules

    public final boolean synpred19_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred14_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Regex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Regex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Regex_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_subject_boundary_in_parse177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_first_alternative_in_regex197 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_Pipe_in_regex219 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x006FFFF7F5AF4ADFL});
    public static final BitSet FOLLOW_concatenation_in_regex221 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_concatenation_in_first_alternative268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_concatenation283 = new BitSet(new long[]{0x7FFDFBAFFF8ABF52L,0x006FFFF7F58F4ADFL});
    public static final BitSet FOLLOW_atom_in_element318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_Plus_in_element320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element344 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_Star_in_element346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element370 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_QuestionMark_in_element372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_quantifier429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_quantifier451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OpenParen_in_group482 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x006FFFF7F58F4ADFL});
    public static final BitSet FOLLOW_regex_in_group484 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CloseParen_in_group486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_atom525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotany_in_atom531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_character_class_in_atom537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_dotany552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OpenBracket_in_character_class588 = new BitSet(new long[]{0x7FFDFB2FFF8ABF50L,0x006FFFF7F58C4ADFL});
    public static final BitSet FOLLOW_cc_atom_in_character_class590 = new BitSet(new long[]{0x7FFDFB2FFFAABF50L,0x006FFFF7F58C4ADFL});
    public static final BitSet FOLLOW_CloseBracket_in_character_class593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_cc_atom627 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_Hyphen_in_cc_atom629 = new BitSet(new long[]{0x7FFDFB2FFF8ABF50L,0x006FFFF7F58C4ADFL});
    public static final BitSet FOLLOW_literal_in_cc_atom631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_cc_atom657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Caret_in_subject_boundary677 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x006FFFF7F58F4ADFL});
    public static final BitSet FOLLOW_regex_in_subject_boundary679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regex_in_subject_boundary693 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_Dollar_in_subject_boundary695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Caret_in_subject_boundary709 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x006FFFF7F58F4ADFL});
    public static final BitSet FOLLOW_regex_in_subject_boundary711 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_Dollar_in_subject_boundary713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letter_in_literal737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digit_in_literal752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_special_chars_in_literal767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_special_chars_with_quote_in_literal782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespace_in_literal797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quoted_in_literal812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlockQuoted_in_literal827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digits_in_number884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digit_in_digits908 = new BitSet(new long[]{0x00000007FE000002L});
    public static final BitSet FOLLOW_letters_in_name993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letter_in_letters1017 = new BitSet(new long[]{0x7E65CA2800028C52L,0x006FDB30F18C48DBL});
    public static final BitSet FOLLOW_non_close_paren_in_non_close_parens1033 = new BitSet(new long[]{0xFFFFFFFFFFBFFFF2L,0x007FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_Backslash_in_special_chars_with_quote1503 = new BitSet(new long[]{0x000000C000740000L,0x0000000802638000L});
    public static final BitSet FOLLOW_set_in_special_chars_with_quote1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regex_in_synpred1_Regex161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_synpred1_Regex163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred5_Regex318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_Plus_in_synpred5_Regex320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred6_Regex344 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_Star_in_synpred6_Regex346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred7_Regex370 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_QuestionMark_in_synpred7_Regex372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_synpred13_Regex627 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_Hyphen_in_synpred13_Regex629 = new BitSet(new long[]{0x7FFDFB2FFF8ABF50L,0x006FFFF7F58C4ADFL});
    public static final BitSet FOLLOW_literal_in_synpred13_Regex631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Caret_in_synpred14_Regex677 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x006FFFF7F58F4ADFL});
    public static final BitSet FOLLOW_regex_in_synpred14_Regex679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_special_chars_in_synpred18_Regex767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_special_chars_with_quote_in_synpred19_Regex782 = new BitSet(new long[]{0x0000000000000002L});

}