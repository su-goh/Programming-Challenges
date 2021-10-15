class LFUCache {
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Integer> count;
    HashMap<Integer, LinkedHashSet<Integer>> counts;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.count = new HashMap<>();
        this.counts = new HashMap<>();
        
        this.capacity = capacity;
        this.min = 0;
    }
    
    public int get(int key) {
        if(min == 0 || !cache.containsKey(key)) return -1;
        else {
            int keyCount = count.get(key);
            count.put(key, keyCount + 1);
            counts.putIfAbsent(keyCount + 1, new LinkedHashSet<>());
            counts.get(keyCount + 1).add(key);
            counts.get(keyCount).remove(key);
            if(counts.get(keyCount).size() == 0) counts.remove(keyCount);
            if(min == keyCount && !counts.containsKey(keyCount)) min++;
            return cache.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
        } else {
            if(min > 0 && cache.size() == this.capacity) {
                int toRemove = counts.get(min).iterator().next();
                cache.remove(toRemove);
                count.remove(toRemove);
                counts.get(min).remove(toRemove);
                if(counts.get(min).size() == 0) counts.remove(min);
            }
            
            if(this.capacity > 0) {
                min = 1;
                cache.put(key, value);
                count.put(key, min);
                counts.putIfAbsent(min, new LinkedHashSet<>());
                counts.get(min).add(key);
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */