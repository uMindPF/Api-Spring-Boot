package com.uMind.uMind.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SecurityClass {

    public static String hashSHA1(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(text.getBytes("utf8"));
            String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            return sha1;
        } catch (Exception e) {
            return "";
        }
    }

    public static String hashSha1Text(Object text) {
        return hashSHA1(text.toString());
    }
}
