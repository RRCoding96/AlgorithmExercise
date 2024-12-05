import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[N + 1];
        for(int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = (long)(arr[i - 1] + now);
        }

        int answer = 0;

        int start = 0;
        int end = 1;
        while (start <= end) {
            if(end > N) break;
            long value = arr[end] - arr[start];

            if(value < M) {
                end++;
            } else if(value > M) {
                start++;
            } else {
                start++;
                answer++;
            }

        }

        System.out.println(answer);
    }

}
