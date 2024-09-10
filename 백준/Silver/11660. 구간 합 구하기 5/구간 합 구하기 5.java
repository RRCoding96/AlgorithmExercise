import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][N + 1];
        dp[1][1] = arr[1][1];
        for(int i = 2; i <= N; i++) {
            dp[i][1] = dp[i - 1][1] + arr[i][1];
        }
        for(int i = 2; i <= N; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1][i];
        }
        for(int i = 2; i <= N; i++) {
            for(int j = 2; j <= N; j++) {
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int value = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            sb.append(value).append("\n");
        }

        System.out.println(sb.toString());
    }
}
