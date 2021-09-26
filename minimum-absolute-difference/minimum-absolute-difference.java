class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        for(int i = arr.length - 1; i > 0; i--) {
            int a = arr[i];
            int diffNext = Math.abs(arr[i - 1] - a);
            int diffLast = Math.abs(arr[0] - a);
            
            if(diffNext == diffLast && diffNext <= minDiff) {
                if(diffNext < minDiff) {
                    ret = createNewList(a, arr[i - 1], ret);
                    if(i - 1 != 0) addToList(a, arr[0], ret);
                    minDiff = diffNext;
                } else {
                    addToList(a, arr[i - 1], ret);
                    if(i - 1 != 0) addToList(a, arr[0], ret);
                }
            } else if (diffNext < diffLast && diffNext <= minDiff) {
               
                if(diffNext < minDiff) {
                    ret = createNewList(a, arr[i - 1], ret);
                    minDiff = diffNext;
                } else {
                    addToList(a, arr[i - 1], ret);
                }
            } else if (diffLast < diffNext && diffLast <= minDiff) {
                if(diffLast < minDiff) {
                    ret = createNewList(a, arr[0], ret);
                    minDiff = diffLast;
                } else {
                    addToList(a, arr[0], ret);
                }
            }
            
        }
        
        ret.sort((a, b) -> a.get(0) - b.get(0));
        
        return ret;
    }
    
    private List<List<Integer>> createNewList(int a, int b, List<List<Integer>> ret) {
        ret = new ArrayList<>();
        addToList(a, b, ret);
        return ret;
    }
    
    private void addToList(int a, int b, List<List<Integer>> ret) {
        List<Integer> curr = new ArrayList<>();
        curr.add(Math.min(a, b));
        curr.add(Math.max(a, b));
        ret.add(curr);
    }
}