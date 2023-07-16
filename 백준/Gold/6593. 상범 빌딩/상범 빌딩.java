import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken()); // 빌딩 층 수
            int R = Integer.parseInt(st.nextToken()); // 행
            int C = Integer.parseInt(st.nextToken()); // 열

            if(L == 0 && R == 0 && C == 0) break;

            int[] start = new int[3];
            char[][][] building = new char[L][R][C];
            for(int l = 0; l < L; l++) {
                for(int r = 0; r < R; r++) {
                    char[] line = br.readLine().toCharArray();
                    for(int c = 0; c < C; c++) {
                        building[l][r][c] = line[c];

                        if(line[c] == 'S') {
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        }
                    }

                }
                br.readLine();
            }

            int result = bfs(building, start, L, R, C);

            if(result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append(String.format("Escaped in %d minute(s).\n", result));
            }

        } // while

        System.out.println(sb);
    }

    public static int bfs(char[][][] building, int[] start, int l, int r, int c) {
        int[] dl = {1, -1, 0, 0, 0, 0};
        int[] dr = {0, 0, 1, -1, 0, 0};
        int[] dc = {0, 0, 0, 0, 1, -1};

        boolean[][][] isVisited = new boolean[l][r][c];
        Queue<Pos> que = new LinkedList<>();

        Pos p = new Pos(start[0], start[1], start[2], 0);
        que.add(p);
        isVisited[p.L][p.R][p.C] = true;

        while (!que.isEmpty()) {
            Pos now = que.poll();

//            System.out.println(now.toString());

            if(building[now.L][now.R][now.C] == 'E') {
//                System.out.println("도착?");
                return now.count;
            }

            for(int t = 0; t < 6; t++) {
                int nL = now.L + dl[t];
                int nR = now.R + dr[t];
                int nC = now.C + dc[t];

                if(nL < 0 || nL >= l || nR < 0 || nR >= r || nC < 0 || nC >= c) continue;
                if(isVisited[nL][nR][nC]) continue;
                if(building[nL][nR][nC] == '#') continue;


                que.add(new Pos(nL, nR, nC, now.count + 1));
                isVisited[nL][nR][nC] = true;
            }


        }

        return -1;
    }

    static class Pos {
        int L;
        int R;
        int C;
        int count;

        public Pos(int L, int R, int C, int count) {
            this.L = L;
            this.R = R;
            this.C = C;
            this.count = count;
        }

        @Override
        public String toString() {
            return L + " " + R + " " + C + ": " + count;
        }
    }
}