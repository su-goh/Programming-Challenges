class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
                        
            if(map.containsKey(find)) {
                int[] ret = {map.get(find), i};
                return ret;
            }
            
            map.put(nums[i], i);
​
        }
        
        return null;
    }
}
