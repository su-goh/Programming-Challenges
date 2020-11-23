class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // use helper 
        return (nums1.length < nums2.length) ? helper(nums1, nums2) : helper(nums2, nums1);
    }
    
    
    // small is smaller array
    public int[] helper(int[] small, int[]big) {
        int[] ret = new int[small.length];
        
        int i = 0;
        int j = 0;
        int next = 0;
        while (i < small.length && j < big.length) {
            // intersection not found, havent reach big, so j++;
            if(small[i] > big[j]) {
                j++;
                continue;
            } else if (small[i] < big[j]) {
                // interesection not found, passed small, so i++
                i++;
                continue;
            } else {
                // small[i] == big[j], found.
                // do your thing, then i++, j++
                ret[next++] = i; //small[i];
                i++;
                j++;
            }
        }
        
        int[] rett = new int[next];
        i = 0;
        for (i = 0; i < next; i++) {
            rett[i] = small[ret[i]];
        }
                
        return rett;
        
    }
}
