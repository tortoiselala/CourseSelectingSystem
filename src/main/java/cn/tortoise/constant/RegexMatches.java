package cn.tortoise.constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	
	public static void main(String args[]) {
		String str = "{\"success\":true,\"message\":\"ed7d2e32bdbb4cfee87d6d3ade1984c9\"}";
		String pattern = "[a-zA-Z0-9]*";

		Pattern r = Pattern.compile(pattern);
		System.out.println(r.matcher(pattern).group());
	}

}