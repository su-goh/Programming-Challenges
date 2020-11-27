class NumArray {
    public int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        if(i > j) return 0;
        for(int k = i; k <= j; k++) {
            sum += nums[k];
        }
        
        return sum;
    }
}
​
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
