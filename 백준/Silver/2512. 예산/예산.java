import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int end = -1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        long M = Long.parseLong(br.readLine());

        int answer = -1;
        int start = 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            int total = 0;
            for(int cost : arr) {
                if(cost <= mid) {
                    total += cost;
                } else {
                    total += mid;
                }
            }

            if(total > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        System.out.println(answer);
    }

}
