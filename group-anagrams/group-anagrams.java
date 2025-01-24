import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String result = String.valueOf(chars); 
            
            map.putIfAbsent(result, new ArrayList<>());
            List<String> list = map.get(result);
            
            list.add(str);
        }
        
        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            
            answer.add(value);
        }
        
        return answer;
    }
}