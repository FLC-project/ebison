# Extended bison

This repository contains the ebison parser suite:

   - ebison.jar     jar file of the parsers
   - javalr1e.bnf   java grammar
   - json.bnf       json grammar
   - listjlr1.cmd   list of java test files
   - listjson1.cmd  list of json test files
   - tests          directory of test files
   - Parser.html    EBNF syntax notation

The ebison suite needs Java to run.

To run the tests:

  java -cp ebison.jar -Xmx1g -Xss2m lbj.ParserScope javalr1e.bnf
        listjlr1.cmd /a=elr1p /e
        
  java -cp ebison.jar -Xmx1g -Xss2m lbj.ParserScope json.bnf
        listjson1.cmd /a=elr1p /e

Notes:

  /a=... selects the parser: elr1p = ELR(1), bison = bison
     
  /e     directs the test driver to report the net parse time,
         i.e., with lexing time removed
