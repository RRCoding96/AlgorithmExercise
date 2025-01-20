import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(deque.isEmpty()) {
                deque.add(c);
            } else {
                if(c == '(' || c == '{' || c == '[') {
                    deque.add(c);
                }
                
                char top = deque.peekLast();
                
                if(c == ')') {
                    if(top == '(') {
                        deque.pollLast();
                    } else {
                        return false;
                    }
                } else if(c == '}') {
                    if(top == '{') {
                        deque.pollLast();
                    } else {
                        return false;
                    }
                } else if(c == ']') {
                    if(top == '[') {
                        deque.pollLast();
                    } else {
                        return false;
                    }
                }
                
            }
        }
        
        if(!deque.isEmpty()) {
            return false;
        }
        
        return true;
    }
}