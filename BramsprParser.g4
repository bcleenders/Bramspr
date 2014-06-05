grammar BramsprParser;
options { tokenVocab=BramsprLexer; }
program: (declaration SEMICOLON | statement SEMICOLON)*;

declaration : VAR IDENTIFIER TYPE;
    
statement: ifstatement
         | assignment SEMICOLON;

ifstatement : IF expression LEFT_CURLY_BRACKET statements RIGHT_CURLY_BRACKET 
              (ELSE LEFT_CURLY_BRACKET statements RIGHT_CURLY_BRACKET)?;

assignment: IDENTIFIER BECOMES expression;

/*
expression: orexpr;
orexpr: andexpr (OR andexpr)*;
andexpr: compareexpr (AND compareexpr)*;
compareexpr: sumexpr (COMPARATOR sumexpr)*;
sumexpr: productexpr ( productexpr)*;
productexpr: unaryexpr ((MULTIPLICATION | DIVISION | MODULUS) unaryexpr)*;
unaryexpr: (PLUS | MINUS | NOT) operand;
*/

expression: expression OPERATOR expression          # arithmeticExpression
          | expression LOGIC expression             # logicExpression
          | expression COMPARATOR expression;       # compareExpression

operand : IDENTIFIER (BECOMES expression)?
        | NUMBER;
