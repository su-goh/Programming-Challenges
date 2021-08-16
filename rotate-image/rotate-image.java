class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        diagonal(matrix);
    }
    
    private void reverse(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;
        while(i < j) {
            int end = matrix.length - 1 - i;
            int[] temp = matrix[i];
            matrix[i] = matrix[end];
            matrix[end] = temp;
            i++;
            j--;
        }
    }
    
    private void diagonal(int[][] matrix){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}