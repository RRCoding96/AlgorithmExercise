import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i = n - 1; i >= 0; i--) {
            System.out.print(citations[i] + " ");
        }
        
        for(int i = 0; i < n; i++) {
            int h = n - i;
            int more = citations[i];
            
            if(more >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}