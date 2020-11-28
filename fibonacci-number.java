class Solution {
    public int fib(int N) {
        int curr = 1;
        int prev = 0;
        
        if(N == 0) return prev;
        if(N == 1) return curr;
        
        for(int i = 2; i <= N; i++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        
        return curr;
    }
}
