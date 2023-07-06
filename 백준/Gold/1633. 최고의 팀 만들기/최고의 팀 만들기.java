
import java.util.*;
import java.io.*;

public class Main {
	
	static int[] white;
	static int[] black;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		white = new int[1001];
		black = new int[1001];
		dp = new int[1001][16][16];
		
		int idx = 0;
		String input = null;
		while(true) {
			input = br.readLine();
			if(input == null || input.equals("")) {
				break;
			}
//			int w = sc.nextInt();
//			int b = sc.nextInt();
			
			String[] temp = input.split(" ");
			int w = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			white[idx] = w;
			black[idx] = b;
			idx++;
//			System.out.println(idx);
		}
		
//		System.out.println(Arrays.toString(white));
//		System.out.println(Arrays.toString(black));
		
		int result = bt(0, 0, 0, idx);
		
		System.out.println(result);
	}
	
	static int bt(int depth, int whiteIdx, int blackIdx, int size) {
		// 팀 다 뽑음
		if(whiteIdx == 15 && blackIdx == 15) {
			return 0;
		}
		// 모든 선수 다 훑어봄
        if(depth == size) {
        	return 0;
        }
        
        // 최대 경우 찾앗음
        if(dp[depth][whiteIdx][blackIdx] != 0) {
        	return dp[depth][whiteIdx][blackIdx];
        }
        
        // 지금 선수는 팀에 안넣음
        int total = bt(depth + 1, whiteIdx, blackIdx, size);
        
        // 지금 선수를 흰팀에 넣음
        if(whiteIdx < 15) {
        	int whiteNxt = bt(depth + 1, whiteIdx + 1, blackIdx, size) + white[depth];
        	total = Math.max(total, whiteNxt);
        }
        
        // 지금 선수를 검정팀에 넣음
        if(blackIdx < 15) {
        	int blackNxt = bt(depth + 1, whiteIdx, blackIdx + 1, size) + black[depth];
        	total = Math.max(total, blackNxt);
        }

        dp[depth][whiteIdx][blackIdx] = total;
        
        return dp[depth][whiteIdx][blackIdx];
	}

}
