# Top-n Email Domains

## Description

This is a Java program that either reads a file containing a list of email addresses, or reads from standard input, and returns the top n domains by frequency.

## Input format

The program expects the input to be **one email per line**. The program will ignore any lines that do not contain a valid email address. There is an example input file, emails.txt, under ./src/resources/

Example input:

```text
joeblogs@hotmail.com
andrew.smith@gmail.com
sondre@gmail.com
```

**IMPORTANT - If you wish to use _standard input_, you must press enter after the last email address twice.**

## Usage

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

> n - the number of domains to return. If not specified, the program will return all domains.

> filename - the file containing the email addresses. If not specified, the program will read from standard input. You can also use emails.txt as an example file.

NOTE: **If you wish to use a custom file, it must be in the ./src/resources/ directory.**

### Running tests

To run the tests, you can use the following command:

```java
mvn test
```
