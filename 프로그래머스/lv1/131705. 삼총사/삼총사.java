class Solution {
    
    static int answer;
    
    public int solution(int[] number) {
        answer = 0;
        
        bt(0, 0, 0, number);
        
        return answer;
    }
    
    public void bt(int depth, int start, int total, int[] number) {
        if(depth == 3) {
            if(total == 0) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i < number.length; i++) {
            bt(depth + 1, i + 1, total + number[i], number);
        }
    }
}