import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[] dp = new long[sequence.length + 1];
        for(int i = 1; i < dp.length; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i - 1] - sequence[i - 1];
            } else {
                dp[i] = dp[i - 1] + sequence[i - 1];
            }
            
        }
        
        // System.out.println(Arrays.toString(dp));
        
        long upMax = Long.MIN_VALUE;
        long upMin = Long.MAX_VALUE;
        for(int i = 0; i < dp.length; i++) {
            upMax = Math.max(upMax, dp[i]);
            upMin = Math.min(upMin, dp[i]);
        }
        
        // System.out.println(upMax);
        // System.out.println(upMin);
        
        answer = Math.abs(upMax - upMin);
        
        return answer;
    }
}