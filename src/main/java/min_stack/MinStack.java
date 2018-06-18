package min_stack;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinStack {

//    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//            push(x) -- Push element x onto stack.
//            pop() -- Removes the element on top of the stack.
//    top() -- Get the top element.
//    getMin() -- Retrieve the minimum element in the stack.
//            Example:
//    MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//            minStack.pop();
//minStack.top();      --> Returns 0.
//            minStack.getMin();   --> Returns -2.
    // Insert your Solution class here
class MinStack1 {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack1() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int i = stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == i) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static class UnitTest {
        @Test
        public void testMinStack() {
           // Solution s = new MinStack().new Solution();
        }
    }
}

