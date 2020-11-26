                if (map.get(currChar) >= 0) {
                    count++;
                }
                
                
                while(count == t.length()) {
                    if(minLen > r-l+1) {
                        minL = l;
                        maxR = r;
                        minLen = r-l+1;
                    }
                    
                    if(map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        if(map.get(s.charAt(l)) > 0) count--;
                    }
                    
                    l++;
                }
                
                
            }
            
        }
        System.out.println(minLen);
        if(minLen > s.length()) return "";
        return s.substring(minL, maxR + 1);
    }
}
