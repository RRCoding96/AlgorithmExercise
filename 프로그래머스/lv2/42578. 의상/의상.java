import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String category = cloth[1];
            
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        int answer = 1;
        for (String s : map.keySet()) {
            // 착용안하는 경우의 수 = +1
            answer *= (map.get(s)+1);
        }
        
        return answer - 1;
        
    }
}