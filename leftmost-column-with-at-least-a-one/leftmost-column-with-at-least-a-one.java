/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    int minCol;
    BinaryMatrix binaryMatrix;
    
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        minCol = Integer.MAX_VALUE;
        this.binaryMatrix = binaryMatrix;
        
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0);
        int col = dim.get(1);
        
        for(int i = 0; i < row; i++) {
            binarySearch(i, 0, Math.min(minCol, col - 1));
            if(minCol == 0) return minCol;
        }
        
        return minCol == Integer.MAX_VALUE ? -1 : minCol;
    }
    
    private void binarySearch(int i, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(binaryMatrix.get(i, mid) == 1) {
                end = mid - 1;
                minCol = Math.min(minCol, mid);
            } else start = mid + 1;
        }
    }
}