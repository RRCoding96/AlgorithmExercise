class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int rst = findCount(i);
            if(rst % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    int findCount(int number) {
        int result = 0;
        
        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                result++;
            }
        } 
        return result;
    }
}