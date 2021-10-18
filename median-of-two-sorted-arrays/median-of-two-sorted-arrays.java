class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, mid = (n + m + 1)/2;
        if(n > m) return findMedianSortedArrays(nums2, nums1);
        
        int p1Start = 0, p1End = n; 
        int p1 = (p1Start + p1End)/2, p2 = mid - p1;      
        
        while(p1Start <= p1End) {
            p1 = (p1Start + p1End)/2;
            p2 = mid - p1;

            int leftNums1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int rightNums1 = (p1 == n) ? Integer.MAX_VALUE : nums1[p1];
            int leftNums2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int rightNums2 = (p2 == m) ? Integer.MAX_VALUE : nums2[p2];

            if(leftNums1 <= rightNums2 && leftNums2 <= rightNums1) {
                if((n + m) % 2 != 0) return Math.max(leftNums1, leftNums2);
                else return (Math.max(leftNums1, leftNums2) + Math.min(rightNums1, rightNums2))/2.0;
            } else if(leftNums1 > rightNums2) {
                p1End = p1 - 1;
            } else {
                p1Start = p1 + 1;
            }
        }
        
        return -1;
    }
}