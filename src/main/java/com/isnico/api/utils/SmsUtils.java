package com.isnico.api.utils;

import java.util.Random;

public class SmsUtils {

	public static String createCode(int len){
		String sources = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz"; 
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int j = 0; j < len; j++) 
		{
			flag.append(sources.charAt(rand.nextInt(sources.length() - 1)) + "");
		}
		return flag.toString();
	}
	
}
