class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] another = new int[2*n];
        int p1 = 0;
        int p2 = n;
        
        for(int i = 0; i < 2*n; i++) {
            another[i++] = nums[p1++];
            another[i] = nums[p2++];
        }
        
        return another;
    }
}
