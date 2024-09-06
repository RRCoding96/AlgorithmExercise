import java.util.*;
import java.io.*;

public class Main {
	static int measure(int number) {
		int i;
		for(i=2; i<number; i++) {
			if(number % i == 0) {
				break;
			}
		}
		return i;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		while(n>1) {
			int ans = measure(n);
			n = n / ans;
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	
	}	
}