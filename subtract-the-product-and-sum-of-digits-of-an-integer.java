class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        
        while(n > 0) {
            int curr = n % 10;
            product *= curr;
            sum += curr;
            
            n /= 10;
        }
        
        return product - sum;
    }
}
