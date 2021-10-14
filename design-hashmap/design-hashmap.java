class MyHashMap {
    
    Node[] hashmap;
    private final int CAPACITY = 10000;
    
    public MyHashMap() {
        hashmap = new Node[this.CAPACITY];
    }
    
    public void put(int key, int value) {
        int idx = calcIdx(key);
        if(hashmap[idx] == null) {
            hashmap[idx] = new Node(-1, -1);
            Node curr = new Node(key, value);
            
            hashmap[idx].next = curr;
            curr.prev = hashmap[idx];
        } else {
            // traverse to end of LL, see if already in bucket
            Node curr = hashmap[idx];
            Node prev = null;
            while(curr != null) {
                if(curr.key == key) {
                    curr.val = value;
                    return;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            
            Node toAdd = new Node(key, value);
            prev.next = toAdd;
            toAdd.prev = prev;
        }
    }
    
    public int get(int key) {
        int idx = calcIdx(key);
        Node curr = hashmap[idx];
        while(curr != null) {
            if(curr.key == key) return curr.val;
            else curr = curr.next;
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int idx = calcIdx(key);
        Node curr = hashmap[idx];
        while(curr != null) {
            if(curr.key == key) {                
                curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
                
                curr.prev = null;
                curr.next = null;
                return;
            } else curr = curr.next;
        }
    }
    
    private int calcIdx(int key) {
        return Integer.hashCode(key) % this.CAPACITY;
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
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */