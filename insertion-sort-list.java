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
    public ListNode insertionSortList(ListNode head) {
        ListNode pre, post, curr = head, dummy = new ListNode(0);
        dummy.next = head;
        
        while(curr != null && curr.next != null) {
            if(curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                // found post and curr
                post = curr.next;
                pre = dummy;
                
                // find pre
                while(pre.next.val < post.val) {
                    pre = pre.next;
                }
                
                // found pre, swap
                curr.next = post.next;
                post.next = pre.next;
                pre.next = post;
            }
        }
        
        return dummy.next;
    }
}
