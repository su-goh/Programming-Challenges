class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        
        //if(numRows == 0) return tri;
        List<Integer> curr;
​
        for(int i = 0; i < numRows; i++) {
            curr = new ArrayList<>();
            
            for(int j = 0; j < i+1; j++){
                if (j == 0 || j == i) curr.add(1);
                else curr.add(tri.get(i-1).get(j-1) + tri.get(i-1).get(j));
            }
            
            tri.add(curr);
        }
        
        
        return tri;
    }
}
