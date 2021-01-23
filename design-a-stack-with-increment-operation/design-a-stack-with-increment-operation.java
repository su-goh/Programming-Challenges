class CustomStack {
    int[] list;
    int maxSize;
    int len = 0;
    
    public CustomStack(int maxSize) {
        list = new int[maxSize];
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(len >= maxSize) return;
        list[len++] = x;
    }
    
    public int pop() {
        if(len <= 0) return -1;
        return list[--len];
    }
    
    public void increment(int k, int val) {
        k = (k >= len) ? len : k;
        for(int i = 0; i < k; i++) {
            list[i] += val;
        }
    }
}
​
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
