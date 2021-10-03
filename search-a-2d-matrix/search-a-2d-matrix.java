class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m*n - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            int row = (int)Math.floor(mid / n), col = mid % n;
            // System.out.println(mid + " " + row + " " + col);

            if(target == matrix[row][col]) return true;
            else if(target < matrix[row][col]) end = mid - 1;
            else start = mid + 1;
        }
        
        return false;
    }
}