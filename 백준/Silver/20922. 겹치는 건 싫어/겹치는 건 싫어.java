import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int maxLength = 1;

        int start = 0;
        int end = 0;
        while (end < N) {

            while (end < N && count[arr[end]] + 1 <= K) {
                count[arr[end]]++;
                end++;
            }

            int len = end - start;
            maxLength = Math.max(maxLength, len);

            count[arr[start]]--;
            start++;
        }

        System.out.println(maxLength);
    }

}
