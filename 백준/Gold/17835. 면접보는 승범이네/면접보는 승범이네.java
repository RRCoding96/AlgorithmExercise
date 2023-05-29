import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static List<Node>[] graph;
    static long[] distance;
    static int[] interviews;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 도시 수 (1 ~ N번 도시)
        M = Integer.parseInt(st.nextToken()); // 도로 수
        K = Integer.parseInt(st.nextToken()); // 면접장 수

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

//            graph[U].add(new Node(V, C));
            graph[V].add(new Node(U, C));
        }

        distance = new long[N + 1];
        for(int i = 0; i <= N; i++) {
            distance[i] = Long.MAX_VALUE;
        }

        interviews = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            interviews[i] = Integer.parseInt(st.nextToken());
        }

        long[] result = dijkstra();

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static long[] dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < K; i++) {
            int interview = interviews[i];
            distance[interview] = 0;
            pq.add(new Node(interview, 0));
        }

//        System.out.println(Arrays.toString(distance));

        while (!pq.isEmpty()) {

            Node now = pq.poll();
            long dist = now.cost;
            int nowPos = now.target;

            if(distance[nowPos] < dist) continue;

            for(Node nxt : graph[now.target]) {
                int nxtPos = nxt.target;

                long cost = dist + nxt.cost;
                if(cost < distance[nxtPos]) {
                    distance[nxtPos] = cost;
                    pq.add(new Node(nxtPos, cost));


//                    System.out.println(Arrays.toString(distance));
                }
            }

        }

        long[] result = new long[2];
        long maxValue = -1;
        for(int i = 1; i <= N; i++) {
            long nowDist = distance[i];
            if(maxValue < nowDist) {
                result[0] = i;
                result[1] = nowDist;

                maxValue = nowDist;
            }
        }

        return result;
    }

    static class Node implements Comparable<Node>{
        int target;
        long cost;

        public Node(int target, long cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1) {
            return Long.compare(this.cost, o1.cost);
        }
    }

}
