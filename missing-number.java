class Solution {
    public int missingNumber(int[] nums) {
​
//         boolean[] tr = new boolean[nums.length + 1];
//         for(int i = 0; i < nums.length; i++) tr[nums[i]] = true;
//         for(int i = 0; i < tr.length; i++) if(tr[i] == false) return i;
        
//         return 99;
        
        int miss = nums.length;
        for(int i = 0; i < nums.length; i++) {
            miss ^= i;
            miss ^= nums[i];
        }
        
        return miss;
    }
}
