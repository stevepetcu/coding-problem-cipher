package com.stefanpetcu.cipher.Implementations;

import com.stefanpetcu.cipher.Interfaces.InputParser;
import com.stefanpetcu.cipher.Interfaces.InputValidator;

import java.util.Collections;
import java.util.List;

enum UserInputErrors {
    MISSING_SEPARATOR {
        @Override
        public String toString() {
            return "The input text does not contain the specified separator.";
        }
    },
    EMPTY_TEXT {
        @Override
        public String toString() {
            return "The input text is empty.";
        }
    },
    INVALID_CIPHER {
        @Override
        public String toString() {
            return "The cipher should contain 26 characters (the length of the English alphabet).";
        }
    }
}

public class UserInputValidator implements InputValidator {
    private static final String DEFAULT_STRING_SEPARATOR = " --- ";
    private String textCipherSeparator = DEFAULT_STRING_SEPARATOR;
    private InputParser inputParser = null;

    @Override
    public InputValidator setTextCipherSeparator(String separator) {
        this.textCipherSeparator = separator;
        return this;
    }

    @Override
    public InputValidator setInputParser(InputParser inputParser) {
        this.inputParser = inputParser;
        return this;
    }

    @Override
    public List<String> validate(String input) {
        List<String> errors = new java.util.ArrayList<>(Collections.emptyList());

        if (input.length() == 0) {
            errors.add(UserInputErrors.EMPTY_TEXT.toString());
        }
        if (!input.contains(textCipherSeparator)) {
            errors.add(UserInputErrors.MISSING_SEPARATOR.toString());
        }
        if (0 == errors.size()
                && null != this.inputParser
                && inputParser.parseWordAndCipher(input, textCipherSeparator).getCipher().length() < 26) {
            errors.add(UserInputErrors.INVALID_CIPHER.toString());
        }

        return errors;
    }
}
