package com.algos.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalencedBrackets {
	//https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isbalanced("((()))}"));
	}
	
	//O(n) ST
	//Using Queue implementation
	static boolean isbalanced(String x)
    {
        // add your code here
        Map<Character, Character> chars = new HashMap<Character, Character>();
        chars.put(')', '(');
        chars.put('}', '{');
        chars.put(']', '[');
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<x.length(); i++){
            if(x.charAt(i) == '{' || x.charAt(i) == '(' || x.charAt(i) == '[')
                list.add(x.charAt(i));
            else if(list.size() > 0 && chars.containsKey(x.charAt(i))){
                if(list.get(list.size() - 1) == chars.get(x.charAt(i)))
                    list.remove(list.size() - 1);
                else
                    return false;
            }
            else
                return false;
        }
        return list.size() == 0;
    }

}
