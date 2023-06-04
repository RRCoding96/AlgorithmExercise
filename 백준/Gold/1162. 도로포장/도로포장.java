import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<Info>[] graph;
    static long[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 도시 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        K = Integer.parseInt(st.nextToken()); // 포장할 도로 수

        graph = new ArrayList[N + 1];
        distance = new long[N + 1][K + 1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            for(int j = 0; j <= K; j++) {
                distance[i][j] = Long.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            graph[a].add(new Info(b, c));
            graph[b].add(new Info(a, c));
        }

        dijkstra();

        long answer = Long.MAX_VALUE;
        for(long a : distance[N]) {
            answer = Math.min(answer, a);
        }

        System.out.println(answer);

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0, 0));
        distance[1][0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dist > distance[now.num][now.count]) continue;

            for(Info nxt : graph[now.num]) {
                long nxtDist = now.dist + nxt.cost;

                if(nxtDist < distance[nxt.target][now.count]) {
                    distance[nxt.target][now.count] = nxtDist;
                    pq.add(new Node(nxt.target, now.count, nxtDist));
                }
                if (now.count < K && now.dist < distance[nxt.target][now.count + 1]) {
                    distance[nxt.target][now.count + 1] = now.dist;
                    pq.add(new Node(nxt.target, now.count + 1, now.dist));
                }
            }

        }
    }

    static class Node implements Comparable<Node>{
        int num, count;
        long dist;

        public Node(int num, int count, long dist) {
            this.num = num;
            this.count = count;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o1) {
            return Long.compare(this.dist, o1.dist);
        }
    }

    static class Info {
        int target;
        long cost;

        public Info(int target, long cost) {
            this.target = target;
            this.cost = cost;
        }
    }

}