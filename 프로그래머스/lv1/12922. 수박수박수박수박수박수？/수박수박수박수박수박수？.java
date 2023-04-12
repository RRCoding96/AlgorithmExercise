import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        
        int a = n / 2;
        int b = n % 2;
        
        for(int i = 0; i < a; i++) {
            sb.append("수박");
        }
        for(int i = 0; i < b; i++) {
            sb.append("수");
        }
        
        answer = sb.toString();
        return answer;
    }
}