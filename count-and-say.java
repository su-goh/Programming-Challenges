// class Solution {
//     public String countAndSay(int n) {
//         StringBuilder sb;
//         String prev = "1"; // the String of n-1
//         char prevInt; // the char at p-1
        
//         for(int i = 2; i <= n; i++) {
//             prevInt = prev.charAt(0);
//             int count = 1;
//             sb = new StringBuilder();
//             for(int j = 1; j < prev.length(); j++) {
                
//                 // same digit
//                 if (prev.charAt(j) == prevInt) count++;
                
//                 // new digit, append
//                 else {
//                     sb.append(count);
//                     sb.append(prevInt);
//                     prevInt = prev.charAt(j);
//                     count = 1;
//                 }
//             }
            
//             sb.append(count);
//             sb.append(prevInt);
//             prev = sb.toString();
//         }
        
//         return prev;
//     }
// }
​
class Solution {
    public String countAndSay(int n) {
        
        String prev = "1"; // the String of n-1
        for(int i = 2; i <= n; i++) {
            prev = helper(prev);
        }
        return prev;
