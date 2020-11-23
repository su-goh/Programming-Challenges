class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] sorted = new int[matrix.length * matrix.length];
        int count = 0;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sorted[count++] = matrix[i][j];
            }
        }
        
        Arrays.sort(sorted);
        
        // do "merge" of merge sort      
        
        return sorted[k-1];
    }
    
//     public int[] merge(int[] L, int[] R, int[] sorted) {
        
//     }
}
