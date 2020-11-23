class Solution {
    public int majorityElement(int[] nums) {
        
        Arrays.sort(nums);
        return(nums[nums.length/2]);
//         HashMap<Integer,Integer> map = new HashMap<>();
//         int maxLen = 0;
//         int maxInt = nums[0];
        
//         for(int i = 0; i < nums.length; i++) {
            
//             // curr num in map
//             if(map.containsKey(nums[i])) {
//                 int len = map.get(nums[i]) + 1;
                
//                 // found the majority
//                 if(len > nums.length/2) return nums[i];
                
//                 // update max if true
//                 if (len > maxLen) {
//                     maxLen = len;
//                     maxInt = nums[i];
//                 }
                
//                 map.replace(nums[i], len);
//             } else { // curr num not in map, add
//                 map.put(nums[i], 1);
//             }
//         }
        
       // return maxInt;
    }
}
