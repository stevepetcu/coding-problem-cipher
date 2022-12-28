package com.stefanpetcu.cipher.Implementations;

import com.stefanpetcu.cipher.Interfaces.StringEncryptor;

import java.util.List;

public class UserSpecifiedCipherStringEncryptor implements StringEncryptor {
    private static final List<Character> ALPHABET =
            List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    private final char[] cipher;

    public UserSpecifiedCipherStringEncryptor(String cipher) {
        this.cipher = cipher.toCharArray();
    }

    @Override
    public String encrypt(String value) {
        char[] wordChars = value.toCharArray();
        StringBuilder encryptedWord = new StringBuilder();

        for (char wordChar : wordChars) {
            int alphabeticIndex = ALPHABET.indexOf(Character.toUpperCase(wordChar));
            if (-1 == alphabeticIndex) {
                encryptedWord.append(wordChar);
                continue;
            }

            char encryptedChar = cipher[alphabeticIndex];

            if (Character.isUpperCase(wordChar)) {
                encryptedWord.append(Character.toUpperCase(encryptedChar));
            } else {
                encryptedWord.append(encryptedChar);
            }
        }

        return encryptedWord.toString();
    }
}
