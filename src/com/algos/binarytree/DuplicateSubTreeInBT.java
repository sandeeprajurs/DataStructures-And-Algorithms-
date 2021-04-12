package com.algos.binarytree;

import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1#
//O(n) ST
public class DuplicateSubTreeInBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	int dupSub(Node root) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        findDups(root, map);
        for(String s:map.keySet()){
            if(map.get(s) > 1)
                return 1;
        }
        return 0;
    }
    
    public String findDups(Node node, Map<String, Integer>map){
        if(node == null) return "$";
        String s = "";
        if(node.left == null && node.right == null){
            s = ""+node.data;
            return s;
        }
        s = s+ node.data;
        s = s+ findDups(node.left, map);
        s = s+ findDups(node.right, map);
        if(map.containsKey(s))
            map.put(s, map.get(s)+1);
        else
            map.put(s, 1);
        return s;
    }

}
