import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = h;
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int area = 0;
        for (int i = 0; i < N; ) {
            int j = i + 1;
            int max = j;
            while (j < N && arr[i][1] > arr[j][1]) {
                if (arr[max][1] < arr[j++][1]) max = j - 1;
            }

            if (j >= N) {
                area += arr[i][1];
                if (max < N) area += arr[max][1] * (arr[max][0] - arr[i][0] - 1);
                i = max;
            } else {
                area += arr[i][1] * (arr[j][0] - arr[i][0]);
                i = j;
            }

        }
        System.out.println(area);

    }
}
