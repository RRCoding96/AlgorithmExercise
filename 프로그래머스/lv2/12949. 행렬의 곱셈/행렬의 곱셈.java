class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int R = arr1.length;
        int C = arr2[0].length;
        
        int[][] answer = new int[R][C];
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                for(int k = 0 ; k < arr1[0].length ; ++k) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}