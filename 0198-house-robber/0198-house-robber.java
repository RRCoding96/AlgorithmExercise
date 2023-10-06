class Solution {
    public int rob(int[] nums) {
        
        if(nums.length <= 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = nums[1];
        
        System.out.println(0 + " : " + arr[0]);
        System.out.println(1 + " : " + arr[1]);
        
        for(int i = 2; i < nums.length; i++) {
            for(int j = 0; j <= i - 2; j++) {
                arr[i] = Math.max(arr[j] + nums[i], Math.max(arr[i - 2] + nums[i], Math.max(arr[i - 1], arr[i])));
                    // arr[i - 2] + nums[i] / arr[i - 1] / 
            }
            
            System.out.println(i + " : " + arr[i]);
        }
        
        return arr[nums.length - 1];
    }
}