
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		int[] dp = new int[arr.length + 1];
		dp[0] = 1;
		for(int i=1; i<=arr.length; i++) {
			int a = arr[i - 1] - '0';
			
			
			if (a >= 1 && a <= 9) {
				dp[i] += dp[i-1];
				dp[i] %= 1000000;
			}
			
			if(i == 1) continue;
			
			int b = arr[i - 2] - '0';
			
			if(b == 0) continue;
			
			int value = b*10 + a;
			
			if(value >= 10 && value <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= 1000000;
			}
		}
		
		System.out.println(dp[arr.length]);
		
	}
}
