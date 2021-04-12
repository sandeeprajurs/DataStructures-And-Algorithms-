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
		Map<Character, Character> braces = new HashMap<Character, Character>();
        braces.put(')', '(');
        braces.put('}', '{');
        braces.put(']', '[');
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<x.length(); i++){
            char ch = x.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                list.add(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']'){
                if(list.size() > 0 && list.get(list.size()-1) == braces.get(ch))
                    list.remove(list.size()-1);
                else
                    return false;
            }
        }
        return list.size() == 0;
    }

}
