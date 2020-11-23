class Solution {
    
    int[] num;
    int[] ori;
​
    public Solution(int[] nums) {
        num = new int[nums.length];
        ori = new int[nums.length];
        deepCopy(nums, ori);
        deepCopy(nums, num);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        deepCopy(ori, num);
        deepCopy(ori, ori);
        return num;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random r = new Random();
        
        for(int i = num.length - 1; i > 0; i--) {
            int rand = r.nextInt(i+1);
            int temp = num[i];
            num[i] = num[rand];
            num[rand] = temp;
        }
        
        return num;
    }
    
    public void deepCopy(int[] src, int[] dest) {
        for(int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
