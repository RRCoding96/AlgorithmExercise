import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int t = 0; t < s.length; t++) {
            StringBuilder sb = new StringBuilder();
            
            String str = s[t];
            
            Stack<Character> stack = new Stack<>();
            int targetCnt = 0;

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                
                if(stack.size() <= 1) {
                    stack.push(c);
                } else {
                    char x = stack.pop();
                    char y = stack.pop();
                    
                    if(x == '1' && y == '1' && c == '0') {
                        targetCnt++;
                    } else {
                        stack.push(y);
                        stack.push(x);
                        stack.push(c);
                    }
                }
                
            }
            
            boolean flag = true;
            while(!stack.isEmpty()) {
                char c = stack.pop();

                if(c == '0' && flag) {
                    for(int i = 0; i < targetCnt; i++) {
                        sb.insert(0, "110");
                    }
                    flag = false;
                }
                sb.insert(0, c);
            }
            
            if(flag) {
                for(int i = 0; i < targetCnt; i++) {
                    sb.insert(0, "110");
                }
            }

            answer[t] = sb.toString();
        }
        
        return answer;
    }
}