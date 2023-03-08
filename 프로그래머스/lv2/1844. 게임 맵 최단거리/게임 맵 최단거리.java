import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int rowLen = maps.length;
        int colLen = maps[0].length;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] checked = new boolean[rowLen][colLen];
        
        que.add(new int[] {0, 0, 1});
        checked[0][0] = true;
        
        while(!que.isEmpty()) {
        	int[] now = que.poll();
        	int x = now[0];
        	int y = now[1];
        	int dist = now[2];
        	
        	if (x == rowLen - 1 && y == colLen - 1) {
        		answer = dist;
        		break;
        	}
        	
        	for (int t=0; t<4; t++) {
        		int nx = x + dx[t];
        		int ny = y + dy[t];
        		
        		if (nx < 0 || ny < 0 || nx >= rowLen || ny >= colLen) continue;
        		if (checked[nx][ny] || maps[nx][ny] == 0) continue;
        		
        		checked[nx][ny] = true;
        		que.add(new int[] {nx, ny, dist + 1});
        	}
        }
        
        
        return answer;
    }
}