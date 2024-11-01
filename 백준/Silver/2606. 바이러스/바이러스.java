import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] isVisited = new boolean[N + 1];
        Deque<Integer> que = new ArrayDeque<>();

        que.add(1);
        isVisited[1] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            for(int next : graph[now]) {
                if(isVisited[next]) continue;

                isVisited[next] = true;
                que.add(next);
            }
        }

        int result = 0;
        for(int i = 2; i <= N; i++) {
            if(isVisited[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

}
