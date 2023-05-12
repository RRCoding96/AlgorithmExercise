import java.util.*;
import java.io.*;

public class Main {

    // 집합 기록할 배열
    static int[] parent;
    static List<Edge> edges;
    static List<Edge> checkedEdges;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        checkedEdges = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(d == 0) {
                edges.add(new Edge(a, b, c, d));
            } else {
                checkedEdges.add(new Edge(a, b, c, d));
            }
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.point - o1.point;
            }
        });

        parent = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(Edge edge : checkedEdges) {
            if(!sameParent(edge.a, edge.b)) {
                union(edge.a, edge.b);
            }
        }

        int answer = 0;
        for(Edge edge : edges) {
            if(!sameParent(edge.a, edge.b)) {
                union(edge.a, edge.b);
            } else {
                answer += edge.point;
            }
        }

        System.out.println(answer);
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

    static boolean sameParent(int x, int y) {
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
        int a, b, point, check;

        public Edge(int a, int b, int point, int check) {
            this.a = a;
            this.b = b;
            this.point = point;
            this.check = check;
        }
    }

}
