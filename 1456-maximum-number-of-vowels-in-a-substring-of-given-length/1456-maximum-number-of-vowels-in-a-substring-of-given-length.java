import java.util.*;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        
        int len = 0;
        for(int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                len++;
            }
        }
        
        int answer = len;
        for(int t = 1; t < s.length(); t++) {
            int e = t + k - 1;
            if(e >= s.length()) break;
            
            int temp = len;
            char beforeC = s.charAt(t - 1);
            if(set.contains(beforeC)) {
                temp--;
            }
            
            char newC = s.charAt(e);
            if(set.contains(newC)) {
                temp++;
            }
            
            len = temp;
            answer = Math.max(answer, temp);
        }
        
        return answer;
    }
}