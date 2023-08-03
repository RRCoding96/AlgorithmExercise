import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] check = new int[N + 1][N + 1];
        for(int s = 1; s <= N; s++) {
            for(int e = s; e <= N; e++) {

                int start = s;
                int end = e;
                boolean isPelin = true;
                while(start <= end) {
                    if(arr[start] != arr[end]) {
                        isPelin = false;
                        break;
                    }

                    start++;
                    end--;
                }
                if(isPelin) {
                    check[s][e] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start <= end) {
                sb.append(check[start][end]).append("\n");
            } else {
                sb.append(check[end][start]).append("\n");
            }

        }

        System.out.println(sb);

    }

}
