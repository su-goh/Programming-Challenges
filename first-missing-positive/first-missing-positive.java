class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        
        for(int i = 1; i <= Integer.MAX_VALUE; i++) {
            if(!numsSet.contains(i)) return i;
        }
        
        return -1;
    }
}