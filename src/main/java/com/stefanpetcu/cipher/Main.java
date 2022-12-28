package com.stefanpetcu.cipher;

import com.stefanpetcu.cipher.DataObjects.UserInput;
import com.stefanpetcu.cipher.Implementations.UserInputParser;
import com.stefanpetcu.cipher.Implementations.UserInputValidator;
import com.stefanpetcu.cipher.Implementations.UserSpecifiedCipherStringEncryptor;
import com.stefanpetcu.cipher.Interfaces.InputParser;
import com.stefanpetcu.cipher.Interfaces.InputValidator;
import com.stefanpetcu.cipher.Interfaces.StringEncryptor;

import java.util.List;
import java.util.Scanner;

class Main {
    private static final String USER_INPUT_SEPARATOR = "; -- ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your word and cipher (<word>" + USER_INPUT_SEPARATOR + "<cipher>): ");
        String input = scanner.nextLine();
        scanner.close();

        InputParser inputParser = new UserInputParser();
        InputValidator inputValidator = new UserInputValidator()
                .setTextCipherSeparator(USER_INPUT_SEPARATOR)
                .setInputParser(inputParser);
        List<String> errors = inputValidator.validate(input);

        if (errors.size() != 0) {
            System.err.println("There were errors processing your input:");
            errors.forEach(e -> System.err.println("  • " + e));
            return;
        }

        UserInput userInput = inputParser.parseWordAndCipher(input, USER_INPUT_SEPARATOR);

        StringEncryptor stringEncryptor = new UserSpecifiedCipherStringEncryptor(userInput.getCipher());

        System.out.println(stringEncryptor.encrypt(userInput.getText()));
    }
}
