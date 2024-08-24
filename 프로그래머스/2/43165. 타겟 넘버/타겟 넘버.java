class Solution {
    
    private int total = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return total;
    }
    
    private void dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                total++;
            }
            return;
        }
        
        int number = numbers[depth];
        
        int plusSum = sum + number;
        dfs(depth + 1, plusSum, numbers, target);
        
        int minusSum = sum - number;
        dfs(depth + 1, minusSum, numbers, target);
        
    }
    
}