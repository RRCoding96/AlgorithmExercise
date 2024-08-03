import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] cards;
    static int M;
    static int[] hands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        hands = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            hands[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(cards);
        for(int i = 0; i < M; i++) {
            int now = hands[i];
            if(binarySearch(now)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }

    static boolean binarySearch(int target) {
        int s = 0;
        int e = N - 1;
        
        while(s <= e) {
            int mid = (s + e) / 2;
            int num = cards[mid];
            if(num == target) {
                return true;
            } else if(num < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return false;
    }

}