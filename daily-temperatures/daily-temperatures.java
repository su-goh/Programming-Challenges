class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int[] ret = new int[T.length];
        
        for(int i = T.length - 1; i >= 0; --i) {
            while(!st.isEmpty() && T[st.peek()] <= T[i]) st.pop();
            ret[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }

        return ret;
    }
}
