import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = -1;
        
        for(int i = 0; i < s.length(); i++) {
            if(stack.size() == 0) {
                stack.add(s.charAt(i));
            } else {
                char top = stack.peek();
                char now = s.charAt(i);
                
                if(top == now) {
                    stack.pop();
                } else {
                    stack.add(now);
                }
            }
            
        }
        
        if(stack.size() == 0) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}