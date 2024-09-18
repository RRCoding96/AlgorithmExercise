import java.io.*;
import java.util.*;

public class Main {

    private static int result;
    private static boolean[] isChecked;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 신맛 / 쓴맛
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            arr[i][0] = sour;
            arr[i][1] = bitter;
        }

        result = Integer.MAX_VALUE;
        isChecked = new boolean[N];

        bt(0, N, 1, 0);

        System.out.println(result);
    }

    private static void bt(int depth, int limit, int sour, int bitter) {
        if(depth == limit) {
            result = Math.min(result, Math.abs(sour - bitter));
            return;
        }

        for(int i = 0; i < limit; i++) {
            if(isChecked[i]) continue;

            isChecked[i] = true;
            int newSour = sour * arr[i][0];
            int newBitter = bitter + arr[i][1];

            result = Math.min(result, Math.abs(newSour - newBitter));
            bt(depth + 1, limit, newSour, newBitter);

            isChecked[i] = false;
        }
    }

}
