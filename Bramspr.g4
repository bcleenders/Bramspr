grammar Bramspr;
options { tokenVocab=BramsprLexer; }

program: statement*;

structure: blockStructure
         | ifStructure
         | whileStructure
         ;

blockStructure:     LEFT_BRACE statement* RIGHT_BRACE;
ifStructure:        IF LEFT_PARENTHESIS expression RIGHT_PARENTHESIS blockStructure (ELSE blockStructure)?;
whileStructure:     WHILE LEFT_PARENTHESIS expression RIGHT_PARENTHESIS blockStructure;

statement : structure
          | declaration SEMICOLON
          | assignment SEMICOLON
          | swap SEMICOLON
          | functionCall SEMICOLON
          ;

declaration: compositeDeclaration
           | functionDeclaration
           | enumerationDeclaration
           | variableDeclaration
           ;

variableDeclaration:    IDENTIFIER (COMMA IDENTIFIER)* COLON typeDenoter                                # pureDeclaration
           |            CONSTANT? IDENTIFIER (COMMA IDENTIFIER)* COLON typeDenoter BECOMES expression   # instantiatingDeclaration
           ; 

enumerationDeclaration: ENUMERATION IDENTIFIER LEFT_BRACE (IDENTIFIER (COMMA IDENTIFIER)*)? RIGHT_BRACE;

functionDeclaration:    FUNCTION IDENTIFIER 
                        LEFT_PARENTHESIS 
                           (IDENTIFIER COLON typeDenoter (COMMA IDENTIFIER COLON typeDenoter)*)? 
                        RIGHT_PARENTHESIS 
                        LEFT_BRACE
                           statement*
                           (RETURN expression SEMICOLON)?
                        RIGHT_BRACE
                   ;

compositeDeclaration:   TYPE IDENTIFIER
                        LEFT_BRACE
                            IDENTIFIER COLON typeDenoter (COMMA IDENTIFIER COLON typeDenoter)*
                        RIGHT_BRACE
                    ;

typeDenoter: IDENTIFIER                                                     # baseTypeDenoter
           | LEFT_BLOCKBRACE NUMBER RIGHT_BLOCKBRACE typeDenoter            # arrayTypeDenoter
           | ENUMERATION DOT IDENTIFIER                                     # enumeratedTypeDenoter
           ;

assignment: (assignable BECOMES)+ expression;
swap:       assignable SWAP assignable;

expression: NOT expression                                                  # notExpression
          | arithmetic                                                      # arithmeticExpression
          | arithmetic (EQUALS_TO arithmetic)+                              # equalsToExpression 
          | arithmetic (NOT_EQUALS_TO arithmetic)+                          # notEqualsToExpression
          | expression EQUALS_TO expression                                 # universalEqualsToExpression
          | expression NOT_EQUALS_TO expression                             # universalNotEqualsToExpression
          | arithmetic EQUALS_TO arithmetic PLUSMINUS arithmetic            # plusMinusExpression                  
          | arithmetic (GREATER_THAN arithmetic)+                           # greaterThanExpression        
          | arithmetic (GREATER_THAN_EQUALS_TO arithmetic)+                 # greaterThanEqualsToExpression            
          | arithmetic (SMALLER_THAN arithmetic)+                           # smallerThanExpression        
          | arithmetic (SMALLER_THAN_EQUALS_TO arithmetic)+                 # smallerThanEqualsToExpression
          | expression AND expression                                       # andExpression
          | expression OR expression                                        # orExpression
          ;

arithmetic: molecule                                                        # moleculeExpression
          | (PLUS | MINUS) arithmetic                                       # signExpression
          | arithmetic POWER <assoc=right> arithmetic                       # powerExpression
          | arithmetic ( MULTIPLICATION | DIVISION | MODULUS ) arithmetic   # multiplicationExpression
          | arithmetic ( PLUS | MINUS ) arithmetic                          # additionExpression
          ;

// Deze nieuwe laag voorkomt dat (IDENTIFIER DOT IDENTIFIER) als accessExpression gematcht wordt.
molecule : IDENTIFIER DOT IDENTIFIER                                          # potentialEnumerationLiteral // of het is een composite
         | atomic                                                             # atomicExpression
         ;

atomic : LEFT_PARENTHESIS assignment RIGHT_PARENTHESIS                      # assignmentExpression
       | LEFT_PARENTHESIS expression RIGHT_PARENTHESIS                      # parenthesisExpression
       | assignable                                                         # assignableExpression
       | functionCall                                                       # functionCallExpression
       | literal                                                            # literalExpression
       | atomic accessExpression                                            # accessOnAtomicExpression
       ;

assignable: assignable accessExpression                                     # accessOnAssignableExpression
          | IDENTIFIER                                                      # basicAssignable
          ;

accessExpression : DOT IDENTIFIER                                           # fieldAccessExpression
                 | LEFT_BLOCKBRACE expression RIGHT_BLOCKBRACE              # arrayAccessExpression
                 ;

functionCall: IDENTIFIER LEFT_PARENTHESIS (expression ( COMMA expression)*)? RIGHT_PARENTHESIS
            ;

literal : NUMBER                                                                                                          # numberLiteral
        | CHARACTER                                                                                                       # characterLiteral
        | STRING                                                                                                          # stringLiteral
        | BOOLEAN                                                                                                         # booleanLiteral
        | LEFT_BLOCKBRACE (expression (COMMA expression)*)? RIGHT_BLOCKBRACE                                              # arrayLiteral
        | IDENTIFIER LEFT_BRACE IDENTIFIER BECOMES expression (COMMA IDENTIFIER BECOMES expression)* RIGHT_BRACE          # compositeLiteral
        | ENUMERATION DOT IDENTIFIER DOT IDENTIFIER                                                                       # explicitEnumerationLiteral
        ;

