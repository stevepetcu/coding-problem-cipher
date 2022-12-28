package com.stefanpetcu.cipher.Implementations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserSpecifiedCipherStringEncryptorTest {
    private UserSpecifiedCipherStringEncryptor testSubject;
    private static final String TEST_CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    @Before
    public void setUp() {
        testSubject = new UserSpecifiedCipherStringEncryptor(TEST_CIPHER);
    }

    @Test
    public void encrypt_willReturnAnEmptyString_givenAnEncryptionKeyAndAnEmptyString() {
        assertEquals("", testSubject.encrypt(""));
    }

    @Test
    public void encrypt_willReturnAnEncryptedString_givenAndEncryptionKeyAndANonEmptyString() {
        assertEquals("Zyxw vutS", testSubject.encrypt("Abcd efgH"));
    }
}
