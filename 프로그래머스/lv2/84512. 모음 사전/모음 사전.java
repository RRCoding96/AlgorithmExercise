import java.util.*;

class Solution {
    
    List<String> list;
    String[] arr;
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        
        recursion(0, "");
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
    
    public void recursion(int depth, String str) {
        
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            recursion(depth + 1, str + arr[i]);
        }
    }
}