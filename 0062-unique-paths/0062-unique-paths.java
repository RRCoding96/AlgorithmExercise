import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // printDp(dp);
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] += dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        // printDp(dp);
        
        
        return dp[m - 1][n - 1];
    }
    
    void printDp(int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}