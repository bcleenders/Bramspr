grammar Bramspr;
options { tokenVocab=BramsprLexer; }

program: statement*;

structure: blockStructure
         | ifStructure
         | whileStructure
         ;

blockStructure: LEFT_BRACE statement* RIGHT_BRACE;
ifStructure: IF LEFT_PARENTHESIS expression RIGHT_PARENTHESIS blockStructure (ELSE blockStructure)?;
whileStructure: WHILE LEFT_PARENTHESIS expression RIGHT_PARENTHESIS blockStructure;

statement : structure
          | declaration SEMICOLON
          | assignment SEMICOLON
          | swap SEMICOLON
          | functionCall SEMICOLON
          ;

declaration: IDENTIFIER (COMMA IDENTIFIER)* COLON typeDenoter
           | FINAL? IDENTIFIER (COMMA IDENTIFIER)* COLON typeDenoter BECOMES expression
           ; 

typeDenoter: IDENTIFIER                                             # baseTypeDenoter
           | LEFT_BLOCKBRACE NUMBER RIGHT_BLOCKBRACE typeDenoter    # arrayTypeDenoter
           ;

assignment: (assignable BECOMES)+ expression;
swap: assignable SWAP assignable;

expression: NOT expression                                            # notExpression
          | arithmetic                                                # arithmeticExpression
          | expression (EQUALS_TO expression)+                        # equalsToExpression 
          | expression (NOT_EQUALS_TO expression)+                    # notEqualsToExpression
          | arithmetic EQUALS_TO arithmetic PLUSMINUS arithmetic      # plusMinusExpression                  
          | arithmetic (GREATER_THAN arithmetic)+                     # greaterThanExpression        
          | arithmetic (GREATER_THAN_EQUALS_TO arithmetic)+           # greaterThanEqualsToExpression            
          | arithmetic (SMALLER_THAN arithmetic)+                     # smallerThanExpression        
          | arithmetic (SMALLER_THAN_EQUALS_TO arithmetic)+           # smallerThanEqualsToExpression                   
          ;

arithmetic: atomic                                                        # atomicExpression
          | (PLUS | MINUS) arithmetic                                     # signExpression
          | arithmetic POWER <assoc=right> arithmetic                     # powerExpression
          | arithmetic ( MULTIPLICATION | DIVISION | MODULUS ) arithmetic # multiplicationExpression
          | arithmetic ( PLUS | MINUS ) arithmetic                        # additionExpression
          ;
            
assignable: IDENTIFIER fieldAccess
          | IDENTIFIER
          ;

atomic : LEFT_PARENTHESIS assignment RIGHT_PARENTHESIS
       | LEFT_PARENTHESIS expression RIGHT_PARENTHESIS
       | assignable
       | functionCall fieldAccess
       | literal
       ;

functionCall: IDENTIFIER LEFT_PARENTHESIS (expression ( COMMA expression)*)? RIGHT_PARENTHESIS
            ;

fieldAccess : DOT IDENTIFIER fieldAccess?
            | LEFT_BLOCKBRACE expression RIGHT_BLOCKBRACE fieldAccess?
            ;

literal : NUMBER
        | CHARACTER
        | STRING
        | TRUE
        | FALSE
        | BOOL
//        | arrayLiteral
//        | compositeLiteral
        ;


/*
arrayLiteral : typeDenoter LEFT_BLOCKBRACE (expression (COMMA expression)*)? RIGHT_BLOCKBRACE
             ;

compositeLiteral : IDENTIFIER LEFT_BRACE (assignment (COMMA assignment)*)? RIGHT_BRACE
                 ;
*/