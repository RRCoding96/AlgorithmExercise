import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            int zipLen = 1;
            String zippedStr = s.substring(0, i);
            String result = "";
            
            for(int j = i; j <= s.length(); j += i) {
                int endIdx = j + i <= s.length() ? j + i : s.length();
                String nextTargetStr = s.substring(j, endIdx);
                
                // 압축할 수 있는 경우
                if(zippedStr.equals(nextTargetStr)) {
                    zipLen++;
                } 
                // 압축 안되는 경우
                else {
                    result += ((zipLen == 1 ? "" : zipLen) + zippedStr);
                    zippedStr = nextTargetStr; // 다음 문자열 -> 다시 압축 확인할 문자열로
                    zipLen = 1;
                }
            }
            
            result += zippedStr;
            
            // System.out.println("result: " + result + "     길이: " + result.length());
            
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}