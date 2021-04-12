package com.algos.strings;

import java.util.*;

public class ConvertRomanToInt {
	//https://leetcode.com/problems/roman-to-integer/submissions/
	//https://www.youtube.com/watch?v=9rfe5nXL05Q&ab_channel=TerribleWhiteboard
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("IV"));
	}
	
	 //O(N) ST
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        int i =0;
        int j =1;
        while(j<s.length()){
            if(map.get(s.charAt(i)) < map.get(s.charAt(j))){
                total += (map.get(s.charAt(j)) - map.get(s.charAt(i)));
                j=j+2;
                i=i+2;
            }
            else{
                total += map.get(s.charAt(i));
                i++;
                j++;
            }
        }
        
        while(i<s.length()){
            total += map.get(s.charAt(i));
            i++;
        }
        return total;
    }

}
