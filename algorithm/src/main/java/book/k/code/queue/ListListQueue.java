package book.k.code.queue;

import book.k.code.ListNode;

public class ListListQueue {

    private ListNode front, rear;
    private int queSize = 0;

    public ListListQueue() {
        front = null;
        rear = null;
    }

    public int size() {
        return queSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public void push(int num) {
        ListNode node = new ListNode(num);
        if (front == null) {
            front = node;
            rear = node;
        }else {
            rear.next = node;
            rear = node;
        }
        queSize++;
    }

    public int pop() {
        int num = peek();
        front = front.next;
        queSize--;
        return num;
    }

    private int peek() {
        if (size() == 0)
            throw new IndexOutOfBoundsException("error");
        return front.val;
    }

    /**
     * 将链表转化为 Array 并返回
     */
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
