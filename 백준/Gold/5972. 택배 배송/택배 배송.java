import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        long answer = dijkstra();
        System.out.println(answer);
    }

    static long dijkstra() {
        long[] distance = new long[N + 1];
        for(int i = 1; i <= N; i++) {
            distance[i] = Long.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(now.num == N) {
                return now.cost;
            }

            for(Edge next : graph[now.num]) {
                long dist = now.cost + next.cost;
                if(distance[next.num] <= dist) continue;

                pq.add(new Edge(next.num, dist));
                distance[next.num] = dist;
            }
        }

        return -1;
    }

    static class Edge implements Comparable<Edge> {
        int num;
        long cost;

        public Edge(int num, long cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.cost - o.cost < 0) {
                return -1;
            } else if(this.cost - o.cost > 0) {
                return 1;
            } else {
                return 0;
            }

        }
    }
}
