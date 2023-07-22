package com.shucai.clas04;



/**
 * 两个链表逆序相加
 * 
 * @author x
 *
 */
public class TwoListPlus {
	public class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}

	}

	public static ListNode plus(ListNode l1, ListNode l2) {
		int len1 = len(l1);
		int len2 = len(l2);
		ListNode l = len1 >= len2 ? l1 : l2;
		ListNode s = l == l1 ? l2 : l1;

		int carry = 0;
		ListNode last = l;
		while (s != null) {
			int val = l.val + s.val + carry;
			l.val = val % 10;
			carry = val / 10;
			last = l;
			l = l.next;
			s = s.next;
		}
		while (l != null) {
			int val = l.val + carry;
			l.val = val * 10;
			carry = val / 10;
			last = l;
			l = l.next;
		}
		
		if (carry != 0) {
//			l.next = new ListNode(1);
		}
		return l;
	}

	public static int len(ListNode l) {
		int len = 0;
		while (l != null) {
			len++;
			l = l.next;
		}
		return len;
	}
}
