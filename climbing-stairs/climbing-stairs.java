class Solution {
    public int climbStairs(int n) {
        int curr = 2;
        int prev = 1;
        
        for(int i = 2; i < n; i++) {
            int temp = prev;
            prev = curr;
            curr = curr + temp;
        }
        
        return (n == 1) ? prev : curr;
    }
}