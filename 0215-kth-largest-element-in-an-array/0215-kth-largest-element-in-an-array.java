import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int answer = -1;
        for(int n : nums) {
            pq.add(n);
        }
        
        for(int i = 0; i < k; i++) {
            answer = pq.poll();
        }
        
        return answer;
    }
}