import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                map.putIfAbsent(c, i);
                
                int k = map.get(c);
                if(k > i) {
                    map.put(c, i);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            String now = targets[i];
            int cnt = 0;
            
            for(int j = 0; j < now.length(); j++) {
                char c = now.charAt(j);
                if(map.get(c) == null) {
                    answer[i] = -1;
                    break;
                }
                cnt += map.get(c) + 1;
                answer[i] = cnt;
            }
        }
        
        
        return answer;
    }
}