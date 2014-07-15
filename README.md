Bramspr Compiler
================

###About
Bramspr is a simple language that can be compiled to JBC (.class files) using the Bramspr compiler.

###Directory structure

    /   antlr/              grammar files for ANTLR4
        docs/               the Javadoc html files of the         documentation.pdf         report discussing the Bramspr language and compiler
Bramspr compiler
        README.md           this file
        src/                Bramspr compiler source
        tests/              Bramspr sourcecode to test the compile levels. The compilerTests folder contains the most interesting (runnable) tests.

Note that the /source/ map also contains the ASM source in /org/objectweb/asm/, as downloaded from the [ASM download page](http://forge.ow2.org/projects/asm/)  (version 4.2).

###How to run
Bramspr.jar is an executable JAR file that contains all the dependencies for running the Bramspr compiler in a Java 7 environment.

To compile a bramspr source file, open the folder containing Bramspr.jar in the console and execute:

    java -jar Bramspr.jar C:\path\to\file.spr
    
Or run
    
    cat /path/to/file.spr | java -jar Bramspr.jar       (linux/Powershell only)
    
This will produce a file "Bramspr.class" in the same directory as the compiler is located. This class file contains the Java bytecode matching the Bramspr source file and can be executed with the following command:

    java Bramspr
    
###How to compile
The Bramspr compiler requires ASM and antlr4. The ASM sourcecode is included in the source folder, the antlr4 library must be in the classpath in order to compile the Bramspr compiler.
