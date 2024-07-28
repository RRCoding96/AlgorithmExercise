import java.util.*;

class Solution {
    
    List<int[]> arr = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        
        int[][] answer = arr.stream()
                .toArray(int[][]::new);
        
        return answer;
    }
    
    public void hanoi(int cnt, int start, int middle, int end) {
        if(cnt == 0) {
            return;
        }
        hanoi(cnt - 1, start, end, middle);
        arr.add(new int[]{start, end});
        hanoi(cnt - 1, middle, start, end);
    }
}