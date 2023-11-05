package book.k.code.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        int peek = queue.peek();
        System.out.println(peek);
        int pop = queue.poll();
        System.out.println(pop);
        int size = queue.size();
        System.out.println(size);
        boolean empty = queue.isEmpty();
        System.out.println(empty);
    }
}
