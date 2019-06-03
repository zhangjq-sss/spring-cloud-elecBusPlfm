package com.common.util;

/**
 * js的 escape，unescape  的后台java版本
 *
 */
public class EscapeUnescape {

	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}
	
	public static String unescape(String src) {
		if (src == null)
			return null;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(
							src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else if (src.charAt(pos + 1) == ' '
						|| src.charAt(pos + 1) == ';') {
					tmp.append(src.substring(pos, pos + 1));
					lastPos = pos + 1;
				} else {
					ch = (char) Integer.parseInt(
							src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

//	public static void main(String[] args) {
//		String tmp = "中文";
//		System.out.println("testing escape : " + tmp);
//		tmp = escape(tmp);
//		System.out.println(tmp);
//		System.out.println("testing unescape :" + tmp);
//		System.out.println(unescape("%u4E3B%u53EB%uFF1A%u7B2C%u4E00%u901A%u6FC0%u6D3B%u7535%u8BDD"));
//	}
}
