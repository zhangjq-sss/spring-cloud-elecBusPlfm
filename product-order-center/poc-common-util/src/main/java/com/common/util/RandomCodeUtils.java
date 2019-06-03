package com.common.util;

import java.util.Random;

public class RandomCodeUtils {
	public static String getRandomNumCode(int number) {
		String codeNum = "";
		int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int next = random.nextInt(10000);// 目的是产生足够随机的数，避免产生的数字重复率高的问题
			codeNum += numbers[next % 10];
		}

		return codeNum;
	}

	public static String getRandomCode(int number) {
		String codeNum = "";
		int[] code = new int[3];
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int num = random.nextInt(10) + 48;
			int uppercase = random.nextInt(26) + 65;
			int lowercase = random.nextInt(26) + 97;
			code[0] = num;
			code[1] = uppercase;
			code[2] = lowercase;
			codeNum += (char) code[random.nextInt(3)];
		}

		return codeNum;
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomCode(4));
		System.out.println(getRandomNumCode(4));
	}
}
