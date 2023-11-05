package book.k.code.stack;

import java.util.ArrayList;

public class ArrayStack {

    private ArrayList<Integer> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    /**
     * 栈的长度
     */
    public int size() {
        return stack.size();
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 入栈
     */
    public void push(int num) {
        stack.add(num);
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException("error");

        return stack.remove(size() - 1);
    }

    /**
     * 访问栈顶元素
     */
    public int peek() {
        if (isEmpty()) throw new IndexOutOfBoundsException("error");

        return stack.get(size() - 1);
    }

    /**
     * 将 list 转化为 array 并返回
     */
    public Object[] toArray() {
        return stack.toArray();
    }
}
