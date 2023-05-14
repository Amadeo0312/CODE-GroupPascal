grammar Simple;

// PARSER RULES
program: (COMMENT | NEWLINE)* BEGIN NEWLINE statements END (COMMENT | NEWLINE)* EOF;

statements: statement+;

statement: (vardec | assign | functionCall | condstmt | whileCondition | switchCondition) NEWLINE;

condstmt : ifstmt (elseifstmt)* (elsestmt)*;

ifstmt : 'IF' '(' value ')' (COMMENT | NEWLINE)* 'BEGIN IF' NEWLINE statements 'END IF' (COMMENT | NEWLINE)*;

elseifstmt: 'ELSE IF' '(' value ')' (COMMENT | NEWLINE)* 'BEGIN IF' NEWLINE statements 'END IF' (COMMENT | NEWLINE)*;

elsestmt: 'ELSE' (COMMENT | NEWLINE)* 'BEGIN IF' NEWLINE statements 'END IF' (COMMENT | NEWLINE)*;

vardec: DATATYPE declaratorlist ;

assign: assignList '=' value;

assignList: VARIABLENAME ('=' VARIABLENAME)*;

functionCall: FUNCTIONNAME ': ' (value (',' value)*)?;

declaratorlist: declarator | declarator ',' declaratorlist;

declarator: VARIABLENAME | VARIABLENAME '='  value;

whileBlock: 'BEGIN WHILE' (COMMENT | NEWLINE)* statements 'END WHILE' (COMMENT | NEWLINE)*;

whileCondition: 'WHILE' '(' value ')' (COMMENT | NEWLINE)* whileBlock;

switchBlock: 'BEGIN SWITCH' (COMMENT | NEWLINE)* (caseBlock)* defaultBlock? 'END SWITCH' (COMMENT | NEWLINE)*;

switchCondition: 'SWITCH' '(' value ')' (COMMENT | NEWLINE)* switchBlock;

caseBlock: 'CASE ' value ':' (COMMENT | NEWLINE)* statements (COMMENT | NEWLINE)* 'BREAK' (COMMENT | NEWLINE)*;

defaultBlock: 'DEFAULT:' (COMMENT | NEWLINE)* statements (COMMENT | NEWLINE)* 'BREAK' (COMMENT | NEWLINE)*;


constant: INTEGERVAL | FLOATVAL | CHARVAL | BOOLVAL | STRINGVAL;  
 
value
    :constant                      #constantExpression
	| VARIABLENAME                 #variablenameExpression
	| functionCall                 #functionCallExpression
	| value compareOp value        #comparisonExpression
	| logicalOp value              #logicalExpression
	| value logicalOp value        #logicalExpression
	| value mulDivOp value         #multiplicativeExpression
	| value addMinOp value         #additiveExpression
	| value concOp value           #concatenateExpression
	| NEWLINEOP                    #newlineopExpression
	| declarator                   #choyens
	| '(' value ')'                #parenthesisExpression
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

WS: [ \t\r]+ -> skip; // Skips whitespaces
NEWLINE: [\r\n]+;
FUNCTIONNAME: 'DISPLAY' | 'SCAN';
VARIABLENAME: [_a-z][a-zA-Z0-9_]* | [a-z][a-zA-Z0-9_]*;
COMMENT: '#' ~[\r\n]* -> skip;