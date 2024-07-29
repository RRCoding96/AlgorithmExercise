import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int speed = speeds[i];
            
            int day = (int)Math.ceil((double)remain / speed);
            que.offer(day);
            // System.out.println(day);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int count = 1;
        int date = que.poll();
        while(!que.isEmpty()) {
            int nowDay = que.poll();
            if(nowDay <= date) {
                count++;
            } else {
                result.add(count);
                count = 1;
                date = nowDay;
            }
        }
        result.add(count);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}