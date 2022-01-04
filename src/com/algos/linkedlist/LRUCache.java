package com.algos.linkedlist;

import java.util.HashMap;
import java.util.Map;

//O(1)ST
public class LRUCache {
	Map<String, Node> map = new HashMap<String, Node>();
	int size;
	int currSize;
	LinkedList dl;

	public LRUCache(int size) {
		this.size = size;
		dl = new LinkedList();
	}

	public void insertKeyValuePair(String key, Integer value) {
		if (currSize < size) {
			Node node = dl.insert(new Node(key, value));
			map.put(key, node);
			currSize++;
		} else if(map.containsKey(key)){
			System.out.println("contains key");
			Node node = map.get(key);
			node.value = value;
			map.put(key, node);
		}else {
			map.put(dl.head.key, null);
			dl.evictCache(new Node(key, value));
			map.put(dl.head.key, dl.head);
			map.put(dl.tail.key, dl.tail);
		}
	}

	public void getValueFromKey(String key) {
		if (map.containsKey(key) && map.get(key) != null) {
			 Node node = dl.reArrangeCache(map.get(key));
			 map.put(key, node);
			 System.out.println(key+" ------------ "+node.value);
		} else {
			System.out.println("No node present");
		}

	}

	public void getMostRectentKeyValue() {
		System.out.println(dl.tail.key + " ---------- " + dl.tail.value);
	}

	static class Node {
		String key;
		int value;
		Node next;
		Node prev;

		public Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	static class LinkedList {
		Node head;
		Node tail;

		public Node insert(Node node) {
			if (this.head == null) {
				this.head = node;
				this.tail = node;
				return head;
			}
			return insertAfter(node);
		}
		
		public Node insertAfter(Node node) {
			tail.next = node;
			node.prev = tail;
			tail = node;
			return tail;
		}

		public void evictCache(Node node) {
			if(head != tail) {
				this.head = this.head.next;
				this.head.prev = null;
				this.tail.next = node;
				node.prev = tail;
				this.tail = this.tail.next;
			}
			else {
				head = node;
				tail = node;
			}
		}

		public Node reArrangeCache(Node node){
			if(node != head && node != tail) {
				Node prev = node.prev;
				prev.next = node.next;
			}
			else if(node == head && head.next != null) {
				head = head.next;
			}
			else if(node == tail)
				return node;
			
			tail.next = node;
			node.prev = tail;
			tail = node;
			return tail;
		}

	}
	
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(1);
//		lruCache.insertKeyValuePair("a", 1);
//		lruCache.getMostRectentKeyValue();
//		
//		lruCache.insertKeyValuePair("b", 2);
//		lruCache.getMostRectentKeyValue();
//		
//		lruCache.insertKeyValuePair("c", 3);
//		lruCache.getMostRectentKeyValue();
//		
//		lruCache.getValueFromKey("a");
//		lruCache.getValueFromKey("b");
//		lruCache.getMostRectentKeyValue();
//		
//		lruCache.insertKeyValuePair("d", 4);
//		lruCache.getValueFromKey("c");
//		
//		lruCache.insertKeyValuePair("e", 5);
//		lruCache.getMostRectentKeyValue();
//		lruCache.getValueFromKey("a");
		
		lruCache.getValueFromKey("a");
		lruCache.insertKeyValuePair("a", 1);
		lruCache.getValueFromKey("a");
		lruCache.insertKeyValuePair("a", 9001);
		lruCache.getValueFromKey("a");
		lruCache.insertKeyValuePair("b", 2);
		lruCache.getValueFromKey("a");
		lruCache.getValueFromKey("b");
		
	}

}
