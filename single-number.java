import java.util.Arrays;
​
class Solution {
    public int singleNumber(int[] nums) {
        
        int k = 0;
        
        for (int i = 0; i < nums.length; i++) {
            k ^= nums[i];
        }
        return k;
    }
}
