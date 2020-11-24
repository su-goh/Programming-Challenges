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
    public int getDecimalValue(ListNode head) {
        int num = 0;
        int sum = 0;
        ListNode curr = head;
        
        while(curr != null) {
            num++;
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null) {
            sum += curr.val * Math.pow(2, --num);
            curr = curr.next;
        }
        
        return sum;
        
    }
}
