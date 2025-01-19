class Solution {
    public int hammingWeight(int n) {
        
        int answer = 0;
        while(n > 0) {
            int value = n % 2;
            if(value == 1) {
                answer++;
            }
            
            n /= 2;
        }
        
        return answer;
    }
}