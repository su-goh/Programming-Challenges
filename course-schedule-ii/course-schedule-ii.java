class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        
        HashMap<Integer, ArrayList<Integer>> outDegree = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int size = 0;
        
        for(int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            outDegree.put(i, new ArrayList<>());
        }
        
        for(int[] prereq : prerequisites) {
            int toTake = prereq[0], required = prereq[1];
            
            inDegree.put(toTake, inDegree.getOrDefault(toTake, 0) + 1);
            outDegree.get(required).add(toTake);
        }
        
        for(int course : inDegree.keySet()) {
            if(inDegree.get(course) == 0) {
                q.add(course);
                visited[course] = true;
            }
        }
        
        while(!q.isEmpty()) {
            int currCourse = q.poll();
            ArrayList<Integer> child = outDegree.get(currCourse);
            courses[size++] = currCourse;
            for(Integer childCourse : child) {
                inDegree.put(childCourse, inDegree.get(childCourse) - 1);

                if(inDegree.get(childCourse) <= 0 && visited[childCourse] == false) {
                    visited[childCourse] = true;
                    q.add(childCourse);
                }
            }            
        }
        
        return size == numCourses ? courses : new int[0];
    }
}