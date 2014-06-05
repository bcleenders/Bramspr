grammar BramsprParser;
options { tokenVocab=BramsprLexer; }

program: (declaration | statement )*;

declaration : variabledeclaration SEMICOLON
            | functiondeclaration
            | typedeclaration
            ;

// x, y: integer
// x: [11]integer (is een array van integers)
variabledeclaration: IDENTIFIER (COMMA IDENTIFIER)* COLON primitiveType;
   
// type bank {
//      kussens: integer,
//      bezetDoor: [2]persoon
// }
typedeclaration: TYPE IDENTIFIER LEFT_BRACE variabledeclaration (COMMA variabledeclaration)* RIGHT_BRACE;

// [2][9]integer
primitiveType: (LEFT_BLOCKBRACE NUMBER RIGHT_BLOCKBRACE)*IDENTIFIER;

// function foo(a,b: integer, z:char) { ... }
functiondeclaration: FUNCTION IDENTIFIER LEFT_PARENTHESIS (variabledeclaration (COMMA variabledeclaration)*)? RIGHT_PARENTHESIS 
                      LEFT_BRACE (variabledeclaration | statement)* RIGHT_BRACE;

// foo(x+1, y)
functioncall: IDENTIFIER LEFT_PARENTHESIS (expression (COMMA expression)*)? RIGHT_PARENTHESIS;

statement: ifstatement
         | whilestatement
         | assignment SEMICOLON
         | expression SEMICOLON
         ;

ifstatement : IF expression LEFT_BRACE statement* RIGHT_BRACE 
              (ELSE LEFT_BRACE statement* RIGHT_BRACE)?;

whilestatement: WHILE expression LEFT_BRACE statement* RIGHT_BRACE;

assignment: (IDENTIFIER BECOMES)+ expression;

expression: LEFT_PARENTHESIS expression RIGHT_PARENTHESIS       # parenthesisExpression
          | PLUS expression                                     # positiveExpression
          | MINUS expression                                    # negativeExpression
          | NOT expression                                      # notExpression
          | expression POWER <assoc=right> expression           # powerExpression
          | expression MULTIPLICATION expression                # multiplicationExpression
          | expression DIVISION expression                      # divisionExpression
          | expression MODULUS expression                       # modulusExpression
          | expression PLUS expression                          # plusExpression
          | expression MINUS expression                         # minusExpression
          | expression (SMALLER_THAN expression)+               # smallerThanExpression        
          | expression (SMALLER_THAN_EQUALS_TO expression)+     # smallerThanEqualsToExpression                   
          | expression (GREATER_THAN expression)+               # greaterThanExpression        
          | expression (GREATER_THAN_EQUALS_TO expression)+     # greaterThanEqualsToExpression                    
          | expression (EQUALS_TO expression)+                  # equalsToExpression        
          | expression (NOT_EQUALS_TO expression)+              # notEqualsToExpression            
          | expression EQUALS_TO expression PLUSMINUS expression    # plusMinusExpression        
          | expression AND expression                           # andExpression
          | expression OR expression                            # orExpression
          | assignment                                          # assignExpression
          | IDENTIFIER                                          # variableExpression
          | (NUMBER | CHARACTER | STRING)                       # literalExpression
          | functioncall                                        # functionExpression
          ;
            
            