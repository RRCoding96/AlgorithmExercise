import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, List<String>> group = new HashMap<>();
        for(String[] arr : clothes) {
            String name = arr[0];
            String category = arr[1];
            
            List<String> clothList = group.putIfAbsent(category, new ArrayList<>());
            group.get(category).add(name);
        }
        
        for(String category : group.keySet()) {
            List<String> clothList = group.get(category);
            answer *= (clothList.size() + 1);

        }
        
        return answer - 1;
    }
}