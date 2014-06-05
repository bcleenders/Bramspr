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

OPERATOR: PLUS
        | MINUS
        | MULTIPLICATION
        | DIVISION
        | MODULUS;

/* Comparators. */
SMALLER_THAN:           '>';
SMALLER_THAN_EQUALS_TO: '<=';
GREATER_THAN:           '>';
GREATER_THAN_EQUALS_TO: '>=';
EQUALS_TO:              '=';
NOT_EQUALS_TO:          '=/=';
PLUSMINUS:              '+-';
POWER:                  '^';

COMPARATOR: SMALLER_THAN
          | SMALLER_THAN_EQUALS_TO
          | GREATER_THAN
          | GREATER_THAN_EQUALS_TO
          | EQUALS_TO
          | NOT_EQUALS_TO
          | PLUSMINUS;

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
PROCEDURE:              'procedure';
    
/* Symbols. */
COLON:                  ':'     ;
SEMICOLON:              ';'     ;
LEFT_PARENTHESIS:       '('     ;
RIGHT_PARENTHESIS:      ')'     ;
LEFT_BRACE:     '{'     ;
RIGHT_BRACE:    '}'     ;
COMMA:                  ','     ;

/* Literals. */
STRING : '"' ( '\\"' | ~('\n'|'\r') )*? '"';
CHARACTER : '\''  ( '\\\'' | ~('\n'|'\r') )*? '\'';
IDENTIFIER: LETTER (LETTER | DIGIT)*;
NUMBER: DIGIT+;

/* Miscellaneous. */
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;

/* Fragments. */
fragment DIGIT: ('0'..'9');
fragment LETTER: ('a'..'z'|'A'..'Z');