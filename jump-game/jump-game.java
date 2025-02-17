class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // 현재까지 도달 가능한 최대 인덱스

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // 현재 위치(i)가 maxReach보다 크면 도달할 수 없음
            }
            
            maxReach = Math.max(maxReach, i + nums[i]); // 가장 멀리 점프할 수 있는 위치 갱신
            if (maxReach >= nums.length - 1) {
                return true; // 마지막 인덱스 이상 도달 가능하면 즉시 true 반환
            }
        }
        
        return false;
    }
}
