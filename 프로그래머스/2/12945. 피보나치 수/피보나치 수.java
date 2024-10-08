class Solution {
    public int solution(int n) {
        int mod = 1234567;
        
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % mod;
        }
        
        int answer = arr[n] % mod;
        return answer;
    }
}