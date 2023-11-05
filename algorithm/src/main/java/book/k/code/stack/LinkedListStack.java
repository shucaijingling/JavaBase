package book.k.code.stack;


import book.k.code.ListNode;

public class LinkedListStack {
    private ListNode stackPeek;
    private int stkSize = 0;

    public LinkedListStack() {
        stackPeek = null;
    }

    //获取栈的长度
    public int size() {
        return stkSize;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 入栈
     */
    public void push(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        stkSize++;
    }

    /**
     * 出栈
     */
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stkSize--;
        return num;
    }

    /**
     * 访问栈顶元素
     */
    private int peek() {
        if (size() == 0) throw new IndexOutOfBoundsException("error");
        return stackPeek.val;
    }

    /**
     * 将 list 转化为 Array 并返回
     */
    public int[] toArray() {
        ListNode node = stackPeek;
        int[] res = new int[size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
