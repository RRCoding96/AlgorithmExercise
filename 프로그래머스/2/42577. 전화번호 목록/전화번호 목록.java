import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        for(String number : phone_book) {
            set.add(number);
        }
        
        for(String phone : phone_book) {
            for(int i = 0; i < phone.length(); i++) {
                String str = phone.substring(0, i);
                if(set.contains(str)) {
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}