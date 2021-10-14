class Solution {
    
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> occurs = new PriorityQueue<>((x, y) -> y.num - x.num);
        
        if(a > 0) occurs.add(new Pair(a, 'a'));
        if(b > 0) occurs.add(new Pair(b, 'b'));
        if(c > 0) occurs.add(new Pair(c, 'c'));
        
        while(!occurs.isEmpty()) {
            Pair curr = occurs.poll();
            boolean isMost = true;
            if(sb.length() > 0 && curr.c == sb.charAt(sb.length() - 1)) {
                isMost = false;
                Pair temp = curr;
                if(occurs.size() == 0) break;
                curr = occurs.poll();
                occurs.add(temp);
            }
            if(curr.num >= 2 && isMost) {
                sb.append(curr.c);
                sb.append(curr.c);
                curr.num -= 2;
            } else {
                sb.append(curr.c);
                curr.num -= 1;
            }
            
            if(curr.num > 0) occurs.add(curr);

        }
        
        
        return sb.toString();
    }
    
    class Pair {
        int num;
        char c;
        
        public Pair(int num, char c) {
            this.num = num;
            this.c = c;
        }
    }
}