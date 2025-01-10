import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        
        int result = -1;
        
        int needleLen = needle.length();
        int s = 0;
        while(true) {
            int e = s + needleLen;
            if(e > haystack.length()) break;
            
            String now = haystack.substring(s, e);
            
            // System.out.println("s: " + s + " e: " + e + " now: " + now);
            
            if(needle.equals(now)) {
                result = s;
                break;
            }
            
            s++;
        }
        
        return result;
    }
}