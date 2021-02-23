package com.algos.strings;

public class ReverseStringWithoutExtraSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "sandeep";
		System.out.println(reverseString(str.toCharArray()));
	}
	
	//O(n) Time || O(1) Space
    public static char[] reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<j){
            swap(i, j, s);
            i++;
            j--;
        }
        return s;
    }
    
    public static void swap(int i, int j, char[] s){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    } 

}
