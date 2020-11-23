class Solution {
    
    Map<Integer, Integer> map;
    int[] arr;
    
    public int[] topKFrequent(int[] nums, int k) {
        
        //Quickselect solution
        if(nums.length == k) return nums;
        
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        arr = new int[map.size()];
        int z = 0;
        for(int num : map.keySet()) arr[z++] = num;
        
        
        
        return quickSelect(0, arr.length - 1, k);
    }
    
    public int[] quickSelect(int start, int end, int k) {
        //System.out.println("STATt \n");
        if(start == end) return Arrays.copyOfRange(arr, arr.length - k, arr.length);
        //System.out.println("Start: " + start + " End: " + end);
        Random r = new Random();
        int pivot = start + r.nextInt(end - start);
        //System.out.println("pivot: " + pivot + " " + arr[pivot]);
        int pivF = map.get(arr[pivot]);
        
        // move pivot to end
        int temp = arr[pivot];
        arr[pivot] = arr[end];
        arr[end] = temp;
        pivot = end;
        
        //for(int i = 0; i < arr.length; i++) System.out.print(arr[i]);
       // System.out.println();
        
        // Loop through array to find < freq
