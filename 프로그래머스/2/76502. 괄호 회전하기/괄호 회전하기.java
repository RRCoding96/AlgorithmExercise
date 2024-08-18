import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int end = i;
            String str = s.substring(end) + s.substring(0, end);
                        
            if(isOk(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isOk(String input) {
        
        Stack<Character> stack = new Stack<>();
        for(char s : input.toCharArray()) {
            if(stack.isEmpty()) {
                stack.add(s);
                continue;
            }
            
            char top = stack.peek();
                        
            if(top == '[') {
                if(s == ']') {
                    stack.pop();
                    continue;
                }
                stack.add(s);
            } else if(top == '{') {
                if(s == '}') {
                    stack.pop();
                    continue;
                }
                stack.add(s);
            } else if(top == '(') {
                if(s == ')') {
                    stack.pop();
                    continue;
                }
                stack.add(s);
            } else {
                stack.add(s);
            }
        }
        
        return stack.isEmpty();
    }
}