import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int lim = w * 2 + 1;
        
        int start = 1;
        for(int i = 0; i < stations.length; i++) {
            int nowStationPos = stations[i];
            
            int end = nowStationPos - w - 1;
            
            if(end < 1) {
                start = nowStationPos + w + 1;
                continue;
            }
            
            int len = end - start + 1;
            
            // answer += (int)Math.ceil(len / lim);
            int a = len / lim;
            answer += a;
            int b = len % lim;
            if(b > 0) {
                answer++;
            }
            
            start = nowStationPos + w + 1;
        }
        
        int len = n - start + 1;
        if(len > 0) {
            // answer += (int)Math.ceil(len / lim);
            int a = len / lim;
            answer += a;
            int b = len % lim;
            if(b > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}