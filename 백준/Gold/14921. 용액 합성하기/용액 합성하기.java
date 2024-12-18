import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long minDiff = Long.MAX_VALUE;
        long answer = 0;

        int start = 0;
        int end = N - 1;
        while (start < end) {
            long midValue = arr[start] + arr[end];

            if(minDiff > Math.abs(midValue)) {
                answer = midValue;
                minDiff = Math.abs(midValue);
            }

            if(midValue >= 0) {
                end--;
            } else {
                start++;
            }

        }

        System.out.println(answer);
    }

}
