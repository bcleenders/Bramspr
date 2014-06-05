grammar BramsprParser;
options { tokenVocab=BramsprLexer; }

program: (declaration | statement )*;

declaration : variabledeclaration SEMICOLON
            | functiondeclaration
            | typedeclaration
            | enumdeclaration
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

// enum days { FRIDAY, SATURDAY, SUNDAY }
enumdeclaration: ENUM IDENTIFIER LEFT_BRACE IDENTIFIER (COMMA IDENTIFIER)* RIGHT_BRACE;

// foo(x+1, y)
functioncall: IDENTIFIER LEFT_PARENTHESIS (expression (COMMA expression)*)? RIGHT_PARENTHESIS;

statement: ifstatement
         | whilestatement
         | assignment SEMICOLON
         | expression SEMICOLON
         | printstatement SEMICOLON
         ;

ifstatement : IF expression LEFT_BRACE statement* RIGHT_BRACE 
              (ELSE LEFT_BRACE statement* RIGHT_BRACE)?;

whilestatement: WHILE expression LEFT_BRACE statement* RIGHT_BRACE;

// print("x = ", x);
printstatement: PRINT LEFT_PARENTHESIS expression (COMMA expression)* RIGHT_PARENTHESIS;

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
          | NUMBER                                              # intLiteralExpression
          | CHARACTER                                           # charLiteralExpression
          | STRING                                              # stringLiteralExpression
          | functioncall                                        # functionExpression
          ;
            
            