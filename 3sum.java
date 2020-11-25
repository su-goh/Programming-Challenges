class Solution {
    
    // List<List<Integer>> li; //= new ArrayList<>();
    // Map<Integer,Integer> map;// = new HashMap<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        // TOO SLOW, Map approach
//         li = new ArrayList<>();
//         map = new HashMap<>();
        
//         for(int i = 0; i < nums.length; i++) {
//             twoSum(nums, 0 - nums[i], i);
​
//         }
        
//         return li;
        
        
        
        // two pointers approach
        Arrays.sort(nums);
        List<List<Integer>> li = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int p1 = i + 1, p2 = nums.length - 1;
            int target = 0 - nums[i];
            
            while(p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if(sum == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[p1]);
                    curr.add(nums[p2]);
                    
                    // curr.sort((Integer n1, Integer n2) -> n1 - n2);
                    //if(!li.contains(curr)) 
                    li.add(curr);
                    
                    while(p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                    while(p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                    
                    p1++;
                    p2--;
                } else if (sum < target) p1++;
                else p2--;
            }
            
        }
