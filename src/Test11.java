import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test11 {
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1, 101, 2, 3, 100};
////		int[] arr1 = new int[]{0,8,4,12,2,10,6,14,1,9,5, 13,3,11,7,15};
//		
//		Set<Integer> set = new HashSet<Integer>();
//		for(int num:arr)
//			set.add(num);
//		int[] arr1 =  set.stream().mapToInt(i-> i).toArray();
//		Arrays.sort(arr1);
//		System.out.println(Arrays.toString(arr1));
//		System.out.println(lcs(arr, arr1, arr.length, arr1.length));
		String x="geeks";
		String y="geeksfor";
		String z ="geeksforgeeks";
		System.out.println(lcs(x,y,z, x.length(), y.length(), z.length()));
	}
	
	public static int lcs(int[] x, int[] y, int m, int n) {
		if(m==0 || n==0) return 0;
		
		if(x[m-1] == y[n-1]) {
			System.out.println((m-1)+"---------"+(n-1));
			return 1+lcs(x, y, m-1, n-1);
		}
		else
			return Math.max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
	}
	
	public static int lcs(String x, String y, String z, int m, int n, int o) {
//		if(m==0 || n==0 || o==0) return 0;
//		
//		if(x.charAt(m-1) == y.charAt(n-1) && x.charAt(m-1) == z.charAt(o-1)) {
//			return 1+lcs(x, y,z, m-1, n-1, o-1);
//		}
//		else
//			return  Math.max(lcs(x,y,z,m,n,o-1), Math.max(lcs(x, y,z, m, n-1,o), lcs(x, y,z, m-1, n,o)));
		int[][][] t=new int[x.length()+1][y.length()+1][z.length()+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				for(int k=0; k<t[0][0].length; k++) {
					if(i==0||j==0||k==0)  t[i][j][k] = 0;
				}
			}
		}
		
		//conditional diagram part
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				for(int k=1; k<t[0][0].length; k++) {
					if(x.charAt(i-1) == y.charAt(j-1) && x.charAt(i-1) == z.charAt(k-1))
						t[i][j][k] = 1+t[i-1][j-1][k-1];
					else
						t[i][j][k] = Math.max(Math.max(t[i-1][j][k],  t[i][j-1][k]),  t[i][j][k-1]);
				}
			}
		}
		return t[t.length-1][t[0].length-1][t[0][0].length-1];
	}
}
