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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int len = 0;
        ListNode curr = head;
        
        // traverse the list, put all elements on stack count len,
        while(curr != null) {
            stack.push(curr.val);
            len++;
            curr = curr.next;
        }
        
        curr = head;
​
        // dequeue len/2 stuff on stack while compare to first half of list.
        for( int i = 0; i < len/2; i++) {
            if(stack.pop() != curr.val) {
                return false;
            } else {
                curr = curr.next;
            }
        }
        
        
        return true;
    }
}
