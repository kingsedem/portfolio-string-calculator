# String Calculator Kata

Welcome to the Java String Calculator Kata!
The aim of this Kata is to implement a simple integer calculator. 
The calculator takes a string of space-separated numbers and operators 
(like "1 + 2 + 3" or "10 + 4 - 5") and returns the result of the calculation.

It should resolve the following sums:

- "1"
- "1 + 1"
- "1 + 2 + 3"
- "10 - 6"
- "10 + 5 - 6"
- "10 * 5"

If an operator isn't known, an exception should be thrown.

## Running the tests under Maven

The project comes with both Maven and Gradle build scripts. To run the tests with Maven, open a command window and run:

  mvn clean verify

## Use Gradle

For GRADLE, pen a command window and run:

  gradle test 

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory.

