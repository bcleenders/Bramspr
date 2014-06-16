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

assignment: (assignable BECOMES)+ expression;
swap: assignable SWAP assignable;

expression: atomic
          | ( PLUS | MINUS | NOT ) expression
          | expression POWER <assoc=right> expression
          | expression ( MULTIPLICATION | DIVISION | MODULUS ) expression
          | expression ( PLUS | MINUS ) expression
          ;
            
assignable: IDENTIFIER fieldAccess
          | IDENTIFIER
          ;

atomic : LEFT_PARENTHESIS expression RIGHT_PARENTHESIS
       | assignable
       | functionCall fieldAccess
       | literal
       ;


fieldAccess : DOT IDENTIFER fieldAccess?
            | LEFT_BLOCKBRACE expression RIGHT_BLOCKBRACE fieldAccess?
            ;

literal : NUMBER
        | CHARACTER
        | STRING
        | BOOL
        | arrayLiteral
        | compositeLiteral
        ;