import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    private static final int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};

    private static int N, M, K;
    private static char[][] map;
    private static Map<String, Integer> mapping;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        findStringCount();

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < K; i++) {
            String target = br.readLine();
            Integer result = mapping.getOrDefault(target, 0);
            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }

    private static void findStringCount() {
        mapping = new HashMap<>();

        for(int len = 1; len <= 5; len++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    dfs(i, j, 1, len, String.valueOf(map[i][j]));
                }
            }
        }
    }

    private static void dfs(int x, int y, int depth, int limit, String str) {

        if(depth == limit) {
            mapping.put(str, mapping.getOrDefault(str, 0) + 1);
            return;
        }

        for(int t = 0; t < 8; t++) {
            int nx = (x + dx[t] + N) % N;
            int ny = (y + dy[t] + M) % M;

            dfs(nx, ny, depth + 1, limit, str + map[nx][ny]);
        }

    }

}
