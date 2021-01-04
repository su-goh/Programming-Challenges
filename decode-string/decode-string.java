class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                StringBuilder currSeq = new StringBuilder();
                while(!stack.peek().equals('[')) {
                    Character currChar = (Character)stack.pop();
                    currSeq.insert(0, currChar);
                }
                
                stack.pop();
                StringBuilder timeString = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) 
                    timeString.insert(0, stack.pop());
                int times = Integer.valueOf(timeString.toString());
                String c = currSeq.toString();
                for(int j = 1; j < times; j++) currSeq.append(c);
                c = currSeq.toString();
                for(int j = 0; j <= c.length() - 1; j++) stack.push(currSeq.charAt(j));
                // System.out.println(currSeq.toString());
                
            }
        }
        
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        
        return sb.toString();
        
    }
}
