package No_1_200.No155最小栈;

import java.util.Stack;

public class MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (stack.empty()) {
            min = Integer.MAX_VALUE;
            return;
        }
        if (pop == min) {
            min = stack.peek();
            for (Integer i : stack) {
                min = Math.min(i, min);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
