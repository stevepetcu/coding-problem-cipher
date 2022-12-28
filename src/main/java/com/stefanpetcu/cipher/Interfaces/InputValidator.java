package com.stefanpetcu.cipher.Interfaces;

import java.util.List;

public interface InputValidator {
    InputValidator setTextCipherSeparator(String separator);

    InputValidator setInputParser(InputParser inputParser);

    List<String> validate(String input);
}
