class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < temp.length; i++) {
            map.putIfAbsent(temp[i], i);
        }
        
        int[] ret = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            ret[i] = map.get(nums[i]);
        }
        
        return ret;
    }
}
