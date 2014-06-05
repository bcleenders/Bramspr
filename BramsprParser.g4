grammar BramsprParser;
options { tokenVocab=BramsprLexer; }

program: (declaration | statement )*;

declaration : variabledeclaration SEMICOLON
            | proceduredeclaration
            | functiondeclaration
            ;
variabledeclaration: IDENTIFIER (COMMA IDENTIFIER)* IDENTIFIER ;

proceduredeclaration: PROCEDURE IDENTIFIER LEFT_PARENTHESIS (variabledeclaration (COMMA variabledeclaration)*)? RIGHT_PARENTHESIS 
                      LEFT_BRACE (variabledeclaration | statement)* RIGHT_BRACE;
    
statement: ifstatement
         | assignment SEMICOLON
         | whilestatement
         | procedurecall
         ;

ifstatement : IF expression LEFT_BRACE statement* RIGHT_BRACE 
              (ELSE LEFT_BRACE statement* RIGHT_BRACE)?;

whilestatement: WHILE expression LEFT_BRACE statement* RIGHT_BRACE;

assignment: (IDENTIFIER BECOMES)+ expression;

expression: (expression)                                # parenthesisExpression
          | PLUS expression                             # positiveExpression
          | MINUS expression                            # negativeExpression
          | NOT expression                              # notExpression
          | expression POWER <assoc=right> expression   # powerExpression
          | expression MULTIPLICATION expression        # multiplicationExpression
          | expression DIVISION expression              # divisionExpression
          | expression MODULUS expression               # modulusExpression
          | expression PLUS expression                  # plusExpression
          | expression MINUS expression                 # minusExpression
          | expression (SMALLER_THAN expression)+                   # smallerThanExpression        
          | expression (SMALLER_THAN_EQUALS_TO expression)+         # smallerThanEqualsToExpression                   
          | expression (GREATER_THAN expression)+                   # greaterThanExpression        
          | expression (GREATER_THAN_EQUALS_TO expression)+         # greaterThanEqualsToExpression                    
          | expression (EQUALS_TO expression)+                      # equalsToExpression        
          | expression (NOT_EQUALS_TO expression)+                  # notEqualsToExpression            
          | expression EQUALS_TO expression PLUSMINUS expression    # plusExpression        
          | expression AND expression                   # andExpression
          | expression OR expression                    # orExpression
          | assignment                                  # assignExpression
          | IDENTIFIER                                  # variableExpression
          | (NUMBER | CHARACTER | STRING)               # literalExpression
          | functioncall                                # functionExpression
          ;
            
            