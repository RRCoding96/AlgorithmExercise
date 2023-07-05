import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] wonho = scores[0];
        
        // 근무 태도 점수 오름차순 정렬 (같으면 동료평가 점수 내림차순)
        Arrays.sort(scores, (x, y) -> {
            if(x[0] == y[0]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(y[0], x[0]);
        });
        
        // 동료평가 점수 저장
        int peerPoint = Integer.MIN_VALUE;
        for(int i = 0; i < scores.length; i++) {
            
            Boolean isDrop = false;
            
            // 근무태도 점수는 이전과 같거나 낮기 때문에 동료평가 점수가 이전의 모든 값보다 같거나 높아야 한다.

            // 동료 평가 점수가 max치가 아니면 갱신
            if(peerPoint < scores[i][1]) {
                peerPoint = scores[i][1];
            }
            // 동료 평가 점수가 더 낮으면 drop
            else if(peerPoint > scores[i][1]) {
                isDrop = true;
            }
            
            if(isDrop) {
                // 현재 대상이 원호거나 원호랑 같은 점수라면 -1
                if(scores[i][0] == wonho[0] && scores[i][1] == wonho[1]) {
                    return -1;
                } 
                // 아니면 다음 반복문 수행
                continue;
            }
            
            // 원호보다 등수가 높은 사람 수만 카운트
            if(scores[i][0] + scores[i][1] > wonho[0] + wonho[1]) {
                answer++;
            }
        }

        return answer;
    }
}