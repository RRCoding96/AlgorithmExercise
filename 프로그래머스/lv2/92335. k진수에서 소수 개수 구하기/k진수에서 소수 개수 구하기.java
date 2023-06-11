import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        
        String[] chunk = Integer.toString(n, k).split("0");
        
        System.out.println(Arrays.toString(chunk));
        
        for(String chu : chunk) {
            if(chu.equals("")) continue;
            
            long num = Long.parseLong(chu);
            if(prime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean prime(long num) {
        
        if(num == 1 || num == 0) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}