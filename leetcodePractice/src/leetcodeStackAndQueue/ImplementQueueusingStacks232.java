package leetcodeStackAndQueue;

import java.util.Stack;

public class ImplementQueueusingStacks232 {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);  
		System.out.println(queue.peek());  // returns 1
		System.out.println(queue.pop());   // returns 1
		System.out.println(queue.empty()); // returns false
	}
}
class MyQueue {
	//设计两个栈，一个用来接收数据，一个用来输出数据
	Stack< Integer> inStack = new Stack<>();
	Stack< Integer> outStack = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.isEmpty()) {
        	while(!inStack.isEmpty()) {//把inStack中所有数据压入outStack
        		outStack.push(inStack.pop());
        	}
        }
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()) {
        	while(!inStack.isEmpty()) {//把inStack中所有数据压入outStack
        		outStack.push(inStack.pop());
        	}
        }
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }
}
