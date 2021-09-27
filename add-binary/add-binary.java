class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length(), lenB = b.length();
        boolean overflow = false;
        
        for(int i = 1; i <= Math.max(lenA, lenB); i++) {
            char aC = lenA - i >= 0 ? a.charAt(lenA - i) : '0';
            char bC = lenB - i >= 0 ? b.charAt(lenB - i) : '0';
            
            if(aC == '1' && bC == '1') {
                if(overflow) sb.append("1");
                else sb.append("0");
                overflow = true;
            } else if (aC == '1' || bC == '1') {
                if(overflow) sb.append("0");
                else sb.append("1");
            } else if (aC == '0' && bC == '0') {
                if(overflow) {
                    sb.append("1");
                    overflow = false;
                } else sb.append("0");
            }
        }
        
        if(overflow) sb.append("1");
        
        return sb.reverse().toString();
    }
}