package com.algos.strings;

import java.util.HashMap;
import java.util.Map;

public class CustomersWhoDidntUseComputer {
	// https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(customerWhoDidntUseComputer(1, "ABCBCADEED"));
	}

	// O(n)ST
	public static int customerWhoDidntUseComputer(int comps, String str) {
		Map<Character, Integer> customers = new HashMap<Character, Integer>();
		Map<Character, Integer> lostCustomers = new HashMap<Character, Integer>();
		int totalComp = comps;
		int i = 0;
		int customerCount = 0;
		while (i < str.length()) {
			char customer = str.charAt(i);
			if (!customers.containsKey(customer) && totalComp > 0) {
				customers.put(customer, 1);
				totalComp--;
			} else if (customers.containsKey(customer)) {
				customers.put(customer, 0);
				totalComp++;
			} else if (totalComp == 0 && !lostCustomers.containsKey(customer)) {
				lostCustomers.put(customer, 0);
				customerCount++;
			}

			i++;
		}
		return customerCount;
	}
}
