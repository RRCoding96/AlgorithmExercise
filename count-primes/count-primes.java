class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) {
            return 0;
        }
        if(n == 2) {
            return 0;
        }
        
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!isNotPrime[i]) { // 소수라면
                for(int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        int answer = 0;
        for(int i = 2; i < n; i++) {
            if(!isNotPrime[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}