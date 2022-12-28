package com.stefanpetcu.cipher;

import com.sun.tools.javac.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    private final InputStream originalInputSource = System.in;
    private final PrintStream originalOutputDestination = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setIn(originalInputSource);
        System.setOut(originalOutputDestination);
    }

    @Test
    public void main_willReturnEncryptedString_givenStringAndCipher() throws Exception {
        // zyxwvutsrqponmlkjihgfedcba
        // abcdefghijklmnopqrstuvwxyz
        System.setIn(new ByteArrayInputStream(("Hello, world!; -- zyxwvutsrqponmlkjihgfedcba").getBytes()));
        Main.main(new String[]{});

        assertThat(outputStreamCaptor.toString(),
                equalTo("Please enter your word and cipher (<word>; -- <cipher>): Svool, dliow!\n"));
    }
}
