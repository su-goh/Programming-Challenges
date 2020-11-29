/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head; // find the end
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p2 = dummy; // n+1 behind p1
        
        for(int i = 1; i <= n; i++) p1 = p1.next;
        
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        if(p2.next != null) p2.next = p2.next.next;
        
        return dummy.next;
        
    }
}
