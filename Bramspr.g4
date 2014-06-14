grammar Bramspr;
options { tokenVocab=BramsprLexer; }

program: block;

block: (declaration | statement | LEFT_BRACE block RIGHT_BRACE)*;

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

// function integer foo(a,b: integer, z:char) { return a + b; }
functiondeclaration: FUNCTION IDENTIFIER IDENTIFIER 
                        LEFT_PARENTHESIS (variabledeclaration (COMMA variabledeclaration)*)? RIGHT_PARENTHESIS 
                        LEFT_BRACE 
                            block
                            (RETURN expression SEMICOLON)?
                        RIGHT_BRACE;

// enum days { FRIDAY, SATURDAY, SUNDAY }
enumdeclaration: ENUM IDENTIFIER LEFT_BRACE IDENTIFIER (COMMA IDENTIFIER)* RIGHT_BRACE;

// foo(x+1, y)
functioncall: GETINT LEFT_PARENTHESIS RIGHT_PARENTHESIS            # getIntExpression
            | GETCHAR LEFT_PARENTHESIS RIGHT_PARENTHESIS           # getCharExpression
            | GETBOOL LEFT_PARENTHESIS RIGHT_PARENTHESIS           # getBoolExpression
            | PUTINT LEFT_PARENTHESIS expression RIGHT_PARENTHESIS            # putIntExpression
            | PUTCHAR LEFT_PARENTHESIS expression RIGHT_PARENTHESIS            # putCharExpression
            | PUTBOOL LEFT_PARENTHESIS expression RIGHT_PARENTHESIS            # putBoolExpression
            // Deze moet als laatste, anders matchen de bovenstaande er al op!
            | IDENTIFIER LEFT_PARENTHESIS (expression (COMMA expression)*)? RIGHT_PARENTHESIS # functionCallExpression
            ;

statement: ifstatement
         | whilestatement
         | assignment SEMICOLON
         | swapstatement SEMICOLON
         | expression SEMICOLON
         | printstatement SEMICOLON
         ;

ifstatement : IF expression LEFT_BRACE statement* RIGHT_BRACE 
              (ELSE LEFT_BRACE statement* RIGHT_BRACE)?;

whilestatement: WHILE expression LEFT_BRACE statement* RIGHT_BRACE;

// print("x = ", x);
printstatement: PRINT LEFT_PARENTHESIS expression (COMMA expression)* RIGHT_PARENTHESIS;

assignment: (expression BECOMES)+ expression;
swapstatement: expression SWAP expression;

expression: LEFT_PARENTHESIS expression RIGHT_PARENTHESIS        # parenthesisExpression
          | (PLUS | MINUS | NOT) expression                      # unaryExpression
          | expression POWER <assoc=right> expression            # powerExpression
          | expression (MULTIPLICATION | DIVISION | MODULUS) expression # multiplicationExpression
          | expression (PLUS | MINUS) expression                 # additionExpression

          // Comparators should be combined?
          | expression (SMALLER_THAN expression)+                # smallerThanExpression        
          | expression (SMALLER_THAN_EQUALS_TO expression)+      # smallerThanEqualsToExpression                   
          | expression (GREATER_THAN expression)+                # greaterThanExpression        
          | expression (GREATER_THAN_EQUALS_TO expression)+      # greaterThanEqualsToExpression                    
          | expression (EQUALS_TO expression)+                   # equalsToExpression        
          | expression (NOT_EQUALS_TO expression)+               # notEqualsToExpression

          | expression EQUALS_TO expression PLUSMINUS expression # plusMinusExpression        
          | expression AND expression                            # andExpression
          | expression OR expression                             # orExpression
          | LEFT_PARENTHESIS assignment RIGHT_PARENTHESIS        # assignExpression
          | functioncall                                         # functionExpression
          | expression (LEFT_BLOCKBRACE expression RIGHT_BLOCKBRACE) # arrayAccessExpression
          | ENUM DOT IDENTIFIER DOT IDENTIFIER                   # enumExpression
          // Let op; dit matcht zowel records als enums! Opletten in de checker.
          | expression DOT IDENTIFIER                            # fieldAccessExpression
          | IDENTIFIER                                           # variableExpression
          | NUMBER                                               # intLiteralExpression
          | BOOL                                                 # boolLiteralExpression
          | CHARACTER                                            # charLiteralExpression
          | STRING                                               # stringLiteralExpression
          ;