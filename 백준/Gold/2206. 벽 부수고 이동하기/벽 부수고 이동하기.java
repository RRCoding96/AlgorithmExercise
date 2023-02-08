
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int answer = bfs(0, 0);
		
		if(answer == -1) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
	}
	
	static int bfs(int x, int y) {
		Queue<Pos> que = new LinkedList<>();
		
		que.add(new Pos(x, y, 1, false));
		visited[x][y][0] = true;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			int curX = p.x;
			int curY = p.y;
			
			if(curX == N-1 && curY == M-1) { // 도착함
				return p.cnt;
			}
			
			for(int t=0; t<4; t++) {
				int nx = curX + dx[t];
				int ny = curY + dy[t];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 0) { // 지나갈 수 있는 길 이면?
					if(!visited[nx][ny][0] && !p.isDestroyed) { // 벽을 하나도 안 부쉈다면
						que.add(new Pos(nx, ny, p.cnt + 1, false)); //벽 부쉇고 거리 추가
						visited[nx][ny][0] = true; 
					} else if(!visited[nx][ny][1] && p.isDestroyed) { // 벽을 한 번 부수 적이 있으면
						que.add(new Pos(nx, ny, p.cnt + 1, true));
						visited[nx][ny][1] = true;
					}
				} else if(map[nx][ny] == 1) { // 벽이면?
					if(!p.isDestroyed) {//벽을 하나도 안 부쉇으면 -> 하나 부수고 통과함
						que.add(new Pos(nx, ny, p.cnt + 1, true));
						visited[nx][ny][1] = true; // 하나 부쉇으니깐 [1]로 감
					} else { // 벽을 한 번 부순 적 잇으면?
						//아무것도 안함
					}
				}
			}
			
		}
		return -1;
	}
	
	static class Pos{
		int x;
		int y;
		int cnt;
		boolean isDestroyed;
		
		Pos(int x, int y, int cnt, boolean isDestroyed){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.isDestroyed = isDestroyed;
		}
	}
}
