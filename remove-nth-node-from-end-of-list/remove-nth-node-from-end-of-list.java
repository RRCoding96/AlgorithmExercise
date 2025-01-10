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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 더미 노드 하나 생성
        ListNode start = new ListNode(0);
        
        // front와 back이라는 포인터 모두 0에 세팅
        ListNode front = start;
        ListNode back = start;
        
        // 더미 노드 뒤에 head 붙여주기
        // (head가 [1,2,3,4,5]라면 [0,1,2,3,4,5]가 된다)
        start.next = head;
        
        // back이라는 포인트를 n번째 노드로 옮긴다
        for(int i = 1; i <= n+1; i++){
            back = back.next;
        } 
        
        // back이 null 될 때까지 n만큼의 간격을 유지하며
        // front와 back 포인터를 한칸씩 움직여준다
        // back이 null 됐을 때 = 리스트노드의 끝에 도달했을 때
        while(back != null) {
            front = front.next;
            back = back.next;
        }
        
        // front 포인터는 제외해야 하는 노드를 한 칸 건너뛴다.
        front.next = front.next.next;
        
        // 더미 노드를 제외한 리스트노드를 반환한다.
        return start.next;
    }
}