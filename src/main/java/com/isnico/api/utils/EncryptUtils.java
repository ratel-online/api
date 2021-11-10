package com.isnico.api.utils;

/**
 * 专为[支付密码]打造的加密工具
 * 
 * @author nico
 */
public class EncryptUtils {
	
	private final static int LEN = 1;
	
	private final static String BLANK = "";
	
	private final static String NULL = "NULL";
	
	private final static String SLAT = "@TRAP";
	
	public static String encode(String token) {
		if(token == null) token = NULL;
		token += SLAT;
		String result = BLANK;
		char[] chars = token.toCharArray();
		int len = chars.length / (chars.length > LEN ? LEN : 1);
		for(int index = 0; index < chars.length; index += len) {
			int dif = chars.length - index;
			dif = dif > len ? len : dif;
			long sum = 1;
			while(-- dif >= 0) {
				sum *= chars[index + dif];
			}
			result += Long.toHexString(sum);
		}
		return result;
	}
	
}
