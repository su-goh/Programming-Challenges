class Solution {
    public int numIdenticalPairs(int[] nums) {
        if(nums.length == 1) return 0;
        
        Arrays.sort(nums);
        
        int currLen = 0;
        int numPairs = 0;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) currLen++;
            else {
                if(currLen > 0) {
                    int fact = 0; 
                    for(int j = 1; j <= currLen; j++) fact += j;
                    numPairs += fact;
                    
                    currLen = 0;
                } else {
                    //
                }
            }
        }
        
        int fact = 0;
        for(int j = 1; j <= currLen; j++) fact += j;
        numPairs += fact;       
        
        return numPairs;
    }
}
