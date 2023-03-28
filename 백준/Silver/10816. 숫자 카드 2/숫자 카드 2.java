import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드 개수

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine()); // 구해야 되는 수

        int[] targets = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
            int result = findByBinarySearch(cards, 0, N - 1, targets[i]);
            sb.append(result).append(" ");
        }

        System.out.println(sb);

    }

    static int findByBinarySearch(int[] arr, int start, int end, int target) {

        int s = start;
        int e = end + 1;

        // 최저 인덱스 찾기
        while(s < e) {
            int mid = (s + e) / 2;

            if(target <= arr[mid]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        int minIdx = s;

        // 최고 인덱스 찾기
        s = start;
        e = end + 1;

        while(s < e) {
            int mid = (s + e) / 2;
            if(arr[mid] > target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        int maxIdx = s;

        return maxIdx - minIdx;
    }
}