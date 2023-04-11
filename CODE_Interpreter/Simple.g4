grammar Simple;

//Main Code
program: 'BEGIN CODE' (NEWLINE stmts+ | NEWLINE)* 'END CODE';
//

// one or more statement (stmt | stmt , stmt)
stmts: stmt+;
//

// assign (x = 123), vardec (Int x, y = 123)
stmt: ( assign | vardec | functionCall) NEWLINE+;
//

// assignment ( x = 123 | x = y = 123 )
assign: VARIABLENAME '=' (value | assign);
//

// Int x | Int x, y;
vardec: DATATYPE declaratorlist;
//

//functionCall: VARIABLENAME ': ' STRINGVAL;
functionCall: FUNCTIONNAME '(' (value (',' value)*)? ')';
//

// Int x | Int x, y 
declaratorlist: declarator | declarator ',' declaratorlist;
//

// x | y = 123
declarator: VARIABLENAME | VARIABLENAME '=' value;
//

constant: INTEGERVAL | FLOATVAL | CHARVAL | BOOLVAL | STRINGVAL;  
 
value:
	constant                       #constantExpression
	| VARIABLENAME                 #variablenameExpression
	| functionCall                 #functionCallExpression
	| value compareOp value        #comparisonExpression
	| value logicalOp value        #logicalExpression
	| value mulDivOp value         #multiplicativeExpression
	| value addMinOp value         #additiveExpression
	| value concOp value           #concatenateExpression
	| value assignOp value         #assignExpression
    ; 
mulDivOp: '*' | '/' | '%'; // Multiplication Division Modulo
addMinOp: '+' | '-'; // Addition Subtraction 
compareOp: '>' | '<' | '>=' | '<=' | '==' | '<>'; 
logicalOp: 'AND' | 'OR' | 'NOT';
concOp: '&';
assignOp: '=';

DATATYPE: 'BOOL' | 'INT' | 'CHAR' | 'FLOAT'; 
BOOLVAL: 'TRUE' | 'FALSE';
CHARVAL: '\'' [a-zA-Z] '\'';
INTEGERVAL: ('-')? [1-9]+;
FLOATVAL: ('-')? [1-9]+ '.' ('-')? [0-9]+;
STRINGVAL: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');

WS: [ \t\r]+ -> skip; // Skips whitespaces
NEWLINE: [\r\n]+;
FUNCTIONNAME: 'DISPLAY' | 'SCAN';
VARIABLENAME: [_a-z][a-zA-Z0-9_]* | [a-z][a-zA-Z0-9_]*;
COMMENT: '#' ~[\r\n]* -> skip;