1. Groovy language 

 1.1 Implement Calculator Using Groovy programming language. 
  Input Parameter: String to be calculated. It contains numbers, operators and parentheses. 

1.1.1 Support operations +,- with unlimited arguments (1+2) – 0,5 point 

1.1.2 Support *,/ (don’t forget about operations priority) – 0,5 point 

1.1.3 Support bracket operation (“(2+2)*3”) – 0,5 point 

1.1.4 Use GString, Groovy Operator Overloading, Groovy closures - 0.5 point 

1.1.5 Use at least two Groovy specific operators (**|?.|&. etc..) 0.5 point

Input data can be integer and without spaces (For example: “2+2*(5-7)”) 

2. Build tools 

2.1 Download archive with sources of multi module project with the following structure: 
jar <-- admin \ 
                   |----services --- utils 
war <-- web / 

2.2 Create Maven and Gradle build scripts to build the project. Two artifacts – war (for web module) and jar (for admin module) should be generated as a result of script running. Also, you need to create README file with build instructions. 

2.3. Task details: 

2.3.1.    Only one project should be in your repository. Build scripts for different build tools should be in the root directory of the project. 

2.3.2.    Repository MUST not contain result artifacts (jar, war). 

2.3.3.    README file should contain instructions to build project via Maven, Gradle tools. Instructions must contain command line to start build project. 

2.3.4.    Build script should allow test running. Details about how to run tests should be written in README. 

2.3.5.    Task will not be accepted if you generate scripts by any generation tools (for example, Gradle from Maven script). 

2.3. Max mark for this part – 2.5 points 

1 Extra mile. Use Spock test framework 1 point 

2 Extra mile. Create Gradle plugin (using Groovy language) for version number generation. It should take 2 integer values from gradle.properties file, environment identifier from console and combine these value according to pattern {majorVersion}.{minorVersion}-{envDescription}. envDescription variable has two possible values: LOCAL – for local builds, RELEASE – for Jenkins builds. - 1 point 