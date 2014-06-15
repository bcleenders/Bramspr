grammar Bramspr;
options { tokenVocab=BramsprLexer; }

program: block;

block: (declaration | statement | LEFT_BRACE block RIGHT_BRACE)*;

declaration : variabledeclaration SEMICOLON
            | finaldeclaration SEMICOLON
            | functiondeclaration
            | typedeclaration
            | enumdeclaration
            ;

// x, y: integer
// x: [11]integer (is een array van integers)
variabledeclaration: IDENTIFIER (COMMA IDENTIFIER)* COLON primitiveTypeDenoter (BECOMES expression)?;
finaldeclaration: IDENTIFIER (COMMA IDENTIFIER)* COLON FINAL primitiveTypeDenoter BECOMES expression;
                      
// type bank {
//      kussens, aantalPoten: integer,
//      bezetDoor: [2]persoon
// }
typedeclaration: TYPE IDENTIFIER LEFT_BRACE fielddeclaration (COMMA fielddeclaration)* RIGHT_BRACE;

fielddeclaration: IDENTIFIER (COMMA IDENTIFIER)* COLON primitiveTypeDenoter;

// [2][9]integer
primitiveTypeDenoter: (LEFT_BLOCKBRACE NUMBER RIGHT_BLOCKBRACE)* IDENTIFIER;

// function integer foo(a,b: integer, z:char) { return a + b; }
functiondeclaration: FUNCTION primitiveTypeDenoter IDENTIFIER 
                        LEFT_PARENTHESIS (variabledeclaration (COMMA variabledeclaration)*)? RIGHT_PARENTHESIS 
                        LEFT_BRACE 
                            block
                            (RETURN expression SEMICOLON)?
                        RIGHT_BRACE;

// enum days { FRIDAY, SATURDAY, SUNDAY }
enumdeclaration: ENUM IDENTIFIER LEFT_BRACE IDENTIFIER (COMMA IDENTIFIER)* RIGHT_BRACE;

// foo(x+1, y)
functioncall: GETINT LEFT_PARENTHESIS RIGHT_PARENTHESIS                         # getIntExpression
            | GETCHAR LEFT_PARENTHESIS RIGHT_PARENTHESIS                        # getCharExpression
            | GETBOOL LEFT_PARENTHESIS RIGHT_PARENTHESIS                        # getBoolExpression
            | PUTINT LEFT_PARENTHESIS expression RIGHT_PARENTHESIS              # putIntExpression
            | PUTCHAR LEFT_PARENTHESIS expression RIGHT_PARENTHESIS             # putCharExpression
            | PUTBOOL LEFT_PARENTHESIS expression RIGHT_PARENTHESIS             # putBoolExpression
            // Deze moet als laatste, anders matchen de bovenstaande er al op!
            | IDENTIFIER LEFT_PARENTHESIS (expression (COMMA expression)*)? RIGHT_PARENTHESIS # functionCallExpression
            ;

statement: ifstatement
         | whilestatement
         | assignment SEMICOLON
         | swapstatement SEMICOLON
         | expression SEMICOLON
         ;

ifstatement : IF expression LEFT_BRACE block RIGHT_BRACE
              (ELSE LEFT_BRACE block RIGHT_BRACE)?;

whilestatement: WHILE expression LEFT_BRACE block RIGHT_BRACE;

assignment: (expression BECOMES)+ expression;
swapstatement: expression SWAP expression;

expression: LEFT_PARENTHESIS expression RIGHT_PARENTHESIS                   # parenthesisExpression
          | (PLUS | MINUS | NOT) expression                                 # unaryExpression
          | expression POWER <assoc=right> expression                       # powerExpression
          | expression (MULTIPLICATION | DIVISION | MODULUS) expression     # multiplicationExpression
          | expression (PLUS | MINUS) expression                            # additionExpression

          // Comparators should be combined?
          | expression (SMALLER_THAN expression)+                           # smallerThanExpression        
          | expression (SMALLER_THAN_EQUALS_TO expression)+                 # smallerThanEqualsToExpression                   
          | expression (GREATER_THAN expression)+                           # greaterThanExpression        
          | expression (GREATER_THAN_EQUALS_TO expression)+                 # greaterThanEqualsToExpression                    
          | expression (EQUALS_TO expression)+                              # equalsToExpression        
          | expression (NOT_EQUALS_TO expression)+                          # notEqualsToExpression

          | expression EQUALS_TO expression PLUSMINUS expression            # plusMinusExpression        
          | expression AND expression                                       # andExpression
          | expression OR expression                                        # orExpression
          | LEFT_PARENTHESIS assignment RIGHT_PARENTHESIS                   # assignExpression
          | functioncall                                                    # functionExpression
          | expression (LEFT_BLOCKBRACE expression RIGHT_BLOCKBRACE)        # arrayAccessExpression
          | ENUM DOT IDENTIFIER DOT IDENTIFIER                              # enumExpression
          // Let op; dit matcht zowel records als enums! Opletten in de checker.
          | IDENTIFIER DOT IDENTIFIER                                       # fieldAccessExpression
          | expression DOT IDENTIFIER                                       # recordAccessExpression
          | IDENTIFIER                                                      # variableExpression
          // Voorbeelden: {5, 8} of {getInt(), stoel.aantalPoten, 10} of {}
          | LEFT_BRACE ((expression COMMA)*(expression))? RIGHT_BRACE       # arrayLiteralExpression
          // Voorbeelden: {aantal = getInt(), prijs = catalogus[1], mooi = true} of {}
          | LEFT_BRACE IDENTIFIER((IDENTIFIER BECOMES expression COMMA)* IDENTIFIER BECOMES expression)? RIGHT_BRACE   # recordLiteralExpression
          | NUMBER                                                          # intLiteralExpression
          | BOOL                                                            # boolLiteralExpression
          | CHARACTER                                                       # charLiteralExpression
          | STRING                                                          # stringLiteralExpression
          ;