# TDD Exercises for Java Developers

## **Test-Driven Development (TDD) Overview**

Test-Driven Development (TDD) is a software development approach that emphasizes writing tests **before** implementing the code. It follows a structured **Red-Green-Refactor** cycle:

1. **Red**: Write a failing test for new functionality.
2. **Green**: Implement the minimal code to make the test pass.
3. **Refactor**: Optimize the code for maintainability and readability while keeping tests passing.

### Benefits of TDD:
- Improves code quality and design.
- Reduces debugging efforts.
- Encourages modular, testable code.

---

## **TDD Exercises**

### **Exercise 1: FizzBuzz**
**Objective**: Write a method that takes an integer input and returns the following:
- `"Fizz"` if the number is divisible by 3.
- `"Buzz"` if the number is divisible by 5.
- `"FizzBuzz"` if the number is divisible by both 3 and 5.
- The number itself (as a `String`) if it’s not divisible by 3 or 5.

**Steps**:
1. Write tests for expected input-output combinations (e.g., 3 → `"Fizz"`, 5 → `"Buzz"`).
2. Implement the function incrementally and run all tests.

---

### **Exercise 2: Leap Year Calculator**
**Objective**: Write a method to determine if a year is a leap year.
- A year is a leap year if:
    - It is divisible by 4.
    - But not divisible by 100, unless it is divisible by 400.

**Steps**:
1. Write tests for cases such as `2000` (leap year) and `1900` (non-leap year).
2. Implement the method step by step while verifying all tests pass.

---

### **Exercise 3: String Calculator**
**Objective**: Write a method `add(String numbers)` that takes a comma-separated string of numbers and returns their sum.

**Requirements**:
1. An empty string should return `0`.
2. Numbers are separated by commas and can include newline characters (`\n`).
3. The function must handle these edge cases incrementally while adhering to TDD principles.

---

### **Exercise 4: Prime Number Checker**
**Objective**: Implement a method to check if a number is prime.
- Prime numbers are greater than 1 and divisible only by 1 and the number itself.

**Steps**:
1. Write test cases for numbers like 2, 3, 5 (prime) and 1 or -1 (not prime).
2. Implement edge case handling for invalid inputs.

---

### **Exercise 5: Password Validator**
**Objective**: Create a method to validate passwords based on the following criteria:
1. A minimum length of 8 characters.
2. At least one uppercase letter, one lowercase letter, and one digit.

**Steps**:
1. Develop individual tests for each rule (e.g., check length first, then special characters).
2. Combine all validation criteria and refactor the code as needed.

---

### **Exercise 6: Roman Numeral Converter**
**Objective**: Write a method that converts integers into Roman numerals. For example:
- `1` → `"I"`, `4` → `"IV"`, `9` → `"IX"`, `58` → `"LVIII"`.

**Steps**:
1. Start small with simple mappings (1 → I, 5 → V).
2. Gradually expand to account for more complex cases.

---

### **Exercise 7: Bowling Game Scorer (Advanced)**
**Objective**: Build a scoring system for a bowling game based on the following rules:
1. A **strike** scores 10 points plus the sum of the next two rolls.
2. A **spare** scores 10 points plus the next single roll.
3. Otherwise, the score is the sum of the pins knocked down.
4. A perfect game (12 strikes) scores 300.

**Steps**:
- Write test cases for simple frames, spares, strikes, and perfect games.
- Implement scoring logic and refactor iteratively.

---

## **Tips for Practicing TDD**
- **Start Small**: Write tests for basic scenarios first, then expand to edge cases and complex cases.
- **Red-Green-Refactor**: Stick to the cycle for each new functionality.
- **Focus on Test Coverage**: Ensure all paths in the code are tested thoroughly.
- **Use Frameworks**: Leverage tools like JUnit for clean, maintainable tests.
- **Refactor Aggressively**: Improve design or performance as long as tests assure correctness.

By practicing progressively more difficult exercises, developers can master both writing and refactoring testable code!