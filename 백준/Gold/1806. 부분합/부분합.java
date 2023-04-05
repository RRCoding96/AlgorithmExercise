
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S;
	static int[] arr;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sumArr = new int[N + 1];
		sumArr[1] = arr[1];
		for(int i = 1; i <= N; i++) {
			sumArr[i] = sumArr[i - 1] + arr[i];
		}
		
//		System.out.println(Arrays.toString(sumArr));
		
		answer = Integer.MAX_VALUE;
		
		int s = 0;
		int e = 1;
		while(e <= N && s <= e) {
			int rst = sumArr[e] - sumArr[s];
			int len = e - s;
			
			if(rst >= S) {
				s++;
				answer = Math.min(answer, len);
			} else {
				e++;
			}
		}
		
		if(answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		
		System.out.println(answer);
	}
	

}
