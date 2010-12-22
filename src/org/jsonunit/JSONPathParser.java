// $ANTLR 3.3 Nov 30, 2010 12:50:56 JSONPath.g 2010-12-22 22:35:41

package org.jsonunit;

import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JSONPathParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEP", "STRING", "NUMBER", "UCHAR", "HEX", "ESCAPE", "'['", "']'"
    };
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


        public JSONPathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public JSONPathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return JSONPathParser.tokenNames; }
    public String getGrammarFileName() { return "JSONPath.g"; }


    List<JSONPathToken> list = new ArrayList<JSONPathToken>();

    public List<JSONPathToken> getTokenList() {
    	return list;
    }



    // $ANTLR start "jsonpath"
    // JSONPath.g:22:1: jsonpath : ( SEP o= headarray )* ( SEP o= objectkey | SEP o= objectarray )+ ;
    public final void jsonpath() throws RecognitionException {
        JSONPathToken o = null;


        try {
            // JSONPath.g:23:2: ( ( SEP o= headarray )* ( SEP o= objectkey | SEP o= objectarray )+ )
            // JSONPath.g:23:4: ( SEP o= headarray )* ( SEP o= objectkey | SEP o= objectarray )+
            {
            // JSONPath.g:23:4: ( SEP o= headarray )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SEP) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==10) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // JSONPath.g:23:5: SEP o= headarray
            	    {
            	    match(input,SEP,FOLLOW_SEP_in_jsonpath33); 
            	    pushFollow(FOLLOW_headarray_in_jsonpath37);
            	    o=headarray();

            	    state._fsp--;

            	     list.add(o); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // JSONPath.g:23:48: ( SEP o= objectkey | SEP o= objectarray )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEP) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==STRING) ) {
                        int LA2_3 = input.LA(3);

                        if ( (LA2_3==10) ) {
                            alt2=2;
                        }
                        else if ( (LA2_3==EOF||LA2_3==SEP) ) {
                            alt2=1;
                        }


                    }


                }


                switch (alt2) {
            	case 1 :
            	    // JSONPath.g:23:49: SEP o= objectkey
            	    {
            	    match(input,SEP,FOLLOW_SEP_in_jsonpath45); 
            	    pushFollow(FOLLOW_objectkey_in_jsonpath49);
            	    o=objectkey();

            	    state._fsp--;

            	     list.add(o); 

            	    }
            	    break;
            	case 2 :
            	    // JSONPath.g:23:91: SEP o= objectarray
            	    {
            	    match(input,SEP,FOLLOW_SEP_in_jsonpath55); 
            	    pushFollow(FOLLOW_objectarray_in_jsonpath59);
            	    o=objectarray();

            	    state._fsp--;

            	     list.add(o); 

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "jsonpath"


    // $ANTLR start "objectkey"
    // JSONPath.g:25:1: objectkey returns [JSONPathToken token] : STRING ;
    public final JSONPathToken objectkey() throws RecognitionException {
        JSONPathToken token = null;

        Token STRING1=null;

        try {
            // JSONPath.g:26:2: ( STRING )
            // JSONPath.g:26:4: STRING
            {
            STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_objectkey76); 
             token = new JSONPathToken((STRING1!=null?STRING1.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return token;
    }
    // $ANTLR end "objectkey"


    // $ANTLR start "objectarray"
    // JSONPath.g:28:1: objectarray returns [JSONPathToken token] : STRING '[' NUMBER ']' ;
    public final JSONPathToken objectarray() throws RecognitionException {
        JSONPathToken token = null;

        Token STRING2=null;
        Token NUMBER3=null;

        try {
            // JSONPath.g:29:2: ( STRING '[' NUMBER ']' )
            // JSONPath.g:29:4: STRING '[' NUMBER ']'
            {
            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_objectarray91); 
            match(input,10,FOLLOW_10_in_objectarray93); 
            NUMBER3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_objectarray95); 
            match(input,11,FOLLOW_11_in_objectarray97); 
             token = new JSONPathToken((STRING2!=null?STRING2.getText():null), Integer.parseInt((NUMBER3!=null?NUMBER3.getText():null))); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return token;
    }
    // $ANTLR end "objectarray"


    // $ANTLR start "headarray"
    // JSONPath.g:31:1: headarray returns [JSONPathToken token] : '[' NUMBER ']' ;
    public final JSONPathToken headarray() throws RecognitionException {
        JSONPathToken token = null;

        Token NUMBER4=null;

        try {
            // JSONPath.g:32:2: ( '[' NUMBER ']' )
            // JSONPath.g:32:4: '[' NUMBER ']'
            {
            match(input,10,FOLLOW_10_in_headarray112); 
            NUMBER4=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_headarray114); 
            match(input,11,FOLLOW_11_in_headarray115); 
             token = new JSONPathToken("", Integer.parseInt((NUMBER4!=null?NUMBER4.getText():null))); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return token;
    }
    // $ANTLR end "headarray"

    // Delegated rules


 

    public static final BitSet FOLLOW_SEP_in_jsonpath33 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_headarray_in_jsonpath37 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEP_in_jsonpath45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_objectkey_in_jsonpath49 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_SEP_in_jsonpath55 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_objectarray_in_jsonpath59 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_objectkey76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_objectarray91 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_objectarray93 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_objectarray95 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_objectarray97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_headarray112 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_headarray114 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_headarray115 = new BitSet(new long[]{0x0000000000000002L});

}