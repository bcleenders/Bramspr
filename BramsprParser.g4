/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
parser grammar BramsprParser;

program: (declarations statement)*;

declarations: (declaration SEMICOLON)*;
declaration : VAR IDENTIFIER TYPE;
    
statements : statement*;

statement: ifstatement
         | assignment SEMICOLON;

ifstatement : IF expression LEFT_CURLY_BRACKET statements RIGHT_CURLY_BRACKET 
              (ELSE LEFT_CURLY_BRACKET statements RIGHT_CURLY_BRACKET)?;

assignment: IDENTIFIER BECOMES expression;

expression: orexpr;
orexpr: andexpr (OR andexpr)*;
andexpr: compareexpr (AND compareexpr)*;
compareexpr: sumexpr (COMPARATOR sumexpr)*;
sumexpr: productexpr ( productexpr)*;
productexpr: unaryexpr ((MULTIPLICATION | DIVISION | MODULUS) unaryexpr)*;
unaryexpr: (PLUS | MINUS | NOT) operand;

operand : IDENTIFIER (BECOMES expression)?
        | NUMBER;
