class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int n, k;
​
​
    public List<List<Integer>> subsets(int[] nums) {
        
        // need a loop that loops through the many sizes I want
        for(int i = 0; i < nums.length + 1; i++) {
            //call the method
            int desiredSize = i;
            recurse(i ,0, new ArrayList<Integer>(), nums);
        }
        
        return list;
    }
​
    public void recurse(int desiredSize, int first, List<Integer> curr ,int[] nums){
        // checks equals to size desired, if yes adds to list
        if(curr.size() == desiredSize) {
            list.add(new ArrayList(curr));
            return;
        }
        
        // if no
        // try each combinition
        for(int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            recurse(desiredSize, i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
        
    }
​
}
