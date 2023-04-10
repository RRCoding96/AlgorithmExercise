import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        int x = 0;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                x = i;
                break;
            }
        }
        
        answer = String.format("김서방은 %d에 있다", x);
        
        return answer;
    }
}