public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int k = 0;
        for(int i = 0 ; i < 32; i++) {
            k += n&1;
            n = n >> 1;
            if(i < 31) k = k << 1;
        }
        return k;
    }
}
