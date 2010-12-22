grammar JSONPath;

@lexer::header {
package org.jsonunit;
}

@header {
package org.jsonunit;

import java.util.List;
import java.util.ArrayList;
}

@members {
List<JSONPathToken> list = new ArrayList<JSONPathToken>();

public List<JSONPathToken> getTokenList() {
	return list;
}
}

jsonpath
	:	(SEP o=headarray { list.add($o.token); } )* (SEP o=objectkey { list.add($o.token); } | SEP o=objectarray { list.add($o.token); })+;

objectkey returns [JSONPathToken token]
	:	STRING { $token = new JSONPathToken($STRING.text); };

objectarray returns [JSONPathToken token]
	:	STRING '[' NUMBER ']' { $token = new JSONPathToken($STRING.text, Integer.parseInt($NUMBER.text)); };
	
headarray returns[JSONPathToken token]
	:	'[' NUMBER']' { $token = new JSONPathToken("", Integer.parseInt($NUMBER.text)); };

NUMBER
	:	('0' .. '9')+;

fragment UCHAR
	:	~('"'| '\\'|'/'|'['|']');

fragment HEX
	: 	('0' .. '9' | 'A' .. 'F' | 'a' .. 'f');

fragment ESCAPE
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HEX HEX HEX HEX);

STRING
	:	(UCHAR|ESCAPE)+;
	
SEP
	:	'/';
	