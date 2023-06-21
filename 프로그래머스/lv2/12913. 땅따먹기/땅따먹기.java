import java.util.*;

class Solution {
    
    int solution(int[][] land) {
        int  answer = 0;
        
        int[][] dp = new int[land.length][4];
        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int r = 1; r < land.length; r++) {
            for(int c = 0; c < 4; c++) {
                
                for(int i = 0; i < 4; i++) {
                    if(c == i) continue;
                    dp[r][c] = Math.max(dp[r][c], dp[r - 1][i] + land[r][c]);
                }
            }
        }
        
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        return answer;
    }
    
}