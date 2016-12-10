lexer grammar L8_XML;

@lexer::members {
	String currentElement = "";
}

fragment NUM: [0-9];
fragment ONEDIG: 		(NUM)?;
fragment TWODIG: 		(NUM NUM)?;
fragment THREEDIG: 		(NUM NUM NUM)?;
fragment FOURDIG: 		(NUM NUM NUM NUM)?;
fragment FIVEDIG: 		(NUM NUM NUM NUM NUM)?;
fragment SIXDIG: 		(NUM NUM NUM NUM NUM NUM)?;
fragment SEVENDIG: 		(NUM NUM NUM NUM NUM NUM NUM)?;
fragment EIGHTDIG: 		(NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment NINEDIG: 		(NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment TENDIG: 		(NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment ELEVENDIG: 	(NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment TWELVEDIG: 	(NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment THIRTEENDIG: 	(NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment FOURTEENDIG: 	(NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;
fragment FIFTEENDIG: 	(NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM NUM)?;

fragment ALPHA: [a-zA-z];
fragment ALPHANUM: [a-zA-Z0-9];
fragment SPECIAL: [-_~!$&'()*+,;=:];
fragment ELEMNAME: ( ALPHA | '_' ) ( ALPHANUM )*;

fragment LOCALPART: ((ALPHANUM | SPECIAL) '.' ( ALPHANUM | SPECIAL ))+ | (ALPHANUM | SPECIAL)+;
fragment DOMAINPART: (ALPHANUM | '-' | '.' )+;
fragment EMAIL: LOCALPART '@' DOMAINPART;

fragment DAY: ( [0-2] [0-9] | '3' [01] );
fragment MONTH: ( '0' [1-9] | '1' [0-2] );
fragment YEAR: ( '20' [0-9] [0-9] | '2100' );
fragment DATE: DAY '/' MONTH '/' YEAR;

fragment PHONEONE: THREEDIG '-' THREEDIG '-' FOURDIG;
fragment PHONETWO: THREEDIG '.' THREEDIG '.' FOURDIG;
fragment PHONETHREE: THREEDIG ' ' THREEDIG ' ' FOURDIG;
fragment PHONEFOUR: '(' THREEDIG ')' THREEDIG '-' FOURDIG;
fragment PHONE: PHONEONE | PHONETWO | PHONETHREE | PHONEFOUR;

fragment VISA: '4' ( TWELVEDIG | FIFTEENDIG );
fragment MASTERCARD: ( '5' [1-5] FOURTEENDIG ) | ( '5' FIFTEENDIG );
fragment AMERICANEXPRESS: '3' [47] THIRTEENDIG;
fragment DINERSCLUB: ( '30' [0-5] ELEVENDIG ) | ( '3' [68] TWELVEDIG );
fragment DISCOVER: ( '6011' TWELVEDIG ) | ( '65' FOURTEENDIG );
fragment JCB: ( ( '2131' | '1800' ) ELEVENDIG ) | ( '35' FOURTEENDIG );
fragment CREDITCARD: VISA | MASTERCARD | AMERICANEXPRESS | DINERSCLUB | DISCOVER | JCB;

EMAILELEMENT: '<EMAIL>' {System.out.println("---Email Tag Found---");}
			( EMAIL {System.out.print("Email: "+getText().substring(7));} 
			| .* {System.out.print("Invalid Email ("+getText().substring(7)+") On Line " + getLine());} )
			 '</EMAIL>' {System.out.print("\n\n");};

DATEELEMENT: '<DATE>' {System.out.println("---Date Tag Found---");}
			( DATE {System.out.print("Date: "+getText().substring(6));}
			| .*? {System.out.print("Invalid Date ("+getText().substring(6)+") On Line " + getLine());} )
			 '</DATE>'  {System.out.print("\n\n");};

PHONEELEMENT: '<PHONE>' {System.out.println("---Phone Tag Found---");}
			( PHONE {System.out.print("Phone: "+getText().substring(7));}
			| .*? {System.out.print("Invalid Phone ("+getText().substring(7)+") On Line " + getLine());} )
			 '</PHONE>' {System.out.print("\n\n");};

CREDITCARDELEMENT: '<CREDITCARD>' {System.out.println("---Credit Card Tag Found---");}
			( CREDITCARD {System.out.print("Credit Card: "+getText().substring(12));}
			| .*? {System.out.print("Invalid Credit Card ("+getText().substring(12)+") On Line " + getLine());} )
			 '</CREDITCARD>' {System.out.print("\n\n");};

OTHERELEMENT: '<' ELEMNAME '>' {currentElement = getText(); System.out.print("---Other Tag Found---\n" + getText().substring(1,getText().length()-1)+": ");}
			(ALPHANUM | SPECIAL | ' ')*? {System.out.print(getText().substring(currentElement.length()));}
			'</' ELEMNAME '>' {System.out.print("\n\n");};

WS: [ \r\t\n]+ {skip();};