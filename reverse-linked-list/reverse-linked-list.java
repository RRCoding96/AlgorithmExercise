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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 이전 값이 담길 노드
        
        while(head != null) {
            // 현재 노드 -> 노드 : 이런 방향의 연결을 끊기
            ListNode next = head.next; // 연결되어 있던 다음 노드 임시 저장
            head.next = prev; // 현재 노드가 이전 노드를 바라보게
            
            prev = head; // 이전 노드를 현재 노드로
            head = next; // 다음 노드를 현재 노드로 -> null이 들어오면 마지막 노드까지 왔다는 거임
        }
        
        return prev;
    }
}