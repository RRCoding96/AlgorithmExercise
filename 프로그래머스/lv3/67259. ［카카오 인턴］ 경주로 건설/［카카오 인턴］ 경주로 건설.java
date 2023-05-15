import java.util.*;

class Solution {
    
    int N;
    boolean[][][] visited;
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    int minCost;
    
    public int solution(int[][] board) {
        
        N = board.length;
        visited = new boolean[N][N][4];
        minCost = Integer.MAX_VALUE;
        
        bfs(board);
        return minCost;
    }
    
    public void bfs(int[][] board) {
        Queue<Node> que = new LinkedList<>();
        int[][] map = new int[N][N];
        
        que.add(new Node(0, 0, -1, 0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        visited[0][0][2] = true;
        visited[0][0][3] = true;
        
        while(!que.isEmpty()) {
            Node now = que.poll();
            
            if(now.x == N - 1 && now.y == N - 1) {
                minCost = Math.min(minCost, now.cost);
            }
            
            for(int t = 0; t < 4; t++) {
                int nx = now.x + dx[t];
                int ny = now.y + dy[t];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) continue;
                
                int newCost = 0;
                if(t == now.dir || now.dir == -1) {
                    newCost = now.cost + 100;
                } else {
                    newCost = now.cost + 600;
                }
                
                if(!visited[nx][ny][t] || newCost <= map[nx][ny]) {
                    map[nx][ny] = newCost;
                    visited[nx][ny][t] = true;
                    que.add(new Node(nx, ny, t, newCost));
                }
            }
        }
    }
    
    static class Node {
        int x, y, dir, cost;
        
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
}