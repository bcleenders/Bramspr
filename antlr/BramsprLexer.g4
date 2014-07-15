lexer grammar BramsprLexer;

/* Operators. */
BECOMES:                ':=';
SWAP:                   '<>';
PLUS:                   '+';
MINUS:                  '-';
MULTIPLICATION:         '*';
DIVISION:               '/';
MODULUS:                '%';
SMALLER_THAN:           '<';
SMALLER_THAN_EQUALS_TO: '<=';
GREATER_THAN:           '>';
GREATER_THAN_EQUALS_TO: '>=';
EQUALS_TO:              '=';
NOT_EQUALS_TO:          '=/=';
PLUSMINUS:              '+-';
POWER:                  '^';
NOT:                    '!';
AND:                    '&' ;
OR:                     '|' ;

/* Keywords. */
IF:                     'if';
THEN:                   'then';
ELSE:                   'else';
WHILE:                  'while';
FUNCTION:               'function';
TYPE:                   'type';
ENUMERATION:            'enumeration';
RETURN:                 'return';
CONSTANT:               'constant';

/* Interpunction. */
COLON:                  ':'     ;
SEMICOLON:              ';'     ;
LEFT_PARENTHESIS:       '('     ;
RIGHT_PARENTHESIS:      ')'     ;
LEFT_BRACE:             '{'     ;
RIGHT_BRACE:            '}'     ;
LEFT_BLOCKBRACE:        '['     ;
RIGHT_BLOCKBRACE:       ']'     ;
COMMA:                  ','     ;
DOT:                    '.'     ;

// Een apostrof, gevolgd door geescapete apostrofes en niet-specialchars. 
// De *? (i.t.t. *) maakt hem niet-greedy, dus bij de eerste " stopt hij.
BOOLEAN: 'true' | 'false';
STRING : '"' ( ESCAPED | ~('\n'|'\r') )*? '"';
CHARACTER : '\''  ( '\\\'' | ~('\n'|'\r') )*? '\'';
IDENTIFIER: LETTER (LETTER | DIGIT)*;
NUMBER: DIGIT+;

/* Annotations. */
COMMENT: '//' ~[\r\n\u000C]* -> skip; // Matcht alles wat na // komt
BLOCKCOMMENT: '/*' .*? '*/' -> skip; // Matcht alles (op een non-greedy manier) tussen /* en */

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;

/* Fragments. */
fragment DIGIT: ('0'..'9');
fragment LETTER: ('a'..'z'|'A'..'Z');
fragment ESCAPED: '\\"' | '\\\\' ; // Dit zijn \" en \\. Met andere woorden; " en \ zoals ze binnen "" staan.
