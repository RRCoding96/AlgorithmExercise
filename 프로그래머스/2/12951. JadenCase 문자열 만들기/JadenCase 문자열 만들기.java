import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] chunks = s.split(" ");
        for(String chunk : chunks) {
            
            if(chunk.length() == 0) {
                answer += " ";
                continue;
            }
                        
            answer += chunk.substring(0, 1).toUpperCase();
            answer += chunk.substring(1, chunk.length()).toLowerCase();
            answer += " ";
        }
        
        if(s.substring(s.length() - 1, s.length()).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length() - 1);
    }
}