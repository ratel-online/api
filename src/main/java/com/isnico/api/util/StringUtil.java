package com.isnico.api.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

public class StringUtil {

	public static String random(int len){
		String sources = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz"; 
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int j = 0; j < len; j++) 
		{
			flag.append(sources.charAt(rand.nextInt(sources.length() - 1)) + "");
		}
		return flag.toString();
	}

	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code.insert(0, "0");
		}
		return md5code.toString();
	}

	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}
