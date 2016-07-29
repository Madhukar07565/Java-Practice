package com.madhu;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Security {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {

		String s = new String("Madhukar");
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA1", "SunJCE");
		kg.init(SecureRandom.getInstance("SHA1PRNG", "SUN"));
		SecretKey key = kg.generateKey();
		Mac mac = Mac.getInstance("HmacSHA1", "SunJCE");
		mac.init(key);
		byte[] b1 = s.getBytes();
		byte[] output = mac.doFinal(b1);
		System.out.println("out put is "+output);
	}

}
