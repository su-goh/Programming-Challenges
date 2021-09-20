class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int minI = 0, maxI = m;
        int minJ = 0, maxJ = n;
        
        while(order.size() < m*n) {
            // left
            for(int j = minJ; j < maxJ; j++) {
                order.add(matrix[minI][j]);
            }
            
            // down
            for(int i = minI + 1; i < maxI; i++) {
                order.add(matrix[i][maxJ - 1]);
            }
            
            // right
            for(int j = maxJ - 2; j >= minJ && order.size() < m*n; j--) {
                order.add(matrix[maxI - 1][j]);
            }
            
            // up
            for(int i = maxI - 2; i > minI && order.size() < m*n; i--) {
                order.add(matrix[i][minJ]);
            }
            
            minI++;
            maxI--;
            minJ++;
            maxJ--;
        }
        
        return order;
    }
}