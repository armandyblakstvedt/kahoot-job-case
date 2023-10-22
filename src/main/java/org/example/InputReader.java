package org.example;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader {

    private Scanner scanner;
    private Counter counter;
    private String filename;

    public InputReader(int n, String filename) {
        this.scanner = new Scanner(System.in);
        this.counter = new Counter(n);
        this.filename = filename;
    }
    public InputReader(int n) {
        this.scanner = new Scanner(System.in);
        this.counter = new Counter(n);
    }

    public InputReader() {
        this.scanner = new Scanner(System.in);
        this.counter = new Counter();
    }

    public void readFile() {
        /* Load the file into an InputStream */
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found");
        }

        /* Use our object to count the domains in the text file */
        counter.count(inputStream);



        /* Print the results */
        System.out.println(counter.toString());
    }

    public void readInput() {
        /* Ask user for input */
        System.out.println("\nPlease enter a list of emails separated by a new line");
        StringBuilder input = new StringBuilder();
        /** User should be able to input multiple lines */
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            /** If user inputted q, exit */
            if (line.equals("q")) {
                System.out.println("User inputted q, exiting...");
                return;
            }
            /** If user inputted input, read from input */
            if (line.equals("")) {
                break;
            }
            input.append(line);
            input.append("\n");
        }

        /* Use our object to count the domains in the input */
        counter.count(input.toString());
        
        /* Print the results */
        System.out.println(counter.toString());
    }

    public void run() {
        /* If user inputted file, read from file */
        if (this.filename != null) {
            try {
                readFile();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("File not found, please try again and make sure the file is in the resources folder");
            }
            catch (Exception e) {
                System.out.println("Unexpected error reading file, please try again");
            } 
            return;
        } 
        /* Present a welcome message to indicate the progrma has started */
        System.out.println("\nWelcome to Top-N-Domains. To exit, type q");
        StringBuilder input = new StringBuilder();

        /* If a user presses q, the program will exit */
        while (!input.toString().equals("q")) {
            /** Check if user inputted q */
            if (input.toString().equals("q")){
                System.out.println("User inputted q, exiting...");
                break;
            }
            /* If user inputted input, read from input */
                try {
                    readInput();
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Illegal argument, please type in a valid input");
                }
                catch (Exception e) {
                    System.out.println("Unexpected error reading input, please try again");
                } 
                


        }
    }

}
