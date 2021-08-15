/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode h = head;
        ListNode t = head;
        
        while(h != null && h.next != null) {
            h = h.next.next;
            t = t.next;
            if(h != null && h.equals(t)) return true;
        }
        
        return false;
    }
}