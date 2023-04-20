class Solution {
    
    static final int MOD = 1234567;
    
    public long solution(int n) {
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[2] = 2;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        long answer = dp[n] % MOD;
        return answer;
    }
}