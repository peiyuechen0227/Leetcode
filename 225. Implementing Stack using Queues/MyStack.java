import java.util.*;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void rePosition(){
        int size = queue.size();
        size--;
        while (size != 0) {
            queue.add(queue.poll());
            size--;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int i = stack.pop();
        System.out.println(i);
    }
}
