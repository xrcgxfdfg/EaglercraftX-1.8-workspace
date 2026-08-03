package me.eldodebug.soar.utils;

import java.util.Locale;

public class SearchUtils {
	
	public static boolean isSimillar(String s1, String s2) {
		return isSimillar(s1, s2, 1);
	}
	
	public static boolean isSimillar(String s1, String s2, int searchDistance) {
		s1 = s1.toLowerCase(Locale.ENGLISH);
		s2 = s2.toLowerCase(Locale.ENGLISH);
		
		if (s1.length() <= searchDistance) {
			return s1.contains(s2);
		}
		
		String[] parts = s1.split("\\s+");
		boolean similar = false;
		for (String a : parts) {
			similar = a.contains(s2) || levenshteinDistance(a, s2) <= searchDistance;
			if (similar) {
				break;
			}
		}
		
		return similar || s1.contains(s2) || levenshteinDistance(s1, s2) <= searchDistance;
	}
	
	private static int levenshteinDistance(String a, String b) {
		if (a == null || b == null) {
			return Integer.MAX_VALUE;
		}
		if (a.equals(b)) {
			return 0;
		}
		if (a.length() == 0) {
			return b.length();
		}
		if (b.length() == 0) {
			return a.length();
		}
		
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i <= a.length(); ++i) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= b.length(); ++j) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= a.length(); ++i) {
			for (int j = 1; j <= b.length(); ++j) {
				int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
				dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
			}
		}
		return dp[a.length()][b.length()];
	}
}
