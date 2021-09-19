class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode next;
        DLinkedNode prev;
        
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        // add to head
        public void add(DLinkedNode newNode) {
            this.next = newNode;
            newNode.prev = this;
        }
        
        // detach node from list
        public void detach() {
            // TODO what if prev or next is head/tail
            this.prev.next = this.next;
            this.next.prev = this.prev;
            
            this.prev = null;
            this.next = null;
        }
    }
    
    Map<Integer, DLinkedNode> cache;
    DLinkedNode head;
    DLinkedNode tail;
    int capacity;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            DLinkedNode targetNode = cache.get(key);
            targetNode.detach();
            moveToHead(targetNode);
            return targetNode.val;
        } else return -1;
    }
    
    public void put(int key, int value) {        
        if(cache.containsKey(key)) {
            DLinkedNode target = cache.get(key);
            target.val = value;
            target.detach();
            moveToHead(target);
        } else {
            if(cache.size() >= capacity) {
                removeLeast();
            }   
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            moveToHead(newNode);
        }
    }
    
    private void moveToHead(DLinkedNode newHead) {
        newHead.next = head.next;
        newHead.prev = head;
        
        head.next.prev = newHead;
        head.next = newHead;
        
        System.out.println("new head: " + head.next.key + " tail: " + tail.prev.key);
    }
    
    private void removeLeast() {
        DLinkedNode toRemove = tail.prev;
        // tail.prev = tail.prev.prev;
        // tail.prev.next = tail;
        toRemove.detach();
        cache.remove(toRemove.key);
        
        System.out.println("removed " + toRemove.key);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */