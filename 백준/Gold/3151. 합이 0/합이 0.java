import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;

        for (int i = 0; i < N; i++) {
            // 양수 부터는 break -> 0 이 될 수 없음 (정렬 된채로 탐색하기 때문에 지금 양수가 들어오면 앞으로의 숫자로는 0 못 만든다는 뜻)
            if (arr[i] > 0) break;

            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int total = arr[i] + arr[start] + arr[end];
                int s = 1; // arr[start]와 중복 되는 값이 몇 개인가? -> 조합 구하려고
                int e = 1; // arr[end]와 중복 되는 값이 몇 개인가? -> 조합 구하려고
                if (total == 0) { // 조건을 만족할 때
                    /* 고려해야할 사항 두가지
                     * #1. start ~ end까지 같은 수가 나열 (-4 2 2 2 2)
                     * #2. 각각 start와 end에서 같은 수가 나열 ( -5 -3 -3 0 8 8 )
                     */

                    // #1
                    if (arr[start] == arr[end]) {
                        // 몇개가 중복 됐는지 구하고
                        long n = end - start + 1;
                        // n개중에서 2개를 고르는 경우의 수가 필요
                        // nC2 = n*(n-1)/2
                        answer += n * (n - 1) / 2;
                        break;
                    }

                    // #2.1 start 값이 몇개 중복 됐는지 계산
                    // 그러려먼 start 뒤부터 세주면 됨.
                    while (start + 1 < end && arr[start] == arr[start + 1]) {
                        s++; // 조합 구할 때 사용
                        start++; // 인덱스
                    }

                    // #2.2 end 값이 몇개 중복 됐는지 계산
                    while (end - 1 > start && arr[end] == arr[end - 1]) {
                        e++; // 조합 구할 때 사용
                        end--; // 인덱스
                    }
                    answer += (long) e * s; // 이동 다 했으니까 중복 경우의 수를 계산해서 넣어준다.
                }

                if (total > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        System.out.println(answer);
    }

}
