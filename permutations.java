class Solution {
    
    int[] numsCopy;
    List<List<Integer>> li;
    
    public List<List<Integer>> permute(int[] nums) {
        li = new ArrayList<>();
        numsCopy = nums;
        bt(new ArrayList<Integer>());
        
        return li;
    }
    
    private void bt(ArrayList<Integer> currList) {
        // for(int i =0; i < currList.size(); i++) System.out.print(currList.get(i));
        // System.out.println();
        // base case
        if(currList.size() == numsCopy.length) {
            // for(int i =0; i < li.size(); i++) System.out.print(li.get(i));
            // System.out.println();
            li.add(new ArrayList<>(currList));
            //return li;
        } else {
            for(int i = 0; i < numsCopy.length; i++) {
                
                // add numsCopy[i] if not in currList
                if(!currList.contains(numsCopy[i])) {
                    currList.add(numsCopy[i]);
                    bt(currList);
                    currList.remove(currList.size() - 1);
                }
                
            }
        }
    }
    
}
