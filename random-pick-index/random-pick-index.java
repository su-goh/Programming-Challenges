class Solution {

    HashMap<Integer, ArrayList<Integer>> map;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(i);
                map.put(nums[i], curr);
            }
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> curr = map.get(target);
        Random r = new Random();
        
        return curr.get(r.nextInt(curr.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */