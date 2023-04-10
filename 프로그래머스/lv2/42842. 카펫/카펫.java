import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        List<Integer> t = new ArrayList<>();
        for(int i = total; i >= Math.sqrt(total); i--) {
            if(total % i == 0) {
                t.add(i);
                t.add(total / i);
            }
        }
        
        // System.out.println(t.toString());
        
        for(int v : t) {
            int b = total / v;
            if((v - 2) * (b - 2) == yellow) {
                answer[0] = v;
                answer[1] = b;
                break;
            }
        }
        
        
        return answer;
    }
}