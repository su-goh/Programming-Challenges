class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        
        int i = 0;
        if(n % 2 != 0) arr[i++] = 0;
        int nextInt = 1;
        
        while(i < n) {
            arr[i++] = nextInt;
            arr[i++] = -nextInt;
            nextInt++;
        }
        
        return arr;
    }
}