package com.algos.linkedlist;

public class MultiplyTwoLinkedLists {
	
	//https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(n) ST
	public long multiplyTwoLists(Node l1,Node l2){
        //add code here.
        Node n1 = l1;
        Node n2 = l2;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while(n1!=null){
            str1.append(String.valueOf(n1.data));
            n1 = n1.next;
        }
        while(n2!=null){
            str2.append(String.valueOf(n2.data));
            n2 = n2.next;
        }
      
      java.math.BigInteger num1 = new java.math.BigInteger(str1.toString());
      java.math.BigInteger num2 = new java.math.BigInteger(str2.toString());
      java.math.BigInteger mul = num1.multiply(num2);
      java.math.BigInteger modd = new java.math.BigInteger("1000000007");
      java.math.BigInteger res = mul.mod(modd);
      Long rs = res.longValue();
      return rs;
 }

}
