import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long[] sum = new long[N * (N + 1) / 2];
        int index = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                sum[index++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sum);

        long max = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                long target = arr[i] - arr[j]; // arr[i] == k

                int start = 0;
                int end = sum.length - 1;
                while (start < end) {
                    int mid = (start + end) / 2;

                    if(sum[mid] > target) {
                        end = mid - 1;
                    } else if(sum[mid] < target) {
                        start = mid + 1;
                    } else {
                        max = Math.max(max, arr[i]);
                        break;
                    }
                }
            }
        }

        System.out.println(max);

    }

}
