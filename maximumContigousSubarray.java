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

        if(currSum >= max) {
            max = currSum;
            maxStart = currStart;
            maxEnd = a.length-1;
        }

        return Arrays.copyOfRange(a, maxStart, maxEnd+1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, -11, 9, 3, -2, 10, -5, 1, 2};
        int[] b = slidingWindow(a);
        for(int i = 0; i < b.length; i++) System.out.print(b[i] + " ");
    }
}