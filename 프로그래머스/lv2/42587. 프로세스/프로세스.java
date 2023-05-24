import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Job> pq = new PriorityQueue<>();

        for(int i = 0; i < priorities.length; i++) {
            pq.add(new Job(i, priorities[i]));
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                //priorities의 값이 현재 오름차순 우선순위가 제일 높은 값과 같은지 확인
                if (priorities[i] == pq.peek().priority) { 
                    if (i == location) {
                        answer++;
                        return answer;
                    }   
                    pq.poll();
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    static class Job implements Comparable<Job>{
        int num, priority;
        
        public Job(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Job o) {
            return o.priority - this.priority;
        }
    }
}