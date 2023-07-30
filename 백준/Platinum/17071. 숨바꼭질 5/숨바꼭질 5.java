import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[2][500001];

        if(n == k) {
            System.out.println(0);
        } else {
            int result = bfs();
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[0][n] = true;   // visited[0][] == 짝수 초, visited[1][] == 홀수 초

        int size, mod, time = 0;
        while (!q.isEmpty()) {
            size = q.size();
            time++;
            mod = time % 2;

            k += time;
            if (k > 500000) {
                return -1;
            }

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now - 1 >= 0 && !visited[mod][now - 1]) {
                    q.offer(now - 1);
                    visited[mod][now - 1] = true;
                }

                if (now + 1 <= 500000 && !visited[mod][now + 1]) {
                    q.offer(now + 1);
                    visited[mod][now + 1] = true;
                }

                if (now * 2 <= 500000 && !visited[mod][now * 2]) {
                    q.offer(now * 2);
                    visited[mod][now * 2] = true;
                }
            }

            if (visited[mod][k]) {
                return time;
            }
        }
        return -1;
    }

}
