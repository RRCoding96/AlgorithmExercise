import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int minTemp = 30010;
        for(int[] v : routes) {
            int start = v[0];
            int end = v[1];
            
            if(start > minTemp) {
                answer++;
                minTemp = end;
            }
            minTemp = Math.min(minTemp, end);
        }
        
        return answer;
    }
}