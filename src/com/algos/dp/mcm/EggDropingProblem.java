package com.algos.dp.mcm;

public class EggDropingProblem {
	
	static int[][] t = null;
	public static void main(String[] args) {
		int egg=2;
		int floors=4;
		t = new int[egg+1][floors+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				t[i][j] = -1;
			}
		}
		int ans = solve(egg, floors);
		System.out.println(ans);
	}
	
	//recurssive
//	public static int solve(int e, int f) {
//		if(f==0 || f==1) return f;
//		if(e == 1) return f;
//		
//		int min = Integer.MAX_VALUE;
//		
//		for(int k=1; k<=f; k++) {
//			int temp = 1+Math.max(solve(e-1, k-1), solve(e, f-k));
//			min = Math.min(temp, min);
//		}
//		return min;
//	}
	
	public static int solve(int e, int f) {
		if(t[e][f] != -1) return t[e][f];
		if(f==0 || f==1) return f;
		if(e == 1) return f;
		int min = Integer.MAX_VALUE;
		for(int k=1; k<=f; k++) {
			int temp = 1+Math.max(solve(e-1, k-1), solve(e, f-k));
			min = Math.min(temp, min);
		}
		t[e][f] = min;
		return min;
	}
}
