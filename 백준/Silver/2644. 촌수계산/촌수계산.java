import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수

        st = new StringTokenizer(br.readLine(), " ");
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 관계의 수

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int result = bfs(graph, targetA, targetB, n);

        System.out.println(result);

    }

    private static int bfs(List<Integer>[] graph, int targetA, int targetB, int maxNum) {

        Queue<Integer> que = new LinkedList<>();
        // 사람은 1부터 시작임
        int[] check = new int[maxNum + 1];

        que.add(targetA);
        check[targetA] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();
            for(int next : graph[now]) {
                if(next == targetB) {
                    return check[now] + 1;
                }
                if(check[next] != 0) continue;

                que.add(next);
                check[next] = check[now] + 1;
            }
        }

        return -1;
    }

}
