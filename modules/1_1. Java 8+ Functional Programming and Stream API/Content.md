Recommended level: 
Junior / Middle

**Trainings**:
=======================

[Streams and Lambda expressions](https://www.linkedin.com/learning/advanced-java-hands-on-with-streams-lambda-expressions-collections-generics-and-more/functional-programming) 1h

[Java 8 Functional way on practice](https://www.youtube.com/watch?v=zolbIZS4SRQ) 2h 00m

[Java practice functional programming](https://www.linkedin.com/learning/java-practice-functional-programming) 1h

[Functional programming with Java](https://www.linkedin.com/learning/functional-programming-with-java/) 3h

**Video**: 
=======================
- [Functional Programming with Java Streams API](https://www.youtube.com/watch?v=f5j1TaJlc0w)
- [Functional Programming in Java - Full Course](https://www.youtube.com/watch?v=rPSL1alFIjI)
- [Java 8 complete tutorial in 3 hour with Realtime Example](https://www.youtube.com/watch?v=ePJrt5-G8eM&list=PLVz2XdJiJQxzrdrpglCv_nWIO5CDIqOVj)

**References**:
=======================

[Basic Stream operations](https://www.tutorialspoint.com/java/java_streams.htm)

[Creating Streams](https://dev.java/learn/api/streams/creating/)

[Collectors producing maps](https://stackabuse.com/guide-to-java-8-collectors-tomap/https://stackabuse.com/guide-to-java-8-collectors-groupingby/)

[Custom Collectors](https://medium.com/@alxkm/how-to-build-a-custom-collector-in-java-961bc506c57e)

[Functional Interfaces in Java](https://www.scaler.com/topics/functional-interface-in-java/)

[Guide To Java 8 Optional](https://www.baeldung.com/java-optional)

[Java 8 Stream Tutorial](https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/)


**Topics:**
Functional programming in Java allows for a more declarative approach to coding, which can improve readability, simplify code, and reduce side effects.

Without focusing on specific Java versions, functional programming (FP) concepts apply to writing code that emphasizes immutability, declarative syntax, and function composition. Even if your language lacks specific FP features like lambdas or stream processing (introduced in later Java versions), these core ideas are relevant and can be implemented to some extent.

Here's an overview of how functional programming principles can be applied to Java without depending on specific version features.

Key Functional Programming Principles 1. Immutability Concept: Once created, immutable objects cannot be modified. This reduces side effects, making code easier to reason about, especially in concurrent or multi-threaded applications. Implementation: Define class fields as final, ensuring they can only be assigned once. Avoid setter methods or provide only methods that return a new object rather than modifying the current one. Example:

public class ImmutablePoint { private final int x; private final int y;

public ImmutablePoint(int x, int y) {
    this.x = x;
    this.y = y;
}

public int getX() { return x; }
public int getY() { return y; }

// Method to create a new instance rather than modifying this one
public ImmutablePoint move(int dx, int dy) {
    return new ImmutablePoint(x + dx, y + dy);
}
}

First-Class Functions (Simulated) Concept: In functional programming, functions can be passed around as arguments, returned from other functions, and assigned to variables. Implementation: Define a functional interface (like Operation) to simulate passing functions as arguments. Example:
public interface Operation { int execute(int a, int b); }

public class Calculator { public int compute(int a, int b, Operation operation) { return operation.execute(a, b); } }

// Usage public static void main(String[] args) { Calculator calculator = new Calculator(); Operation add = new Operation() { public int execute(int a, int b) { return a + b; } }; System.out.println(calculator.compute(5, 3, add)); // 8 }

Pure Functions Concept: Pure functions always produce the same output for the same input and do not have any side effects (i.e., they don't alter external states). Implementation: Write methods that depend only on their input parameters and avoid modifying any external or shared data. Example:
public class MathUtils { public static int square(int x) { return x * x; } }

// Usage System.out.println(MathUtils.square(5)); // Always 25 for input 5

Declarative vs. Imperative Style Concept: Functional programming favors declarative over imperative code. Declarative code describes what needs to be done without specifying step-by-step instructions. Implementation: Use loops and collections methods to convey your intent rather than manipulating data step-by-step. Example (Imperative vs. Declarative Sum):
// Imperative int sum = 0; int[] numbers = {1, 2, 3, 4, 5}; for (int num : numbers) { sum += num; }

// Declarative (in later versions, this would be a single line using Stream's sum) int declarativeSum = Arrays.stream(numbers).sum();

Higher-Order Functions (Simulated) Concept: Higher-order functions take other functions as arguments or return functions. Implementation: Simulate higher-order functions using interfaces for passing behavior around as in the Operation example above. By using interfaces, you can make a function more flexible and reusable.

Recursive Functions Concept: Functional programming often uses recursion instead of loops, particularly for operations on collections, like calculating a sum or searching. Implementation: Write recursive functions in place of loops, keeping in mind that Java does not optimize tail recursion. Example:

public static int recursiveSum(int[] numbers, int index) { if (index == numbers.length) return 0; return numbers[index] + recursiveSum(numbers, index + 1); }

Function Composition (Simulated) Concept: Combine multiple small functions to form a more complex function. This is common in functional programming to promote modularity and reuse. Implementation: Combine functions by passing output from one function to another. In early Java versions, without lambdas, this requires more boilerplate. Example:
public interface Function<T, R> { R apply(T input); }

public class FunctionComposition { public static <T, R, V> Function<T, V> compose(Function<T, R> f1, Function<R, V> f2) { return input -> f2.apply(f1.apply(input)); } }

// Usage: Function<String, Integer> parse = input -> Integer.parseInt(input); Function<Integer, String> doubleToString = input -> "Double: " + (input * 2); Function<String, String> composedFunction = FunctionComposition.compose(parse, doubleToString);

System.out.println(composedFunction.apply("4")); // Output: "Double: 8"

Avoiding Side Effects Concept: Side effects occur when a function modifies some state outside its scope. Pure functions help avoid this, but it’s still essential to carefully manage state in functional programming. Java Implementation: Avoid modifying global variables or class fields within functions unless absolutely necessary. Favor using immutable variables or returning new objects when state needs to be changed.
Practical Benefits of Functional Programming in Java

Code Readability: Functional patterns can lead to more readable code, especially when chaining operations or working with data. Easier Testing and Debugging: Pure functions with predictable output are easier to test. Improved Concurrency: Immutability and stateless functions make it easier to parallelize code safely.

Functional programming in Java requires a mindset shift more than specific language features. By focusing on immutability, pure functions, and function composition, you can apply these concepts to write cleaner, more maintainable code, regardless of Java version constraints.

Java 8 features: Optionals, Functional interfaces, Lambdas etc.

Java 8 introduced functional programming features that revolutionized the way we write code, making it more expressive, concise, and readable. Functional programming is a programming paradigm where you construct software by composing pure functions, avoiding shared state, mutable data, and side-effects. Java 8 incorporates this paradigm while maintaining compatibility with object-oriented programming. Here’s a high-level overview of key concepts and features introduced with Java 8:

Lambda Expressions Lambda expressions allow you to treat functionality as method arguments or define small anonymous functions. They provide a clear and concise way to represent a single method interface (functional interface).

Syntax:

(parameters) -> expression // or (parameters) -> { statements; } Example: List<String> names = Arrays.asList("John", "Jane", "Jack"); names.forEach(name -> System.out.println(name));

Functional Interfaces A functional interface is an interface with exactly one abstract method, and it can be represented using lambda expressions. Java 8 includes several built-in functional interfaces like Predicate, Function, Consumer, and Supplier in the java.util.function package.
Example: @FunctionalInterface interface Greeting { void sayHello(String name); } You can implement this using a lambda expression:

Greeting greeting = name -> System.out.println("Hello, " + name); greeting.sayHello("John");

Method References Method references provide a shorthand syntax for calling a method in a lambda expression. You can use the :: operator to refer to a method directly.
Types of Method References:

Reference to a static method: ClassName::staticMethod
Reference to an instance method of a particular object: instance::methodName
Reference to an instance method of an arbitrary object of a particular type: ClassName::instanceMethod
Reference to a constructor: ClassName::new Example:
List<Integer> numbers = Arrays.asList(1, 2, 3, 4); numbers.forEach(System.out::println); // Method reference to println

Streams API The Streams API allows you to process sequences of elements in a functional style. You can perform operations like filtering, mapping, and reducing on data collections (like lists or arrays).
Common Stream Operations:

filter(): Select elements based on a condition
map(): Transform elements
reduce(): Combine elements into a single result
- collect(): Convert the stream into a collection
Example:

List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
List<String> filteredNames = names.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());
System.out.println(filteredNames); // Output: [John, Jane, Jack]

Optional Class Java 8 introduced the Optional class to handle null values more gracefully. It helps in avoiding NullPointerException by providing methods to deal with nullable objects.

Example

Optional<String> name = Optional.ofNullable(null); name.ifPresent(n -> System.out.println(n)); // Will not print anything as the value is null

Default and Static Methods in Interfaces Java 8 allows you to add default methods to interfaces. This feature lets you define methods with implementation in an interface, ensuring backward compatibility.
Example:

interface MyInterface { default void defaultMethod() { System.out.println("Default method in interface"); } }

class MyClass implements MyInterface { // No need to implement defaultMethod if not required }

Benefits of Functional Programming in Java: - Conciseness: Code becomes more compact and readable. - Immutability: Reduces bugs by avoiding mutable state. - Parallelism: Stream API supports parallel processing, improving performance. - Maintainability: Code written in functional style is easier to understand and maintain.

Java 8, the introduction of functional programming enables developers to write more efficient, readable, and clean code while maintaining Java’s traditional object-oriented principles.

Difference between OOPS & Functional Programming

In Java, Object-Oriented Programming (OOP) and Functional Programming (FP) are two paradigms that differ in their approach to organizing and structuring code. Here's a comparison between the two:

Core Concepts: OOP: Focuses on objects, which are instances of classes. Classes define the data (attributes) and the behavior (methods) of objects. FP: Focuses on functions as first-class citizens. It emphasizes using pure functions, immutability, and avoiding side effects.
State and Data Handling: OOP: Data is encapsulated within objects. Objects maintain a state, and methods can modify this state. FP: Emphasizes immutability, where data doesn’t change once it’s created. Functions don’t modify state but rather return new values based on input.
Programming Structure: OOP: Code is structured around classes and objects. You use inheritance, polymorphism, and encapsulation to organize and reuse code. FP: Code is structured around functions. Higher-order functions (functions that accept other functions as arguments or return them) are a key feature.
Mutability: OOP: Objects are often mutable. State is changed over time through object methods. FP: Immutability is a key principle. Once created, values cannot change, and any operation returns new values instead of modifying the existing ones.
Execution Model: OOP: Execution revolves around sending messages between objects to change their state or invoke behavior. FP: Execution is modeled as applying functions to arguments. Pure functions, without side effects, allow more predictable and testable code.
Concurrency: OOP: Managing concurrency often involves locks and synchronization to handle mutable shared state. FP: Since FP encourages immutability and pure functions, concurrency is easier to handle. Functions can run in parallel without worrying about shared state.
Key Constructs in Java: OOP in Java: Java is inherently object-oriented. Everything revolves around classes, objects, and inheritance. FP in Java: With Java 8+, functional programming constructs were introduced. Java now supports lambda expressions, streams, and functional interfaces (e.g., Function, Predicate, Consumer) to promote a functional style of programming.
Error Handling: OOP: Errors are often handled through exceptions and object state. FP: Errors are managed through function compositions like Try, Optional, or monadic structures that capture failure states within the function flow.
Example in Java: OOP Example:

class Car { private String model;

public Car(String model) { this.model = model; }

public void drive() { System.out.println(model + " is driving."); } }

Car car = new Car("Toyota"); car.drive();

FP Example:

Function<String, String> drive = model -> model + " is driving."; String result = drive.apply("Toyota"); System.out.println(result);

In Summary: OOP focuses on objects, encapsulation, and mutable state, while FP emphasizes functions, immutability, and avoiding side effects. Java supports both paradigms, especially after Java 8 with the introduction of functional programming features, allowing developers to combine both approaches as needed.

Optionals :

Optional is a class introduced in Java 8 as part of the java.util package to represent the presence or absence of a value in a more expressive and safe way, reducing the chances of encountering NullPointerException (NPE). It allows developers to explicitly specify when a variable might not hold a value, encouraging more robust and null-safe code.

Key Concepts:

Purpose:

Optional is used to encapsulate a value that might or might not be present. It provides methods to deal with values that can be null in a more elegant way, reducing the need for explicit null checks. Creating an Optional:

You can create an Optional instance in several ways:

Empty Optional: Represents no value. Optional<String> empty = Optional.empty(); Non-Null Value Optional: Represents a non-null value.

Optional<String> optional = Optional.of("Hello"); Nullable Optional: Can hold either a value or be empty (null-safe).

Optional<String> optionalNullable = Optional.ofNullable(null);

Checking for Value: Instead of checking for null, Optional provides methods like: isPresent(): Checks if a value is present. if (optional.isPresent()) { // Value is present } ifPresent(): Performs an action if a value is present, eliminating the need for null checks. optional.ifPresent(value -> System.out.println(value));

Retrieving Values: To retrieve the value from an Optional, you can use: get(): Returns the value if present, but throws NoSuchElementException if it’s empty (use with caution). String value = optional.get(); orElse(): Returns the value if present, otherwise provides a default value.

String value = optional.orElse("Default Value"); orElseGet(): Similar to orElse(), but takes a Supplier to lazily supply the default value.

String value = optional.orElseGet(() -> "Lazy Default Value"); orElseThrow(): Throws a custom exception if the value is absent.

String value = optional.orElseThrow(() -> new IllegalStateException("Value not found!"));

Functional Methods: Optional supports several functional programming-inspired methods, allowing for more streamlined and concise code:

map(): Transforms the value if present and returns a new Optional. Optional<String> upperCase = optional.map(String::toUpperCase);
flatMap(): Similar to map(), but used when the transformation itself returns an Optional (avoiding nested Optional<Optional<T>>). Optional<Integer> length = optional.flatMap(str -> Optional.of(str.length()));
filter(): Filters the value based on a condition and returns an Optional. If the condition is false, it returns an empty Optional. Optional<String> filtered = optional.filter(str -> str.length() > 3);
Benefits: 1. Null Safety: Optional encourages handling potential null values explicitly, reducing the chances of NullPointerException. 2. Readable Code: Using Optional methods like ifPresent(), orElse(), and filter() makes the intent clearer and eliminates cumbersome null checks. 3. Functional Style: It integrates well with Java's functional programming features, allowing for concise and expressive code.

Limitations:

Not for Fields or Method Parameters: Optional is not recommended for class fields or method parameters. It is mainly intended for return types to indicate an absent or present value.
Overhead: Wrapping values in Optional can introduce some overhead in terms of performance, especially when overused or misused.
Use Wisely: Overusing Optional in situations where null handling is simpler can complicate code unnecessarily.
Example Usage: public Optional<String> getUsernameById(int id) { if (id == 1) { return Optional.of("JohnDoe"); } else { return Optional.empty(); } }

Optional<String> username = getUsernameById(2); username.ifPresent(name -> System.out.println("Username: " + name)); // Will not print anything

String name = username.orElse("Unknown User"); System.out.println("Name: " + name); // Prints "Unknown User"

In Summary: Optional is a powerful tool to handle values that might be absent without resorting to null checks. It encourages safe and clean handling of optional values and promotes a more declarative style of programming. However, use Optional thoughtfully and only when dealing with method return types that may legitimately be absent.

Functional Interfaces

A Functional Interface in Java is an interface that contains only one abstract method (though it can have multiple default or static methods). These interfaces are used as the foundation of lambda expressions and method references, enabling a functional programming style in Java. Functional interfaces were introduced in Java 8 to facilitate writing concise and readable code by passing behavior (functions) as arguments to methods.

Key Characteristics: 1.Single Abstract Method (SAM) : A functional interface must have exactly one abstract method. This is the method that the lambda expression or method reference will implement.

2.Default and Static Methods: Even though functional interfaces must have only one abstract method, they can have any number of default or static methods with implementation.

3.@FunctionalInterface Annotation: This is an optional annotation that can be added to indicate that the interface is intended to be functional. If the interface does not adhere to the functional interface contract (i.e., more than one abstract method), the compiler will generate an error.

Common Functional Interfaces in Java:

Java provides several built-in functional interfaces in the java.util.function package, which can be used in various contexts:

Function<T, R>: Represents a function that takes an argument of type T and returns a result of type R. Function<String, Integer> lengthFunction = str -> str.length();

Predicate<T>: Represents a function that takes an argument of type T and returns a boolean (used for conditions). Predicate<String> isEmpty = str -> str.isEmpty();

Consumer<T>: Represents a function that takes an argument of type T but returns no result (typically used for performing actions like logging or printing). Consumer<String> printConsumer = System.out::println;

Supplier<T>: Represents a function that takes no arguments but returns a result of type T (often used to lazily generate values). Supplier<Double> randomValue = () -> Math.random();

BinaryOperator<T>: Represents a function that takes two arguments of the same type T and returns a result of the same type. BinaryOperator<Integer> sum = (a, b) -> a + b;

Runnable: A functional interface from earlier Java versions that represents a task that takes no arguments and returns no result. Runnable task = () -> System.out.println("Task executed");

Benefits of Functional Interfaces:

Concise Code with Lambdas: Functional interfaces allow the use of lambda expressions, which result in more concise and readable code by reducing boilerplate (no need to create anonymous inner classes).
Improved Readability: By passing behavior as an argument (instead of creating classes or implementing methods), functional interfaces improve the readability of code, especially in contexts like streams or event handling.
Enhanced Flexibility: Functional interfaces enable more flexible programming patterns, especially in functional-style constructs such as map(), filter(), forEach(), etc., which are heavily used with streams.
Easier Testing: Lambda expressions simplify testing by allowing you to easily pass mock behaviors into functions, reducing dependencies on complex class structures.
Example of Functional Interface: Traditional Anonymous Class Example (Pre-Java 8): public class Main { public static void main(String[] args) { Runnable runnable = new Runnable() { @Override public void run() { System.out.println("Running..."); } }; runnable.run(); } }

**With Functional Interface Using Lambda **: public class Main { public static void main(String[] args) { Runnable runnable = () -> System.out.println("Running..."); runnable.run(); } } In the above example, Runnable is a functional interface with a single abstract method, run(). The lambda expression () -> System.out.println("Running...") provides the implementation for that method in a more concise way.

Custom Functional Interface Example: You can also create your own functional interfaces.

@FunctionalInterface interface Greeting { void sayHello(String name); }

Using the custom functional interface with a lambda:

Greeting greet = (name) -> System.out.println("Hello, " + name); greet.sayHello("John");

Important Functional Interfaces in java.util.function:

UnaryOperator<T>: Takes one argument of type T and returns a value of the same type. UnaryOperator<Integer> square = x -> x * x;

BiFunction<T, U, R>: Takes two arguments of types T and U and returns a result of type R. BiFunction<Integer, Integer, String> sumString = (a, b) -> "Sum: " + (a + b);

@FunctionalInterface Annotation: Although it’s optional, it’s a good practice to use the @FunctionalInterface annotation to ensure that the interface adheres to the functional interface contract. It also signals to other developers that the interface is meant to be used with lambda expressions or method references.

@FunctionalInterface interface Calculator { int calculate(int a, int b); }

In Summary: Functional Interfaces allow for the implementation of single abstract method contracts using lambda expressions or method references. They are a key enabler for functional programming in Java, allowing more expressive, compact, and flexible code. Java provides many built-in functional interfaces like Function, Predicate, Supplier, Consumer, and more, making it easier to work with collections and functional constructs. You can also create custom functional interfaces to tailor behavior specific to your application's needs.

Lambda Expressions

Lambda Expressions were introduced in Java 8 as a powerful feature that allows you to write concise, expressive, and functional-style code by simplifying how you pass behavior (functions) as arguments. Lambda expressions enable the implementation of functional interfaces without the need for creating anonymous inner classes, making code more readable and reducing boilerplate.

Key Characteristics: 1. Conciseness: Lambda expressions allow you to write more compact code compared to anonymous inner classes. 2. Functional Programming: Lambdas enable a more functional programming style in Java by allowing behavior to be passed as a first-class entity (functions). 3. Integration with Streams: Lambdas are widely used in the Streams API, making it easier to write declarative code for manipulating collections. 4. Lambda Expression Syntax: A lambda expression consists of three parts:

Parameters: The input parameters to the lambda. Arrow (->): Separates the parameters from the body of the lambda expression. Body: The code that is executed when the lambda is invoked. (parameters) -> expression If there is more than one statement in the body, curly braces {} are required. (parameters) -> { // multiple statements here } Lambda Expression Examples:

No Parameters: Runnable runnable = () -> System.out.println("Running..."); runnable.run();
Single Parameter: If there is only one parameter, parentheses are optional: Consumer<String> printConsumer = message -> System.out.println(message); printConsumer.accept("Hello, World!");
Multiple Parameters: BinaryOperator<Integer> sum = (a, b) -> a + b; System.out.println(sum.apply(5, 3)); // Output: 8

Multiple Statements in the Body: Comparator<String> comparator = (s1, s2) -> { int result = s1.length() - s2.length(); return result == 0 ? s1.compareTo(s2) : result; };

Functional Interface Compatibility: Lambda expressions in Java can only be used with functional interfaces (interfaces with a single abstract method). This is because a lambda expression must provide an implementation for one and only one method. @FunctionalInterface interface MathOperation { int operate(int a, int b); } MathOperation addition = (a, b) -> a + b; System.out.println(addition.operate(10, 5)); // Output: 15

Type Inference: The type of parameters in a lambda expression is inferred from the context, based on the target functional interface. This means you can omit the parameter types in many cases:

BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b; If needed, you can explicitly declare parameter types: BiFunction<Integer, Integer, Integer> multiply = (Integer a, Integer b) -> a * b;

Common Use Cases for Lambda Expressions: Event Handling: Replacing anonymous classes for event-driven programming.

button.setOnAction(event -> System.out.println("Button clicked!")); Collections and Streams: Manipulating collections using functional programming constructs.

List<String> names = Arrays.asList("John", "Jane", "Adam"); names.stream() filter(name -> name.startsWith("J")) forEach(System.out::println);

Simplifying the creation of new threads.

new Thread(() -> System.out.println("Thread running")).start(); Comparator: Implementing sorting logic more concisely.

List<String> list = Arrays.asList("apple", "orange", "banana"); Collections.sort(list, (s1, s2) -> s1.compareTo(s2));

Benefits of Lambda Expressions: -Reduced Boilerplate: Lambda expressions significantly reduce the amount of code compared to traditional anonymous classes. -Improved Readability: By eliminating the need for verbose anonymous classes and enabling the expression of behavior directly in methods, lambdas improve code readability. -Functional Programming Style: Lambda expressions allow Java developers to adopt a functional programming paradigm, particularly when combined with the Streams API. -Reusability and Flexibility: Lambda expressions can be passed as arguments or returned from methods, enhancing the flexibility of Java code.

Limitations:

-Functional Interface Dependency: Lambdas can only be used with functional interfaces, meaning they rely on interfaces with a single abstract method. -Debugging: Since lambdas do not have a name or class structure like traditional methods, debugging lambda expressions can sometimes be challenging. -Not for All Use Cases: While lambdas are concise and expressive, they are not always the best choice for more complex logic that requires more structure and clarity, in which case traditional classes or methods may be preferable. Example: Sorting with Lambdas Before Java 8, sorting a list by string length using an anonymous inner class looked like this:

List<String> names = Arrays.asList("John", "Jane", "Adam"); Collections.sort(names, new Comparator<String>() { @Override public int compare(String s1, String s2) { return Integer.compare(s1.length(), s2.length()); } }); With lambda expressions, this becomes more concise:

Collections.sort(names, (s1, s2) -> Integer.compare(s1.length(), s2.length())); Method References: Lambda expressions can also be replaced by method references where appropriate. Method references allow you to refer to methods or constructors directly using :: syntax.

For example, using a method reference:

List<String> names = Arrays.asList("John", "Jane", "Adam"); names.forEach(System.out::println);

In Summary: -Lambda Expressions provide a concise and functional way to represent instances of functional interfaces. -They reduce boilerplate, improve readability, and allow developers to write more declarative code, especially when used with the Streams API. -By embracing functional programming, lambdas enhance the flexibility of code, though they come with some limitations, such as reliance on functional interfaces and more challenging debugging in certain scenarios.

Java 9 features Java 9 introduced several new features that make Java more powerful and easier to work with. we'll cover some of the most important features and provide examples to help you understand how to use them.

Module System (Project Jigsaw)

What Is It? The Module System is one of the most significant features of Java 9. It allows developers to organize code into modules, which are like packages but at a higher level. This helps to manage complex applications by breaking them into smaller, more manageable units.

Key Concepts: Module: A self-contained unit of code that has its own module-info.java file. Requires: Used to declare dependencies on other modules. Exports: Specifies which packages are accessible to other modules.

Example: Let's create two modules: com.example.hello and com.example.world.

1.com.example.hello Package: com.example.hello Class: Hello.java

package com.example.hello; public class Hello { public void sayHello() { System.out.println("Hello from Hello module!"); } }

2.module-info.java for com.example.hello

module com.example.hello { exports com.example.hello; // Export this package to other modules }

3.com.example.world Package: com.example.world Class: World.java

package com.example.world;

import com.example.hello.Hello;

public class World { public static void main(String[] args) { Hello hello = new Hello(); hello.sayHello(); System.out.println("Hello from World module!"); } }

4.module-info.java for com.example.world

module com.example.world { requires com.example.hello; // Requires Hello module } Running the Modules: You compile and run the code using the following commands:

bash javac -d mods/com.example.hello com/example/hello/Hello.java com/example/hello/module-info.java javac --module-path mods -d mods/com.example.world com/example/world/World.java com/example/world/module-info.java java --module-path mods -m com.example.world/com.example.world.World

JShell (REPL)
What Is It? JShell is a new interactive tool introduced in Java 9 that allows you to execute Java code snippets directly without creating a full program. It’s particularly useful for trying out new code quickly and learning Java.

How to Use: You can start JShell by typing jshell in your terminal or command prompt.

Example: Start JShell: bash jshell Enter the following commands in JShell: jshell> int a = 10; a ==> 10

jshell> int b = 20; b ==> 20

jshell> int sum = a + b; sum ==> 30

jshell> System.out.println("Sum is: " + sum); Sum is: 30 You can exit JShell by typing:

jshell> /exit

Improved Stream API Java 9 introduced several new methods to the Stream API, making it more powerful and easier to work with.
Example: takeWhile(): Returns elements until a condition becomes false. dropWhile(): Drops elements until a condition becomes false.

Example:

import java.util.List; import java.util.stream.Collectors; import java.util.stream.Stream;

public class StreamExample { public static void main(String[] args) { List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) .takeWhile(n -> n < 5) .collect(Collectors.toList()); System.out.println("Numbers less than 5: " + numbers); List<Integer> droppedNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) .dropWhile(n -> n < 5) .collect(Collectors.toList()); System.out.println("Numbers after dropping less than 5: " + droppedNumbers); } } 4. Private Methods in Interfaces Java 9 allows you to write private methods inside interfaces. This helps in avoiding code duplication in default methods. Example:

interface Greeting { default void sayHello() { say("Hello"); }

default void sayGoodbye() { say("Goodbye"); }

private void say(String message) { System.out.println(message); } }

public class PrivateMethodInterfaceExample implements Greeting { public static void main(String[] args) { PrivateMethodInterfaceExample example = new PrivateMethodInterfaceExample(); example.sayHello(); // Output: Hello example.sayGoodbye(); // Output: Goodbye } }

5. HTTP/2 Client API

Java 9 introduces a new HTTP client API that supports HTTP/2 and WebSocket.

Example:

import java.net.URI; import java.net.http.HttpClient; import java.net.http.HttpRequest; import java.net.http.HttpResponse;

public class Http2Example { public static void main(String[] args) throws Exception { HttpClient client = HttpClient.newHttpClient(); HttpRequest request = HttpRequest.newBuilder() .uri(new URI("https://jsonplaceholder.typicode.com/posts")) .build();

HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); System.out.println("Response: " + response.body()); } } 6. Enhanced Process API Java 9 improves the Process API, allowing you to get more information about system processes.

Example:

import java.io.IOException;

public class ProcessAPIExample { public static void main(String[] args) throws IOException { ProcessHandle processHandle = ProcessHandle.current(); System.out.println("Process ID: " + processHandle.pid()); System.out.println("Is process alive: " + processHandle.isAlive()); System.out.println("Process user: " + processHandle.info().user().orElse("Unknown")); } }

Multi-Release JAR Files Java 9 allows creating multi-release JAR files, enabling you to ship different versions of the same class for different Java versions.
Example: Create different versions of a class for Java 8 and Java 9.During runtime, Java will automatically pick the appropriate version based on the Java version being used.

Conclusion:

Java 9 introduces numerous features that enhance productivity, performance, and modularity. The Module System, JShell, improvements in the Stream API, and the new HTTP/2 Client are just a few of the many features that make Java 9 a major upgrade.

Java 10 features
Java 10, released in March 2018, brought several improvements and enhancements to the Java platform. Though it was a relatively smaller release compared to Java 9, Java 10 introduced important features that further improved developer productivity, performance, and memory management.

Local Variable Type Inference (var)
What Is It? Java 10 introduced local variable type inference, which allows the use of the var keyword to declare local variables. The compiler infers the type of the variable from the context, making the code more concise while maintaining type safety.

Example:

public class VarExample { public static void main(String[] args) { var message = "Hello, Java 10!"; System.out.println(message);

var number = 10; // The compiler infers it as int System.out.println(number); } }

Key Points: - var can only be used for local variables inside methods, constructors, and loops. - It cannot be used for class fields or method parameters. - The inferred type is determined at compile time, so it doesn't reduce type safety.

Garbage Collector (GC) Improvements What Is It? Java 10 introduced improvements to the garbage collection process, focusing on better memory management and performance.
Key Changes: Parallel Full GC for G1: The G1 garbage collector, introduced in Java 9, was enhanced to perform full garbage collection in parallel, improving performance for applications with large heaps.

Heap Allocation on Alternative Memory Devices: Java 10 allows the JVM to allocate the Java heap on alternative memory devices, such as NV-DIMM (Non-Volatile Dual In-Line Memory Module), which can be faster than traditional RAM in certain use cases.

Application Class-Data Sharing (CDS) What Is It? Java 10 extended Class-Data Sharing (CDS) to allow the sharing of application classes across different JVM processes. This improves startup time and reduces memory footprint, as the shared classes are loaded only once and reused by multiple JVM processes.
Key Points:

Prior to Java 10, CDS was limited to sharing system classes. With Java 10, you can now include application classes. Helps reduce memory usage, especially in environments where multiple JVMs are running the same application.

Time-Based Release Versioning What Is It?
Java 10 introduced a new versioning scheme for the JDK. Instead of large, irregular feature releases, Java now follows a time-driven release cycle, with new versions coming every six months.

Example: Java versions now follow a format like X.Y.Z, where:

X: Major version (e.g., 10) Y: Feature release number (e.g., 0 for the initial release) Z: Patch version (e.g., 1 for minor updates or security patches) Key Points: The six-month release cycle ensures a more predictable and manageable update process. Features that aren’t ready by a release date will be postponed to the next version.

Thread-Local Handshakes What Is It?
Java 10 introduced Thread-Local Handshakes, which improve how the JVM manages tasks that require stopping all Java threads (e.g., garbage collection). This feature allows the JVM to stop individual threads and not the entire JVM.

Benefits: Improved performance in certain situations, especially when performing garbage collection or safepoint operations. Allows for finer control of thread management without halting the entire JVM, reducing overhead in multi-threaded applications.

Root Certificates What Is It? Java 10 included a set of default root certificates in the JDK. These certificates are part of the OpenJDK distribution, providing a trust anchor for TLS (Transport Layer Security) connections.
Key Points:

-Previously, root certificates were primarily available in the Oracle JDK, but Java 10 made them available in OpenJDK as well. -Helps improve security out of the box by providing a pre-defined set of trusted certificates.

Experimental Java-Based JIT Compiler What Is It?
Java 10 included an experimental just-in-time (JIT) compiler called Graal, which is written in Java. The Graal compiler is intended to improve performance and eventually replace the existing JIT compilers (C1 and C2).

Key Points: -The Graal JIT compiler is not enabled by default in Java 10, but it can be tested by enabling the experimental JVM options. -It's part of a broader goal to improve runtime optimization and allow more flexible code generation.

8.Optional Garbage-Collector Interface What Is It?

Java 10 introduced a new Garbage-Collector Interface, which allows different garbage collectors to be plugged into the JVM without modifying the core codebase. This decouples the garbage collector implementation from the JVM, making it easier to experiment with or swap different collectors.

Key Points: -Provides a cleaner and more modular way to implement different garbage collection algorithms. -Helps in testing new garbage collection strategies or using custom collectors. 9. Immutable Collections Enhancements What Is It?

While introduced in Java 9, immutable collection factories (List.of(), Set.of(), etc.) were further enhanced in Java 10 for better usability and performance. Java 10 adds more optimized factory methods for immutable collections.

Example:

import java.util.List;

public class ImmutableCollectionExample { public static void main(String[] args) { List<String> names = List.of("Alice", "Bob", "Charlie"); System.out.println(names); // names.add("David"); // UnsupportedOperationException because the list is immutable } }

Heap Allocation on Alternative Memory Devices What Is It?
Java 10 allows the Java heap to be allocated on alternative memory devices, such as Non-Volatile Memory (NVM) devices. This is beneficial for environments with large memory footprints and specialized hardware.

Key Points: -Helps improve performance in applications running on systems with different memory tiers. -Useful in environments where fast memory allocation is crucial, such as large-scale enterprise applications or high-performance computing.

Conclusion: While Java 10 was not as groundbreaking as Java 9, it introduced several useful features that improved developer productivity and system performance. Features like local variable type inference (var), garbage collection improvements, application class-data sharing (CDS), and Thread-Local Handshakes show that Java is continuously evolving to meet modern software demands. Java 10 also set the stage for future, more frequent Java releases, making it an important milestone in the language’s development.

Java 11 features

Java 11, released in September 2018, was a Long-Term Support (LTS) release, meaning it received extended support from Oracle and other vendors. It brought numerous features, updates, and removals to the Java platform, enhancing developer productivity, performance, and modernizing the language further. Here are the major features and changes introduced in Java 11:

New var in Lambda Parameters What Is It?
Java 11 extends the use of the var keyword to lambda expressions, allowing developers to declare lambda parameters using var. This provides consistency with local variable declarations and makes it easier to apply modifiers like annotations.

Example:

import java.util.List;

public class VarLambdaExample { public static void main(String[] args) { List<String> names = List.of("Alice", "Bob", "Charlie");

// Lambda expression using 'var' for parameter type names.forEach((var name) -> System.out.println(name)); } }

Key Points:

-You can now use var to infer the type of lambda parameters. -All parameters in a lambda expression must use var or none. -var allows adding annotations to lambda parameters, which was not possible without explicit type declarations.

New HTTP Client (Standard) What Is It?
Java 11 introduced the new HTTP Client API as a standard feature (previously incubated in Java 9 and 10). It supports HTTP/1.1 and HTTP/2, and simplifies writing HTTP requests in Java, allowing both synchronous and asynchronous requests.

Example:

import java.net.URI; import java.net.http.HttpClient; import java.net.http.HttpRequest; import java.net.http.HttpResponse;

public class HttpClientExample { public static void main(String[] args) throws Exception { HttpClient client = HttpClient.newHttpClient(); HttpRequest request = HttpRequest.newBuilder() .uri(new URI("https://jsonplaceholder.typicode.com/posts")) .build();

HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); System.out.println("Response: " + response.body()); } }

Key Points:

-Simplifies working with HTTP requests in Java. -Supports both synchronous (send()) and asynchronous (sendAsync()) requests. -Built-in support for HTTP/2 and WebSocket.

Running Java Files with java Command What Is It?
Java 11 allows you to run single Java source files directly without needing to compile them first. This makes it easier to write small scripts or quick tests in Java, simplifying the development process for small programs.

Example: Save a file named HelloWorld.java:

public class HelloWorld { public static void main(String[] args) { System.out.println("Hello, Java 11!"); } } Now you can run it directly using the java command without compiling:

bash : java HelloWorld.java

Key Points:

-No need to compile the code with javac. Just use java <filename>.java. -Great for small, quick programs or scripts.

Nest-Based Access Control What Is It?
Java 11 introduced nest-based access control, which improves how the JVM handles access between nested classes (i.e., inner classes and outer classes). It resolves issues where nested classes could not access each other's private members without synthetic bridge methods.

Key Points:

-Nests: A new concept that groups nested classes together, allowing them to access each other’s private fields and methods directly. -It improves the encapsulation and performance of nested classes.

Deprecation of Nashorn JavaScript Engine What Is It?
The Nashorn JavaScript Engine, introduced in Java 8 to allow Java programs to run JavaScript code, was deprecated in Java 11. JavaScript’s evolving standards and the availability of better alternatives (e.g., GraalVM) led to this decision.

Key Points:

-Nashorn is no longer actively developed and will be removed in future versions. -Developers are encouraged to switch to other JavaScript engines or use the GraalVM polyglot runtime.

String API Improvements
Java 11 introduced several useful methods for the String class, making it easier to work with strings.

New Methods:

-isBlank(): Checks if a string is empty or contains only white spaces. -lines(): Returns a stream of lines from a string, split by line terminators. -strip(): Removes leading and trailing white spaces (similar to trim(), but it handles Unicode). -repeat(int n): Returns a string repeated n times. -stripLeading() and stripTrailing(): Strip white spaces from the beginning or end of a string.

Example:

public class StringExample { public static void main(String[] args) { String str = " Hello, Java 11 ";

System.out.println("Is blank: " + str.isBlank()); // false System.out.println("Stripped: '" + str.strip() + "'"); // "Hello, Java 11" System.out.println("Repeated: " + "Hi!".repeat(3)); // "Hi!Hi!Hi!"

String multiLine = "line1\nline2\nline3"; multiLine.lines().forEach(System.out::println); // line1, line2, line3 } } 7. Collection API Improvements

Java 11 added new methods to the Collection interface, including the toArray() method that allows you to create arrays directly from collections.
Example:

import java.util.List;

public class CollectionExample { public static void main(String[] args) { List<String> names = List.of("Alice", "Bob", "Charlie");

// Convert list to an array String[] nameArray = names.toArray(String[]::new);

for (String name : nameArray) { System.out.println(name); // Prints Alice, Bob, Charlie } } }

New Files API Methods Java 11 improved the Files class, adding several new methods to work with files more efficiently.
New Methods: -writeString(): Writes a string to a file. -readString(): Reads all content from a file as a string.

Example:

import java.nio.file.Files; import java.nio.file.Path;

public class FilesExample { public static void main(String[] args) throws Exception { Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Hello, Java 11!"); System.out.println("Written to file: " + Files.readString(path)); } }

Optional API Enhancements Java 11 enhances the Optional class with new methods that improve null-handling and reduce boilerplate code.
New Methods: -isEmpty(): Returns true if the Optional is empty.

Example:

import java.util.Optional;

public class OptionalExample { public static void main(String[] args) { Optional<String> opt = Optional.of("Hello");

System.out.println(opt.isEmpty()); // false opt.ifPresent(System.out::println); // Hello } }

Removal of Java EE and CORBA Modules
Java 11 removed Java EE (e.g., JAXB, JAX-WS) and CORBA modules, which were deprecated in earlier versions. These are no longer part of the JDK and need to be included as external libraries if needed

Key Points: Java EE (now Jakarta EE) APIs like JAXB, JAX-WS, and other related modules are no longer bundled with the JDK. Developers should include these APIs via external libraries if their applications depend on them.

Conclusion: Java 11 was a significant release, as it was the first Long-Term Support (LTS) version after Java 8. It introduced several productivity-enhancing features like var in lambda expressions, a modern HTTP Client, and String API improvements. With the new Nest-Based Access Control and the removal of obsolete technologies (Nashorn and Java EE modules), Java 11 modernized the platform while maintaining compatibility and improving performance. It also set the foundation for more frequent and incremental releases in the future.

Java 17 features

Java 17, released in September 2021, is an important milestone as it is a Long-Term Support (LTS) version, meaning it will receive extended support and updates, making it highly recommended for production use. Java 17 brings several key updates, new features, and enhancements that improve performance, security, and developer productivity.

Key Features and Enhancements in Java 17 1.** Sealed Classes (JEP 409)** Purpose: Sealed classes let you control which classes can extend or implement a particular class or interface. This feature increases code clarity and control over class hierarchies. Usage:

public abstract sealed class Shape permits Circle, Rectangle { } public final class Circle extends Shape { /* ... / } public final class Rectangle extends Shape { / ... */ } Benefit: Improves security and maintainability by clearly defining inheritance constraints, making the codebase easier to understand and extend safely.

Pattern Matching for switch (Preview) (JEP 406) Purpose: Pattern matching for switch simplifies complex switch statements, allowing for matching against types directly in switch cases. Usage:
static String formatShape(Shape shape) { return switch (shape) { case Circle c -> "Circle with radius " + c.radius(); case Rectangle r -> "Rectangle with area " + r.area(); default -> "Unknown shape"; }; } Benefit: Increases code readability and reduces boilerplate by allowing type checks and casts directly within switch cases.

Enhanced switch Statements (JEP 406) Purpose: The switch expression, which was introduced in Java 12, is now more powerful and can handle multiple patterns in a single line, simplifying conditional logic. Benefit: Allows for more concise, expressive, and error-resistant code.

Removal of the Deprecated SecurityManager (JEP 411) Purpose: The SecurityManager, introduced in Java 1.0, was deprecated due to its limited adoption and performance overhead. Java 17 officially removes it. Impact: Applications relying on SecurityManager will need to find alternative security measures.

Foreign Function & Memory API (Incubator) (JEP 412) Purpose: Provides an API for interoperability between Java and native code, such as C libraries. It introduces a way to access native memory safely and efficiently. Usage: Java programs can now call functions written in other languages without the need for the Java Native Interface (JNI). Benefit: Offers a more efficient, lower-overhead way to integrate Java with native libraries, boosting performance for applications that need it.

Context-Specific Deserialization Filters (JEP 415) Purpose: Enhances Java’s security by allowing applications to filter serialized data during deserialization. This helps prevent security risks, such as deserialization attacks. Usage: ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("maxdepth=5;package=java.util,java.lang"); Benefit: Improves security by allowing fine-grained control over what is allowed during deserialization.

Removal of Experimental AOT and JIT Compilers (JEP 410) Purpose: Java 17 removes the ahead-of-time (AOT) and just-in-time (JIT) compilers, which were introduced experimentally but saw little adoption. Impact: Reduces Java’s codebase complexity, but developers who relied on AOT/JIT compilers may need to consider alternatives.

New macOS Rendering Pipeline (JEP 382) Purpose: Provides a Java 2D rendering pipeline for macOS based on the Apple Metal API, replacing the deprecated OpenGL-based pipeline. Benefit: Ensures improved compatibility and performance for Java applications on macOS.

New HexFormat API Purpose: The HexFormat class was added to simplify formatting and parsing hexadecimal data. Usage: HexFormat formatter = HexFormat.of(); String hex = formatter.formatHex(new byte[]{0x1A, 0x2B, 0x3C}); Benefit: Reduces the need for third-party libraries for hex manipulation, making it easier to work with binary data in applications.

Removal of Deprecated APIs Java 17 has removed some APIs that were previously deprecated, including the Applet API, making the platform cleaner and leaner. Performance Improvements and Miscellaneous Changes Java 17 includes several performance improvements across the platform, including enhancements to the G1 and ZGC garbage collectors, which now offer improved startup times and reduced memory footprint.
