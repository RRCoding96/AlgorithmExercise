import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        char[] inputList = s.toCharArray();
        
        for (int i=0; i<inputList.length; i++) {
        	if (stack.size() == 0) {
        		stack.add(inputList[i]);
        	} else {
        		char top = stack.peek();
        		if (inputList[i] == '(') {
        			stack.add(inputList[i]);
        		} else if(inputList[i] == ')' && top == '(') {
        			stack.pop();
        		}
        	}
        }
        
        if (stack.size() != 0) {
        	answer = false;
        }
        
        
        return answer;
    }
}