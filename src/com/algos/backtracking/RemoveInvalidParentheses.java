package com.algos.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()(((()l("));
	}

	static List<String> result = new ArrayList<String>();
	static Set<String> set1 = new HashSet<String>();

	public static List<String> removeInvalidParentheses(String s) {
		int min = getMin(s);
		Set<String> set = new HashSet<String>();
		solutionString(min, s, set);
		return result;
	}

	public static void solutionString(int minRemoval, String str, Set<String> set) {
		if (minRemoval == 0) {
			int currMinRemoval = getMin(str);
			if (currMinRemoval == 0 && !set.contains(str)) {
				set.add(str);
				result.add(str);
			}
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			if (!set1.contains(left + right)) {
				set1.add(left + right);
				solutionString(minRemoval - 1, left + right, set);
			}
		}
	}

	public static int getMin(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				stack.add('(');
			else if (c == ')') {
				if (stack.isEmpty())
					stack.add(')');
				else if (stack.peek() == ')')
					stack.add(')');
				else if (stack.peek() == '(')
					stack.pop();
			}
		}
		return stack.size();
	}
}
