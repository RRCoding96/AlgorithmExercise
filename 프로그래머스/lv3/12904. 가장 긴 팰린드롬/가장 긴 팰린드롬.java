import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;

        // char[] arr = s.toCharArray();
        
        for(int len = s.length(); len >= 1; len--) {
            int start = 0;
            while(true) {
                int end = start + len - 1;
                
                if(end >= s.length()) break;
                
                if(check(s, start, end)) {
                    answer = end - start + 1;
                    return answer;
                }
                
//                 String a = s.substring(start, end + 1);
//                 String b = reverse(a);
                
//                 if(a.equals(b)) {
//                     answer = end - start + 1;
//                     return answer;
//                 }
                start++;
                
            }
        }

        return answer;
    }
    
    public boolean check(String str, int start, int end) {
        int s = start;
        int e = end;
        while(s <= e) {
            if(str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    
    public String reverse(String str) {
        String rst = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            // rst += str.charAt(i).toString();
            rst += String.valueOf(str.charAt(i));
        }
        
        return rst;
    }
}