
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] parent;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a <= b) {
				edges[i] = new Edge(a, b, c);
			} else {
				edges[i] = new Edge(b, a, c);
			}
			
		}
		
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		int target = 0;
		for(int i = 0; i < M; i++) {
			Edge edge = edges[i];
			
			if(!isSameParent(edge.s, edge.e)) {
				union(edge.s, edge.e);
				
				target = Math.max(target, edge.cost);
				answer += edge.cost;
			}
		}
		
		System.out.println(answer - target);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return true;
		}
		
		return false;
	}
	
	static class Edge {
		int s, e, cost;
		
		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}
}
