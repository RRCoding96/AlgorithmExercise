import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int mod = 10007;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if(n >= 2) {
            dp[2] = 2;
            for(int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
        }

        System.out.println(dp[n]);
    }

}
