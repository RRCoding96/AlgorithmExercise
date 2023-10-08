class Solution {
    
    final long MOD = 1000000007;
    
    public int numTilings(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;
        
        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        for(int i = 4; i <= n; i++) {
            // arr[i] = (arr[i - 1] + (arr[i - 2] * 2) + (arr[i - 3] * 5)) % MOD;
            arr[i] = (arr[i - 1] * 2 + arr[i - 3]) % MOD;
        }
        
        return (int)arr[n];
    }
}