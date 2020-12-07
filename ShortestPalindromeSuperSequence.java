class ShortestPalindomeSuperSequence {
    public static String SPSS(String s) {
        String[][] dp = new String[s.length() + 1][s.length() + 1];

        // initialization
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = "";
            dp[0][i] = "";
        }
        
        for(int len = 0; len < s.length(); len++) {
            for(int j = 1; j <= s.length(); j++) {
                int start = j;
                int end = j+len;

                if(end > s.length()) continue;

                if(s.charAt(start-1) == s.charAt(end-1)) {
                    if(start == end) {
                        dp[start][end] = s.charAt(start-1) +"";
                        continue;
                    }
                    dp[start][end] = s.charAt(start-1) + dp[start+1][end-1] + s.charAt(end-1);
                } else {
                    String choice1 = s.charAt(start-1) + dp[start+1][end] + s.charAt(start-1);
                    String choice2 = s.charAt(end-1) + dp[start][end-1] + s.charAt(end-1);
                    dp[start][end] = (choice1.length() <= choice2.length()) ? choice1 : choice2;
                }
            }
        }
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(SPSS("test"));
    }
}