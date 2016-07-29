package com.madhu;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

public class PasswordEncDec {
	public static void main(String a[]) throws NoSuchAlgorithmException,
			UnsupportedEncodingException, Base64DecodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		encrypt();
	}

	private static void encrypt() throws NoSuchAlgorithmException,
			UnsupportedEncodingException, Base64DecodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String password = "madhukar";
		//String ciphertext;
		//String decryptedtext;
		/*MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		messageDigest.update(password.getBytes());
		byte[] data = messageDigest.digest();
		ciphertext = Base64.encode(data);
		System.out.println("Encrypted Text is" + ciphertext);
		decryptedtext = (Base64.decode(ciphertext)).toString();
		System.out.println("decrypted text is" + decryptedtext);*/
		
		Key key = new SecretKeySpec(password.getBytes(), "DES");

		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedData = cipher.doFinal(password.getBytes());
		
		System.out.println("Encrypted Text is" + encryptedData.toString());

		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedData = cipher.doFinal(encryptedData);
		System.out.println("Decrypted Text is" + decryptedData);

	}
}
