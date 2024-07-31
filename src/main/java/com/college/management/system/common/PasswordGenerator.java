package com.college.management.system.common;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGenerator {
	  public static String generatePassword() {
	        SecureRandom random = new SecureRandom();
	        byte[] passwordBytes = new byte[8];
	        random.nextBytes(passwordBytes);
	        return Base64.getEncoder().encodeToString(passwordBytes);
	    }

	    public static void main(String[] args) {
	        String password = generatePassword();
	    }
}
