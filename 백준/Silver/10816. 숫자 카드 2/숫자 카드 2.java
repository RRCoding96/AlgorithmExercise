import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] hands = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            hands[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for(int i = 0; i < hands.length; i++) {
            int result = findCount(cards, hands[i]);
            sb.append(result).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int findCount(int[] cards, int target) {
        int s = 0;
        int e = cards.length;

        // 최소
        while (s < e) {
            int mid = (s + e) / 2;
            if(target <= cards[mid]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        int minIndex = s;
        // 최대
        s = 0;
        e = cards.length;
        while (s < e) {
            int mid = (s + e) / 2;
            if(target < cards[mid]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        int maxIndex = s;


        return maxIndex - minIndex;
    }

}
