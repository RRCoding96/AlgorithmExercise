class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length + 1];
        for(int i = 0; i <= cost.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        arr[0] = 0;
        // arr[1] = Math.min(cost[0], cost[1]);
        arr[1] = 0;
        // System.out.println(0 + " : " + arr[0]);
        // System.out.println(1 + " : " + arr[1]);
        for(int i = 2; i <= cost.length; i++) {
            arr[i] = Math.min(arr[i - 1] + cost[i - 1], arr[i - 2] + cost[i - 2]);
            // System.out.println(i + " : " + arr[i]);
        }
        
        return arr[cost.length];
    }
}
