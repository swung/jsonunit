// $ANTLR 3.3 Nov 30, 2010 12:50:56 JSONPath.g 2010-12-22 22:35:41

package org.jsonunit;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JSONPathLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int SEP=4;
    public static final int STRING=5;
    public static final int NUMBER=6;
    public static final int UCHAR=7;
    public static final int HEX=8;
    public static final int ESCAPE=9;

    // delegates
    // delegators

    public JSONPathLexer() {;} 
    public JSONPathLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JSONPathLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "JSONPath.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JSONPath.g:7:7: ( '[' )
            // JSONPath.g:7:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JSONPath.g:8:7: ( ']' )
            // JSONPath.g:8:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JSONPath.g:35:2: ( ( '0' .. '9' )+ )
            // JSONPath.g:35:4: ( '0' .. '9' )+
            {
            // JSONPath.g:35:4: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // JSONPath.g:35:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "UCHAR"
    public final void mUCHAR() throws RecognitionException {
        try {
            // JSONPath.g:38:2: (~ ( '\"' | '\\\\' | '/' | '[' | ']' ) )
            // JSONPath.g:38:4: ~ ( '\"' | '\\\\' | '/' | '[' | ']' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UCHAR"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            // JSONPath.g:41:2: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // JSONPath.g:41:5: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "ESCAPE"
    public final void mESCAPE() throws RecognitionException {
        try {
            // JSONPath.g:44:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HEX HEX HEX HEX ) )
            // JSONPath.g:44:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HEX HEX HEX HEX )
            {
            match('\\'); 
            // JSONPath.g:44:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HEX HEX HEX HEX )
            int alt2=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt2=1;
                }
                break;
            case '\\':
                {
                alt2=2;
                }
                break;
            case '/':
                {
                alt2=3;
                }
                break;
            case 'b':
                {
                alt2=4;
                }
                break;
            case 'f':
                {
                alt2=5;
                }
                break;
            case 'n':
                {
                alt2=6;
                }
                break;
            case 'r':
                {
                alt2=7;
                }
                break;
            case 't':
                {
                alt2=8;
                }
                break;
            case 'u':
                {
                alt2=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // JSONPath.g:44:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // JSONPath.g:44:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // JSONPath.g:44:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // JSONPath.g:44:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // JSONPath.g:44:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // JSONPath.g:44:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // JSONPath.g:44:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // JSONPath.g:44:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // JSONPath.g:44:60: 'u' HEX HEX HEX HEX
                    {
                    match('u'); 
                    mHEX(); 
                    mHEX(); 
                    mHEX(); 
                    mHEX(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "ESCAPE"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JSONPath.g:47:2: ( ( UCHAR | ESCAPE )+ )
            // JSONPath.g:47:4: ( UCHAR | ESCAPE )+
            {
            // JSONPath.g:47:4: ( UCHAR | ESCAPE )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='.')||(LA3_0>='0' && LA3_0<='Z')||(LA3_0>='^' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }
                else if ( (LA3_0=='\\') ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // JSONPath.g:47:5: UCHAR
            	    {
            	    mUCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // JSONPath.g:47:11: ESCAPE
            	    {
            	    mESCAPE(); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "SEP"
    public final void mSEP() throws RecognitionException {
        try {
            int _type = SEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JSONPath.g:50:2: ( '/' )
            // JSONPath.g:50:4: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEP"

    public void mTokens() throws RecognitionException {
        // JSONPath.g:1:8: ( T__10 | T__11 | NUMBER | STRING | SEP )
        int alt4=5;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // JSONPath.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // JSONPath.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // JSONPath.g:1:22: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 4 :
                // JSONPath.g:1:29: STRING
                {
                mSTRING(); 

                }
                break;
            case 5 :
                // JSONPath.g:1:36: SEP
                {
                mSEP(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\3\uffff\1\6\3\uffff";
    static final String DFA4_eofS =
        "\7\uffff";
    static final String DFA4_minS =
        "\1\0\2\uffff\1\0\3\uffff";
    static final String DFA4_maxS =
        "\1\uffff\2\uffff\1\uffff\3\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\3";
    static final String DFA4_specialS =
        "\1\0\2\uffff\1\1\3\uffff}>";
    static final String[] DFA4_transitionS = {
            "\42\4\1\uffff\14\4\1\5\12\3\41\4\1\1\1\4\1\2\uffa2\4",
            "",
            "",
            "\42\4\1\uffff\14\4\1\uffff\12\3\41\4\1\uffff\1\4\1\uffff\uffa2"+
            "\4",
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
            return "1:1: Tokens : ( T__10 | T__11 | NUMBER | STRING | SEP );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='[') ) {s = 1;}

                        else if ( (LA4_0==']') ) {s = 2;}

                        else if ( ((LA4_0>='0' && LA4_0<='9')) ) {s = 3;}

                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='.')||(LA4_0>=':' && LA4_0<='Z')||LA4_0=='\\'||(LA4_0>='^' && LA4_0<='\uFFFF')) ) {s = 4;}

                        else if ( (LA4_0=='/') ) {s = 5;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_3 = input.LA(1);

                        s = -1;
                        if ( ((LA4_3>='0' && LA4_3<='9')) ) {s = 3;}

                        else if ( ((LA4_3>='\u0000' && LA4_3<='!')||(LA4_3>='#' && LA4_3<='.')||(LA4_3>=':' && LA4_3<='Z')||LA4_3=='\\'||(LA4_3>='^' && LA4_3<='\uFFFF')) ) {s = 4;}

                        else s = 6;

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