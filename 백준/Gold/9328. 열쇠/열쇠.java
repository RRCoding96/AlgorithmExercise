import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;
    static boolean[] key; //알파벳 26개
    static ArrayList<Point>[] gates; // 열지 못한 문
    static boolean[][] visited;
    static int h;
    static int w;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] inputMap = br.readLine().split(" ");

            h = Integer.parseInt(inputMap[0]);
            w = Integer.parseInt(inputMap[1]);

            map = new char[h + 2][w + 2];
            visited = new boolean[h + 2][w + 2];
            key = new boolean[26];
            gates = new ArrayList[26];

            count = 0;

            // 열쇠랑 매핑 되는 문 초기화
            for (int i = 0; i < 26; i++) {
                gates[i] = new ArrayList<>();
            }

            // 테두리 빈 칸으로 채우기
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (int i = 0; i < keyInput.length(); i++) {
                    int temp = keyInput.charAt(i) - 'a';
                    key[temp] = true;
                }
            }

            bfs();
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) {
                    continue;
                }

                if (map[nx][ny] == '*' || visited[nx][ny]) {
                    continue;
                }

                int elem = map[nx][ny];
                // 문 발견
                if (elem - 'A' >= 0 && elem - 'A' <= 25) {
                    // 열쇠 있으면
                    if (key[elem - 'A']) {
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                    // 열쇠 없으면 현재 만난 문 위치 추가
                    else {
                        gates[elem - 'A'].add(new Point(nx, ny));
                    }
                }
                // 열쇠 발견
                else if (elem - 'a' >= 0 && elem - 'a' <= 25) {
                    // 열쇠 찾았다고 표시
                    key[elem - 'a'] = true;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));

                    for (int j = 0; j <= 25; j++) {
                        // 아직 못 연 문이 있고 열쇠 있으면
                        if (gates[j].size() != 0 && key[j]) {
                            // 그 문으로 들어감
                            for (int z = 0; z < gates[j].size(); z++) {
                                Point temp = gates[j].get(z);
                                map[temp.x][temp.y] = '.';
                                visited[temp.x][temp.y] = true;
                                q.add(new Point(temp.x, temp.y));
                            }
                        }
                    }
                }
                // 문서 발견
                else if (elem == '$') {
                    count++;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
                // 빈 칸 '.'
                else {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }

            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
