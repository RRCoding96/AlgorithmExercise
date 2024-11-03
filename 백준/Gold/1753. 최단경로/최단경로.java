import java.io.*;
import java.util.*;

public class Main {

    private static int V;
    private static int E;
    private static List<Node>[] graph;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(u, v, w));
        }

        distance = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        distance[start] = 0;
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowWeight = now[0];
            int nowIndex = now[1];

            if(nowWeight > distance[nowIndex]) continue;

            for(Node next : graph[nowIndex]) {
                int cost = nowWeight + next.w;

                if(cost < distance[next.v]) {
                    distance[next.v] = cost;
                    pq.add(new int[]{cost, next.v});
                }
            }
        }

    }

    public static class Node {
        int u;
        int v;
        int w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

}
