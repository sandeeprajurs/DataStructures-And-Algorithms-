package com.algos.dp.lcs;

public class EditDistance {
	
	public static void main(String[] args) {
		String str1 = "sunday";
        String str2 = "saturday";
		int ans=lcs("sunday", "saturday", str1.length(), str2.length());
		System.out.println(ans);
	}
	
	public static int lcs(String x, String y, int m, int n) {
		// If first string is empty, the only option is to
        // insert all characters of second string into first
		if(m==0) return n;
		// If second string is empty, the only option is to
        // remove all characters of first string
		if(n==0) return m;
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return lcs(x, y, m-1, n-1);
		else                  //Insert, Remove, Replace
			return 1+ Math.min(lcs(x, y, m, n-1), Math.min(lcs(x, y, m-1, n-1), lcs(x, y, m-1, n)));
	}
}
