import java.util.*;
import java.io.*;

public class Main {

    static int N, M, X;
    static List<Node>[] nodes;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            nodes[s].add(new Node(e, time));
        }

        int dist = -1;
        int[] result = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            int go = dijkstra(i, X);
            int come = dijkstra(X, i);

            result[i] = go + come;

            if(result[i] > dist) {
                dist = result[i];
            }
        }

//        System.out.println(Arrays.toString(result));

        System.out.println(dist);

    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] distance = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(distance[now.target] < now.weight) continue;

            for(Node nxt : nodes[now.target]) {

                int nCost = now.weight + nxt.weight;
                if(nCost < distance[nxt.target]) {
                    distance[nxt.target] = nCost;
                    pq.add(new Node(nxt.target, nCost));
                }
            }
        }

        return distance[end];

    }

    static class Node implements Comparable<Node>{
        int target, weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}
