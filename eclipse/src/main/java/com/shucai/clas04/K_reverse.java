package com.shucai.clas04;

/**
 * 每k个反转
 * 
 * @author x
 *
 */
public class K_reverse {

	public class Node {
		public int val;
		public Node next;

	}
	
	public Node rev(Node head, int k) {
		Node start = head;
		Node end  = findend(head, k);
		if (end == null) {
			return head;
		}
		head = end;
		reverse(start, end);
		Node lastEnd = start;
		while (lastEnd.next != null) {
			start = lastEnd.next;
			end = findend(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
		}
		
		return head;
	}
	
	public static Node findend(Node start, int k) {
		while (--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}
	
	public static void reverse(Node start, Node end) {
		end = end.next;
		Node pre = null;
		Node cur = start;
		Node next = null;
		while (cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}
	
	
}
