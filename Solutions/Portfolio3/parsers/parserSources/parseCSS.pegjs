start
	= start:(ws* block ws*)+ {return "\nSTART:\n"+start.join('')+"\n";}

selector
	= sel:((tagSelector / classSelector / idSelector) ws* )+ {return "" + sel.join('')+"";}

block
	= blck:(selector ws* openBracket ws* (ws* attribute ws*)* closeBracket ws*) { return "BLOCK:\n"+blck.join('')+"\n";}

attribute
	= attr:(word ":" ws? (word ws*)+ ";") {return ""+attr.join('')+""; }

tagSelector = ts:(word ws*) {return ""+ts.join('')+"";}
classSelector = cs:("." word ws*) {return ""+cs.join('')+"";}
idSelector = iss:("#" word ws*) {return ""+iss.join('')+"";}

openBracket
	= obr:"{" {return ""+obr+"";}
closeBracket
	= cbr:"}" {return ""+cbr+"";}

word = wrd:(letter)+ {return ""+wrd.join('')+"";}
letter = [a-zA-z0-9\-#.,()]

ws = ws:[ \t\r\n]+ {return ""+ws+"";}
