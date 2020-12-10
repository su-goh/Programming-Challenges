import java.util.Arrays;

class maxSub {
    public static int[] slidingWindow(int[] a) {

        int max = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;

        int currSum = 0, currStart = 0; // currEnd is denoted by i

        for(int i = 0; i < a.length; i++) {
            currSum += a[i];
            if(currSum >= max) {
                max = currSum;
                maxStart = currStart;
                maxEnd = i;
            } else if(currSum < 0) {
                currSum = 0;
                currStart = i+1;
            }
        }

        return Arrays.copyOfRange(a, maxStart, maxEnd+1);
    }

    public static int[] slidingWindow2(int[] a) {
        int[] s = new int[a.length+1];
        
        for(int i = 0; i < a.length; i++) {
            s[i+1] = Math.max(a[i], s[i] + a[i]);
        }

        int max = Integer.MIN_VALUE, maxJ = 0, maxI = 0;
        for(int i = 1; i < s.length; i++) {
            if(s[i] > max) {
                max = s[i];
                maxJ = i;
            }
        }        

        maxI = maxJ;
        while(max != 0) {
            max -= s[maxI--];
        }

        return Arrays.copyOfRange(a, maxI, maxJ);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,-2,-3,-4,-5};
        int[] b = slidingWindow2(a);
        for(int i = 0; i < b.length; i++) System.out.print(b[i] + " ");
    }
}