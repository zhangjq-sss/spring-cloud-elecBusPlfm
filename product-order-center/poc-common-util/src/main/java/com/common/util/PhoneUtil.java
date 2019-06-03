package com.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {
	/* 手机号码正则 */
	private static String phoneReg = "^(13[0-9]|(14[0-9])|15[0-9]|(17[0-9])|18[0-9])\\d{8}$";
	private static Pattern p1 = Pattern.compile(phoneReg);
	private static String numberReg = "^[0-9]*(0{##}|1{##}|2{##}|3{##}|4{##}|5{##}|6{##}|7{##}|8{##}|9{##})[0-9]*$";
	private static Pattern moble = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");

	/* 固定电话正则 */
	private static Pattern telephone = Pattern.compile("^(\\d{3,4})?\\d{7,8}$");

	/**
	 * 手机号码检验，弱检验
	 * 
	 * @param number
	 * @return 不合格，则返回false
	 */
	public static boolean testPhoneFriendly(String number) {
		Matcher m1 = p1.matcher(number.trim());
		if (m1.matches()) {
			return true;
		}
		return false;
	}

	public static boolean testPhoneForceByReg(String number, int count) {
		boolean test = testPhoneFriendly(number);
		if (!test)
			return false;

		String reg = numberReg.replace("##", count + "");
		Pattern p2 = Pattern.compile(reg);
		Matcher m1 = p2.matcher(number.trim());
		if (m1.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 手机号码检验，强检验，对于超过指定位数的重复数字号码都将被判无效
	 * 
	 * @param number
	 * @param count
	 *            重复次数
	 * @return
	 */
	public static boolean testPhoneForce(String number, int count) {
		boolean test = testPhoneFriendly(number);
		if (!test)
			return false;

		String[] duplatedNumbers = new String[10];
		String duplatedNumber = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < count; j++) {
				duplatedNumber += i;
			}
			duplatedNumbers[i] = duplatedNumber;
			duplatedNumber = "";
		}

		for (int i = 0; i < duplatedNumbers.length; i++) {
			if (number.contains(duplatedNumbers[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 验证手机号码或者固定电话规则
	 * 
	 * @Title: checkPhone
	 * @Description:
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone) {
		Matcher m = moble.matcher(phone);
		if (m.matches()) {
			return true;
		} else {
			int phoneSize = phone.length();
			String str = phone.substring(0, 3);

			if (phoneSize < 8) {
				return false;
			}
			if (str.equals("168") || str.equals("400") || str.equals("800") || str.equals("125") || str.equals("268")
					|| str.equals("195") || str.equals("198")) {
				return false;
			}
			m = telephone.matcher(phone);
			if (m.matches()) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkMoblePhone(String phone) {
		Matcher m = moble.matcher(phone);
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String number = "17868849031";
		System.out.println(PhoneUtil.testPhoneFriendly(number));
		// System.out.println(PhoneUtil.testPhoneForceByReg(number, 6));
	}
}
