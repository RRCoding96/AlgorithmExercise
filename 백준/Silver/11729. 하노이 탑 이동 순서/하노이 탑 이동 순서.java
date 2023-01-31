import java.io.*;


public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int n, int start, int mid, int to) {
		/*
		 * n: 원판 개수
		 * start: 출발지
		 * mid: 옮기기 위해 이동해야 할 장소
		 * to: 목적지
		 */
		
		// 원판 1개
		if(n == 1) {
			sb.append(start +" "+ to + "\n");
			return;
		}
		// A -> C로 옮김
		//1. n-1개를 a에서 b로 이동
		hanoi(n-1, start, to, mid);
		//2. 1개를 a에서 c로 이동
		sb.append(start+" "+to+"\n");
		//3. n-1개를 b에서 c로 이동
		hanoi(n-1, mid, start, to);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int)(Math.pow(2, n) - 1)).append('\n');
		
		hanoi(n, 1, 2, 3);
		System.out.println(sb);
		
	}
 
}