import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + i;
        }
        
        // System.out.println(Arrays.toString(dp));
        
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 0; j < i; j++) {
        //         int rst = dp[i] - dp[j];
        //         if(rst == n) {
        //             System.out.println(i + " " + dp[j]);
        //             answer++;
        //         }
        //     }
        // }
        
        // System.out.println("여긴 밑");
        for(int i = 1; i <= n; i++) {
            int target = dp[i] - n;
            if(binarySearch(dp, 0, n, target)) {
                // System.out.println(i + " " + target);
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}