class Solution {
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> prevBlocks = new Stack<>();
        
        for(int i = 0; i < height.length; i++) {
            int currBlock = height[i];
            while(!prevBlocks.isEmpty() && height[prevBlocks.peek()] < currBlock) {
                int middle = height[prevBlocks.pop()];
                if(prevBlocks.isEmpty()) break;
                int leftIdx = prevBlocks.peek();
                int left = height[leftIdx];
                
                int depth = Math.min(currBlock, left) - middle;
                int len = i - leftIdx - 1;
                water += depth*len;
            }
            
            prevBlocks.add(i);
        }
        
        
        return water;
    }
}