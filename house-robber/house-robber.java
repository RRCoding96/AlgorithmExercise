class Solution {
    public int rob(int[] nums) {
        int[] total = new int[nums.length];
        total[0] = nums[0];
        if(nums.length >= 2) {
            total[1] = Math.max(nums[0], nums[1]);
        }
        
        for(int i = 2; i < nums.length; i++) {
            total[i] = Math.max(total[i - 2] + nums[i], total[i - 1]);
        }
        
        return total[nums.length - 1];
    }
}