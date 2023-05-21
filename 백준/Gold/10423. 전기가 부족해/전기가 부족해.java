import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[] parent;
    static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            edges.add(new Edge(0, Integer.parseInt(st.nextToken()), 0));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, cost));
        }

        edges.sort((o1, o2) -> o1.cost - o2.cost);

        long answer = 0;
        for(int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            int a = edge.a;
            int b = edge.b;
            int cost = edge.cost;

            if(!sameParent(a, b)) {
                union(a, b);

                answer += cost;
            }
        }

        System.out.println(answer);
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

    static int find(int x) {
        if(x == parent[x]) {
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
