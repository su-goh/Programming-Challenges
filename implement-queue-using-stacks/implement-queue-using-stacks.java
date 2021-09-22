class MyQueue {
    Stack<Integer> backlog;
    Stack<Integer> queue;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        backlog = new Stack<>();
        queue = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        backlog.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!queue.empty()) return queue.pop();
        
        while(!backlog.empty()) {
            queue.push(backlog.pop());
        }
        
        return this.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!queue.empty()) return queue.peek();
        
        while(!backlog.empty()) {
            queue.push(backlog.pop());
        }
        
        return this.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return backlog.empty() && queue.empty() ? true : false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */