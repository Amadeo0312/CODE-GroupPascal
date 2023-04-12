grammar Simple;

// PARSER RULES
program: 'BEGIN CODE' NEWLINE statements+ 'END CODE';

statements: statement+;

statement: (vardec | assign | functionCall) NEWLINE;

vardec: DATATYPE declaratorlist ;

assign: assignList '=' value;

assignList: VARIABLENAME ('=' VARIABLENAME)*;

functionCall: FUNCTIONNAME ': ' (value (',' value)*)?;

declarator: VARIABLENAME | VARIABLENAME '=' value;

declaratorlist: declarator | declarator ',' declaratorlist;

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
	| NEWLINEOP                    #newlineopExpression
    ; 
   
mulDivOp: '*' | '/' | '%'; // Multiplication Division Modulo
addMinOp: '+' | '-'; // Addition Subtraction 
compareOp: '>' | '<' | '>=' | '<=' | '==' | '<>'; 
logicalOp: 'AND' | 'OR' | 'NOT';
concOp: '&';
assignOp: '=';

//LEXER RULES

NEWLINEOP: '$';
DATATYPE: 'BOOL' | 'CHAR' | 'INT' | 'FLOAT';
BOOLVAL: 'TRUE' | 'FALSE';
CHARVAL: '\'' ([a-zA-Z] | [0-9]) '\'';
INTEGERVAL: ('-')? [0-9]+;
FLOATVAL: ('-')? [0-9]+ '.' ('-')? [0-9]+;
STRINGVAL: ('"' ~'"'* '"')
	| ('\'' ~'\''* '\'')
	| ('[' ~']'* ']'+);

WS: [ \t\r]+ -> skip; // Skips whitespaces
NEWLINE: [\r\n]+;
FUNCTIONNAME: 'DISPLAY';
VARIABLENAME: [_a-z][a-zA-Z0-9_]* | [a-z][a-zA-Z0-9_]*;
COMMENT: '#' ~[\r\n]* -> skip;