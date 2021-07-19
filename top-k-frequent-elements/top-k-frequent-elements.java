class Solution {
    HashMap<Integer, Integer> map;
    int[] A;
    
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        A = new int[map.size()];
        
        int i = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet())
            A[i++] = e.getKey();
        
        quickSelect(0, A.length - 1, A.length - k);
        
        return Arrays.copyOfRange(A, A.length - k, A.length);
    }
    
    private void quickSelect(int start, int end, int k) {
        if (start == end) return;
        
        Random r = new Random();
        int pivotIndex = start + (int) Math.floor((end + 1 - start)/2);
        System.out.println(pivotIndex + " " + A[pivotIndex]);
        for (int i = 0; i < A.length; i ++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        
        int p = partition(start, end, pivotIndex);
        if(p == k) return;
        else if (p < k) quickSelect(p + 1, end, k);
        else quickSelect(start, p - 1, k);
    }
    
    private int partition(int start, int end, int pivotIndex) {
        int pivotFreq = map.get(A[pivotIndex]);
        swap(pivotIndex, end);
        int p = start;
        for ( int i = start; i <= end; i++) {
            if (map.get(A[i]) < pivotFreq) {
                swap(i, p);
                p++;
            }
        }
        swap(p, end);
        
        for (int i = 0; i < A.length; i ++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        return p;
    }
    
    private void swap(int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
}