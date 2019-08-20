# Eclipse Options Java Programming Challenge

## General requirements

Maven projects are provided containing interfaces. These interfaces contain JavaDoc with the requirements. You should
not change these interfaces.

*It is very important to carefully read and fully understand the JavaDoc requirements before answering.*

For your answers, you may only use the Java 8 language and J2SE APIs. You may use third party libraries in your unit
tests, but not your solution itself.

Simplicity and correctness are valued more than performance and extensibility. However your solution should not be
needlessly inefficient.

We expect your code to be unit tested against the requirements. Use the standard Maven directory for your test classes.

There are no trick questions - if a problem seems straightforward to solve it probably is.

Implement your solution within this directory structure and return it as a .tar.gz file to your HR contact. Note you
can create a .tar.gz file for submission by running `mvn clean verify`. The file will be generated in the target
directory.

## Tuple 

For this challenge, provide an implementation of the `TupleFactory` interface, which in turn will require you to 
provide an implementation of the `Tuple` interface. All should meet the requirements specified in
the interfaces' JavaDoc. 

Please note the implementation detail that `Tuple` must be backed by an array, not a list or other collection.
