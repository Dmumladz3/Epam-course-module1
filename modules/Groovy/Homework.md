**Calculator on Groovy**

1. Implement Calculator Using Groovy programming language. 

**Input Parameter**: String to be calculated. It contains numbers, operators and parentheses.
* Support operations +,- with two arguments (1+2) – 1 point 
* Support +,- with unlimited arguments  – 2 point 
* Support *,/ (don’t forget about operations priority)  - 2 point 
* Support bracket operation (“(2+2)*3”) – 2 point 
* Use GString  - 0.5 point 
* Use at least two Groovy specific operators (**|?.|&. etc..) 0.5 point 
* Use Groovy Operator Overloading – 1 point 
* Use Groovy closures – 1 point 

Business logic should be covered by unit tests on groovy with 100%. (-5 point if not covered) 
Extra mile: 
* Use Spock test framework – 2 

*Max mark is 12*

Other comments: 
* Input data can be integer and without spaces (For example: “2+2*(5-7)”) 

Implementation details:  
1. Unzip - GroovyCalculator.zip (attached to the mail) 
2. Use Project GroovyCalculator (which based on maven) as a base project for this task  
3. Finally, your logic should be called from  
   com.epam.cdp.caclulator.GroovyCalculator.calculate() 

    To build project and run test please use “mvn clean install” if you have installed maven on your machine  

Otherwise :  call this goals from your IDE  


Useful links: 
http://groovy-lang.org/documentation.html 

http://spockframework.org/spock/docs/1.1-rc-2/index.html 