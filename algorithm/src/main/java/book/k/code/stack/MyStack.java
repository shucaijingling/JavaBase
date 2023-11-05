package book.k.code.stack;

import java.util.Stack;

/**
 * 栈
 */
public class MyStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        //访问栈顶元素
        int peek = stack.peek();
        System.out.println(peek);
        //元素出栈
        int pop = stack.pop();
        System.out.println(pop);
        // 获取栈的长度
        int size = stack.size();
        System.out.println(size);
        //判断是否为空
        boolean empty = stack.isEmpty();
        System.out.println(empty);
    }


}
