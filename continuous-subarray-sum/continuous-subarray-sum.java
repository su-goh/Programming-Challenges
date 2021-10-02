class Solution {
    int[] nums;
    
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mods = new HashMap<>();
        mods.put(0, -1);
        int currSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if(k > 0) currSum %= k;
            
            if(mods.containsKey(currSum) && i - mods.get(currSum) > 1) return true;
            mods.putIfAbsent(currSum, i);
        }
        
        return false;
    }
    

}