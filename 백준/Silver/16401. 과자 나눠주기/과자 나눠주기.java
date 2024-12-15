import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // 조카의 수
        int N = Integer.parseInt(st.nextToken()); // 과자의 수

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);

        long answer = 0;
        long start = 1;
        long end = snacks[N - 1];
        while (start <= end) {
            long total = 0;
            long mid = (start + end) / 2;

            for(int snack : snacks) {
                total += snack / mid;
            }

            if(total >= M) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);

    }

}
