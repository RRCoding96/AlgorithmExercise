import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        
        List<Integer> list = new ArrayList<Integer>();
        for(int value : arr) {
            if(value % divisor == 0) {
                list.add(value);
            }
        }
        
        int listSize = list.size();
        
        if (listSize == 0) {
            answer = new int[]{-1};
            return answer;
        }
        
        answer = new int[listSize];
        for(int i = 0; i < listSize; i++) {
            answer[i] = list.get(i);
        }
    
        
        Arrays.sort(answer);
        
        return answer;
    }
}