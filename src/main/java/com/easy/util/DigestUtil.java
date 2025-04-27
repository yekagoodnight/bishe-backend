package com.easy.util;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtil {

	private final static int countindex=12;
	private final static int saltIndex=1;
	
	private final static char[] saltArr= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	public static String randomDigest(String pass) {
		int randomCountIndex=(int)(Math.random()*saltArr.length);
		int randomSaltIndex=(int)(Math.random()*saltArr.length);
		char count =saltArr[randomCountIndex];
		char salt =saltArr[randomSaltIndex];
		String result=pass+salt;
		for(int i=0;i<count;i++) {
			//16进制加密
			result=DigestUtils.md5Hex(result);
		}
		//result已经加密
		//放入盐值
		result=result.substring(0,saltIndex)+salt+result.substring(saltIndex);
		//放入加密次数
		result=result.substring(0,countindex)+count+result.substring(countindex);
		
		return result;
	}
	public static boolean equal(String pass,String ciphertext) {
		//取出盐值和加密次数
		char salt=ciphertext.charAt(saltIndex);
		char count=ciphertext.charAt(countindex);
		//加密
		String result=pass+salt;
		for(int i=0;i<count;i++) {
			//16进制加密
			result=DigestUtils.md5Hex(result);
		}
		//result已经加密
		//放入盐值
		result=result.substring(0,saltIndex)+salt+result.substring(saltIndex);
		//放入加密次数
		result=result.substring(0,countindex)+count+result.substring(countindex);
		return result.equals(ciphertext);
	}
	public static void main(String[] args) {
		String s=randomDigest("123456");
		System.out.println(s);
		System.out.println(equal("123",s));
	}
}
