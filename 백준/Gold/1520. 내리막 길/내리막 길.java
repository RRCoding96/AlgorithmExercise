import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] board;
    static int[][] dp;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M + 1][N + 1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));

    }

    public static int dfs(int x, int y) {
        if (x == M && y == N) {
            return 1;
        }

        // 이미 체크 한 곳이면
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
        for (int t = 0; t < 4; t++) {
            int nx = x + dx[t];
            int ny = y + dy[t];

            if (nx < 1 || ny < 1 || nx > M || ny > N) {
                continue;
            }

            // 내리막길이면
            if (board[x][y] > board[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

}
