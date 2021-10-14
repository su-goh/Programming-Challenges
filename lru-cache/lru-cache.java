class LRUCache {

    HashMap<Integer, Node> cacheMap;
    Node cacheHead;
    Node cacheTail;
    int size;
    int capacity;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        cacheHead = new Node(-1, -1);
        cacheTail = new Node(-1, -1);
        
        cacheHead.next = cacheTail;
        cacheTail.prev = cacheHead;
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            // move to top
            moveToTop(remove(key));
            return cacheMap.get(key).val;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            cacheMap.get(key).val = value;
            moveToTop(remove(key));
        } else {
            Node curr = new Node(key, value);
            moveToTop(curr);
            cacheMap.put(key, curr);
            size++;
            
            if(size > capacity) {
                Node toRemove = remove(cacheTail.prev.key);
                cacheMap.remove(toRemove.key);
                size--;
            }
        }
    }
    
    private Node remove(int key) {
        Node curr = cacheMap.get(key);
        Node prev = curr.prev;
        Node next = curr.next;
        
        prev.next = next;
        next.prev = prev;
        
        curr.next = null;
        curr.prev = null;
        
        return curr;
    }
    
    private void moveToTop(Node curr) {
        curr.prev = cacheHead;
        curr.next = cacheHead.next;

        cacheHead.next = curr;
        curr.next.prev = curr;
    }
    
    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */