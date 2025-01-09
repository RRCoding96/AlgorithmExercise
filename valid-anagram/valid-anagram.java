import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        int[] sArr = new int[36];
        int[] tArr = new int[36];
        
        for(int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
                        
            sArr[ss - 'a']++;
            tArr[tt - 'a']++;
        }
        
        for(int i = 0; i < 36; i++) {
            if(sArr[i] != tArr[i]) return false;
        }
        
        return true;
    }
}