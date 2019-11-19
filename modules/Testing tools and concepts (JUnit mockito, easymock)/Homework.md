Testing tools task 

We will create calculator application that execute complex arithmetic expression.  

The implementation of the calculator should be your own. You are not allowed to use any third-parties libraries. 

- The application takes string with the expression to be calculated and generates string output with calculation result or error message.  

- Calculator should works in two modes: console and file mode.  

- In console mode the application takes expression from console and prints result to console. No application parameters should be specified to use this mode. 

- In file mode application takes expression from file and output results to file. To use this mode user should specify input and output file names as application parameters. 

- Expression can contain integer numbers, parentheses with only one level of nesting and simple arithmetic operations (‘+’, ‘-‘, ‘*’, ‘/’). 

- If expression can’t be calculated the application should write error message. 

 

Tasks: 

You should create tests for calculator with the following condition (In scope of this task you can create more than one test to cover the same functionality): 

@Parameterized runner (1 point) 

@Theory and @DataPoints (1 point) 

TemporaryFolder rule (1 point) 

 

Mock reading from file/console (1 point) 

Use partial mock(1 point) 

Use spy (1 point) 

 

Create custom rule to output test execution information to file (1 point) 

Create custom rule to check Exception class and error message text (1 point) 

Test quality and adequate coverage will be assessed as 2 points. 

Don't forget about good tests, checkstyle and other staff that already included into your build phase.