class WordDictionary {
    
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String word = "";
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++) {
            if(currNode.children[word.charAt(i) - 'a'] == null) {
                currNode.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            currNode = currNode.children[word.charAt(i) - 'a'];
        }
        currNode.word = word;
    }
    
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    private boolean find(String word, int i, TrieNode curr) {     
        if (i == word.length()) {
            if(curr.word != "") return true;
            else return false;
        }

        char currChar = word.charAt(i);
        if(currChar != '.') {
            TrieNode next = curr.children[currChar - 'a'];
            if (next != null) return find(word, i + 1, next);
        } else {
            for(int j = 0; j < curr.children.length; j++) {
                if(curr.children[j] != null)
                    if(find(word, i + 1, curr.children[j]))
                        return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */