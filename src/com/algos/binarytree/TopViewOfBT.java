package com.algos.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//O(n) ST
//https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(40);
		Node n4 = new Node(60);
		Node n5 = new Node(30);
		Node n6 = new Node(90);
		Node n7 = new Node(100);
		Node n8 = new Node(101);
		Node n9 = new Node(102);
		Node n10 = new Node(103);
		
		n1.left = n2;
		n2.left = n3;
		n2.right = n4;
		
		n1.right = n5;
		n5.left = n6;
		n5.right = n7;
		n7.left = n8;
		n8.right = n9;
		n9.right = n10;
		System.out.println(topView(n1));
	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	static class TreeInfo{
        int level;
        Node node;
        
        public TreeInfo(Node node, int level){
            this.node= node;
            this.level = level;
        }
    }
    
    //O(N) ST
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<TreeInfo> queue = new LinkedList<TreeInfo>();
        queue.add(new TreeInfo(root, 0));
        while(!queue.isEmpty()){
            TreeInfo currNode = queue.poll();
            if(!map.containsKey(currNode.level)){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(currNode.node.data);
                map.put(currNode.level, list);
            }
            else
                map.get(currNode.level).add(currNode.node.data);
            if(currNode.node.left != null){
                queue.add(new TreeInfo(currNode.node.left, currNode.level -1));
            }
            if(currNode.node.right != null){
                queue.add(new TreeInfo(currNode.node.right, currNode.level +1));
            }
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            result.add(entry.getValue().get(0));
        }
        
        return result;
    }

}
