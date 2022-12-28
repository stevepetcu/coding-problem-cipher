package com.stefanpetcu.cipher.Implementations;

import com.stefanpetcu.cipher.DataObjects.UserInput;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInputParserTest {
    private static final String TEST_CIPHER = "zyxwvutsrqponmlkjihgfedcba";
    private UserInputParser testSubject;

    @Before
    public void setUp() {
        testSubject = new UserInputParser();
    }

    @Test
    public void parseWordAndCipher_willReturnAnObjectContainingTheWordAndTheCipher_givenAValidInputText() {
        UserInput userInput = testSubject.parseWordAndCipher("Hello, World -- " + TEST_CIPHER, "\\s--\\s");
        assertEquals("Hello, World", userInput.getText());
        assertEquals(TEST_CIPHER, userInput.getCipher());
    }
}
