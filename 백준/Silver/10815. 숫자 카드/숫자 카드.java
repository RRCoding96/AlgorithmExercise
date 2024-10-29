import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] hands = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            hands[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hands);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int result = binarySearch(N, hands, target);
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int N, int[] arr, int target) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int value = arr[mid];
            if(value == target) {
                return 1;
            } else if(value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }

}
