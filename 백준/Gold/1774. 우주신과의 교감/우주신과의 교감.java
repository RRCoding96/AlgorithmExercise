
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	static Node[] nodes;
	static List<Edge> edges;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		double answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 각 우주신이 속한 집합
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		// 우주신 좌표 입력
		nodes = new Node[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			nodes[i] = new Node(i, x, y);
		}
		
		// 연결 통로 계산
		edges = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				Node s = nodes[i];
				Node e = nodes[j];
//				double weight = Math.sqrt((s.x - e.x)*(s.x - e.x) + (s.y - e.y)*(s.y - e.y));
				double weight = Math.sqrt(Math.pow(s.x - e.x, 2) + Math.pow(s.y - e.y, 2));
				
				edges.add(new Edge(s.num, e.num, weight));
			}
		}
		// 오름차순 정렬
		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1.weight < o2.weight) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		// 이미 연결된 부분 처리
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			union(x, y);
		}
		
		// 최소 스패닝 트리 만들기
		for(Edge edge : edges) {
			
			if(!sameParent(edge.start, edge.end)) {
				union(edge.start, edge.end);
				
				answer += edge.weight;
			}
		}
		
		System.out.printf("%.2f\n", answer);
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x <= y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
	
	static boolean sameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return true;
		}
		return false;
	}
	
	static class Node {
		int num, x, y;
		
		public Node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		int start, end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
}
