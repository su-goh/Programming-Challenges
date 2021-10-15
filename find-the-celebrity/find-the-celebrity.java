/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        HashSet<Integer> celebCandidate = new HashSet<>();
        for(int i = 0; i < n; i++) celebCandidate.add(i);
        
        for(int a = 0; a < n; a++) {
            for(int b : new ArrayList<Integer>(celebCandidate)) {
                if(a == b) continue;
                if(!knows(a, b)) celebCandidate.remove(b);
                else celebCandidate.remove(a);
            }
        }
        
        int size = 0;
        for(int a : celebCandidate) {
            for(int i = 0; i < n; i++) {
                if(i != a && knows(a, i)) break;
                if(i != a && knows(i, a)) size++;
            }
            if(size == n - 1) return a;
            else size = 0;
        }
        
        return -1;
    }
}