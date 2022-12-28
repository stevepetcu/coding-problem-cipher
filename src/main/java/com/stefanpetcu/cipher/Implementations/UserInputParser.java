package com.stefanpetcu.cipher.Implementations;

import com.stefanpetcu.cipher.DataObjects.UserInput;
import com.stefanpetcu.cipher.Interfaces.InputParser;

public class UserInputParser implements InputParser {
    @Override
    public UserInput parseWordAndCipher(String inputText, String separator) throws IllegalArgumentException {
        String[] input = inputText.split(separator);
        return new UserInput(input[0], input[1]);
    }
}
