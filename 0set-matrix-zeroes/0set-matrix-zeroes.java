class Solution {
    public void setZeroes(int[][] matrix) {
        // 배열의 첫 번째 행과 열은 해당 행과 열을
        // 0으로 치환해야하는지 판단하는데 사용
        
        // 첫 번째 행을 0으로 채워야하는지 판별하기 위한 변수
        // 첫 번째 행과 첫 번째 열은 겹치기 때문에 행 판단을 위한 변수를 따로 사용
        boolean firstRow = false;
        
        // 배열의 각 행,열을 탐색하여
        // 각 행과 열의 0 치환 여부를 판단
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                // 현재 탐색중인 값이 0이라면
                if(matrix[i][j] == 0) {
                    // 현재 열은 0으로 치환해야하는 것으로 판단
                    matrix[0][j] = 0;
                    
                    // 첫 번째 행이 아닌 경우
                    // 현재 행은 0으로 치환해야하는 것으로 판단
                    if(i > 0) {
                        matrix[i][0] = 0;
                    }
                    // 첫 번째 행인 경우
                    // 첫 번째 행은 0으로 치환해야하는 것으로 판단
                    else {
                        firstRow = true;
                    }
                }
            }
        }
        
        // 첫 번째 행,열을 제외한 나머지 셀 값 치환
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                // 탐색중인 행이 0이거나 열이 0인 경우
                // 현재 값을 0으로 변경
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 첫 번째 열이 0인 경우
        if(matrix[0][0] == 0) {
            // 첫 번째 열의 모든 값을 0으로 변경
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        // 첫 번째 행이 0인 경우
        if(firstRow) {
         // 첫 번째 행의 모든 값을 0으로 변경
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}