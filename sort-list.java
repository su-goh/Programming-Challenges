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
    public ListNode sortList(ListNode head) {
                
        // insection sort
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        
        list.sort((Integer i, Integer j) -> (i-j));
        curr = head;
        
        for(int i = 0; i < list.size(); i++) {
            curr.val = list.get(i);
            curr = curr.next;
        }
        
        return head;
    }
}
