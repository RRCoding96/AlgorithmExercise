import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                que.add(matrix[i][j]);
            }
        }
        
        for(int j = rowLen - 1; j >= 0; j--) {
            for(int i = 0; i < colLen; i++) {
                matrix[i][j] = que.poll();
            }
        }

    }
}