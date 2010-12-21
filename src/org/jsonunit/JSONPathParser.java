// $ANTLR 3.3 Nov 30, 2010 12:50:56 JSONPath.g 2010-12-20 10:52:00

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
    // JSONPath.g:22:1: jsonpath : SEP o= objectkey ( SEP o= objectkey | SEP o= objectarray )* ;
    public final void jsonpath() throws RecognitionException {
        JSONPathToken o = null;


        try {
            // JSONPath.g:23:2: ( SEP o= objectkey ( SEP o= objectkey | SEP o= objectarray )* )
            // JSONPath.g:23:4: SEP o= objectkey ( SEP o= objectkey | SEP o= objectarray )*
            {
            match(input,SEP,FOLLOW_SEP_in_jsonpath32); 
            pushFollow(FOLLOW_objectkey_in_jsonpath36);
            o=objectkey();

            state._fsp--;

             list.add(o); 
            // JSONPath.g:23:44: ( SEP o= objectkey | SEP o= objectarray )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SEP) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==STRING) ) {
                        int LA1_3 = input.LA(3);

                        if ( (LA1_3==10) ) {
                            alt1=2;
                        }
                        else if ( (LA1_3==EOF||LA1_3==SEP) ) {
                            alt1=1;
                        }


                    }


                }


                switch (alt1) {
            	case 1 :
            	    // JSONPath.g:23:45: SEP o= objectkey
            	    {
            	    match(input,SEP,FOLLOW_SEP_in_jsonpath41); 
            	    pushFollow(FOLLOW_objectkey_in_jsonpath45);
            	    o=objectkey();

            	    state._fsp--;

            	     list.add(o); 

            	    }
            	    break;
            	case 2 :
            	    // JSONPath.g:23:87: SEP o= objectarray
            	    {
            	    match(input,SEP,FOLLOW_SEP_in_jsonpath51); 
            	    pushFollow(FOLLOW_objectarray_in_jsonpath55);
            	    o=objectarray();

            	    state._fsp--;

            	     list.add(o); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
            STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_objectkey72); 
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
            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_objectarray87); 
            match(input,10,FOLLOW_10_in_objectarray89); 
            NUMBER3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_objectarray91); 
            match(input,11,FOLLOW_11_in_objectarray93); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_SEP_in_jsonpath32 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_objectkey_in_jsonpath36 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_SEP_in_jsonpath41 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_objectkey_in_jsonpath45 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_SEP_in_jsonpath51 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_objectarray_in_jsonpath55 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_objectkey72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_objectarray87 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_objectarray89 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_objectarray91 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_objectarray93 = new BitSet(new long[]{0x0000000000000002L});

}