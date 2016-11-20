/**
 * This example parses complex expressions in multiple lines 
 * 
 */
grammar ExprCalc;		

@members {
  long exprVal;
  long v1, v2;
}

// PARSER RULES
start:	(expr {System.out.println("******* ANSWER = "+$expr.value);} NEWLINE)* EOF ;
expr returns [long value]
    @after {
       System.out.println("after: " + $value);
    }
    :	
      a=expr {v1 = $a.value;} '*' b=expr  {$value = $a.value * $b.value;}
    | a=expr {v1 = $a.value;} '/' b=expr  {$value = $a.value / $b.value;}
    | a=expr {v1 = $a.value;} '+' b=expr  {$value = $a.value + $b.value;}
    | a=expr {v1 = $a.value;} '-' b=expr  {$value = $a.value - $b.value;}
    |	INT {$value = Integer.parseInt($INT.text);}
    |	'(' a=expr {$value = $a.value;} ')'
    ;

// LEXER RULES
NEWLINE : ['\r''\n']+ ;
INT     : [0-9]+ ;

