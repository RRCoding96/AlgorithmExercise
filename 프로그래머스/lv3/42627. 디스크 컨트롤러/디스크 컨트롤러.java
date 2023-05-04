import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int end = 0;
        int idx = 0;
        int cnt = 0;
        
        while(cnt < jobs.length) {
            
            // 시작 시간이 지금 작업 끝나기 전인 작업들을 큐에 넣기
            while(idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            // 뽑아내기
            if(pq.isEmpty()) {
                // pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                end = jobs[idx][0];
            } else {
                Job job = pq.poll();
                
                answer += job.time + end - job.start;
                end += job.time;
                cnt++;
            }
            
        }
        
        answer = (int) Math.floor(answer / jobs.length);
        return answer;
    }
    
    static class Job implements Comparable<Job>{
        int start;
        int time;
            
        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Job o) {
            return this.time - o.time;
        }
    }
}