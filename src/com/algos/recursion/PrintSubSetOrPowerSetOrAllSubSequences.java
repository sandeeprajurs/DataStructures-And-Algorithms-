package com.algos.recursion;

public class PrintSubSetOrPowerSetOrAllSubSequences {
	
	public static void main(String[] args) {
		
		//1 and 3
//		solve("", "ab");
		
		//2
//		solve("a", "bc");
		
		//4
		solve("", "a1B");
	}

//	1)
//	public static void solve(String op, String ip) {
//		if(ip.length() == 0) {
//			System.out.println(op);
//			return;
//		}
//		String op1 = op;
//		String op2 = op;
//		op2 += ip.charAt(0);
//		ip = ip.substring(1);
//		solve(op1, ip);
//		solve(op2, ip);
//	}

	
//2  With Space
//	public static void solve(String op, String ip) {
//		if(ip.length() == 0) {
//			System.out.println(op);
//			return;
//		}	
//		String op1 = op;
//		String op2 = op;
//		op1 += "_";
//		op1 += ip.charAt(0);
//		op2 += ip.charAt(0);
//		ip = ip.substring(1);
//		solve(op1, ip);
//		solve(op2, ip);
//	}
	
//3 permutation Case change
//	public static void solve(String op, String ip) {
//		if(ip.length() == 0) {
//			System.out.println(op);
//			return;
//		}	
//		String op1 = op;
//		String op2 = op;
//		op1 += ip.charAt(0);
//		op2 += (ip.charAt(0)+"").toUpperCase();;
//		ip = ip.substring(1);
//		solve(op1, ip);
//		solve(op2, ip);
//	}
	
//4 Letter Case Permutation
	public static void solve(String op, String ip) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}	
		
		if(Character.isAlphabetic(ip.charAt(0))) {
			String op1 = op;
			String op2 = op;
			op1 += (ip.charAt(0)+"").toLowerCase();
			op2 += (ip.charAt(0)+"").toUpperCase();
			ip = ip.substring(1);
			solve(op1, ip);
			solve(op2, ip);
		}
		else if(Character.isDigit(ip.charAt(0))) {
			String op1 = op;
			op1 += ip.charAt(0);
			ip = ip.substring(1);
			solve(op1, ip);
		}
	}
}
