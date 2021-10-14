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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int size = 0;
        ListNode curr = head;
        
        while(curr != null) {
            size++;
            st.add(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        for(int i = 0; i < size/2; i++) {
            if(curr.val != st.pop()) return false;
            curr = curr.next;
        }
        
        return true;
        
    }
}