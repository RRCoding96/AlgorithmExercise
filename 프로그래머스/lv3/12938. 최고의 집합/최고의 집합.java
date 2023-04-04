class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(n > s) {
            answer = new int[]{-1};
            return answer;
        }
        
        int init = s / n;
        int mod = s % n;
        
        answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = init;
        }
        
        int idx = n - 1;
        for(int m = 0; m < mod; m++) {
            answer[idx]++;
            idx--;
        }
        
        return answer;
    }
}