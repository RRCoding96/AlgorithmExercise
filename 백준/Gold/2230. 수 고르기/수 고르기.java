
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			int target = arr[i] + M;
			if(target > arr[N - 1]) break;
			
			binarySearch(i, target);
			
			if(answer == M) {
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	static void binarySearch(int start, int target) {
		int s = start;
		int e = N;
		
		while(s < e) {
			int mid = (s + e) / 2;
			
			if(arr[mid] - arr[start] < M) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		
		if(e == N) {
			return;
		}
		
		answer = Math.min(answer, arr[e] - arr[start]);
		
	}

}
