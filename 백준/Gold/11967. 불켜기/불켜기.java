import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Node>[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static boolean[][] lights;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lights = new boolean[N + 1][N + 1];
        graph = new ArrayList[N + 1][N + 1];
        lights[1][1] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int a = Integer.parseInt(input[2]);
            int b = Integer.parseInt(input[3]);
            graph[x][y].add(new Node(a, b));
        }

        System.out.println(bfs() + 1);
        br.close();
    }

    public static int bfs() {
        int cnt = 0;
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(1, 1));
        visit = new boolean[N + 1][N + 1];

        boolean isSwitchOn = false;

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();

            for (int t = 0; t < 4; t++) {
                int nx = now.x + dx[t];
                int ny = now.y + dy[t];
                if (1 <= nx && nx <= N && 1 <= ny && ny <= N && !visit[nx][ny] && lights[nx][ny]) {
                    dq.offerLast(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }

            for (Node turnOn : graph[now.x][now.y]) {
                if (!lights[turnOn.x][turnOn.y]) {
                    isSwitchOn = true;
                    lights[turnOn.x][turnOn.y] = true;
                    cnt++;
                }
            }
        }

        if (isSwitchOn) {
            return cnt + bfs();
        }
        return cnt;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}