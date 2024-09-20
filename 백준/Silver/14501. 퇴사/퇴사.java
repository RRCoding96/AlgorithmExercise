import java.io.*;
import java.util.*;

public class Main {

    private static int maxPay;
    private static int[][] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        inputs = new int[N + 1][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            inputs[i][0] = t;
            inputs[i][1] = p;
        }

        maxPay = Integer.MIN_VALUE;
        // 0일 부터 시작
        bt(N, 0, 0);

        System.out.println(maxPay);
    }

    private static void bt(int limit, int day, int pay) {
        // 날짜 넘어가면 종료
        if(day >= limit) {
            maxPay = Math.max(maxPay, pay);
            return;
        }

        // 상담 끝낼 수 있음 -> 돈 더해줌
        if(day + inputs[day][0] <= limit) {
            bt(limit, day + inputs[day][0], pay + inputs[day][1]);
        } 
        // 상담 끝낼 수 없음 -> 돈 못 범, 넘어가서 종료 조건에 걸림
        else {
            bt(limit, day + inputs[day][0], pay);
        }
        
        // 상담 안하고 하루씩 넘어가는 경우
        bt(limit, day + 1, pay);
    }

}
