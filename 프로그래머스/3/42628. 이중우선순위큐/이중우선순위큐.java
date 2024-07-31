import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(
            (o1, o2) -> o2 - o1
        );
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for(String oper : operations) {
            String[] op = oper.split(" ");
            
            String order = op[0];
            int num = Integer.parseInt(op[1]);
            
            if("I".equals(order)) {
                maxPq.offer(num);
                minPq.offer(num);
            } else if("D".equals(order)) {
                // 비어잇으면 무시
                if(maxPq.isEmpty() || minPq.isEmpty()) {
                    continue;
                }
                // 로직
                if(num == 1) {
                    int m = maxPq.poll();
                    minPq.remove(m);
                } else if(num == -1) {
                    int n = minPq.poll();
                    maxPq.remove(n);
                }
            }
        }
        
        int[] answer = new int[2];
        if(minPq.size() > 0) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        
        return answer;
    }
}