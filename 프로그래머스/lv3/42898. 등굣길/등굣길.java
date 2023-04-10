class Solution {
    
    static final int MOD = 1_000_000_007;
    
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n + 1][m + 1];
        for(int[] v : puddles) {
            dp[v[1]][v[0]] = -1;
        }
        for(int i = 1; i <= n; i++) {
            if(dp[i][1] == -1) break;
            dp[i][1] = 1;
        }
        for(int j = 1; j <= m; j++) {
            if(dp[1][j] == -1) break;
            dp[1][j] = 1;
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                if(dp[i][j] == -1) continue;
                
                for(int t = 0; t < 2; t++) {
                    int nx = i - dx[t];
                    int ny = j - dy[t];
                    
                    if(dp[nx][ny] == -1) continue;
                    
                    dp[i][j] += dp[nx][ny] % MOD;
                }
            }
        }
        
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        answer = dp[n][m] % MOD;
        
        return answer;
    }
}