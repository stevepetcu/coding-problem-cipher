package com.stefanpetcu.cipher.Interfaces;

import com.stefanpetcu.cipher.DataObjects.UserInput;

public interface InputParser {
    UserInput parseWordAndCipher(String inputText, String separator) throws IllegalArgumentException;
}
