class Solution {
    public void rotate(int[] nums, int k) {
        //[1,2,3,4,5,6,7], O(c*n) ,O(1) space
        // 1. Reverse it -> [7,6,5,4,3,2,1]
        // 2. cut at k -> [7,6,5] | [4,3,2,1]
        // 3. reverse these two array -> [5,6,7] | [1,2,3,4]
        // 4. combine them -> [5,6,7,1,2,3,4]
        
        
        
        // the other way is: O(n) time, O(n) space
        // let k = (nums.length > k) k : k - nums.length
        // make a new array
        // starting from i = nums.length - k, copy nums[k] -> nums[0], ...
        // [1,2,3,4,5,6,7], k = 3
        // [5,6,7,1,2,3,4] 
        
        int[] newArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            newArray[(i+k)%nums.length] = nums[i];
        }
        
        for(int i = 0; i < nums.length; i++) nums[i] = newArray[i];
​
    }
}
