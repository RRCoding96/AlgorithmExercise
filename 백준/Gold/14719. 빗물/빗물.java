import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] map = new int[W];
        for(int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i < W; ) {
            int j = i + 1;
            int maxPosition = j;

            while (j < W && map[i] > map[j]) {
                if(map[maxPosition] < map[j++]) {
                    maxPosition = j - 1;
                }
            }

            if(j >= W) {
//                result += map[i];
                if(maxPosition < W) {
                    int t = map[maxPosition] * (maxPosition - i - 1);
                    for(int s = i + 1; s < maxPosition; s++) {
                        t -= map[s];
                    }

                    result += t;
                }
                i = maxPosition;
            } else {
                int t = map[i] * (j - 1 - i);
                for(int s = i + 1; s < j; s++) {
                    t -= map[s];
                }

                result += t;
                i = j;
            }

        }

        System.out.println(result);
    }
}
