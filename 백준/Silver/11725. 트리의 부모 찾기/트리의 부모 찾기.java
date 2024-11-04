import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] parents = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();

        isVisited[1] = true;
        que.add(1);
        while (!que.isEmpty()) {
            int now = que.poll();

            for(int next : graph[now]) {
                if(isVisited[next]) continue;

                parents[next] = now;
                isVisited[next] = true;
                que.add(next);
            }
        }

        for(int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

}
