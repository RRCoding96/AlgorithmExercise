import java.util.*;

class Solution {
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    int N, M;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        
        N = maze.length;
        M = maze[0].length;
        
        int x = entrance[0];
        int y = entrance[1];
        
        int result = bfs(x, y, maze);
        
        return result;
    }
    
    int bfs(int x, int y, char[][] maze) {
        Queue<Pos> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        
        isVisited[x][y] = true;
        que.add(new Pos(x, y, 0));
        
        while(!que.isEmpty()) {
            Pos now = que.poll();
            
            for(int t = 0; t < 4; t++) {
                int nx = now.x + dx[t];
                int ny = now.y + dy[t];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    if(now.cnt >= 1) {
                        return now.cnt;
                    }  
                    continue;
                }
                
                if(isVisited[nx][ny]) continue;
                if(maze[nx][ny] == '+') continue;
                
                que.add(new Pos(nx, ny, now.cnt + 1));
                isVisited[nx][ny] = true;
            }
        }
        
        return -1;
    }
    
    static class Pos {
        int x, y, cnt;
        
        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}