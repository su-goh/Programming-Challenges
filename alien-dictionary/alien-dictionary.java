class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> edge = new HashMap<>();
        StringBuilder dict = new StringBuilder();
        
        for(String s : words)
            for(char c : s.toCharArray())
                degree.put(c, 0);

        for(int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            if(curr.length() > next.length() && curr.startsWith(next)) return "";

            for(int j = 0; j < len; j ++) {
                char currChar = curr.charAt(j);
                char nextChar = next.charAt(j);
                
                if(currChar != nextChar) {
                    edge.putIfAbsent(currChar, new HashSet<>());
                    if(!edge.get(currChar).contains(nextChar))
                        degree.put(nextChar, degree.get(nextChar) + 1);
                    edge.get(currChar).add(nextChar);
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(Character c : degree.keySet()) 
            if(degree.get(c) == 0) q.add(c);

        while(!q.isEmpty()) {
            Character currChar = q.poll();
            dict.append(currChar);
            
            Set<Character> set = edge.getOrDefault(currChar, new HashSet<>());
            
            for(Character child : set) {
                degree.put(child, degree.get(child) - 1);
                if(degree.get(child) == 0) q.add(child);
            }
        }
        
        return dict.length() == degree.size() ? dict.toString() : "";
    }
}