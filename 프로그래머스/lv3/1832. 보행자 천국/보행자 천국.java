import java.util.*;

class Solution {
    int MOD = 20170805;  
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][][] dp = new int[2][m + 1][n + 1];
        dp[0][0][0] = 1;
        // dp[1][0][0] = 1;
               
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                int state = cityMap[i][j];
                if(state == 0) {
                    // 세로
                    dp[0][i + 1][j] += (dp[0][i + 1][j] + dp[0][i][j] + dp[1][i][j]) % MOD;
                    // 가로
                    dp[1][i][j + 1] += (dp[1][i][j + 1] + dp[1][i][j] + dp[0][i][j]) % MOD;
                } else if(state == 2) {
                    // 세로
                    dp[0][i + 1][j] = (dp[0][i + 1][j] + dp[0][i][j]) % MOD;
                    // 가로
                    dp[1][i][j + 1] = (dp[1][i][j + 1] + dp[1][i][j]) % MOD;
                }
            }
        }

        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 System.out.print(dp[0][i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();
        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 System.out.print(dp[1][i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();
                
        
        answer = (dp[0][m - 1][n - 1] + dp[1][m - 1][n - 1]) % MOD;
        
        return answer;
    }
    

}