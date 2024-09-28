
import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[1000];
		for (int i=0; i<1000; i++) {
			dp[i] = 1;
		}

		int answer = 1;
		for (int i=1; i<N; i++) {
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
