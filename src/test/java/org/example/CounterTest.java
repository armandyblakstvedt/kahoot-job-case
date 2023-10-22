package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTest {
    private Counter counter;

    @BeforeEach
    public void setUp() {
        counter = new Counter();
    }

    @Test
    public void testCountStringWithValidInput() {
        counter.count("john@example.com\nalice@example.com");
        assertEquals("\nexample.com 2\n", counter.toString());
    }

    @Test
    public void testCountStringWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> counter.count((String) null));
    }

    @Test
    public void testCountStringWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> counter.count(""));
    }

    @Test
    public void testCountInputStreamWithValidInput() {
        String input = "\njohn@example.com\nalice@example.com\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        counter.count(inputStream);
        assertEquals("\nexample.com 2\n", counter.toString());
    }

    @Test
    public void testCountInputStreamWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> counter.count((InputStream) null));
    }

    @Test
    public void testCountInputStreamWithInvalidInput() {
        String input = "invalid-email";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        counter.count(inputStream);
        assertEquals("\n", counter.toString());
    }

    @Test
    public void testToStringWithNoCounts() {
        assertEquals("\n", counter.toString());
    }

    @Test
    public void testToStringWithMultipleDomains() {
        counter.count("john@example.com\nalice@example.com");
        counter.count("bob@gmail.com");
        assertEquals("\nexample.com 2\n"+ "gmail.com 1\n" , counter.toString());
    }
}
