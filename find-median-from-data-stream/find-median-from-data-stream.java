class MedianFinder {
    
    PriorityQueue<Integer> h1;
    PriorityQueue<Integer> h2;
    int size;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        // max-pq of first half, min-pq of second half
        h1 = new PriorityQueue<>(Collections.reverseOrder());
        h2 = new PriorityQueue<>();
        size = 0;
    }
    
    public void addNum(int num) {
        size++;
        
        if(size % 2 == 0) {
            h2.add(num);
            h1.add(h2.poll());
        } else {
            h1.add(num);
            h2.add(h1.poll());
        }
        System.out.println(h1.peek() + " " + h2.peek() + " " + size);

    }
    
    public double findMedian() {
        // System.out.println(h1.peek() + " " + h2.peek() + " " + size);
        if (size % 2 == 0) return (h1.peek() + h2.peek())/2.0;
        else return h2.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */