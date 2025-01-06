import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        k = k % len;

        reverse(nums, 0, len - 1); //step1 전체 reverse    [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);   //step2 로테이션 숫자들 reverse [ 5,6,7,4,3,2,1 ]
        reverse(nums, k, len - 1); //step3 나머지 숫자들 reverse [ 5,6,7,1,2,3,4 ]
        
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}