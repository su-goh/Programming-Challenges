class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;
        HashSet<Integer> past = new HashSet<>();
        HashSet<Integer> future = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i) past.add(arr[i]);
            else if(arr[i] < i) past.add(arr[i]);
            else if(arr[i] > i) future.add(arr[i]);
            
            if(future.contains(i)) past.add(i);
            
            if(past.size() == i + 1) maxChunks++;
        }
        
        
        return maxChunks;
    }
}