import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] holeCost;
    static List<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 논의 개수
        edges = new ArrayList<>();

        holeCost = new int[N + 1];
//        int hole = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            holeCost[i] = Integer.parseInt(br.readLine());
            int cost = holeCost[i];
//            hole = Math.min(hole, cost);
            edges.add(new Edge(0, i, cost));
        }


        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= i; j++) {
                st.nextToken();
            }

            for(int j = i + 1; j <= N; j++) {
                int s = i;
                int e = j;
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s, e, cost));
            }
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        parent = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        long answer = 0;

        for(Edge edge : edges) {
            int a = edge.s;
            int b = edge.e;
            int cost = edge.cost;

            if(!sameParent(a, b)) {
//                System.out.println(a + " " + b + " " + cost);
                union(a, b);
                answer += cost;
            }
        }


        System.out.println(answer);
    }

    static boolean sameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }

        return false;
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

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
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
