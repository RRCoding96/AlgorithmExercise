class Solution {
    public int climbStairs(int n) {
        int[] check = new int[n + 1];
        
        check[0] = 1;
        check[1] = 1;
        for(int i = 2; i <= n; i++) {
            check[i] = check[i - 1] + check[i - 2];
        }
        
        return check[n];
    }
}