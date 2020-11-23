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
    public ListNode oddEvenList(ListNode head) {
        if(head == (null)) return head; // null node
        if(head.next == (null)) return head; // check: only one node
        if(head.next.next == (null)) return head;// check only two nodes;
        
        ListNode head2 = head.next; // reference of even
        ListNode p1 = head; // pointer of odd nodes
        ListNode p2 = head2; // pointer of even nodes
        
        while(p2.next != null && p2.next.next != null) {
            // System.out.println("p1: " + p1.val + " " + p1.next.val + " " + p1.next.next.val);
            // System.out.println("p2: " + p2.val + " " + p2.next.val + " " + p2.next.next.val);
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
            //System.out.println("");
        }
        
        if(p2.next != (null)) {
            //System.out.println("p1: " + p1.val + " " + p1.next.val + " " + p1.next.next.val);
            p1.next = p1.next.next; // check if odd > even
            p1 = p1.next;
            p2.next = null;
            //System.out.println("WOWEE");
            
        }
        p1.next = head2;
        
        return head;
    }
}
