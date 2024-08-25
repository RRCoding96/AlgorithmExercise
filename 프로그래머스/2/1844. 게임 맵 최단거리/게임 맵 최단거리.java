import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int answer = bfs(maps);
        return answer;
    }
    
    private int bfs(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int rowLen = maps.length;
        int colLen = maps[0].length;
        
        boolean[][] isVisited = new boolean[rowLen][colLen];
        Queue<int[]> que = new LinkedList<>();
        
        isVisited[0][0] = true;
        que.add(new int[]{0, 0, 1});
        while(!que.isEmpty()) {
            int[] now = que.poll();
            
            int nowRow = now[0];
            int nowCol = now[1];
            int nowCnt = now[2];
            
            if(nowRow == rowLen - 1 && nowCol == colLen - 1) {
                return nowCnt;
            }
            
            for(int t = 0; t < 4; t++) {
                int nextRow = nowRow + dx[t];
                int nextCol = nowCol + dy[t];
                
                if(nextRow < 0 || nextRow >= rowLen || nextCol < 0 || nextCol >= colLen) {
                    continue;
                }
                if(maps[nextRow][nextCol] == 0 || isVisited[nextRow][nextCol]) continue;
                
                isVisited[nextRow][nextCol] = true;
                que.add(new int[]{nextRow, nextCol, nowCnt + 1});
            }
        }
        
        return -1;
    }
}