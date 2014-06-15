lexer grammar BramsprLexer;

/* Assigners. */
BECOMES:                ':=';
SWAP:                   '<>';

/* Operators. */
PLUS:                   '+';
MINUS:                  '-';
MULTIPLICATION:         '*';
DIVISION:               '/';
MODULUS:                '%';

/* Comparators. */
SMALLER_THAN:           '<';
SMALLER_THAN_EQUALS_TO: '<=';
GREATER_THAN:           '>';
GREATER_THAN_EQUALS_TO: '>=';
EQUALS_TO:              '=';
NOT_EQUALS_TO:          '=/=';
PLUSMINUS:              '+-';
POWER:                  '^';

/* Logic. */
NOT:                    '!';

AND:                    '&' ;
OR:                     '|' ;
XOR:                    '!&' ;

LOGIC: AND
     | OR
     | XOR;

/* Keywords. */
IF:                     'if';
THEN:                   'then';
ELSE:                   'else';
WHILE:                  'while';
FUNCTION:               'function';
TYPE:                   'type';
PRINT:                  'print';
GETINT:                 'getInt';
GETCHAR:                'getChar';
GETBOOL:                'getBool';
PUTINT:                 'putInt';
PUTCHAR:                'putChar';
PUTBOOL:                'putBool';
PUTSTRING:              'putString';
ENUM:                   'enum';
RETURN:                 'return';
FINAL:                  'final';
TRUE:                   'true';
FALSE:                  'false';

/* Symbols. */
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

/* Literals. */
// Een apostrof, gevolgd door geescapete apostrofes en niet-specialchars. 
// De *? (i.t.t. *) maakt hem niet-greedy, dus bij de eerste " stopt hij.
STRING : '"' ( ESCAPED | ~('\n'|'\r') )*? '"';
CHARACTER : '\''  ( '\\\'' | ~('\n'|'\r') )*? '\'';
IDENTIFIER: LETTER (LETTER | DIGIT)*;
NUMBER: DIGIT+;
BOOL: TRUE | FALSE;

/* Miscellaneous. */
COMMENT: '//' ~[\r\n]* -> skip; // Matcht alles wat na // komt
BLOCKCOMMENT: '/*' .*? '*/' -> skip; // Matcht alles (op een non-greedy manier) tussen /* en */
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;

/* Fragments. */
fragment DIGIT: ('0'..'9');
fragment LETTER: ('a'..'z'|'A'..'Z');
fragment ESCAPED: '\\"' | '\\\\' ; // Dit zijn \" en \\. Met andere woorden; " en \ zoals ze binnen "" staan.
