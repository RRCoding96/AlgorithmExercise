import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] input;

    static int[][] island;

    static int answer;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Info> q;
    static int[][] count;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        answer = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        input = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island = new int[N][N];
        q = new LinkedList<>();
        count = new int[N][N];

        markIslandNumber();

//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                System.out.print(island[i][j] + " ");
//            }
//            System.out.println();
//        }

        bfs();

        System.out.println(answer);
    }

    static void markIslandNumber() {
        Queue<Pos> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        int idx = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && input[i][j] == 1) {
                    que.add(new Pos(i, j));
                    visited[i][j] = true;

                    while (!que.isEmpty()) {
                        Pos now = que.poll();

                        island[now.x][now.y] = idx;
                        q.add(new Info(0, idx, now.x, now.y));

                        for(int t = 0; t < 4; t++) {
                            int nx = now.x + dx[t];
                            int ny = now.y + dy[t];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[nx][ny] || input[nx][ny] != 1) continue;

                            que.add(new Pos(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }

                    idx++;
                }
            }
        }
    }

    static void bfs() {

        while (!q.isEmpty()) {
            Info now = q.poll();

            for(int t = 0; t < 4; t++) {
                int nx = now.x + dx[t];
                int ny = now.y + dy[t];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(island[nx][ny] != now.num && island[nx][ny] != 0) {
                    answer = Math.min(answer, count[now.x][now.y] + count[nx][ny]);
                }

                if(island[nx][ny] == 0) {
                    q.add(new Info(now.cnt + 1, now.num, nx, ny));
                    island[nx][ny] = now.num;
                    count[nx][ny] = now.cnt + 1;
                }
            }
        }

    }

    static class Info {
        int cnt, num, x, y;

        public Info(int cnt, int num, int x, int y) {
            this.cnt = cnt;
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}