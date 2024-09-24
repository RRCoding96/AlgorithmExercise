import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
//        int[] R = new int[n + 1];
//        int[] G = new int[n + 1];
//        int[] B = new int[n + 1];
        int[][] colors = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            colors[i][0] = r;
            colors[i][1] = g;
            colors[i][2] = b;
        }

        int[][] dp = new int[n + 1][3];
        dp[1][0] = colors[1][0];
        dp[1][1] = colors[1][1];
        dp[1][2] = colors[1][2];

        dp[2][0] = colors[2][0] + Math.min(dp[1][1], dp[1][2]);
        dp[2][1] = colors[2][1] + Math.min(dp[1][0], dp[1][2]);
        dp[2][2] = colors[2][2] + Math.min(dp[1][0], dp[1][1]);

        for(int i = 3; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    dp[i][j] = colors[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                }
                if(j == 1) {
                    dp[i][j] = colors[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                }
                if(j == 2) {
                    dp[i][j] = colors[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int j = 0; j < 3; j++) {
            result = Math.min(result, dp[n][j]);
        }

        System.out.println(result);
    }

}
