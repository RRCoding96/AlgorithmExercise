
import java.io.*;
import java.util.*;

public class Main {	
	
	static int N, M;
	static int cnt;
	static int[] move = new int[101];
	static boolean[] visited = new boolean[101];
	static int[] map = new int[101];
	static int[] dice = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());//사다리 수
		M = Integer.parseInt(st.nextToken());//뱀의 수
		
		for(int i=0; i<N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			move[a] = b;
		}
		
		bfs();
		
	}	
	
	//bfs
	static void bfs() {
		Queue<Integer> que =new LinkedList<>();
		cnt = 0;
		que.offer(1);
		map[1] = 0;
		visited[1] = true;
		
		while(!que.isEmpty()) {
			
			int newNum = que.poll();
			
			if(newNum == 100) {
				System.out.println(map[newNum]);
				return;
			}
			
			for(int i = 0; i < 6; i++) {
				int x = newNum +dice[i];
				
				if(x > 100) continue;
				if(visited[x]) continue;
				visited[x] = true;
				
				if(move[x] != 0) {
					if(!visited[move[x]]) {
						que.offer(move[x]);
						visited[move[x]] = true;
						map[move[x]] = map[newNum] + 1;
					}
				} else {
					que.offer(x);
					map[x] = map[newNum] + 1;
				}
			}
	
		}
	}
}



