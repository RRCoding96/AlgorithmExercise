class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        
        int left = searchInsert(nums, target);
        if (left < nums.length && nums[left] == target) { 
            return new int[] { left, searchInsert(nums, target + 1) - 1 }; 
        } else {
            return new int[] { -1, -1 };
        }
    }
    
    private int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] >= target) {
            return left;
        } else if (nums[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }
}