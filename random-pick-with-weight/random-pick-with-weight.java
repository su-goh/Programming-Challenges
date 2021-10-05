class Solution {
    int[] accumulatedW;
    Random rdm;
    
    public Solution(int[] w) {
        accumulatedW = new int[w.length];
        rdm = new Random();
        for(int i = 0; i < w.length; i++) {
            accumulatedW[i] = (i == 0) ? w[i] : w[i] + accumulatedW[i - 1];
        }
    }
    
    public int pickIndex() {
        int target = 1 + rdm.nextInt(accumulatedW[accumulatedW.length - 1]);
        
        int l = 0, r = accumulatedW.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            
            if(accumulatedW[m] < target) l = m + 1;
            else if(accumulatedW[m] > target) r = m - 1;
            else return m;
        }
        
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */