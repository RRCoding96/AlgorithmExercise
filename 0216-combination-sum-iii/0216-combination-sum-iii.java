import java.util.*;

class Solution {
    
    List<List<Integer>> answer;
    List<Integer> temp;
    int len, limit;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        answer = new ArrayList<>();
        temp = new ArrayList<>();
        len = k;
        limit = n;
        
        bt(0, 0, 0);
        
        return answer;
    }
    
    void bt(int depth, int start, int total) {
        if(depth == len) {
            
            if(total != limit) return;
            
            List<Integer> result = new ArrayList<>();
            for(int a : temp) {
                result.add(a);
            }
            
            answer.add(result);
            
            return;
        }
        
        for(int i = start + 1; i <= 9; i++) {
            if(total + i > limit) continue;
            
            temp.add(i);
            
            bt(depth + 1, i, total + i);
            
            temp.remove(temp.size() - 1);
        }
        
    }
    
}