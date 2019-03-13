package leetcodeStackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues225 {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);  
		stack.push(3);
		System.out.println(stack.top());   // returns 2
		//System.out.println(stack.pop());   // returns 2
		//System.out.println(stack.empty()); // returns false
	}
}
class MyStack {
	Queue<Integer> inQueue = new LinkedList<Integer>();
	Queue<Integer> outQueue = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int n = inQueue.size();
        for(int i=0;i<n-1;i++) {
        	outQueue.add(inQueue.poll());
        }
        int out = inQueue.poll();
        inQueue.addAll(outQueue);//把outQueue中的数据全部放入inQueue
        outQueue.clear();
        return out;
    }
    
    /** Get the top element. */
    public int top() {
    	int n = inQueue.size();
        for(int i=0;i<n-1;i++) {
        	outQueue.add(inQueue.poll());
        }
        int out = inQueue.poll();
        inQueue.addAll(outQueue);//把outQueue中的数据全部放入inQueue
        inQueue.add(out);
        outQueue.clear();
        return out;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty();
    }
}

