import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 보석 갯수
        int K = Integer.parseInt(st.nextToken()); // 가방 갯수

        Gem[] gems = new Gem[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int m = Integer.parseInt(st.nextToken()); // 보석 무게
            int v = Integer.parseInt(st.nextToken()); // 가격

            gems[i] = new Gem(m, v);
        }
        Arrays.sort(gems); // 무게(오름차순) -> 가격(오름차순)

        int[] bags = new int[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long total = 0;
        PriorityQueue<Integer> availableCosts = new PriorityQueue<>(Comparator.reverseOrder());
        int gemIndex = 0;
        for(int bagLimit : bags) {

            while (gemIndex < N && gems[gemIndex].weight <= bagLimit) {
                availableCosts.add(gems[gemIndex++].cost);
            }

            if(!availableCosts.isEmpty()) {
                total += availableCosts.poll();
            }
        }

        System.out.println(total);
    }

    static class Gem implements Comparable<Gem> {
        int weight;
        int cost;

        public Gem(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Gem o) {
            if(this.weight == o.weight) {
                return this.cost - o.cost;
            }

            return this.weight - o.weight;
        }
    }

}
