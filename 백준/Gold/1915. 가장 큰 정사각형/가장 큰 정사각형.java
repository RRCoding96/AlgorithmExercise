import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 전체 게임판의 크기가 1 x 1인 경우는
        // 바로 1 출력하고 끝냄.
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        int ans = 0;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 1; j <= m; j++) {
                int temp = input[j - 1] - '0';

                if (i == 1 && j == 1) { // 맨 처음 게임판의 숫자는 그대로 dp[i][j]에 저장.
                    dp[i][j] = temp;
                } else { // (1, 2) 부터는 왼쪽, 위쪽, 왼쪽 대각선 방향 중 가장 작은 값에 1을 더한 값을 dp[i][j]에 저장.
                    if (temp == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(ans * ans);

    }

}
