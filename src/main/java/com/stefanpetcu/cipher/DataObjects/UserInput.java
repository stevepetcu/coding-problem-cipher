package com.stefanpetcu.cipher.DataObjects;

public class UserInput {
    private final String text;
    private final String cipher;

    public UserInput(String text, String cipher) {
        this.text = text;
        this.cipher = cipher;
    }

    public String getText() {
        return text;
    }

    public String getCipher() {
        return cipher;
    }
}
