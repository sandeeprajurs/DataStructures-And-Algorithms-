package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/expression-contains-redundant-bracket-not/
//O(n) ST
public class DoesExpressionContainsRedundantBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRedundant("((a+b))"));
		System.out.println(isRedundant("(a+(b)/c)"));
		System.out.println(isRedundant("(a+b*(c-d))"));
	}
	
	static boolean isRedundant(String str) {
		Stack<Character> stack = new Stack<Character>();
      	List<Character> operators = new ArrayList<Character>(Arrays.asList('+', '-', '*', '/'));
      	for(int i=0; i<str.length(); i++){
        	char ch = str.charAt(i);
          	if(operators.indexOf(ch) != -1)
            	stack.push(ch);
          	else if(ch == '(')
              stack.push(ch);
         	else if(ch == ')'){
            	if(stack.peek() == '(')
                  return true;
              	while(operators.indexOf(stack.peek()) != -1)
                  stack.pop();
             	stack.pop();
            }
        }
      	return false;
	}

}
