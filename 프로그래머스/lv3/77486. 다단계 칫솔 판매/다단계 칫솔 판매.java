import java.util.*;

class Solution {
    
    static int enrollLen; // 인원 수
    static int[] answer; // 정답(총합)
    static Map<String, String> parent; // key의 부모 노드의 이름
    static Map<String, Integer> index; // 해당 인원의 순서 번호
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        enrollLen = enroll.length; // 총 인원 수
        answer = new int[enrollLen];
        parent = new HashMap<>();
        index = new HashMap<>();
        
        parent.put("-", "none");
        index.put("-", 0);
        
        for(int i = 0; i < enrollLen; i++) {
            String name = enroll[i];
            parent.put(name, referral[i]);
            index.put(name, i);
            
            // System.out.printf("%d번째 입력\n", i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int cost = amount[i] * 100;
            
            String nowName = name;
            int nowCost = cost;
            int k = 0; // test용
            while(true) {
                String nextName = parent.get(nowName);
                
                int nowIdx = index.get(nowName);
                int nextIdx = index.get(nextName);
                
                int shareCost = (int)(nowCost * 0.1);
                int myCost = nowCost - shareCost;
                if(myCost < 1) {
                    answer[nowIdx] += nowCost;
                    break;
                } 
                
                answer[nowIdx] += myCost;
                
                if(nextName.equals("-")) {
                    // answer[nextIdx] += shareCost;   
                    break;
                }
                
                // System.out.printf("%d번째의 %d번째 now: %d, share: %d\n", i, k, nowCost, shareCost);
                
                // 다음 단계에 쓸 데이터
                nowCost = shareCost;
                nowName = nextName;
                k++;
            }
        }
        
        
        
        return answer;
    }
}