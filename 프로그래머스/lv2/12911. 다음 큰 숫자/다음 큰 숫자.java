import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binaryN = Integer.toBinaryString(n);
        int oneCnt = 0;
        for(int i = 0; i < binaryN.length(); i++) {
            if(binaryN.charAt(i) == '1') {
                oneCnt++;
            }
        }
        
        for(int num = n + 1; num <= 1_000_000; num++) {
            String binaryNum = Integer.toBinaryString(num);
            int numOneCnt = 0;
            for(int i = 0; i < binaryNum.length(); i++) {
                if(binaryNum.charAt(i) == '1') {
                    numOneCnt++;
                }
            }
            
            if(oneCnt == numOneCnt) {
                answer = num;
                break;
            }
        }
        
        
        return answer;
    }
}