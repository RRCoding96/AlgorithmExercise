
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] cards = new int[2][N + 1];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=N; j++) {
					cards[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][N + 1];
			
			dp[0][1] = cards[0][1];
			dp[1][1] = cards[1][1];
			
			for(int i=2; i<=N; i++) {
				dp[0][i] = Math.max(cards[0][i] + dp[1][i-1], Math.max(dp[0][i-1], dp[1][i-1]));
				dp[1][i] = Math.max(cards[1][i] + dp[0][i-1], Math.max(dp[0][i-1], dp[1][i-1]));
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
			
		}
	}

}
