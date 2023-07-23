package code;

import java.util.PriorityQueue;

public class Code23_MergeKSortedLists {

    //定义节点
    public static class ListNode {
        public int val;
        public ListNode next;

    }

    public ListNode MergeKSortedLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }

        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }
}
