
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] board;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        board = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = str.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(new Pos(1, 1), 0, 1));
        visited[1][1][0] = true;

        while (!q.isEmpty()) {

            Pair pair = q.poll();
            Pos pos = pair.pos;

            if (pos.r == N && pos.c == M) {
                return pair.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];

                if ((1 <= nr && nr <= N) && (1 <= nc && nc <= M)) {
                    // 벽 아니면 벽 안 부수고 진행
                    if (board[nr][nc] == 0 && !visited[nr][nc][pair.wall]) {
                        q.offer(new Pair(new Pos(nr, nc), pair.wall, pair.cnt + 1));
                        visited[nr][nc][pair.wall] = true;
                    }
                    // 벽 만나면 벽 부수고 진행
                    else if (board[nr][nc] == 1 && pair.wall < K && !visited[nr][nc][pair.wall + 1]) {
                        q.offer(new Pair(new Pos(nr, nc), pair.wall + 1, pair.cnt + 1));
                        visited[nr][nc][pair.wall + 1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static class Pair {

        int cnt;
        Pos pos;
        int wall;

        Pair(Pos pos, int wall, int cnt) {
            this.pos = pos;
            this.wall = wall;
            this.cnt = cnt;
        }
    }

    static class Pos {

        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
