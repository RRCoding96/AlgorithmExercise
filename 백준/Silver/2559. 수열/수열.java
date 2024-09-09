import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int s = 0;
        for(int i = 0; i < K; i++) {
            s += arr[i];
        }
        dp[K - 1] = s;

        int maxResult = s;
        for(int i = K; i < N; i++) {
            int j = i - K;
            dp[i] = dp[i - 1] + arr[i] - arr[j];
            maxResult = Math.max(maxResult, dp[i]);
        }

        System.out.println(maxResult);
    }
}
