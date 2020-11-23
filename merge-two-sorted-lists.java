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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ans = head;
        
        while(l1 != null && l2 != null) {
            // l1 > l2
            if(l1.val >= l2.val) {
                ans.next = new ListNode();
                ans = ans.next;
                ans.val = l2.val;
                l2 = l2.next;
            } else {
                ans.next = new ListNode();
                ans = ans.next;
                ans.val = l1.val;
                l1 = l1.next;
            }
        }
        
        while (l1 != null) {
            ans.next = new ListNode();
            ans = ans.next;
            ans.val = l1.val;
            l1 = l1.next;
        } 
        
        while (l2 != null) {
            ans.next = new ListNode();
            ans = ans.next;
            ans.val = l2.val;
