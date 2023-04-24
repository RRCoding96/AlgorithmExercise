class Solution {
    public int solution(int num) {
        int answer = 0;
        long number = num;
        
        while(number > 1) {
            
            // System.out.println(num);
            
            if(answer >= 500) {
                answer = -1;
                break;
            }
            
            if(number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}