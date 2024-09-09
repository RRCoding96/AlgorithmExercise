import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        int minValue = arr[0];
        int answer = arr[0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];

            if(minValue > dp[i]) {
                minValue = dp[i];
            } else {
                answer = Math.max(answer, Math.max(dp[i] - minValue, Math.max(dp[i], arr[i])));
            }

            answer = Math.max(answer, Math.max(dp[i], arr[i]));
        }

        System.out.println(answer);
    }
}
