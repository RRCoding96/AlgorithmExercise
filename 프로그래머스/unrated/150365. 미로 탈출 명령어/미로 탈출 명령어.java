import java.io.*;
import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] term = {"d", "l", "r", "u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        PriorityQueue<load> q = new PriorityQueue<>((o1, o2) -> o1.route.compareTo(o2.route));
        
        q.offer(new load(x - 1, y - 1, 0, ""));
        
        boolean[][] v = new boolean[n][m];
        
        v[x - 1][y - 1] = true;
        
        while(!q.isEmpty()){
            load now = q.poll();
            
            if(now.x == r - 1 && now.y == c - 1 && now.time == k) {
                return now.route;
            }
            
            if(now.time > k) continue;
            if(!ispossible(now.x, now.y, r - 1, c - 1, k - now.time)) continue;
            
            for(int t = 0; t < 4; t++){
                int nx = now.x + dx[t];
                int ny = now.y + dy[t];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                String Nroute = now.route+ term[t];

                q.offer(new load(nx, ny, now.time + 1, Nroute));
            }
        }
        
        return "impossible";
    }
    
    boolean ispossible(int x, int y, int r, int c, int time){
        int rest = Math.abs(r-x)+Math.abs(c-y);
        
        if(rest > time) {
            return false;
        }
        
        if((rest % 2) - (time % 2) == 0) {
            return true;
        }
        
        return false;
    }
    
    static class load{
        int x;
        int y;
        int time;
        String route;
        
        public load(int x, int y, int time, String route){
            this.x = x; 
            this.y = y; 
            this.time = time; 
            this.route = route;
        }
        
        public String toString(){
            return route;
        }
    }
}