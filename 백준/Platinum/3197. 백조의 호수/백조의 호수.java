import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int R, C;
    static char[][] map;

    static Node start, end;
    static Queue<Node> birdPosQue;
    static Queue<Node> water;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        map = new char[R][C];

        water = new ArrayDeque<>();
        birdPosQue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    if (start == null) {
                        start = new Node(i, j);
                        visited[i][j] = true;
                        birdPosQue.add(new Node(i, j));
                    } else {
                        end = new Node(i, j);
                    }
                    water.add(new Node(i, j));
                } else if (map[i][j] == '.') {
                    water.add(new Node(i, j));
                }
            }
        }

        int day = 0;

        while (true) {
            // 백조 인접 여부 확인
            if (check()) {
                break;
            }
            //빙하 녹이기(물 확산)
            melt();
            day++;
        }
        System.out.println(day);
    }

    // 백조 인접 여부
    static boolean check() {
        Queue<Node> newBirdQue = new ArrayDeque<>();
        while (!birdPosQue.isEmpty()) {

            int size = birdPosQue.size();
            while (size-- > 0) {
                Node cur = birdPosQue.poll();
                int x = cur.x;
                int y = cur.y;

                if (cur.x == end.x && cur.y == end.y) {
                    return true;
                }
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isOut(nx, ny) || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    if (map[nx][ny] == 'X') {
                        newBirdQue.add(new Node(nx, ny));
                        continue;
                    }
                    birdPosQue.add(new Node(nx, ny));
                }

            }
        }
        birdPosQue = newBirdQue;
        return false;
    }

    static void melt() {
        Queue<Node> melting = new ArrayDeque<>();

        while (!water.isEmpty()) {
            Node cur = water.poll();
            int x = cur.x;
            int y = cur.y;


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isOut(nx, ny) || map[nx][ny] != 'X') {
                    continue;
                }

                map[nx][ny] = '.';
                melting.add(new Node(nx, ny));
            }
        }
        water = melting;
    }

    static boolean isOut(int x, int y) {
        if (x < 0 || y < 0 || x >= R || y >= C) {
            return true;
        }
        return false;

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
