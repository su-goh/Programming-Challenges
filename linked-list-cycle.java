/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
​
// naaive approach
//         ListNode curr = head;
        
//         while(curr != null) {
//             if(curr.val == 2147000000) {
//                 return true;
//             }
            
//             curr.val = 2147000000;
//             curr = curr.next;
//         }
//         return false;
//     }
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        
        do {
            if(hare == null || hare.next == null) {
                return false;
            } else {
                hare = hare.next.next;
                tortoise = tortoise.next;
            }
        } while(tortoise != hare);
        
        return true;
    }
}
