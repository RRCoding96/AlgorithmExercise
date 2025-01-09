import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            map.putIfAbsent(c, new ArrayList<>());
            
            List<Integer> list = map.get(c);
            list.add(i);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            char key = entry.getKey();
            List<Integer> value = entry.getValue();
            
            if(value.size() == 1) {
                pq.add(value.get(0));
            }
        }
        
        if(pq.size() == 0) {
            return -1;
        } else {
            return pq.poll();
        }
        
    }
}