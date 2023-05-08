import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int[] arr = new int[elements.length * 2 + 1];
        for(int i = 1; i < elements.length * 2 + 1; i++) {
            arr[i] = elements[i % elements.length];
        }
        
        // System.out.println(Arrays.toString(arr));
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        
        // System.out.println(Arrays.toString(dp));
        
        for(int len = 1; len <= elements.length; len++) {
            int s = 0;
            while(s <= elements.length) {
                int e = s + len;
                
                int value = dp[e] - dp[s];
                set.add(value);
                
                s++;
            }
        }
        
        answer = set.size();
        return answer;
    }
}