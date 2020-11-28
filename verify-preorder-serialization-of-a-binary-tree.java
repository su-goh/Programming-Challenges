class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] arr = preorder.split(",");
        
        for(int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            
            while(stack.size() >= 3) {
                String top1 = stack.get(stack.size() - 1);
                String top2 = stack.get(stack.size() - 2);
                String top3 = stack.get(stack.size() - 3);
                
                if(top1.equals("#") && top2.equals("#") && !top3.equals("#")) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push("#");
                } else {
                    break;
                }
            } 
        }
        
        return (stack.size() == 1 && stack.peek().equals("#")) ? true: false;
    }
}
