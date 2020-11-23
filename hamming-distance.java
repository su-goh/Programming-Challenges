class Solution {
    public int hammingDistance(int x, int y) {
        //return Integer.bitCount(x^y);
        int num = 0;
        int diff = x ^ y;
        
        while(diff != 0) {
            if(diff%2 == 1) num++;
            diff = diff >> 1;
        }
        return num;
    }
}
