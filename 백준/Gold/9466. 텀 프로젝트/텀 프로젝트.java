import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int cnt;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            cnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1 ; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++) {
                if(finished[i]) continue;
                dfs(i);
            }


            sb.append(n - cnt).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int now) {
        if(finished[now]) return;

        if(visited[now]) {
            finished[now] = true;
            cnt++;
        }

        visited[now] = true;

        dfs(arr[now]);

        finished[now] = true;
        visited[now] = false;
    }
}