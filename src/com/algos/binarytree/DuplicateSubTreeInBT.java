package com.algos.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//we have 2 varients in this problem..please check below
//https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1#
//O(n) ST
public class DuplicateSubTreeInBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(2);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(3);
//		Node node6 = new Node(4);
//		Node node7 = new Node(4);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
//		node3.right = node6;
//		node5.left = node7;
		List<Node> list = getListOfSub(node1);
		System.out.println(list);
	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	////////////////////////////////Check if it has Dupe sub trees//////////////////////////////////////////////////////
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
    
    ////////////////////////////////List all the duplicate sub tree//////////////////////////////////////////////////////
    static List<Node> getListOfSub(Node root) {
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	Map<String, Boolean> map1 = new HashMap<String, Boolean>();
        List<Node> list = new ArrayList<DuplicateSubTreeInBT.Node>();
        listDups(root, map, map1, list);
        return list;
    }
    
    public static String listDups(Node node, Map<String, Integer> map, Map<String, Boolean> map1, List<Node> list){
    	if(node == null) return "$";
        String s = "";
        s = s+ node.data;
        s = s+"/"+ listDups(node.left, map, map1, list);
        s = s+ listDups(node.right, map, map1, list);
        if(map.containsKey(s)) {
            map.put(s, map.get(s)+1);
            if(map1.get(s) == false) {
            	list.add(node);
            }
            map1.put(s, true);
    	}
        else {
        	map.put(s, 1);
        	 map1.put(s, false);
        }
        return s;
    }

}
