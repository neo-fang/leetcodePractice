package leetcodeStackAndQueue;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack155 {
public static void main(String[] args) {
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	System.out.println(minStack.getMin());   //Returns -3.
	minStack.pop();
	System.out.println(minStack.top());      // Returns 0.
	System.out.println(minStack.getMin());   // Returns -2.
}
}
class MinStack {
	Stack<Integer> stack = new Stack<>();
	//用小根堆保存栈中每一个元素
	PriorityQueue<Integer> min = new PriorityQueue<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        min.add(x);
    }
    
    public void pop() {
        int tmp = stack.pop();
        min.remove(tmp);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
