import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
       int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int value : scoville) {
        	pq.add(value);
        }
        
        int min = pq.peek();
        while(min < K && pq.size() > 1) {
        	int a = pq.poll();
        	int b = pq.poll();
        	
        	int nScale = a + b * 2;
        	
        	pq.add(nScale);
        	answer++;
        	min = pq.peek();
        }
        
        if (K > min) {
        	answer = -1;
        }
        
              
        return answer;
    }
}