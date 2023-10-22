package book.k.code.linkedlist;

public class Linked_list {

    public static void main(String[] args) {

        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(n0);

        ListNode p = new ListNode(-1);
        insert(n0, p);
        printLinkedList(n0);

        remove(n0, p);
        printLinkedList(n0);

        ListNode access = access(n0, 1);
        System.out.println(access.val);

        int i = find(n0, 3);
        System.out.println(i);
    }

    // print
    static void printLinkedList(ListNode head) {
        if (head != null) {
            System.out.print(head.val);
        }
        head = head.next;
        while (head != null) {
            System.out.print(" -> ");
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    // insert p after n0
    static void insert(ListNode n0, ListNode p) {
        ListNode n1 = n0.next;
        n0.next = p;
        p.next = n1;
    }

    // delete node p
    static void remove(ListNode n0, ListNode p) {
        if (n0.next == null) return;
        n0.next = p.next;
    }


    // access by index
    static ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null) return null;
            head = head.next;
        }
        return head;
    }

    //find index
    static int find(ListNode head, int target) {
        int index = 0;
        while (head != null) {
            if (head.val == target) {
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }
}
