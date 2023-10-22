package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Counter {
    /* All emails read from user */
    private Map<String, Integer> emailCounts;
    private int n = 0;

    /** Static regex for validating email format */
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    /** Static separator for splitting emails */
    private static final String SEPARATOR = "\n";

    /* Constructor initializes emailCounts to be empty */
    public Counter() {
        emailCounts = new HashMap<String, Integer>();
    }
    public Counter(int n) {
        emailCounts = new HashMap<String, Integer>();
        this.n = n;
    }

    private boolean validateEmail(String email) {
        return email.matches(Counter.EMAIL_REGEX);
    }

    private String getDomain(String email) {
        /** Check if email is valid */
        if (!validateEmail(email)) {
            return null;
        }
        String[] components = email.split("@");
        /** Check if email has a domain */
        if (components.length != 2) {
            return null;
        }
        return components[1];
    }


    public void count(String input){
        /* Check if input is not null */
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("Input cannot be null");
        } 
        /* Split input by separator */
        String[] emails = input.split(SEPARATOR);
        /* For each email, get the domain */
        for (String email : emails) {
            /** Extract domain */
            String domain = getDomain(email);
            /** Skip if domain is null */
            if (domain == null) {
                continue;
            }
            emailCounts.put(domain, emailCounts.getOrDefault(domain, 0) + 1);
        }
    }

    public void count(InputStream input) {
        /* Check if input is not null */
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        /* Read input line by line */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                /** Extract domain */
                String domain = getDomain(line);
                /** Skip if domain is null */
                if (domain == null) {
                    continue;
                }
                emailCounts.put(domain, emailCounts.getOrDefault(domain, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String toString(){
        Map<String, Integer> sortedEmailCounts = new HashMap<String, Integer>();
        sortedEmailCounts = emailCounts.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        int i = 0;
        for (String domain : sortedEmailCounts.keySet()) {
            if (n != 0 && i >= n) {
                break;
            }
            i++;
            sb.append(domain);
            sb.append(" ");
            sb.append(sortedEmailCounts.get(domain));
            sb.append("\n");
        }
        return sb.toString();
    }

}
