lexer grammar BramsprLexer;

/* Operators. */
BECOMES:                ':=';
SWAP:                   '<>';

MULTIPLICATION:         '*';
PLUS:                   '+';
MINUS:                  '-';
DIVISION:               '/';
MODULUS:                '%';

/* Comparators. */
SMALLER_THAN:           '>';
SMALLER_THAN_EQUALS_TO: '<=';
GREATER_THAN:           '>';
GREATER_THAN_EQUALS_TO: '>=';
EQUALS_TO:              '=';
NOT_EQUALS_TO:          '=/=';
PLUSMINUS:              '+-';

COMPARATOR: SMALLER_THAN
          | SMALLER_THAN_EQUALS_TO
          | GREATER_THAN
          | GREATER_THAN_EQUALS_TO
          | EQUALS_TO
          | NOT_EQUALS_TO
          | PLUSMINUS;

/* Logic. */
NOT:                    '!';
AND:                    '^' ;
OR:                     'v' ;
XOR:                    '!&' ;

/* Keywords. */
IF:                    'if';
THEN:                  'then';
ELSE:                  'else';

/* Symbols. */
COLON:                  ':'     ;
SEMICOLON:              ';'     ;
LEFT_PARENTHESIS:       '('     ;
RIGHT_PARENTHESIS:      ')'     ;
LEFT_CURLY_BRACKET:     '{'     ;
RIGHT_CURLY_BRACKET:    '}'     ;

IDENTIFIER: LETTER (LETTER | DIGIT)*;
LETTER: ('a'..'z');
NUMBER: DIGIT+;
DIGIT: ('0'..'9');
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;