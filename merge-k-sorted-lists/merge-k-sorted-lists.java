/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode();
        ListNode currMergedNode = merged;
        PriorityQueue<ListNode> minNode = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) minNode.add(lists[i]);
        }

        while(!minNode.isEmpty()) {
            ListNode currNode = minNode.poll();
            
            currMergedNode.next = new ListNode(currNode.val);
            currMergedNode = currMergedNode.next;
            
            currNode = currNode.next;
            if(currNode != null) minNode.add(currNode);
        }
        
        
        return merged.next;
    }
}