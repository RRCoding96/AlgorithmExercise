import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 우선순위 큐 사용 -> 작업이 가장 많이 남은 업무 순으로 정렬됨
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 우선순위 큐에 작업량 넣기
        for (int work : works) {
            pq.offer(work);
        }
        
        // 모든 시간이 소모될 때 까지 작업을 1씩 줄이면서 반복
        for (int i = 0; i < n; i++) {
            int work = pq.poll();
            
            // 모든 작업이 끝나면 종료 -> 더 이상 할 일 없다는 뜻
            if (work == 0){
                break;
            }
            
           pq.offer(work - 1); 
        }

        long answer = 0;
        // 문제 조건대로 제곱해서 모두 더하기
        for (int sub : pq) {
            answer += Math.pow(sub, 2);
        }
        
        return answer;
    }
}