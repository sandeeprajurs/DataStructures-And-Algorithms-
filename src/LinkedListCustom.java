
class Node {
	Node next;
	Node prev;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedListCustom {
	Node head;
	Node tail;

	public void insert(Node nodeToInsert) {
		if (this.head == null) {
			this.head = nodeToInsert;
			this.tail = nodeToInsert;
		} else {
			insertAfter(tail, nodeToInsert);
		}
	}

	public void insertAfter(Node node, Node nodeToInsert) {
		if (node.next == null) {
			node.next = nodeToInsert;
			nodeToInsert.prev = node;
			tail = nodeToInsert;
		} else {
			nodeToInsert.next = node.next;
			nodeToInsert.next.prev = nodeToInsert;
			node.next = nodeToInsert;
			nodeToInsert.prev = node;
		}
	}

	public void insertBefore(Node node, Node nodeToInsert) {
		if (node.prev == null) {
			nodeToInsert.next = node;
			head = nodeToInsert;
		} else {
			nodeToInsert.prev = node.prev;
			node.prev.next = nodeToInsert;
			node.prev = nodeToInsert;
			nodeToInsert.next = node;
		}
	}

	public void remove(Node nodeToRemove) {
		if (head == tail) {
			head = null;
			tail = null;
		} else if (head == nodeToRemove)
			head = head.next;
		else if (tail == nodeToRemove) {
			tail = tail.prev;
			tail.next = null;
		} else
			removeNode(nodeToRemove);
	}

	public void removeNode(Node nodeToRemove) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == nodeToRemove.data)
				break;
			temp = temp.next;
		}

		Node tempPrevNode = temp.prev;
		Node tempNextNode = temp.next;
		tempPrevNode.next = tempNextNode;
		tempNextNode.prev = tempPrevNode;
		temp = null;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(22);
		LinkedListCustom ll = new LinkedListCustom();
		ll.insert(n1);
		ll.insert(n2);
		ll.insert(n3);
		ll.insert(n4);
//		ll.insertBefore(n4, n5);
		Node node= ll.head;
		while(node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
		
		reverseLinkedList(ll);
	}
	
	
	public static void reverseLinkedList(LinkedListCustom ll) {
		Node p1 = null;
		Node p2 = ll.head;
		while(p2 != null) {
			Node p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		System.out.println(p1);
	}

}
