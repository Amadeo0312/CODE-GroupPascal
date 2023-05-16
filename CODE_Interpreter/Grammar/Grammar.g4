grammar Grammar;

// PARSER RULES
program: (COMMENT | NEWLINE)* BEGIN NEWLINE statements END (COMMENT | NEWLINE)* EOF;

statements: statement+;

statement: (variableDeclaration | assign | functionCall | conditionalStatement | whileCondition | switchCondition) NEWLINE;

conditionalStatement : ifStatement (elseifStatement)* (elseStatement)*;

ifStatement : 'IF' '(' value ')' (COMMENT | NEWLINE)* 'BEGIN IF' NEWLINE statements 'END IF' (COMMENT | NEWLINE)*;

elseifStatement: 'ELSE IF' '(' value ')' (COMMENT | NEWLINE)* 'BEGIN IF' NEWLINE statements 'END IF' (COMMENT | NEWLINE)*;

elseStatement: 'ELSE' (COMMENT | NEWLINE)* 'BEGIN IF' NEWLINE statements 'END IF' (COMMENT | NEWLINE)*;

variableDeclaration: DATATYPE declaratorlist ;

assign: assignList assignmentOperator value;

assignList: VARIABLENAME (assignmentOperator VARIABLENAME)*;

functionCall: FUNCTIONNAME ': ' (value (',' value)*)?;

declaratorlist: declarator | declarator ',' declaratorlist;

declarator: VARIABLENAME | VARIABLENAME assignmentOperator  value;

whileBlock: 'BEGIN WHILE' (COMMENT | NEWLINE)* statements 'END WHILE' (COMMENT | NEWLINE)*;

whileCondition: 'WHILE' '(' value ')' (COMMENT | NEWLINE)* whileBlock;

switchBlock: 'BEGIN SWITCH' (COMMENT | NEWLINE)* (caseBlock)* defaultBlock? 'END SWITCH' (COMMENT | NEWLINE)*;

switchCondition: 'SWITCH' '(' value ')' (COMMENT | NEWLINE)* switchBlock;

caseBlock: 'CASE ' value ':' (COMMENT | NEWLINE)* statements (COMMENT | NEWLINE)* 'BREAK' (COMMENT | NEWLINE)*;

defaultBlock: 'DEFAULT:' (COMMENT | NEWLINE)* statements (COMMENT | NEWLINE)* 'BREAK' (COMMENT | NEWLINE)*;

constant: INTEGERVAL | FLOATVAL | CHARVAL | BOOLVAL | STRINGVAL;  
 
value
    :constant                               #constantExpression
    | NEWLINEOPERATOR                       #newlineOperatorExpression  
	| VARIABLENAME                          #variableNameExpression
	| functionCall                          #functionCallExpression
	| value compareOperators value          #comparisonExpression
	| logicalOperators value                #logicalExpression
	| value logicalOperators value          #logicalExpression
	| value mulDivOperators value           #multiplicativeExpression
	| value addMinOperators value           #additiveExpression
	| value concatOperator value            #concatenateExpression
	| declarator                            #choyens
	| '(' value ')'                         #parenthesisExpression
    ; 
   
mulDivOperators: '*' | '/' | '%';                               // Multiplication Division Modulo
addMinOperators: '+' | '-';                                     // Addition Subtraction 
compareOperators: '>' | '<' | '>=' | '<=' | '==' | '<>';        // Relational Operators
logicalOperators: 'AND' | 'OR' | 'NOT';                         // Logical Operators
concatOperator: '&';
assignmentOperator: '=';


// LEXER RULES
BEGIN: 'BEGIN CODE';
END: 'END CODE';
NEWLINEOPERATOR: '$';
DATATYPE: 'BOOL' | 'CHAR' | 'INT' | 'FLOAT';
BOOLVAL: 'TRUE' | 'FALSE';
CHARVAL: '\'' ([a-zA-Z] | [0-9]) '\'';
INTEGERVAL: ('-')?[0-9]+;
FLOATVAL: ('-')? [0-9]+ '.' [0-9]+;
STRINGVAL: ('"' ~'"'* '"')
	| ('\'' ~'\''* '\'')
	| ('[' ~']'* ']'+);

WS: [ \t\r]+ -> skip; // Skips whitespaces
NEWLINE: [\r\n]+;
FUNCTIONNAME: 'DISPLAY' | 'SCAN';
VARIABLENAME: [_a-z][a-zA-Z0-9_]* | [a-z][a-zA-Z0-9_]*;
COMMENT: '#' ~[\r\n]* -> skip;

