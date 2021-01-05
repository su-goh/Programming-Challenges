//                 for(int j = 1; j < times; j++) currSeq.append(c);
//                 c = currSeq.toString();
//                 for(int j = 0; j <= c.length() - 1; j++) stack.push(currSeq.charAt(j))                
//             }
//         }
        
//         while(!stack.isEmpty()) sb.insert(0, stack.pop());
        
//         return sb.toString();
        
        String ret = "";
        Stack<String> st = new Stack<>();
        Stack<Integer> ct = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder times = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                times.append(s.charAt(i));
            } else if(s.charAt(i) == '[') {
                Integer number = Integer.valueOf(times.toString());
                times = new StringBuilder();
                st.push(ret);
                ct.push(number);
                ret = "";
            } else if(s.charAt(i) == ']') {
                sb = new StringBuilder(st.pop());
                int number = ct.pop();
                for(int j = 0; j < number; j++) sb.append(ret);
                ret = sb.toString();
            } else {
                ret += s.charAt(i);
            }
        }
        
        return ret;
    }
}
