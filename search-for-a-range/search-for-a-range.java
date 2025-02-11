class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = lowerBinarySearch(nums, target);
        int end = upperBinarySearch(nums, target) - 1;

        // target이 배열 내에 없는 경우 체크
        if (start >= nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{start, end};
    }
    
    // target의 첫 번째 위치
    private int lowerBinarySearch(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] >= target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }

    // target 보다 큰 값이 처음 등장하는 위치
    private int upperBinarySearch(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return s;
    }
}