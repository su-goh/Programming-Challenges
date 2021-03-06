class Solution {
    public boolean isPowerOfThree(int n) {
                //naiive approach, but second fastest
        if(n == 0) return false;
        
        while (n != 1) {
            if (n%3 != 0) return false;
            n = n/3;
        }
        
        return true;
        
        // quick smart way
        //return n > 0 && 1162261467 % n == 0;  
    }
}
