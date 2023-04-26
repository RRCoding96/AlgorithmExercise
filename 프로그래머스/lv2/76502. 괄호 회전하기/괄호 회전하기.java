import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int sLen = s.length();
        
        String str = s;
        
        for(int i = 0; i < sLen; i++) {
            String temp = str.substring(1, sLen) + String.valueOf(str.charAt(0));
            Stack<Character> stack = new Stack<>();
            
            // System.out.println(temp);
            
            for(int j = 0; j < sLen; j++) {
                char c = temp.charAt(j);
                if(stack.size() == 0) {
                    stack.add(c);
                } else {
                    char top = stack.peek();
                    if(c == '[' || c == '(' || c == '{') {
                        stack.add(c);
                    } else if(c == ']') {
                        if(top == '[') {
                            stack.pop();
                        } else {
                            str = temp;
                            break;
                        }
                    } else if(c == ')') {
                        if(top == '(') {
                            stack.pop();
                        } else {
                            str = temp;
                            break;
                        }
                    } else if(c == '}') {
                        if(top == '{') {
                            stack.pop();
                        } else {
                            str = temp;
                            break;
                        }
                    }
                }
            }
            if(stack.size() == 0) {
                answer++;
            }
            str = temp;
        }
        
        return answer;
    }
}