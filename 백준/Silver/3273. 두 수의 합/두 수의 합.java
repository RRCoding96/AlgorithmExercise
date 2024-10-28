import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;

        int s = 0;
        int e = N - 1;
        while(s < e) {
            int sum = arr[s] + arr[e];

            if(sum == target) {
                answer++;
            }

            if(sum < target) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(answer);
    }

}
