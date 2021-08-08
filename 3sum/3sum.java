class Solution {
    
    List<List<Integer>> ret;
    Set<List<Integer>> added;
    int[] nums;
    
    public List<List<Integer>> threeSum(int[] nums) {
        ret = new ArrayList<>();
        added = new HashSet<>();
        this.nums = nums;
        Arrays.sort(this.nums);
        
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || i > 0 && nums[i] != nums[i-1])
                twoSum(-nums[i], i);
        }
        
        return ret;
    }
    
    private void twoSum(int target, int start) {
        Set<Integer> map = new HashSet<>();
        
        for(int i = start + 1; i < nums.length; i++) {
            int curr = nums[i];
            int newTarget = target - nums[i];
            if (map.contains(newTarget)) {
                List<Integer> temp = new ArrayList<>(){{
                    add(-target);
                    add(newTarget);
                    add(curr);
                }};
                if(added.contains(temp))
                    continue;
                ret.add(temp);
                added.add(temp);
            }
            map.add(nums[i]);
        }
    }
}