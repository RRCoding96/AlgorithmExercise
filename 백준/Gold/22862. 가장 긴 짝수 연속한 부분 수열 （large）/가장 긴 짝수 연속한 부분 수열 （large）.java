import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isEven = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            isEven[i] = num % 2 == 0;
        }

        int maxLen = 0;
        int oddCount = 0;

        int start = 0;
        int end = 0;
        // end는 최대한 움직여야됨
        while (end < N) { // 끝까지 가면 종료
            // 홀수 제거할 수 있을 때 -> end 이동 가능
            if (oddCount < K) {
                // end가 홀수일 때 -> 홀수 카운트 +1
                if (!isEven[end]) {
                    oddCount++;
                }
                end++;
                maxLen = Math.max(end - start - oddCount, maxLen);
            }
            // 제거할 수 있는 홀수 없음 && end가 짝수 -> end 움직일 수 있음
            else if (isEven[end]) {
                end++; // 짝수라서 end를 그냥 증가 가능
                maxLen = Math.max(end - start - oddCount, maxLen);
            }
            // 제거할 수 있는 홀수 없음 && end가 홀수 -> end는 못 움직임
            else {
                // start 한칸 이동 -> 지금 홀수였다면, 홀수 카운트 -1
                if (!isEven[start]) {
                    oddCount--;
                }
                start++;
            }
        }

        System.out.println(maxLen);


    }

}
