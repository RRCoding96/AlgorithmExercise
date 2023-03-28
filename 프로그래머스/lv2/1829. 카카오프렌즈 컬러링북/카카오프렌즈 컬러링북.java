import java.util.*;

class Solution {
    
    static boolean[][] isVisited;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int R, C;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        R = m;
        C = n;
        
        isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!isVisited[i][j] && picture[i][j] != 0) {
                    int rst = bfs(i, j, picture[i][j], picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, rst);
                }
            }
        }        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int r, int c, int color,int[][] picture) {
        int total = 1;
        
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{r, c});
        isVisited[r][c] = true;
        
        while(!que.isEmpty()) {
            int[] now = que.poll();
            
            int x = now[0];
            int y = now[1];
            
            for(int t = 0; t < 4; t++) {
                int nx = x + dx[t];
                int ny = y + dy[t];
                
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                
                if(isVisited[nx][ny]) continue;
                
                if(picture[nx][ny] == color) {
                    total++;
                    isVisited[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }
            }
        }
        
        return total;
    }
}