class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> {
            double distA = Math.sqrt(Math.pow((a[0]), 2) + Math.pow(a[1], 2));
            double distB = Math.sqrt(Math.pow((b[0]), 2) + Math.pow(b[1], 2));
            return (distA - distB) <= 0 ? (distA - distB == 0) ? 0 : -1 : 1; 
        });
        
        int[][] kNearest = new int[k][2];
        
        for(int i = 0; i < k; i++) 
            kNearest[i] = points[i];
        
        return kNearest;
    }
}