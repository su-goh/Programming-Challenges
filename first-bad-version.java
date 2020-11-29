/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
​
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int start = 0, end = n, mid = start + (end - start)/2;
        
        while(start < end) {
            if(isBadVersion(mid)) {
                end = mid;
                mid = start + (end - start)/2;
            } else {
                start = mid + 1;
                mid = start + (end - start)/2;
            }
        }
        
        return start;
    }
}
