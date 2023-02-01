
import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] board;
	static int answer;
	
	static int[] dx = {0, 1, 1}; // 가로먼저
	static int[] dy = {1, 0, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		dfs(0, 1, 0);
		System.out.print(answer);

	}
	
	// dir-> 0: 가로 // 1: 세로 // 2: 대각선
	static void dfs(int x, int y, int dir) {
		if(x == N-1 && y == N-1) {
			answer++;
			return;
		}
		
		for(int t=0; t<3; t++) {
			if((t==0 && dir==1) || (t==1 && dir==0)){
				continue;
			}
			
			int nx = x + dx[t];
			int ny = y + dy[t];
			if(!isRange(nx, ny)) {
				continue;
			}
			
			if((t == 2 && board[x+1][y] == 1) || (t == 2 && board[x][y+1] == 1)) {
				continue;
			}
			
			dfs(nx, ny, t);
		}
	}	
	
	static boolean isRange(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N || board[x][y] == 1) {
			return false;
		}
		return true;
	}

}
