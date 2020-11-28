class Solution {
    public int reverse(int x) {
        int temp = x;
        int ret = 0;
        
        while(temp != 0) {
            if(ret > Integer.MAX_VALUE/10 || ret < Integer.MIN_VALUE/10) {
                return 0;
            } else {
                ret = ret*10 + temp % 10;
                temp /= 10;
            }
        }
        
        return ret;
    }
}
