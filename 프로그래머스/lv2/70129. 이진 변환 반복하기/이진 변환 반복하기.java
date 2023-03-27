import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int turnCnt = 0;
        int zeroCnt = 0;
        
        String str = s;
        while(true) {
            if(str.equals("1")) break;
            
            turnCnt++;
            int oneCnt = 0;
            for(char c : str.toCharArray()) {
                if(c == '1') {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }
            
            // turnCnt++;
            String bin = Integer.toBinaryString(oneCnt);
            str = bin;
        }
        
        answer[0] = turnCnt;
        answer[1] = zeroCnt;
        return answer;
    }
}