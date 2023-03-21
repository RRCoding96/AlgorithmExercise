
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		
		int[][] dp = new int[A.length + 1][B.length + 1];
		
		int answer = 0;
		for(int a=0; a<A.length; a++) {
			for(int b=0; b<B.length; b++) {
				if(A[a] == B[b]) {
					dp[a + 1][b + 1] = dp[a][b] + 1;
				} else {
					dp[a + 1][b + 1] = Math.max(dp[a][b + 1], dp[a+1][b]);
				}
				
				answer = Math.max(answer, dp[a + 1][b + 1]);
			}
		}
		
		System.out.println(answer);
		
	}
	
}
