class Solution {
    public int countPrimes(int n) {
        
        // true = is not prime, false = is prime
        boolean[] arr = new boolean[n+1];
        int count = 0;
        
        for(int i = 2; i < n; i++) {
            if (arr[i]) continue;
            count++;
            if(i >= 46340) continue;
            for (int j = i*i; j < n; j += i) arr[j] = true;
        }
        
        return count;
    }
}
