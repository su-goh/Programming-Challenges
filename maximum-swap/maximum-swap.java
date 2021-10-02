class Solution {
    public int maximumSwap(int num) {
        ArrayList<Integer> numArr = new ArrayList<>();
        while(num != 0) {
            numArr.add(0, num % 10);
            num /= 10;
        }
        
        int largestNum = 0;
        int largestNumIdx = 0;
        int max = 0;
        
        int i = 0;
        while(i + 1 < numArr.size() && numArr.get(i) >= numArr.get(i + 1)) i++;
        
        for(; i < numArr.size(); i++) {
            
            if(numArr.get(i) >= largestNum) {
                largestNum = numArr.get(i);
                largestNumIdx = i;
            }
        }

        boolean swapped = false;
        
        for(i = 0; i < numArr.size(); i++) {
            if(!swapped && numArr.get(i) < largestNum && i < largestNumIdx) {
                int temp = numArr.get(i);
                numArr.set(i, largestNum);
                numArr.set(largestNumIdx, temp);
                swapped = true;
            }
            max = max*10 + numArr.get(i);
        }        

        return max;
    }
}