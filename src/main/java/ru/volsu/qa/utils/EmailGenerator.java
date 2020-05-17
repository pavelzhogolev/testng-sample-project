package ru.volsu.qa.utils;

import java.util.Random;

public class EmailGenerator {

    private static final String SALT_CHARS = "abcdefghilklmnopqrstuvwxyz1234567890";
    private static final int EMAIL_LENGTH = 10;
    private static final String EMAIL_DOMAIN = "@test.com";

    public static String generateEmail() {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while ( salt.length() < EMAIL_LENGTH ) {
            int index = (int) ( rnd.nextFloat() * EmailGenerator.SALT_CHARS.length() );
            salt.append( EmailGenerator.SALT_CHARS.charAt( index ) );
        }

        return salt.toString() + EmailGenerator.EMAIL_DOMAIN;
    }
}
