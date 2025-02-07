class Solution {
    
    private char[][] gBoard;
    private boolean[][] isVisited;
    private boolean result = false;
    
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    
    private char[] target;
    
    public boolean exist(char[][] board, String word) {
        gBoard = board;
        isVisited = new boolean[board.length][board[0].length];
        target = word.toCharArray();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                char now = board[i][j];
                if(target[0] == now) {
                    isVisited[i][j] = true;
                    dfs(i, j, 1);
                    isVisited[i][j] = false;
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int x, int y, int depth) {
        if(depth == target.length || result) {
            result = true;
            return;
        }
        
        for(int t = 0; t < 4; t++) {
            int nextX = x + dx[t];
            int nextY = y + dy[t];
            
            if(nextX < 0 || nextY < 0 || nextX >= gBoard.length || nextY >= gBoard[0].length) {
                continue;
            }
            if(isVisited[nextX][nextY]) {
                continue;
            }
            
            char nextChar = gBoard[nextX][nextY];
            if(nextChar == target[depth]) {
                isVisited[nextX][nextY] = true;
                dfs(nextX, nextY, depth + 1);
                isVisited[nextX][nextY] = false;
            }
        }
    }
}