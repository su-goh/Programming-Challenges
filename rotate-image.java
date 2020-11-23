class Solution {
    public void rotate(int[][] matrix) {
        // reverse(matrix);       
        // transpose(matrix);
        
        int i = 0;
        int j = matrix.length - 1;
        
        while(i < j) {
            int[] temp = matrix[i];
            matrix[i++] = matrix[j];
            matrix[j--] = temp;
        }
        
        for(i = 0; i < matrix.length; i++) {
            for(j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    
    public void reverse(int[][] matrix) {
//         int i = 0;
//         int j = matrix.length - 1;
        
//         while(i < j) {
//             int[] temp = matrix[i];
//             matrix[i++] = matrix[j];
//             matrix[j--] = temp;
//         }
    }
    
    public void transpose(int[][] matrix) {
        // for(int i = 0; i < matrix.length; i++) {
        //     for(int j = i + 1; j < matrix[i].length; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
    }
