import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long minDiff = Long.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;

        int start = 0;
        int end = N - 1;
        while (start < end) {
            long sum = arr[start] + arr[end];

            if(minDiff > Math.abs(sum)) {
                minDiff = Math.abs(sum);
                minStart = start;
                minEnd = end;
            }

            if(sum >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(arr[minStart] + " " + arr[minEnd]);
    }

}
