package No_201_400.No225用队列实现栈;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(x);
            return;
        }
        if (!queue1.isEmpty()) {
            queue1.add(x);
            return;
        }
        queue2.add(x);
    }

    public int pop() {
        if (!queue1.isEmpty()){
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        if (!queue2.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        return queue1.poll();
    }

    public int top() {
        if (!queue1.isEmpty()){
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            Integer poll = queue1.poll();
            queue2.add(poll);
            return poll;
        }
        if (!queue2.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            Integer poll = queue2.poll();
            queue1.add(poll);
            return poll;
        }
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

