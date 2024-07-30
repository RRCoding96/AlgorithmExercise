import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.offer(i);
        }
        
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(first >= K) {
                break;
            }
            if(pq.isEmpty()) {
                answer = -1;
                break;
            }
            int second = pq.poll();
            
            
            int newValue = first + (second * 2);
            answer++;
            
            pq.offer(newValue);
        }
        
        return answer;
    }
}