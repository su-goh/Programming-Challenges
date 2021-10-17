class MaxStack {
    
    class LinkedNode {
        LinkedNode prev;
        LinkedNode next;
        int val;
        int score;
        
        public LinkedNode(int val, int score) {
            this.val = val;
            this.score = score;
        }
        
        public LinkedNode() {}
    }
    
    LinkedNode head;
    LinkedNode tail;
    PriorityQueue<LinkedNode> maxes;
    
    public MaxStack() {
        head = new LinkedNode();
        tail = new LinkedNode();
        maxes = new PriorityQueue<>((a, b) -> {
            if(a.val == b.val) {
                return (b.score - a.score);
            } else {
                return (b.val - a.val);
            }
        });
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        LinkedNode curr = new LinkedNode(x, maxes.size());
        tail.prev.next = curr;
        curr.prev = tail.prev;
        curr.next = tail;
        tail.prev = curr;
        
        maxes.add(curr); 
    }
    
    public int pop() {
        LinkedNode toRemove = tail.prev;
        toRemove.prev.next = tail;
        tail.prev = toRemove.prev;
        maxes.remove(toRemove);
        
        return toRemove.val;
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return maxes.peek().val;
    }
    
    public int popMax() {
        LinkedNode removedMax = maxes.poll();
        
        removedMax.prev.next = removedMax.next;
        removedMax.next.prev = removedMax.prev;
        
        return removedMax.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */