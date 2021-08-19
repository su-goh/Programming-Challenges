class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];
            if(graph[course][pre] == 0) inDegree[course]++;
            graph[course][pre] = 1;
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int currCourse = q.poll();
            count++;
            for(int i = 0; i < numCourses; i++) {
                if(graph[i][currCourse] == 1) {
                    if(--inDegree[i] == 0) q.add(i);
                }
            }
        }
        
        return count == numCourses;
    }
}