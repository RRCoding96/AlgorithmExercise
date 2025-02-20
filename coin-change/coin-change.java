import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 불가능한 경우 대비 큰 값으로 초기화
        dp[0] = 0; // 0원을 만드는 데 필요한 동전 개수는 0

        for (int coin : coins) { // 각 동전에 대해
            for (int i = coin; i <= amount; i++) { // 현재 동전 사용 가능 범위
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
