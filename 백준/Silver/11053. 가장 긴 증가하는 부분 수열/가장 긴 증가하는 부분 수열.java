import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 길이 저장할 배열
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int answer = 1;
        // 오른쪽(기준)
        for (int i = 1; i < n; i++) {
            // 왼쪽(탐색할 인덱스)
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                if (dp[i] > answer) {
                    answer = dp[i];
                }
            }
        }

//		System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }

}
