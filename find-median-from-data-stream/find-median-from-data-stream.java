class MedianFinder {

    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    int size;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
        size = 0;
    }
    
    public void addNum(int num) {
        if(size % 2 == 0) leftMax.add(num);
        else rightMin.add(num);
        size++;
        
        while (size > 1 && leftMax.peek() > rightMin.peek()) {
            // System.out.println(size + " " + (size % 2 != 0 && leftMax.size() > Math.ceil(size/2.0)));
            int leftTemp = leftMax.poll();
            int rightTemp = rightMin.poll();
            rightMin.add(leftTemp);
            leftMax.add(rightTemp);
        }
    }
    
    public double findMedian() {
        if(size % 2 == 0) {
            System.out.println("both " + leftMax.peek() + " " + rightMin.peek());
            return (leftMax.peek() + rightMin.peek())/2.0;
        } else {
            System.out.println("not both");
            return (double) leftMax.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */