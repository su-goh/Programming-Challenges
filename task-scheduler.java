class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(n == 0) return tasks.length;
        
        // map to keep track of num tasks for each task
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) 
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        
        // keep track of task with most frequency
        Queue<Integer> queue = new PriorityQueue<>((Integer i, Integer j) -> j - i);
        for(char c: map.keySet()) queue.offer(map.get(c));
        
        // key keep tracks of time a task will be out of cooldown, 
        // value is the frequency of the task in cooldown
        HashMap<Integer, Integer> cooldown = new HashMap<>();
        int time = 0;
        
        while(!queue.isEmpty() || !cooldown.isEmpty()) {
            
            // if something's cooldown expired, add them back to queue
            if(cooldown.containsKey(time)) {
                // System.out.println("lol");
                int returnFromCooldown = cooldown.get(time);
                cooldown.remove(time);
                queue.add(returnFromCooldown);
            }
            
            // do the task at the top of queue and put that task to cooldown, else idle
            if(!queue.isEmpty()) {
                int returnFromQueue = queue.poll() - 1;
                if(returnFromQueue > 0) cooldown.put(time + n + 1, returnFromQueue);
                // System.out.println(time+n);
            }
                // } else {
            //     System.out.println("IDLE");
            // }
            time++;
        }
        
        return time;
    }
}
