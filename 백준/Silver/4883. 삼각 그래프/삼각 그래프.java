
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			int[][] graph = new int[N + 1][3];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			long[][] dp = new long[N + 1][3];
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j < 3; j++) {
					dp[i][j] = 1_000_001;
				}
			}

			dp[1][1] = graph[1][1];

			dp[1][2] = dp[1][1] + graph[1][2];

			dp[2][0] = dp[1][1] + graph[2][0];

			dp[2][1] = Math.min(dp[2][1], 
					Math.min(dp[1][1] + graph[2][1], 
					Math.min(dp[1][2] + graph[2][1], 
							dp[2][0] + graph[2][1])));

			dp[2][2] = Math.min(dp[2][2],
					Math.min(dp[1][1] + graph[2][2], 
					Math.min(dp[2][1] + graph[2][2], 
							dp[1][2] + graph[2][2])));

			for (int i = 3; i <= N; i++) {
				dp[i][0] = Math.min(dp[i][0],
						Math.min(dp[i - 1][0] + graph[i][0], 
								dp[i - 1][1] + graph[i][0]));

				dp[i][1] = Math.min(dp[i][1], 
						Math.min(dp[i - 1][0] + graph[i][1], 
						Math.min(dp[i - 1][1] + graph[i][1],
						Math.min(dp[i][0] + graph[i][1], 
								dp[i - 1][2] + graph[i][1]))));

				dp[i][2] = Math.min(dp[i][2], 
						Math.min(dp[i - 1][1] + graph[i][2],
						Math.min(dp[i][1] + graph[i][2], 
								dp[i - 1][2] + graph[i][2])));
			}

			sb.append(tc).append(". ").append(dp[N][1]).append("\n");

			tc++;

		}

		System.out.println(sb);

	}

}
