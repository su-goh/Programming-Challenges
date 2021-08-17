class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        
        int n = matrix.length, m = matrix[0].length;
        int minI = 0, maxI = n;
        int minJ = 0, maxJ = m;
                
        while(ret.size() < n * m) {
            for(int j = minJ; j < maxJ; j++) {
                ret.add(matrix[minI][j]);
                System.out.println(minI + " " + j);
            }
            
            for(int i = minI + 1; i < maxI; i++) {
                ret.add(matrix[i][maxJ - 1]);
                System.out.println(i + " " + (maxJ - 1));
            }
            
            for(int j = maxJ - 2; j >= minJ && minI != maxI - 1; j--) {
                ret.add(matrix[maxI - 1][j]);
                System.out.println((maxI - 1) + " " + j);
            }
            
            for(int i = maxI - 2; i > minI && minJ != maxJ - 1; i--) {
                ret.add(matrix[i][minJ]);
                System.out.println(i + " " + minJ);
            }
            
            minI++;
            maxI--;
            minJ++;
            maxJ--;
        }
        
        return ret;
    }
}