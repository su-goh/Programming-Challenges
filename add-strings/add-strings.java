class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int overflow = 0;
        
        while(l1 >= 0 || l2 >= 0) {
            int n1 = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int n2 = l2 < 0 ? 0 : num2.charAt(l2) - '0';
            
            int currNum = n1 + n2 + overflow;
            overflow = 0;
            
            if(currNum >= 10) {
                overflow = 1;
                currNum -= 10;
            }
            
            sum.append(currNum);
            l1--;
            l2--;
        }
        
        if(overflow == 1) sum.append(overflow);
        
        return sum.reverse().toString();
    }
}