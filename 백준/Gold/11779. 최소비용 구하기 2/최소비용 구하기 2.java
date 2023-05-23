import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<City>[] cities;
    static int[] history;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        cities = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            cities[s].add(new City(e, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        history = new int[N + 1];

        dijkstra(start);

        System.out.println(distance[end]);

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (history[end] != 0) {
            cnt += 1;
            stack.push(history[end]);
            end = history[end];
        }
        System.out.println(cnt + 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();

        pq.add(new City(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            City now = pq.poll();

            int nowCity = now.to;
            int nowDist = now.weight;

            if(distance[nowCity] < nowDist) continue;

            for(City nxt : cities[nowCity]) {
                int nxtCity = nxt.to;
                int cost = nxt.weight;

                int nextCost = nowDist + cost;

                if(nextCost < distance[nxtCity]) {
                    distance[nxtCity] = nextCost;
                    history[nxtCity] = nowCity;
                    pq.add(new City(nxtCity, nextCost));
                }
            }
        }
    }

    static class City implements Comparable<City> {
        int to;
        int weight;

        public City(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(City o) { // 비용 오름차순 정렬
            return this.weight - o.weight;
        }
    }

}
