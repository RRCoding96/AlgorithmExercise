
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] parent;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		N++;
		M++;
		
		Edge[] edges = new Edge[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		int maxCost = 0;
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < M; i++) {
			Edge edge = edges[i];
			if(!isSameParent(edge.a, edge.b)) {
				union(edge.a, edge.b);
				
				if(edge.cost == 0) {
					maxCost++;
				}
//				System.out.println(edge.a + " " + edge.b);
			}
		}
		
		
		int minCost = 0;
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for(int i = M - 1; i >= 0; i--) {
			Edge edge = edges[i];
			if(!isSameParent(edge.a, edge.b)) {
				union(edge.a, edge.b);
				
				if(edge.cost == 0) {
					minCost++;
				}
				
//				System.out.println(edge.a + " " + edge.b);
			}
		}
//		System.out.println(maxCost);
//		System.out.println(minCost);
		
		System.out.println(maxCost * maxCost - minCost * minCost);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}
	
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return true;
		}
		
		return false;
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static class Edge {
		int a, b, cost;
		
		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
	
}
