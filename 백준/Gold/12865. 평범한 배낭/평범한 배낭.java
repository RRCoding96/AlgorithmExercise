import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] inputs = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            inputs[i][0] = w;
            inputs[i][1] = v;
        }
        
        int[][] dp = new int[N + 1][K + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                // i 번째 무게를 더 담을 수 없는 경우
                if(inputs[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // i 번째 무게를 더 담을 수 있는 경우
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - inputs[i][0]] + inputs[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }



}
