class MinStack {
    
    ArrayList<Integer> minStack;
    int min;
    int len;
    
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
        len = -1;
    }
    
    public void push(int x) {
        minStack.add(x);
        min = Math.min(min, x);
        len++;
    }
    
    public void pop() {
        int rem = minStack.remove(len--);
        if(min == rem) getMinHelper();
    }
    
    public int top() {
        return minStack.get(len);
    }
    
    public int getMin() {
        return min;
    }
    
    public void getMinHelper() {
        min = Integer.MAX_VALUE;
        for(int i = 0; i < len + 1; i++) {
            min = Math.min(min, minStack.get(i));
        }
    }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
