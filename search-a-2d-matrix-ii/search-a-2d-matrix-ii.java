class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        // 우측 상단에서 시작
        int row = 0;
        int col = m - 1;
        
        while (row < n && col >= 0) {
            int value = matrix[row][col];
            
            if (value == target) {
                return true;     // 찾았으면 true
            } else if (value > target) {
                col--;          // 현재 값이 target보다 크므로 열을 왼쪽으로 이동
            } else {
                row++;          // 현재 값이 target보다 작으므로 행을 아래로 이동
            }
        }
        
        // 찾지 못하면 false
        return false;
    }
}
