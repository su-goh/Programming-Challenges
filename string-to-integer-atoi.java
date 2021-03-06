// class Solution {
//     public int myAtoi(String str) {
        
//         StringBuilder s = new StringBuilder();
//         str = str.trim();
//         boolean neg = false;
//         int sum = 0;
        
//         int start = 0;
//         // check if len == 0
//         if(str.length() == 0) return 0;
//         // if first char is letter, return
//         if(Character.isLetter(str.charAt(0))) return 0;
//         // if first char is '-', negative
//         if(str.charAt(0) == '-') {
//             neg = true;
//             start++;
//         } else if (str.charAt(0) == '+') start++;
        

        
//         for(int i = start; i < str.length(); i++) {

//             if (Character.isDigit(str.charAt(i))){
//                 // make sure not out of int range
//                 if(s.length() >= 9 && Integer.parseInt(s.toString()) >= Integer.MAX_VALUE/10) {
//                     // for case == 214748364x
//                     if(Integer.parseInt(s.toString()) == Integer.MAX_VALUE/10 && str.charAt(i) < '8') {
//                         s.append(str.charAt(i));
//                         break;
//                     }
                    
//                     // for case > 21474864x
//                     return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//                 } 

//                 s.append(str.charAt(i));
//             } 
//             else {
//                 // meet letter, so end
//                 try { return neg ? Integer.parseInt(s.toString())*(-1) : Integer.parseInt(s.toString());} 
//                 catch(NumberFormatException e) { return 0;}
//             }

//         }
        
//         try { return neg ? Integer.parseInt(s.toString())*(-1) : Integer.parseInt(s.toString());} 
//         catch(NumberFormatException e) { return 0;}
//     }
// }


class Solution {
    public int myAtoi(String str) {
        
        str = str.trim();
        boolean neg = false;
        int sum = 0;
        
        int start = 0;
        // check if len == 0
        if(str.length() == 0) return 0;
        // if first char is letter, return
        if(Character.isLetter(str.charAt(0))) return 0;
        // if first char is '-', negative
        if(str.charAt(0) == '-') {
            neg = true;
            start++;
        } else if (str.charAt(0) == '+') start++;
        
        for(int i = start; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))){
                // make sure not out of int range
                if(sum > Integer.MAX_VALUE/10 || (!neg && sum == Integer.MAX_VALUE/10 && str.charAt(i) >= '7')) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } 
                
                if(neg && sum == Integer.MAX_VALUE/10 && str.charAt(i) >= '8') {
                    return Integer.MIN_VALUE;
                }

                //s.append(str.charAt(i));
                sum *= 10;
                sum += str.charAt(i) - '0';
            } // meet letter, so end
            
            else break;

        }
        
        try { return neg ? sum*(-1) : sum;} 
        catch(NumberFormatException e) { return 0;}
    }
}
