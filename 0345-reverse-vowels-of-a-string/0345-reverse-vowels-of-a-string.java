import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();
        for(char c : s.toCharArray()) {
            if(isVowel(c)) {
                vowels.add(c);
            }
        }
        
        String answer = "";
        for(char c : s.toCharArray()) {
            if(isVowel(c)) {
                answer += "" + vowels.pop();
            } else {
                answer += "" + c;
            }
        }
        
        return answer;
    }
    
    boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
          c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}