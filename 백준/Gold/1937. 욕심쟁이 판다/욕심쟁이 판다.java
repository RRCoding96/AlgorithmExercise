import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxResult = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                maxResult = Math.max(maxResult, dfs(i, j));
            }
        }

        System.out.println(maxResult);
    }

    private static int dfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        // dp에 저장된 값이 있을 경우 그 값을 반환.
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        // 판다가 대나무 숲에서 최소한 1년은 살 수 있으므로
        // dp[x][y] = 1로 초기화 할 수 있음.
        dp[x][y] = 1;

        // 상하좌우 검사.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위에서 벗어났을 경우 continue.
            if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                continue;
            }

            // 현재 대나무 숲보다 더 많은 양의 대나무가 있는 경우.
            if (arr[x][y] < arr[nx][ny]) {
                // 상하좌우 중에서 가장 오랫동안 생존할 수 있는 기간을 계산한다.
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                dfs(nx, ny);
            }
        }
        return dp[x][y];
    }

}
