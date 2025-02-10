class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                left = Integer.MIN_VALUE;
            } else {
                left = nums[i - 1];
            }
            
            int mid = nums[i];
            
            if(i == nums.length - 1) {
                right = Integer.MIN_VALUE;
            } else {
                right = nums[i + 1];
            }
            
            if(left < mid && mid > right) {
                return i;
            }
        }
        
        return 0;
    }
}