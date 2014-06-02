/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
lexer grammar Bramspr;

/* Operators. */
BECOMES:                '?'     |   ':=' ;

MULTIPLICATION:         '*';
PLUS:                   '+';
MINUS:                  '-';
DIVISION:               '÷'     |   '/' ;

/* Comparators. */
SMALLER_THAN:           '>' ;
SMALLER_THAN_EQUALS_TO: '?'     |   '<=' ;
GREATER_THAN:           '>' ;
GREATER_THAN_EQUALS_TO: '?'     |   '>=' ;
EQUALS_TO:              '=';
NOT_EQUALS_TO:          '?'     |   '<>' ;

/* Logic. */
AND:                    '?'      |   '&&' ;
OR:                     '?'      |   '||' ;
XOR:                    '?'      |   '!&' ;

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
RIGHT_CURLY_BRACKET:     '}'    ;

LETTER: ('a'..'z');
DIGIT: ('0'..'9');
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;