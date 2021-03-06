class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        
        // empty slot approach O(n) time, O(1) space
        int max = 0; // frequecy of task of max frequency
        int numMax = 0; // count of task with max frequency
        int[] counter = new int[26]; // keep track of frequency of all tasks
        
        for(int i = 0; i < tasks.length; i++) {
            counter[tasks[i] - 'A'] += 1;
            int currFreq = counter[tasks[i] - 'A'];
            
            if(max == currFreq) { // current task is also a task with max frequency
                numMax++; // a new task has achieved max
            } else if (currFreq > max){ // found a new max
                numMax = 1;
                max = currFreq;
            }
        }
        
        int numParts = max - 1; // number of partitions
        int partLen = n - (numMax - 1);
        int numSlots = numParts*partLen;
        int availableTasks = tasks.length - max*numMax;
        int numIndles = Math.max(0, numSlots - availableTasks);
        
        return numIndles + tasks.length;
        
        //Hash-priority Queue approach - O(time) time, O(n) space
//         if(n == 0) return tasks.length;
        
//         // map to keep track of num tasks for each task
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < tasks.length; i++) 
//             map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        
//         // keep track of task with most frequency
//         Queue<Integer> queue = new PriorityQueue<>((Integer i, Integer j) -> j - i);
//         for(char c: map.keySet()) queue.offer(map.get(c));
        
//         // key keep tracks of time a task will be out of cooldown, 
//         // value is the frequency of the task in cooldown
//         HashMap<Integer, Integer> cooldown = new HashMap<>();
//         int time = 0;
        
//         while(!queue.isEmpty() || !cooldown.isEmpty()) {
            
//             // if something's cooldown expired, add them back to queue
//             if(cooldown.containsKey(time)) {
//                 int returnFromCooldown = cooldown.get(time);
//                 cooldown.remove(time);
//                 queue.add(returnFromCooldown);
//             }
            
//             // do the task at the top of queue and put that task to cooldown, else idle
//             if(!queue.isEmpty()) {
//                 int returnFromQueue = queue.poll() - 1;
//                 if(returnFromQueue > 0) cooldown.put(time + n + 1, returnFromQueue);
//             }

//             time++;
//         }
        
//         return time;
    }
}
