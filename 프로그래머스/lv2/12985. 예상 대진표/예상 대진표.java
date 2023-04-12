import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        int cnt = 0;
        int s = 1;
        int e = n;
        while(s <= e) {
            int mid = (s + e) / 2;
            if(min <= mid && mid < max) {
                cnt = e - s + 1;
                break;
            } else if(max <= mid) {
                e = mid;
            } else if(mid < min) {
                s = mid + 1;
            }
        }
        
        while(cnt > 1) {
            answer++;
            cnt /= 2;
        }

        return answer;
    }
}