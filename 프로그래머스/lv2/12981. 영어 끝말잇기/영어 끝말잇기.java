import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        
        char before = ' ';
        for(int i = 0; i < words.length; i++) {
            String nowWord = words[i];
            char now = nowWord.charAt(0);
            
            // System.out.println(i);
            // System.out.println(before);
            // System.out.println(now);
            // System.out.println();
            
            if(set.contains(nowWord)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            set.add(nowWord);
            
            if(i > 0 && now != before) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            before = nowWord.charAt(nowWord.length() - 1);
        }

        return answer;
    }
}