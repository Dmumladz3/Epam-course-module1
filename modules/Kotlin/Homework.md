**Calculator on Kotlin**

Implement Calculator Using Kotlin programming language. 

**Input Parameter**: String to be calculated. It contains numbers, operators and parentheses.
* Support operations +,- with two arguments `1+2` – 1 point 
* Support +,- with unlimited arguments  – 2 point 
* Support *,/ (don’t forget about operations priority)  - 2 point 
* Support bracket operation `(2+2)*3` – 2 point 
* Use String templates  - 1 point  
* Use Operator Overloading – 1 point 
* Use Lambdas – 1 point 
* Use Extensions – 1 point 
* Use Data classes – 1 point 

Business logic should be covered by unit tests on Kotlin with 100%. (-5 point if not covered) 
Extra mile: 
* Use Kotest test framework – 2

or

* Use Spek test framework – 2

*Max mark is 14*

Other comments: 
* Input data can be integer and without spaces (For example: `2+2*(5-7)`)
* Precision = 4 digits after decimal point (For example: `1/3` = `0.3333`) 

Implementation details:  
1. Unzip - KotlinCalculator.zip (attached to the mail) 
2. Use Project KotlinCalculator (which based on gradle) as a base project for this task  
3. Finally, your logic should be called from  
   com.epam.cdp.calculator.KotlinCalculator.calculate() 

To build project and run test please use `./gradlew clean test`  

Otherwise: call this goals from your IDE  


https://github.com/kotest/kotest/blob/master/doc/reference.md#getting-started
https://www.spekframework.org/ 