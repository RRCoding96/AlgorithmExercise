import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> result = bfs(map, N);
        result.sort(Comparator.naturalOrder());

        sb.append(result.size()).append("\n");
        for(int n : result) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> bfs(int[][] map, int n) {
        List<Integer> result = new ArrayList<>();

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        boolean[][] isVisited = new boolean[n][n];

        int houseCnt = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0 || isVisited[i][j]) {
//                    if(houseCnt > 0) {
//                        result.add(houseCnt);
//                    }
                    houseCnt = 0;
                    continue;
                }

                isVisited[i][j] = true;
                que.add(new int[]{i, j});
                while (true) {
                    if(que.isEmpty()) {
                        if(houseCnt > 0) {
                            result.add(houseCnt);
                        }
                        break;
                    }

                    int[] nowPos = que.poll();
                    houseCnt++;
                    int x = nowPos[0];
                    int y = nowPos[1];

                    for(int t = 0; t < 4; t++) {
                        int nextX = x + dx[t];
                        int nextY = y + dy[t];

                        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                        if(map[nextX][nextY] == 0 || isVisited[nextX][nextY]) {
                            continue;
                        }

                        isVisited[nextX][nextY] = true;
                        que.add(new int[]{nextX, nextY});
                    }
                }

            }
        }

        return result;
    }


}
