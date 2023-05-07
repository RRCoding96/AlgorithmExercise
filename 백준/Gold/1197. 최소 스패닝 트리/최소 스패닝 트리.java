import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int V, E;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        int answer = 0;

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, cost));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        parent = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < E; i++) {
            Edge edge = edges.get(i);

            if(!isSameParent(edge.s, edge.e)) {
                union(edge.s, edge.e);
                answer += edge.cost;
            }
        }

        System.out.println(answer);

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

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
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
