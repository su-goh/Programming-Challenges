class Solution {
    public void nextPermutation(int[] nums) {
        // find the last increasing index 0, i-1, i, n - 1
        // hence, i -> n - 1 is decreasing. Means this part is large.
        // hence, to make the number bigger, i -> n - 1 is already largest
        // therefore, i - 1 is the one we should change
        // the smallest change we can make is the smallest number in i, n-1
        // so swap [i - 1] and smallest num in i, n - 1 
        // (that's bigger than i - 1)
        // make sure [i...n-1] is as small as possible, hence sort this part
        
        int latestIncIndex = -1;
        
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                latestIncIndex = i - 1;
                break;
            }
        }
        
        if(latestIncIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        
        int smallestButBigger = Integer.MAX_VALUE;
        int smallestIdx = latestIncIndex;
        
        for(int i = latestIncIndex + 1; i < nums.length; i++) {
            if(nums[i] > nums[latestIncIndex] && nums[i] < smallestButBigger) {
                smallestButBigger = nums[i];
                smallestIdx = i;
            }
        }
        
        int temp = nums[latestIncIndex];
        nums[latestIncIndex] = nums[smallestIdx];
        nums[smallestIdx] = temp;
        
        Arrays.sort(nums, latestIncIndex + 1, nums.length);
        
        
        
    }
}