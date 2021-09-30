class SparseVector {
    List<Integer> index;
    List<Integer> num;
    
    SparseVector(int[] nums) {
        index = new ArrayList<>();
        num = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                index.add(i);
                num.add(nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        int vec1Ptr = 0;
        int vec2Ptr = 0;
        List<Integer> vecIdx = vec.index;
        List<Integer> vecNum = vec.num;
        
        while(vec1Ptr < index.size() && vec2Ptr < vecIdx.size()){
            if (index.get(vec1Ptr).equals(vecIdx.get(vec2Ptr)))
                sum += num.get(vec1Ptr++)*vecNum.get(vec2Ptr++);
            else if(index.get(vec1Ptr) > vecIdx.get(vec2Ptr)) vec2Ptr++;
            else vec1Ptr++;
        } 

        
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);