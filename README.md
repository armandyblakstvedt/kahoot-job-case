# Top-n Email Domains

## Description

This is a Java program that either reads a file containing a list of email addresses, or reads from input, and returns the top n domains by frequency.

## Input format

The program expects the input to be **one email per line**. The program will ignore any lines that do not contain a valid email address. There is an example input file, emails.txt, in the ./src/resources/ directory.

Example input:

```text
joeblogs@hotmail.com
andrew.smith@gmail.com
sondre@gmail.com
```

## Usage

To run the program, you can either run the jar file in the target directory.

### Building the jar file

To build the jar file, you can use the following command:

```java
mvn package
```

### Running the jar file

To run the jar file, you can use the following command:

```java
java -jar target/kahoot-job-case-1.0-SNAPSHOT.jar <n> <filename>
```

> n - optional, the number of domains to return. If not specified, the program will return the top 10 domains.

> filename - optional, the file containing the email addresses. If not specified, the program will read from standard input.

NOTE: **If you wish to use a custom file, it must be in the ./src/resources/ directory.**

### Running tests

To run the tests, you can use the following command:

```java
mvn test
```
