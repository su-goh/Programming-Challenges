class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int looking = target - nums[i];
            if(map.containsKey(looking)) {
                res[0] = map.get(looking);
                res[1] = i;
                break;
            } else map.put(nums[i], i);
            
        }
        
        return res;
    }
}