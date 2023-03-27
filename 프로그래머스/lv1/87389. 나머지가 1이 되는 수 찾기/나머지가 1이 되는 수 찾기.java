class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int num = n - 1;
        for(int i = 2; i <= num; i++) {
            if(num % i == 0) {
                return i;
            }
        }
        
        return answer;
    }
}