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
        ListNode fast = head; // 2칸 씩 움직임
        ListNode slow = head; // 1칸 씩 움직임
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next; // 2칸 씩 움직임
            slow = slow.next; // 1칸 씩 움직임
            
            if(fast == slow) {
                return true;
            }
        }
        
        return false;
    }
}