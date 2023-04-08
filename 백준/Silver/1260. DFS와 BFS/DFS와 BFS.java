import java.util.*;
import java.io.*;

public class Main {

    static int N, M, V;

    static int[][] graph;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b]++;
            graph[b][a]++;
        }

        sb = new StringBuilder();
        isVisited = new boolean[N + 1];

        isVisited[V] = true;
        sb.append(V).append(" ");
        dfs(V);
        System.out.println(sb);

        sb = new StringBuilder();
        isVisited = new boolean[N + 1];
        bfs();
        System.out.println(sb);

    }

    static void dfs(int start) {
        for(int i = 1; i <= N; i++) {
            if(graph[start][i] > 0 && !isVisited[i]) {
                isVisited[i] = true;
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        que.add(V);
        sb.append(V).append(" ");
        isVisited[V] = true;

        while (!que.isEmpty()) {
            int now = que.poll();

            for(int i = 1; i <= N; i++) {
                if(isVisited[i]) continue;

                if(graph[now][i] > 0) {
                    que.add(i);
                    sb.append(i).append(" ");
                    isVisited[i] = true;
                }
            }
        }
    }

}