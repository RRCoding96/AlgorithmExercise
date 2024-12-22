import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 휴게소 개수
        int M = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소 수
        int L = Integer.parseInt(st.nextToken()); // 고속도로 길이

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N + 2];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N + 1] = L;

        Arrays.sort(arr);

        int start = 1;
        int end = L - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for(int i = 1; i < arr.length; i++) {
                sum += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if(sum > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

}
