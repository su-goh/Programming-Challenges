class Solution {
    public int climbStairs(int n) {
        int curr = 2;
        int prev = 1;
        
        if(n == 1) return prev;
        if(n == 0) return 0;
        
        for(int i = 3; i <= n; i++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        
        return curr;
        
     }
}
