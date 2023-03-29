import java.util.*;

class Solution {
    
    static final String[] DIGIT = {"4", "1", "2"};
    
    public String solution(int n) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        
        while(n > 0) {
            int idx = n % 3;
            
            n /= 3;
            
            if(idx == 0) {
                n--;
            }
            
            list.add(DIGIT[idx]);
        }
        
        Collections.reverse(list);
        
        // System.out.println(list);
        
        answer = String.join("", list);
        
        return answer;
    }
    
}