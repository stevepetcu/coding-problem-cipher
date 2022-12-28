package com.stefanpetcu.cipher.Implementations;

import com.stefanpetcu.cipher.Interfaces.InputValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserInputValidatorTest {
    private static final String TEST_CIPHER = "zyxwvutsrqponmlkjihgfedcba";
    private InputValidator testSubject;

    @Before
    public void setUp() {
        testSubject = new UserInputValidator();
    }

    @Test
    public void validate_willReturnAnEmptyArrayOfErrors_givenAValidInputText() {
        assertEquals("We should get no errors for this input",
                testSubject.setTextCipherSeparator(" -- ").validate("Hello, World -- " + TEST_CIPHER).size(),
                0);
    }

    @Test
    public void validate_willReturnAnError_givenTextCipherSeparatorInvalid() {
        List<String> errors = testSubject.setTextCipherSeparator(" --- ").validate("Hello, World -- " + TEST_CIPHER);
        assertEquals("We should get 1 error for this input", errors.size(), 1);
        assertEquals(errors.get(0), UserInputErrors.MISSING_SEPARATOR.toString());
    }

    @Test
    public void validate_willReturnAListOfErrors_givenInputTextIsEmpty() {
        List<String> errors = testSubject.validate("");
        assertEquals("We should get 2 errors for this input", errors.size(), 2);
        assertEquals(errors.get(0), UserInputErrors.EMPTY_TEXT.toString());
        assertEquals(errors.get(1), UserInputErrors.MISSING_SEPARATOR.toString());
    }

    @Test
    public void validate_willValidateTheCipherLength_givenASetInputParser() {
        List<String> errors = testSubject
                .setInputParser(new UserInputParser())
                .setTextCipherSeparator(" -- ")
                .validate("Hello, World -- asdfg");

        assertEquals("We should get 1 error for this input", errors.size(), 1);
        assertEquals(errors.get(0), UserInputErrors.INVALID_CIPHER.toString());
    }
}
