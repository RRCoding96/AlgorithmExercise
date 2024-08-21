import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());

        int answer = bfs(n, arr, start);

        System.out.println(answer);
    }

    private static int bfs(int n, int[] arr, int start) {
        int result = 0;

        Queue<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[n + 1];

        check[start] = true;
        que.add(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            int jump = arr[now];
            result++;

            int rightNext = now + jump;
            if((rightNext <= n && rightNext >= 1) && !check[rightNext]) {
                check[rightNext] = true;
                que.add(rightNext);
            }

            int leftNext = now - jump;
            if((leftNext <= n && leftNext >= 1) && !check[leftNext]) {
                check[leftNext] = true;
                que.add(leftNext);
            }
        }

        return result;
    }

}
