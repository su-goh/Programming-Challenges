class Solution {
    int[] A;
    public int findKthLargest(int[] nums, int k) {
        A = nums;
        return quickSelect(0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int start, int end, int k) {
        if (start == end) return A[start];
        
        Random r = new Random();
        int pivot = start + r.nextInt(end - start);
        
        pivot = partition(start, end, pivot);
        if (pivot == k) return A[pivot];
        else if (pivot < k) return quickSelect(pivot + 1, end, k);
        else return quickSelect(start, pivot -1, k);
    }
    
    private int partition(int start, int end, int pivot) {
        int pivotNum = A[pivot];
        swap(pivot, end);
        int p = start;
        for (int i = start; i < end; i++) {
            if (A[i] < pivotNum) {
                swap(i, p);
                p++;
            }
        }
        swap(end, p);
        return p;
    }
    
    private void swap(int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}