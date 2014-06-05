grammar BramsprParser;
options { tokenVocab=BramsprLexer; }

program: (declaration | statement )*;

declaration : IDENTIFIER (COMMA IDENTIFIER)* IDENTIFIER SEMICOLON;
    
statement: ifstatement
         | assignment SEMICOLON
         | whilestatement;

ifstatement : IF expression LEFT_CURLY_BRACKET statement* RIGHT_CURLY_BRACKET 
              (ELSE LEFT_CURLY_BRACKET statement* RIGHT_CURLY_BRACKET)?;

whilestatement: WHILE expression LEFT_CURLY_BRACKET statement*;

assignment: (IDENTIFIER BECOMES)+ expression;

expression: PLUS expression                             # positiveExpression
          | MINUS expression                            # negativeExpression
          | NOT expression                              # notExpression
          | expression POWER <assoc=right> expression   # powerExpression
          | expression MULTIPLICATION expression        # multiplicationExpression
          | expression DIVISION expression              # divisionExpression
          | expression MODULUS expression               # modulusExpression
          | expression PLUS expression                  # plusExpression
          | expression MINUS expression                 # minusExpression
          | expression SMALLER_THAN expression          # smallerThanExpression        
          | expression SMALLER_THAN_EQUALS_TO expression # smallerThanEqualsToExpression                   
          | expression GREATER_THAN expression          # greaterThanExpression        
          | expression GREATER_THAN_EQUALS_TO expression # greaterThanEqualsToExpression                    
          | expression EQUALS_TO expression             # equalsToExpression        
          | expression NOT_EQUALS_TO expression         # notEqualsToExpression            
          | expression PLUSMINUS expression             # plusExpression        
          | expression AND expression                   # andExpression
          | expression OR expression                    # orExpression
          | assignment                                  # assignExpression
          | IDENTIFIER                                  # variableExpression
          | (NUMBER | CHARACTER | STRING)               # literalExpression
          ;
            
            