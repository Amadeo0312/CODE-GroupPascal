grammar Simple;

// PARSER RULES
program: (COMMENT | NEWLINE)* BEGIN NEWLINE statements+ END (COMMENT | NEWLINE)*;

statements: statement+;

statement: (vardec | assign | functionCall) NEWLINE;

vardec: DATATYPE declaratorlist ;

assign: assignList '=' value;

assignList: VARIABLENAME ('=' VARIABLENAME)*;

functionCall: FUNCTIONNAME ': ' (value (',' value)*)?;

declaratorlist: declarator | declarator ',' declaratorlist;

declarator: VARIABLENAME | VARIABLENAME '=' value;


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
	| declarator                   #choyens
    ; 
   
mulDivOp: '*' | '/' | '%'; // Multiplication Division Modulo
addMinOp: '+' | '-'; // Addition Subtraction 
compareOp: '>' | '<' | '>=' | '<=' | '==' | '<>'; 
logicalOp: 'AND' | 'OR' | 'NOT';
concOp: '&';
assignOp: '=';

//LEXER RULES

BEGIN: 'BEGIN CODE';
END: 'END CODE';
NEWLINEOP: '$';
DATATYPE: 'BOOL' | 'CHAR' | 'INT' | 'FLOAT';
BOOLVAL: 'TRUE' | 'FALSE';
CHARVAL: '\'' ([a-zA-Z] | [0-9]) '\'';
INTEGERVAL: ('-')? [0-9]+;
FLOATVAL: ('-')? [0-9]+ '.' ('-')? [0-9]+;
STRINGVAL: ('"' ~'"'* '"')
	| ('\'' ~'\''* '\'')
	| ('[' ~']'* ']'+);

WS: [\t\r]+ -> skip; // Skips whitespaces
NEWLINE: [\r\n]+;
FUNCTIONNAME: 'DISPLAY';
VARIABLENAME: [_a-z][a-zA-Z0-9_]* | [a-z][a-zA-Z0-9_]*;
COMMENT: '#' ~[\r\n]* -> skip;