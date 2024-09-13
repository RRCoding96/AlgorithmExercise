import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] bottom = new int[h + 2];
        int[] top = new int[h + 2];
        for (int i = 1; i <= n / 2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = h - Integer.parseInt(br.readLine()) + 1;
            bottom[a]++;
            top[b]++;
        }

        for (int i = 1; i <= h; i++) {
            bottom[i] += bottom[i - 1];
        }
        for (int i = h; i >= 1; i--) {
            top[i] += top[i + 1];
        }

        int min = n;
        int cnt = 0;
        for (int i = 1; i < h + 1; i++) {
            int diff = (bottom[h] - bottom[i - 1]) + (top[1] - top[i + 1]);

            if (diff < min) {
                min = diff;
                cnt = 1;
            } else if (diff == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);

    }
}
