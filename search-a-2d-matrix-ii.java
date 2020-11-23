class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        // At the top right, see as a BST
        int i = 0, j = matrix[0].length - 1;
        
        while(i < matrix.length && j >= 0) {
            int num = matrix[i][j];
            if(num == target) return true;
            else if (num < target) i++;
            else j--;
        }
        
        return false;
        
        // 2D binary search, FAIL
        /**
        int rowStart = 0, rowEnd = matrix[0].length - 1, rowMid = 0;
        int colStart = 0, colEnd = matrix.length - 1, colMid = 0;
        int prevRow = 0, prevCol = 0;
        
        while(rowEnd <= rowStart && colEnd <= colStart) {
            rowMid = rowStart + (rowEnd - rowStart)/2;
            colMid = colStart + (colEnd - colStart)/2;
            
            if(matrix[colMid][rowMid] == target) return true;
            else if(matrix[colMid][rowMid] > target) {
                prevRow = rowMid;
                prevCol = colMid;
                rowStart = rowMid + 1;
                colStart = colMid + 1;
            } else {
                prevRow = rowMid;
                prevCol = colMid;
                rowEnd = rowMid - 1;
                colEnd = colMid - 1;
            }
        }
        
        if(prevRow > rowMid) {
            int temp = prevRow;
            prevRow = rowMid;
            rowMid = temp;
        }
        
         if(prevCol > colMid) {
            int temp = prevCol;
            prevCol = colMid;
            colMid = temp;
        }
        
        for(int i = prevRow; i < rowMid; i++) {
            for(int j = prevCol; j < colMid; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        **/
​
        
        // Naiive search
        /**
        int k = 0;
