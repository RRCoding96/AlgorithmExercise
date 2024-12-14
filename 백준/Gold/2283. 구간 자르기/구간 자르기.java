import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] arr = new int[1000002];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A + 1]++;
            arr[B + 1]--;
        }

        for(int i = 1; i <= 1000000; i++) {
            arr[i] += arr[i - 1];
        }

        StringBuilder answer = new StringBuilder();
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            if(sum > K) {
                start++;
                sum -= arr[start];
            } else if(sum < K) {
                end++;
                sum += arr[end];
            } else {
                answer.append(start).append(" ").append(end);
                System.out.println(answer);
                return;
            }

            if(end == 1000001) break;
        }

        System.out.println("0 0");

    }

}
