class Solution {
    public int lengthOfLIS(int[] nums) {

        int max = 1;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        for(int i = 1; i < nums.length; i++) {
            int now = nums[i];
            for(int j = i - 1; j >= 0; j--) {
                int v = nums[j];
                if(v < now) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
            // System.out.println(dp[i]);
        }
        
        
        
        return max;
    }
}