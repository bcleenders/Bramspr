grammar BramsprParser;
options { tokenVocab=BramsprLexer; }
program: (declaration SEMICOLON | statement SEMICOLON)*;

declaration : VAR IDENTIFIER TYPE;

statements: (statement SEMICOLON)*;
    
statement: ifstatement
         | assignment SEMICOLON;

ifstatement : IF expression LEFT_CURLY_BRACKET statements RIGHT_CURLY_BRACKET 
              (ELSE LEFT_CURLY_BRACKET statements RIGHT_CURLY_BRACKET)?;

assignment: IDENTIFIER BECOMES expression;

expression: expression '^' <assoc=right> expression # machtsverheffen
          | expression OPERATOR expression          # arithmeticExpression
          | expression LOGIC expression             # logicExpression
          | expression COMPARATOR expression        # compareExpression
          | assignment
          | IDENTIFIER
          | NUMBER
          ;
