class Solution {
    public long solution(int n) {
        int mod = 1234567;
        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % mod;
        }
        
        
        long answer = arr[n] % 1234567;
        return answer;
    }
}