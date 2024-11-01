
import java.io.*;
import java.util.*;

public class Main {	
	
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[N][M];
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int num = 0;
				if(map[i][j] == 'L') {
					visited = new boolean[N][M];
					num = bfs(i, j);
					//System.out.println(i + " "+j+": "+num);
					max = max < num ? num : max;
				}
			}
		}
		
		System.out.println(max);
		
	}	
	
	static int bfs(int x, int y) {
		Queue<Po> que = new LinkedList<>();
		
		int max = 0;
		
		que.add(new Po(x, y, 0));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Po p = que.poll();
			
			int curX = p.x;
			int curY = p.y;

			for(int t=0; t<4; t++) {
				int nx = curX + dx[t];
				int ny = curY + dy[t];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 'L' && !visited[nx][ny]) {
					que.add(new Po(nx, ny, p.cnt+1));
					visited[nx][ny] = true;
					max = Math.max(max, p.cnt+1);
				}
			}
		}
		return max;
	}
	public static class Po{
		int x;
		int y;
		int cnt;
		public Po(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
}







