// $ANTLR 3.4 /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g 2013-12-14 17:44:30

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALC", "ALTERNATIVE", "AUC", "AlphaNumeric", "Ampersand", "At", "BLC", "BUC", "Backslash", "BlockQuoted", "CHARACTER_CLASS", "CLC", "CONCATENATION", "CUC", "Caret", "CarriageReturn", "CloseBrace", "CloseBracket", "CloseParen", "Colon", "Comma", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DLC", "DOTANY", "DUC", "Dollar", "Dot", "DoubleQuote", "ELC", "ELEMENT", "EUC", "Equals", "Exclamation", "FLC", "FUC", "GLC", "GROUP", "GUC", "GraveAccent", "GreaterThan", "HLC", "HUC", "Hash", "Hyphen", "ILC", "IUC", "JLC", "JUC", "KLC", "KUC", "LITERAL", "LLC", "LUC", "LessThan", "MLC", "MUC", "NLC", "NUC", "NewLine", "NonAlphaNumeric", "OLC", "ONEORMORE", "OPTIONAL", "OUC", "OpenBrace", "OpenBracket", "OpenParen", "PLC", "PUC", "Percent", "Pipe", "Plus", "QLC", "QUC", "QuestionMark", "Quoted", "RANGE", "RLC", "RUC", "SLC", "SUC", "Semicolon", "SingleQuote", "Slash", "Star", "TLC", "TUC", "Tab", "Tilde", "ULC", "UUC", "Underscore", "VLC", "VUC", "WHITESPACE", "WLC", "WUC", "XLC", "XUC", "YLC", "YUC", "ZEROORMORE", "ZLC", "ZUC"
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
    public static final int NLC=69;
    public static final int NUC=70;
    public static final int NewLine=71;
    public static final int NonAlphaNumeric=72;
    public static final int OLC=73;
    public static final int ONEORMORE=74;
    public static final int OPTIONAL=75;
    public static final int OUC=76;
    public static final int OpenBrace=77;
    public static final int OpenBracket=78;
    public static final int OpenParen=79;
    public static final int PLC=80;
    public static final int PUC=81;
    public static final int Percent=82;
    public static final int Pipe=83;
    public static final int Plus=84;
    public static final int QLC=85;
    public static final int QUC=86;
    public static final int QuestionMark=87;
    public static final int Quoted=88;
    public static final int RANGE=89;
    public static final int RLC=90;
    public static final int RUC=91;
    public static final int SLC=92;
    public static final int SUC=93;
    public static final int Semicolon=94;
    public static final int SingleQuote=95;
    public static final int Slash=96;
    public static final int Star=97;
    public static final int TLC=98;
    public static final int TUC=99;
    public static final int Tab=100;
    public static final int Tilde=101;
    public static final int ULC=102;
    public static final int UUC=103;
    public static final int Underscore=104;
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:82:1: parse : ( regex EOF -> regex | subject_boundary );
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:83:3: ( regex EOF -> regex | subject_boundary )
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
            case Ampersand:
            case At:
            case Backslash:
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
            case Percent:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
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
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
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
            case Quoted:
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
            case BlockQuoted:
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
            case OpenParen:
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
            case Dot:
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
            case OpenBracket:
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
            case Pipe:
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:84:3: regex EOF
                    {
                    pushFollow(FOLLOW_regex_in_parse151);
                    regex1=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex1.getTree());

                    EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse153); if (state.failed) return retval; 
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
                    // 85:5: -> regex
                    {
                        adaptor.addChild(root_0, stream_regex.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:86:5: subject_boundary
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_subject_boundary_in_parse167);
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:93:1: regex : ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )? ;
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:94:3: ( ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )? )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:95:3: ( first_alternative -> first_alternative ) ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )?
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:95:3: ( first_alternative -> first_alternative )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:95:4: first_alternative
            {
            pushFollow(FOLLOW_first_alternative_in_regex187);
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
            // 96:7: -> first_alternative
            {
                adaptor.addChild(root_0, stream_first_alternative.nextTree());

            }


            retval.tree = root_0;
            }

            }


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:97:3: ( ( '|' concatenation )+ -> ^( ALTERNATIVE first_alternative ( concatenation )+ ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Pipe) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:98:5: ( '|' concatenation )+
                    {
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:98:5: ( '|' concatenation )+
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
                    	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:98:6: '|' concatenation
                    	    {
                    	    char_literal5=(Token)match(input,Pipe,FOLLOW_Pipe_in_regex209); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Pipe.add(char_literal5);


                    	    pushFollow(FOLLOW_concatenation_in_regex211);
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
                    // elements: first_alternative, concatenation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 99:7: -> ^( ALTERNATIVE first_alternative ( concatenation )+ )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:100:9: ^( ALTERNATIVE first_alternative ( concatenation )+ )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:104:1: first_alternative : concatenation ;
    public final RegexParser.first_alternative_return first_alternative() throws RecognitionException {
        RegexParser.first_alternative_return retval = new RegexParser.first_alternative_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.concatenation_return concatenation7 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:105:3: ( concatenation )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:106:3: concatenation
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_concatenation_in_first_alternative258);
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:109:1: concatenation : ( element )* -> ^( CONCATENATION ( element )* ) ;
    public final RegexParser.concatenation_return concatenation() throws RecognitionException {
        RegexParser.concatenation_return retval = new RegexParser.concatenation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.element_return element8 =null;


        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:110:3: ( ( element )* -> ^( CONCATENATION ( element )* ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:111:3: ( element )*
            {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:111:3: ( element )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ALC||LA4_0==AUC||(LA4_0 >= Ampersand && LA4_0 <= BlockQuoted)||LA4_0==CLC||LA4_0==CUC||LA4_0==CarriageReturn||(LA4_0 >= Colon && LA4_0 <= DLC)||LA4_0==DUC||(LA4_0 >= Dot && LA4_0 <= ELC)||(LA4_0 >= EUC && LA4_0 <= GLC)||(LA4_0 >= GUC && LA4_0 <= KUC)||(LA4_0 >= LLC && LA4_0 <= NewLine)||LA4_0==OLC||LA4_0==OUC||(LA4_0 >= OpenBracket && LA4_0 <= Percent)||(LA4_0 >= QLC && LA4_0 <= QUC)||LA4_0==Quoted||(LA4_0 >= RLC && LA4_0 <= Slash)||(LA4_0 >= TLC && LA4_0 <= YUC)||(LA4_0 >= ZLC && LA4_0 <= ZUC)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:111:3: element
            	    {
            	    pushFollow(FOLLOW_element_in_concatenation273);
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
            // 112:5: -> ^( CONCATENATION ( element )* )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:113:7: ^( CONCATENATION ( element )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONCATENATION, "CONCATENATION")
                , root_1);

                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:113:23: ( element )*
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:116:1: element : ( atom '+' -> ^( ONEORMORE atom ) | atom '*' -> ^( ZEROORMORE atom ) | atom '?' -> ^( OPTIONAL atom ) | atom -> ^( ELEMENT atom ) );
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:117:3: ( atom '+' -> ^( ONEORMORE atom ) | atom '*' -> ^( ZEROORMORE atom ) | atom '?' -> ^( OPTIONAL atom ) | atom -> ^( ELEMENT atom ) )
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
            case Ampersand:
            case At:
            case Backslash:
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
            case Percent:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
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
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
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
            case Quoted:
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
            case BlockQuoted:
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
            case OpenParen:
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
            case Dot:
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
            case OpenBracket:
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:118:3: atom '+'
                    {
                    pushFollow(FOLLOW_atom_in_element308);
                    atom9=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom9.getTree());

                    char_literal10=(Token)match(input,Plus,FOLLOW_Plus_in_element310); if (state.failed) return retval; 
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
                    // 119:5: -> ^( ONEORMORE atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:120:7: ^( ONEORMORE atom )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:121:5: atom '*'
                    {
                    pushFollow(FOLLOW_atom_in_element334);
                    atom11=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom11.getTree());

                    char_literal12=(Token)match(input,Star,FOLLOW_Star_in_element336); if (state.failed) return retval; 
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
                    // 122:5: -> ^( ZEROORMORE atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:123:7: ^( ZEROORMORE atom )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:124:5: atom '?'
                    {
                    pushFollow(FOLLOW_atom_in_element360);
                    atom13=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom13.getTree());

                    char_literal14=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_element362); if (state.failed) return retval; 
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
                    // 125:5: -> ^( OPTIONAL atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:126:7: ^( OPTIONAL atom )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:127:5: atom
                    {
                    pushFollow(FOLLOW_atom_in_element386);
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
                    // 128:5: -> ^( ELEMENT atom )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:129:7: ^( ELEMENT atom )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:132:1: quantifier : ( '+' -> ^( ONEORMORE ) | '*' -> ^( ZEROORMORE ) );
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:133:3: ( '+' -> ^( ONEORMORE ) | '*' -> ^( ZEROORMORE ) )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:134:3: '+'
                    {
                    char_literal16=(Token)match(input,Plus,FOLLOW_Plus_in_quantifier419); if (state.failed) return retval; 
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
                    // 135:5: -> ^( ONEORMORE )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:136:7: ^( ONEORMORE )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:137:5: '*'
                    {
                    char_literal17=(Token)match(input,Star,FOLLOW_Star_in_quantifier441); if (state.failed) return retval; 
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
                    // 138:5: -> ^( ZEROORMORE )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:139:7: ^( ZEROORMORE )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:142:1: group : '(' regex ')' -> ^( GROUP regex ) ;
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:143:3: ( '(' regex ')' -> ^( GROUP regex ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:144:3: '(' regex ')'
            {
            char_literal18=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_group472); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OpenParen.add(char_literal18);


            pushFollow(FOLLOW_regex_in_group474);
            regex19=regex();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_regex.add(regex19.getTree());

            char_literal20=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_group476); if (state.failed) return retval; 
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
            // 145:5: -> ^( GROUP regex )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:146:7: ^( GROUP regex )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:149:1: atom : ( literal | group | dotany | character_class );
    public final RegexParser.atom_return atom() throws RecognitionException {
        RegexParser.atom_return retval = new RegexParser.atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.literal_return literal21 =null;

        RegexParser.group_return group22 =null;

        RegexParser.dotany_return dotany23 =null;

        RegexParser.character_class_return character_class24 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:150:3: ( literal | group | dotany | character_class )
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
            case Percent:
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:151:3: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom509);
                    literal21=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal21.getTree());

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:152:5: group
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_group_in_atom515);
                    group22=group();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, group22.getTree());

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:153:5: dotany
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dotany_in_atom521);
                    dotany23=dotany();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dotany23.getTree());

                    }
                    break;
                case 4 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:154:5: character_class
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_character_class_in_atom527);
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:157:1: dotany : Dot -> ^( DOTANY ) ;
    public final RegexParser.dotany_return dotany() throws RecognitionException {
        RegexParser.dotany_return retval = new RegexParser.dotany_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Dot25=null;

        Object Dot25_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:158:3: ( Dot -> ^( DOTANY ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:159:3: Dot
            {
            Dot25=(Token)match(input,Dot,FOLLOW_Dot_in_dotany542); if (state.failed) return retval; 
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
            // 160:5: -> ^( DOTANY )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:161:7: ^( DOTANY )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:169:1: character_class : OpenBracket ( cc_atom )+ CloseBracket -> ^( CHARACTER_CLASS ( cc_atom )+ ) ;
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:170:3: ( OpenBracket ( cc_atom )+ CloseBracket -> ^( CHARACTER_CLASS ( cc_atom )+ ) )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:171:3: OpenBracket ( cc_atom )+ CloseBracket
            {
            OpenBracket26=(Token)match(input,OpenBracket,FOLLOW_OpenBracket_in_character_class578); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OpenBracket.add(OpenBracket26);


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:171:15: ( cc_atom )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ALC||LA8_0==AUC||(LA8_0 >= Ampersand && LA8_0 <= BlockQuoted)||LA8_0==CLC||LA8_0==CUC||LA8_0==CarriageReturn||(LA8_0 >= Colon && LA8_0 <= DLC)||LA8_0==DUC||(LA8_0 >= DoubleQuote && LA8_0 <= ELC)||(LA8_0 >= EUC && LA8_0 <= GLC)||(LA8_0 >= GUC && LA8_0 <= KUC)||(LA8_0 >= LLC && LA8_0 <= NewLine)||LA8_0==OLC||LA8_0==OUC||(LA8_0 >= PLC && LA8_0 <= Percent)||(LA8_0 >= QLC && LA8_0 <= QUC)||LA8_0==Quoted||(LA8_0 >= RLC && LA8_0 <= Slash)||(LA8_0 >= TLC && LA8_0 <= YUC)||(LA8_0 >= ZLC && LA8_0 <= ZUC)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:171:15: cc_atom
            	    {
            	    pushFollow(FOLLOW_cc_atom_in_character_class580);
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


            CloseBracket28=(Token)match(input,CloseBracket,FOLLOW_CloseBracket_in_character_class583); if (state.failed) return retval; 
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
            // 172:5: -> ^( CHARACTER_CLASS ( cc_atom )+ )
            {
                // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:173:7: ^( CHARACTER_CLASS ( cc_atom )+ )
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:176:1: cc_atom : ( literal Hyphen literal -> ^( RANGE literal literal ) | literal );
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
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:177:3: ( literal Hyphen literal -> ^( RANGE literal literal ) | literal )
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
                        int LA9_9 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 9, input);

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
                        int LA9_10 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                        int LA9_11 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
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
                    case Quoted:
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
                    case BlockQuoted:
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
                    case Ampersand:
                    case At:
                    case Backslash:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Percent:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
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
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_1==EOF||LA9_1==ALC||LA9_1==AUC||(LA9_1 >= Ampersand && LA9_1 <= BlockQuoted)||LA9_1==CLC||LA9_1==CUC||LA9_1==CarriageReturn||LA9_1==CloseBracket||(LA9_1 >= Colon && LA9_1 <= DLC)||LA9_1==DUC||(LA9_1 >= DoubleQuote && LA9_1 <= ELC)||(LA9_1 >= EUC && LA9_1 <= GLC)||(LA9_1 >= GUC && LA9_1 <= Hash)||(LA9_1 >= ILC && LA9_1 <= KUC)||(LA9_1 >= LLC && LA9_1 <= NewLine)||LA9_1==OLC||LA9_1==OUC||(LA9_1 >= PLC && LA9_1 <= Percent)||(LA9_1 >= QLC && LA9_1 <= QUC)||LA9_1==Quoted||(LA9_1 >= RLC && LA9_1 <= Slash)||(LA9_1 >= TLC && LA9_1 <= YUC)||(LA9_1 >= ZLC && LA9_1 <= ZUC)) ) {
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
                        int LA9_9 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 9, input);

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
                        int LA9_10 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                        int LA9_11 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
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
                    case Quoted:
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
                    case BlockQuoted:
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
                    case Ampersand:
                    case At:
                    case Backslash:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Percent:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
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
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_2==EOF||LA9_2==ALC||LA9_2==AUC||(LA9_2 >= Ampersand && LA9_2 <= BlockQuoted)||LA9_2==CLC||LA9_2==CUC||LA9_2==CarriageReturn||LA9_2==CloseBracket||(LA9_2 >= Colon && LA9_2 <= DLC)||LA9_2==DUC||(LA9_2 >= DoubleQuote && LA9_2 <= ELC)||(LA9_2 >= EUC && LA9_2 <= GLC)||(LA9_2 >= GUC && LA9_2 <= Hash)||(LA9_2 >= ILC && LA9_2 <= KUC)||(LA9_2 >= LLC && LA9_2 <= NewLine)||LA9_2==OLC||LA9_2==OUC||(LA9_2 >= PLC && LA9_2 <= Percent)||(LA9_2 >= QLC && LA9_2 <= QUC)||LA9_2==Quoted||(LA9_2 >= RLC && LA9_2 <= Slash)||(LA9_2 >= TLC && LA9_2 <= YUC)||(LA9_2 >= ZLC && LA9_2 <= ZUC)) ) {
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
            case Ampersand:
            case At:
            case Backslash:
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
            case Percent:
            case Semicolon:
            case SingleQuote:
            case Slash:
            case Tilde:
            case Underscore:
                {
                int LA9_3 = input.LA(2);

                if ( (LA9_3==Hyphen) ) {
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
                        int LA9_9 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 9, input);

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
                        int LA9_10 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                        int LA9_11 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
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
                    case Quoted:
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
                    case BlockQuoted:
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
                    case Ampersand:
                    case At:
                    case Backslash:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Percent:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
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
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_3==EOF||LA9_3==ALC||LA9_3==AUC||(LA9_3 >= Ampersand && LA9_3 <= BlockQuoted)||LA9_3==CLC||LA9_3==CUC||LA9_3==CarriageReturn||LA9_3==CloseBracket||(LA9_3 >= Colon && LA9_3 <= DLC)||LA9_3==DUC||(LA9_3 >= DoubleQuote && LA9_3 <= ELC)||(LA9_3 >= EUC && LA9_3 <= GLC)||(LA9_3 >= GUC && LA9_3 <= Hash)||(LA9_3 >= ILC && LA9_3 <= KUC)||(LA9_3 >= LLC && LA9_3 <= NewLine)||LA9_3==OLC||LA9_3==OUC||(LA9_3 >= PLC && LA9_3 <= Percent)||(LA9_3 >= QLC && LA9_3 <= QUC)||LA9_3==Quoted||(LA9_3 >= RLC && LA9_3 <= Slash)||(LA9_3 >= TLC && LA9_3 <= YUC)||(LA9_3 >= ZLC && LA9_3 <= ZUC)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;

                }
                }
                break;
            case CarriageReturn:
            case NewLine:
            case Tab:
            case WHITESPACE:
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
                        int LA9_9 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 9, input);

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
                        int LA9_10 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                        int LA9_11 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
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
                    case Quoted:
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
                    case BlockQuoted:
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
                    case Ampersand:
                    case At:
                    case Backslash:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Percent:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
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
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_4==EOF||LA9_4==ALC||LA9_4==AUC||(LA9_4 >= Ampersand && LA9_4 <= BlockQuoted)||LA9_4==CLC||LA9_4==CUC||LA9_4==CarriageReturn||LA9_4==CloseBracket||(LA9_4 >= Colon && LA9_4 <= DLC)||LA9_4==DUC||(LA9_4 >= DoubleQuote && LA9_4 <= ELC)||(LA9_4 >= EUC && LA9_4 <= GLC)||(LA9_4 >= GUC && LA9_4 <= Hash)||(LA9_4 >= ILC && LA9_4 <= KUC)||(LA9_4 >= LLC && LA9_4 <= NewLine)||LA9_4==OLC||LA9_4==OUC||(LA9_4 >= PLC && LA9_4 <= Percent)||(LA9_4 >= QLC && LA9_4 <= QUC)||LA9_4==Quoted||(LA9_4 >= RLC && LA9_4 <= Slash)||(LA9_4 >= TLC && LA9_4 <= YUC)||(LA9_4 >= ZLC && LA9_4 <= ZUC)) ) {
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
            case Quoted:
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
                        int LA9_9 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 9, input);

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
                        int LA9_10 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                        int LA9_11 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
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
                    case Quoted:
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
                    case BlockQuoted:
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
                    case Ampersand:
                    case At:
                    case Backslash:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Percent:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
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
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_5==EOF||LA9_5==ALC||LA9_5==AUC||(LA9_5 >= Ampersand && LA9_5 <= BlockQuoted)||LA9_5==CLC||LA9_5==CUC||LA9_5==CarriageReturn||LA9_5==CloseBracket||(LA9_5 >= Colon && LA9_5 <= DLC)||LA9_5==DUC||(LA9_5 >= DoubleQuote && LA9_5 <= ELC)||(LA9_5 >= EUC && LA9_5 <= GLC)||(LA9_5 >= GUC && LA9_5 <= Hash)||(LA9_5 >= ILC && LA9_5 <= KUC)||(LA9_5 >= LLC && LA9_5 <= NewLine)||LA9_5==OLC||LA9_5==OUC||(LA9_5 >= PLC && LA9_5 <= Percent)||(LA9_5 >= QLC && LA9_5 <= QUC)||LA9_5==Quoted||(LA9_5 >= RLC && LA9_5 <= Slash)||(LA9_5 >= TLC && LA9_5 <= YUC)||(LA9_5 >= ZLC && LA9_5 <= ZUC)) ) {
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
            case BlockQuoted:
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
                        int LA9_9 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 9, input);

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
                        int LA9_10 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                        int LA9_11 = input.LA(4);

                        if ( (synpred13_Regex()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
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
                    case CarriageReturn:
                    case NewLine:
                    case Tab:
                    case WHITESPACE:
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
                    case Quoted:
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
                    case BlockQuoted:
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
                    case Ampersand:
                    case At:
                    case Backslash:
                    case Colon:
                    case Comma:
                    case DoubleQuote:
                    case Equals:
                    case Exclamation:
                    case GraveAccent:
                    case GreaterThan:
                    case Hash:
                    case LessThan:
                    case Percent:
                    case Semicolon:
                    case SingleQuote:
                    case Slash:
                    case Tilde:
                    case Underscore:
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
                    case CloseBracket:
                        {
                        alt9=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                }
                else if ( (LA9_6==EOF||LA9_6==ALC||LA9_6==AUC||(LA9_6 >= Ampersand && LA9_6 <= BlockQuoted)||LA9_6==CLC||LA9_6==CUC||LA9_6==CarriageReturn||LA9_6==CloseBracket||(LA9_6 >= Colon && LA9_6 <= DLC)||LA9_6==DUC||(LA9_6 >= DoubleQuote && LA9_6 <= ELC)||(LA9_6 >= EUC && LA9_6 <= GLC)||(LA9_6 >= GUC && LA9_6 <= Hash)||(LA9_6 >= ILC && LA9_6 <= KUC)||(LA9_6 >= LLC && LA9_6 <= NewLine)||LA9_6==OLC||LA9_6==OUC||(LA9_6 >= PLC && LA9_6 <= Percent)||(LA9_6 >= QLC && LA9_6 <= QUC)||LA9_6==Quoted||(LA9_6 >= RLC && LA9_6 <= Slash)||(LA9_6 >= TLC && LA9_6 <= YUC)||(LA9_6 >= ZLC && LA9_6 <= ZUC)) ) {
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:178:3: literal Hyphen literal
                    {
                    pushFollow(FOLLOW_literal_in_cc_atom617);
                    literal29=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal29.getTree());

                    Hyphen30=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_cc_atom619); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen30);


                    pushFollow(FOLLOW_literal_in_cc_atom621);
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
                    // 179:5: -> ^( RANGE literal literal )
                    {
                        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:180:7: ^( RANGE literal literal )
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:181:5: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_cc_atom647);
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:189:1: subject_boundary : ( '^' regex -> regex | regex '$' EOF -> regex | '^' regex '$' EOF -> regex );
    public final RegexParser.subject_boundary_return subject_boundary() throws RecognitionException {
        RegexParser.subject_boundary_return retval = new RegexParser.subject_boundary_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal33=null;
        Token char_literal36=null;
        Token EOF37=null;
        Token char_literal38=null;
        Token char_literal40=null;
        Token EOF41=null;
        RegexParser.regex_return regex34 =null;

        RegexParser.regex_return regex35 =null;

        RegexParser.regex_return regex39 =null;


        Object char_literal33_tree=null;
        Object char_literal36_tree=null;
        Object EOF37_tree=null;
        Object char_literal38_tree=null;
        Object char_literal40_tree=null;
        Object EOF41_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_Dollar=new RewriteRuleTokenStream(adaptor,"token Dollar");
        RewriteRuleTokenStream stream_Caret=new RewriteRuleTokenStream(adaptor,"token Caret");
        RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:190:3: ( '^' regex -> regex | regex '$' EOF -> regex | '^' regex '$' EOF -> regex )
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
            else if ( (LA10_0==ALC||LA10_0==AUC||(LA10_0 >= Ampersand && LA10_0 <= BlockQuoted)||LA10_0==CLC||LA10_0==CUC||LA10_0==CarriageReturn||(LA10_0 >= Colon && LA10_0 <= DLC)||(LA10_0 >= DUC && LA10_0 <= ELC)||(LA10_0 >= EUC && LA10_0 <= GLC)||(LA10_0 >= GUC && LA10_0 <= KUC)||(LA10_0 >= LLC && LA10_0 <= NewLine)||LA10_0==OLC||LA10_0==OUC||(LA10_0 >= OpenBracket && LA10_0 <= Pipe)||(LA10_0 >= QLC && LA10_0 <= QUC)||LA10_0==Quoted||(LA10_0 >= RLC && LA10_0 <= Slash)||(LA10_0 >= TLC && LA10_0 <= YUC)||(LA10_0 >= ZLC && LA10_0 <= ZUC)) ) {
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:191:3: '^' regex
                    {
                    char_literal33=(Token)match(input,Caret,FOLLOW_Caret_in_subject_boundary667); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Caret.add(char_literal33);


                    pushFollow(FOLLOW_regex_in_subject_boundary669);
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
                    // 192:5: -> regex
                    {
                        adaptor.addChild(root_0, stream_regex.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:193:5: regex '$' EOF
                    {
                    pushFollow(FOLLOW_regex_in_subject_boundary683);
                    regex35=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex35.getTree());

                    char_literal36=(Token)match(input,Dollar,FOLLOW_Dollar_in_subject_boundary685); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Dollar.add(char_literal36);


                    EOF37=(Token)match(input,EOF,FOLLOW_EOF_in_subject_boundary687); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EOF.add(EOF37);


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
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:195:5: '^' regex '$' EOF
                    {
                    char_literal38=(Token)match(input,Caret,FOLLOW_Caret_in_subject_boundary701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Caret.add(char_literal38);


                    pushFollow(FOLLOW_regex_in_subject_boundary703);
                    regex39=regex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regex.add(regex39.getTree());

                    char_literal40=(Token)match(input,Dollar,FOLLOW_Dollar_in_subject_boundary705); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Dollar.add(char_literal40);


                    EOF41=(Token)match(input,EOF,FOLLOW_EOF_in_subject_boundary707); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EOF.add(EOF41);


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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:200:1: literal : ( letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] | other_chars -> LITERAL[$other_chars.text] | whitespace -> LITERAL[$whitespace.text] | Quoted -> LITERAL[$Quoted.text] | BlockQuoted -> LITERAL[$BlockQuoted.text] );
    public final RegexParser.literal_return literal() throws RecognitionException {
        RegexParser.literal_return retval = new RegexParser.literal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token Quoted46=null;
        Token BlockQuoted47=null;
        RegexParser.letter_return letter42 =null;

        RegexParser.digit_return digit43 =null;

        RegexParser.other_chars_return other_chars44 =null;

        RegexParser.whitespace_return whitespace45 =null;


        Object Quoted46_tree=null;
        Object BlockQuoted47_tree=null;
        RewriteRuleTokenStream stream_Quoted=new RewriteRuleTokenStream(adaptor,"token Quoted");
        RewriteRuleTokenStream stream_BlockQuoted=new RewriteRuleTokenStream(adaptor,"token BlockQuoted");
        RewriteRuleSubtreeStream stream_digit=new RewriteRuleSubtreeStream(adaptor,"rule digit");
        RewriteRuleSubtreeStream stream_letter=new RewriteRuleSubtreeStream(adaptor,"rule letter");
        RewriteRuleSubtreeStream stream_other_chars=new RewriteRuleSubtreeStream(adaptor,"rule other_chars");
        RewriteRuleSubtreeStream stream_whitespace=new RewriteRuleSubtreeStream(adaptor,"rule whitespace");
        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:201:3: ( letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] | other_chars -> LITERAL[$other_chars.text] | whitespace -> LITERAL[$whitespace.text] | Quoted -> LITERAL[$Quoted.text] | BlockQuoted -> LITERAL[$BlockQuoted.text] )
            int alt11=6;
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
            case Ampersand:
            case At:
            case Backslash:
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
            case Percent:
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
                alt11=4;
                }
                break;
            case Quoted:
                {
                alt11=5;
                }
                break;
            case BlockQuoted:
                {
                alt11=6;
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
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:202:3: letter
                    {
                    pushFollow(FOLLOW_letter_in_literal731);
                    letter42=letter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_letter.add(letter42.getTree());

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
                    // 203:5: -> LITERAL[$letter.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (letter42!=null?input.toString(letter42.start,letter42.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:204:5: digit
                    {
                    pushFollow(FOLLOW_digit_in_literal746);
                    digit43=digit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_digit.add(digit43.getTree());

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
                    // 205:5: -> LITERAL[$digit.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (digit43!=null?input.toString(digit43.start,digit43.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:206:5: other_chars
                    {
                    pushFollow(FOLLOW_other_chars_in_literal761);
                    other_chars44=other_chars();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_other_chars.add(other_chars44.getTree());

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
                    // 207:5: -> LITERAL[$other_chars.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (other_chars44!=null?input.toString(other_chars44.start,other_chars44.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:208:5: whitespace
                    {
                    pushFollow(FOLLOW_whitespace_in_literal776);
                    whitespace45=whitespace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_whitespace.add(whitespace45.getTree());

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
                    // 209:5: -> LITERAL[$whitespace.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (whitespace45!=null?input.toString(whitespace45.start,whitespace45.stop):null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:210:5: Quoted
                    {
                    Quoted46=(Token)match(input,Quoted,FOLLOW_Quoted_in_literal791); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Quoted.add(Quoted46);


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
                    // 211:5: -> LITERAL[$Quoted.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (Quoted46!=null?Quoted46.getText():null))
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:212:5: BlockQuoted
                    {
                    BlockQuoted47=(Token)match(input,BlockQuoted,FOLLOW_BlockQuoted_in_literal806); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BlockQuoted.add(BlockQuoted47);


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
                    // 213:5: -> LITERAL[$BlockQuoted.text]
                    {
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(LITERAL, (BlockQuoted47!=null?BlockQuoted47.getText():null))
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:216:1: whitespace : ( WHITESPACE | Tab | NewLine | CarriageReturn );
    public final RegexParser.whitespace_return whitespace() throws RecognitionException {
        RegexParser.whitespace_return retval = new RegexParser.whitespace_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set48=null;

        Object set48_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:217:3: ( WHITESPACE | Tab | NewLine | CarriageReturn )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set48=(Token)input.LT(1);

            if ( input.LA(1)==CarriageReturn||input.LA(1)==NewLine||input.LA(1)==Tab||input.LA(1)==WHITESPACE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set48)
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


    public static class digit_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "digit"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:224:1: digit : ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 );
    public final RegexParser.digit_return digit() throws RecognitionException {
        RegexParser.digit_return retval = new RegexParser.digit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set49=null;

        Object set49_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:225:3: ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set49=(Token)input.LT(1);

            if ( (input.LA(1) >= D0 && input.LA(1) <= D9) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set49)
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


    public static class non_close_parens_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "non_close_parens"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:238:1: non_close_parens : ( non_close_paren )+ ;
    public final RegexParser.non_close_parens_return non_close_parens() throws RecognitionException {
        RegexParser.non_close_parens_return retval = new RegexParser.non_close_parens_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        RegexParser.non_close_paren_return non_close_paren50 =null;



        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:239:3: ( ( non_close_paren )+ )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:240:3: ( non_close_paren )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:240:3: ( non_close_paren )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= ALC && LA12_0 <= CloseBracket)||(LA12_0 >= Colon && LA12_0 <= ZUC)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:240:3: non_close_paren
            	    {
            	    pushFollow(FOLLOW_non_close_paren_in_non_close_parens932);
            	    non_close_paren50=non_close_paren();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, non_close_paren50.getTree());

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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:243:1: non_close_paren : ~ CloseParen ;
    public final RegexParser.non_close_paren_return non_close_paren() throws RecognitionException {
        RegexParser.non_close_paren_return retval = new RegexParser.non_close_paren_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set51=null;

        Object set51_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:244:3: (~ CloseParen )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set51=(Token)input.LT(1);

            if ( (input.LA(1) >= ALC && input.LA(1) <= CloseBracket)||(input.LA(1) >= Colon && input.LA(1) <= ZUC) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set51)
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
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:248:1: letter : ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC );
    public final RegexParser.letter_return letter() throws RecognitionException {
        RegexParser.letter_return retval = new RegexParser.letter_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set52=null;

        Object set52_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:249:3: ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set52=(Token)input.LT(1);

            if ( input.LA(1)==ALC||input.LA(1)==AUC||(input.LA(1) >= BLC && input.LA(1) <= BUC)||input.LA(1)==CLC||input.LA(1)==CUC||input.LA(1)==DLC||input.LA(1)==DUC||input.LA(1)==ELC||input.LA(1)==EUC||(input.LA(1) >= FLC && input.LA(1) <= GLC)||input.LA(1)==GUC||(input.LA(1) >= HLC && input.LA(1) <= HUC)||(input.LA(1) >= ILC && input.LA(1) <= KUC)||(input.LA(1) >= LLC && input.LA(1) <= LUC)||(input.LA(1) >= MLC && input.LA(1) <= NUC)||input.LA(1)==OLC||input.LA(1)==OUC||(input.LA(1) >= PLC && input.LA(1) <= PUC)||(input.LA(1) >= QLC && input.LA(1) <= QUC)||(input.LA(1) >= RLC && input.LA(1) <= SUC)||(input.LA(1) >= TLC && input.LA(1) <= TUC)||(input.LA(1) >= ULC && input.LA(1) <= UUC)||(input.LA(1) >= VLC && input.LA(1) <= VUC)||(input.LA(1) >= WLC && input.LA(1) <= YUC)||(input.LA(1) >= ZLC && input.LA(1) <= ZUC) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set52)
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


    public static class other_chars_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "other_chars"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:304:1: other_chars : ( Exclamation | DoubleQuote | Hash | Percent | Ampersand | SingleQuote | Comma | Hyphen | Slash | Colon | Semicolon | LessThan | Equals | GreaterThan | At | Backslash | Underscore | GraveAccent | Tilde );
    public final RegexParser.other_chars_return other_chars() throws RecognitionException {
        RegexParser.other_chars_return retval = new RegexParser.other_chars_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set53=null;

        Object set53_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:305:3: ( Exclamation | DoubleQuote | Hash | Percent | Ampersand | SingleQuote | Comma | Hyphen | Slash | Colon | Semicolon | LessThan | Equals | GreaterThan | At | Backslash | Underscore | GraveAccent | Tilde )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set53=(Token)input.LT(1);

            if ( (input.LA(1) >= Ampersand && input.LA(1) <= At)||input.LA(1)==Backslash||(input.LA(1) >= Colon && input.LA(1) <= Comma)||input.LA(1)==DoubleQuote||(input.LA(1) >= Equals && input.LA(1) <= Exclamation)||(input.LA(1) >= GraveAccent && input.LA(1) <= GreaterThan)||(input.LA(1) >= Hash && input.LA(1) <= Hyphen)||input.LA(1)==LessThan||input.LA(1)==Percent||(input.LA(1) >= Semicolon && input.LA(1) <= Slash)||input.LA(1)==Tilde||input.LA(1)==Underscore ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set53)
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
    // $ANTLR end "other_chars"


    public static class special_chars_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "special_chars"
    // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:327:1: special_chars : ( Dollar | OpenParen | CloseParen | Star | Plus | Dot | QuestionMark | OpenBracket | CloseBracket | Caret | OpenBrace | Pipe | CloseBrace );
    public final RegexParser.special_chars_return special_chars() throws RecognitionException {
        RegexParser.special_chars_return retval = new RegexParser.special_chars_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set54=null;

        Object set54_tree=null;

        try {
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:328:3: ( Dollar | OpenParen | CloseParen | Star | Plus | Dot | QuestionMark | OpenBracket | CloseBracket | Caret | OpenBrace | Pipe | CloseBrace )
            // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:
            {
            root_0 = (Object)adaptor.nil();


            set54=(Token)input.LT(1);

            if ( input.LA(1)==Caret||(input.LA(1) >= CloseBrace && input.LA(1) <= CloseParen)||(input.LA(1) >= Dollar && input.LA(1) <= Dot)||(input.LA(1) >= OpenBrace && input.LA(1) <= OpenParen)||(input.LA(1) >= Pipe && input.LA(1) <= Plus)||input.LA(1)==QuestionMark||input.LA(1)==Star ) {
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
    // $ANTLR end "special_chars"

    // $ANTLR start synpred1_Regex
    public final void synpred1_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:84:3: ( regex EOF )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:84:3: regex EOF
        {
        pushFollow(FOLLOW_regex_in_synpred1_Regex151);
        regex();

        state._fsp--;
        if (state.failed) return ;

        match(input,EOF,FOLLOW_EOF_in_synpred1_Regex153); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Regex

    // $ANTLR start synpred5_Regex
    public final void synpred5_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:118:3: ( atom '+' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:118:3: atom '+'
        {
        pushFollow(FOLLOW_atom_in_synpred5_Regex308);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,Plus,FOLLOW_Plus_in_synpred5_Regex310); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Regex

    // $ANTLR start synpred6_Regex
    public final void synpred6_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:121:5: ( atom '*' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:121:5: atom '*'
        {
        pushFollow(FOLLOW_atom_in_synpred6_Regex334);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,Star,FOLLOW_Star_in_synpred6_Regex336); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Regex

    // $ANTLR start synpred7_Regex
    public final void synpred7_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:124:5: ( atom '?' )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:124:5: atom '?'
        {
        pushFollow(FOLLOW_atom_in_synpred7_Regex360);
        atom();

        state._fsp--;
        if (state.failed) return ;

        match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred7_Regex362); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Regex

    // $ANTLR start synpred13_Regex
    public final void synpred13_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:178:3: ( literal Hyphen literal )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:178:3: literal Hyphen literal
        {
        pushFollow(FOLLOW_literal_in_synpred13_Regex617);
        literal();

        state._fsp--;
        if (state.failed) return ;

        match(input,Hyphen,FOLLOW_Hyphen_in_synpred13_Regex619); if (state.failed) return ;

        pushFollow(FOLLOW_literal_in_synpred13_Regex621);
        literal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred13_Regex

    // $ANTLR start synpred14_Regex
    public final void synpred14_Regex_fragment() throws RecognitionException {
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:191:3: ( '^' regex )
        // /home/abrandl/Dropbox/ma-thesis/workspace/lucene.regex/src/main/java/de/abrandl/regex/grammar/Regex.g:191:3: '^' regex
        {
        match(input,Caret,FOLLOW_Caret_in_synpred14_Regex667); if (state.failed) return ;

        pushFollow(FOLLOW_regex_in_synpred14_Regex669);
        regex();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred14_Regex

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


 

    public static final BitSet FOLLOW_regex_in_parse151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subject_boundary_in_parse167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_first_alternative_in_regex187 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_Pipe_in_regex209 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x001BFFFDFD6FD2FFL});
    public static final BitSet FOLLOW_concatenation_in_regex211 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_concatenation_in_first_alternative258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_concatenation273 = new BitSet(new long[]{0x7FFDFBAFFF8ABF52L,0x001BFFFDFD67D2FFL});
    public static final BitSet FOLLOW_atom_in_element308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Plus_in_element310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element334 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_Star_in_element336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_QuestionMark_in_element362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_quantifier419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_quantifier441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OpenParen_in_group472 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x001BFFFDFD67D2FFL});
    public static final BitSet FOLLOW_regex_in_group474 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CloseParen_in_group476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_atom515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotany_in_atom521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_character_class_in_atom527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_dotany542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OpenBracket_in_character_class578 = new BitSet(new long[]{0x7FFDFB2FFF8ABF50L,0x001BFFFDFD6712FFL});
    public static final BitSet FOLLOW_cc_atom_in_character_class580 = new BitSet(new long[]{0x7FFDFB2FFFAABF50L,0x001BFFFDFD6712FFL});
    public static final BitSet FOLLOW_CloseBracket_in_character_class583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_cc_atom617 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_Hyphen_in_cc_atom619 = new BitSet(new long[]{0x7FFDFB2FFF8ABF50L,0x001BFFFDFD6712FFL});
    public static final BitSet FOLLOW_literal_in_cc_atom621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_cc_atom647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Caret_in_subject_boundary667 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x001BFFFDFD67D2FFL});
    public static final BitSet FOLLOW_regex_in_subject_boundary669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regex_in_subject_boundary683 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_Dollar_in_subject_boundary685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_subject_boundary687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Caret_in_subject_boundary701 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x001BFFFDFD67D2FFL});
    public static final BitSet FOLLOW_regex_in_subject_boundary703 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_Dollar_in_subject_boundary705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_subject_boundary707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letter_in_literal731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_digit_in_literal746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_other_chars_in_literal761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespace_in_literal776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quoted_in_literal791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlockQuoted_in_literal806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_non_close_paren_in_non_close_parens932 = new BitSet(new long[]{0xFFFFFFFFFFBFFFF2L,0x001FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_regex_in_synpred1_Regex151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_synpred1_Regex153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred5_Regex308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Plus_in_synpred5_Regex310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred6_Regex334 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_Star_in_synpred6_Regex336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred7_Regex360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_QuestionMark_in_synpred7_Regex362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_synpred13_Regex617 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_Hyphen_in_synpred13_Regex619 = new BitSet(new long[]{0x7FFDFB2FFF8ABF50L,0x001BFFFDFD6712FFL});
    public static final BitSet FOLLOW_literal_in_synpred13_Regex621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Caret_in_synpred14_Regex667 = new BitSet(new long[]{0x7FFDFBAFFF8ABF50L,0x001BFFFDFD67D2FFL});
    public static final BitSet FOLLOW_regex_in_synpred14_Regex669 = new BitSet(new long[]{0x0000000000000002L});

}