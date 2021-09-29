class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder validString = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            
            if(stack.isEmpty()) stack.addLast(currChar);
            else if(stack.peekLast().equals(currChar)) stack.pollLast();
            else stack.addLast(currChar);
        }
        
        while(!stack.isEmpty()) validString.append(stack.pollFirst());
        
        return validString.toString();
    }
}