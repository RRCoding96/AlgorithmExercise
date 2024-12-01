import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            Deque<int[]> deque = new ArrayDeque<>();
            for(int i = 0; i < N; i++) {
                int h = arr[i]; // 현재 높이

                // top에 있는 높이 >= i(지금) 높이 : 현재가 더 작다!!
                // i번째 막대보다 작은 이전 막대들을 pop 하면서 최대 넓이 구함
                while (!deque.isEmpty() && deque.peekLast()[1] >= h) {
                    int[] top = deque.pollLast();
                    int topHeight = top[1]; // 이전 막대의 높이

                    // pop 한 뒤 그 다음이 없다면,
                    // -> 0번째 index부터 (i - 1)번째 인덱스 까지가 유일한 폭이 됨 (폭 == i)
                    // pop 한 뒤 그 다음에 아직 막대가 남아있다면,
                    // 아직 pop한 높이보다 낮은 막대가 더 남았다는 뜻
                    // -> (i - 1)번째 index에서 그 다음 이전 막대의 index를 빼준 것이 폭이 됨
                    long width = deque.isEmpty() ? i : i - 1 - deque.peekLast()[0];
                    long size = width * topHeight;
                    result = Math.max(result, size);
                }

                // 위에 작업이 끝남
                // -> 스택에 저장되어 있는 막대들은 모두 현재(i 번째) 높이보다 작거나 같은 것들
                // -> 현재 값 넣어줌
                deque.addLast(new int[]{i, h});
            }

            // 위의 과정이 끝나고도 아직 스택에 남은 막대들이 있으면,
            while (!deque.isEmpty()) {
                int[] top = deque.pollLast();
                int topHeight = top[1]; // 가장 상단의 높이

                // 만약 pop 하고 난 뒤, 스택이 비어있다면
                // 남아 있는 막대가 없다는 뜻
                // -> 0 ~ (N - 1) 까지인 전체 폭이 width가 됨
                long width = deque.isEmpty() ? N : N - 1 - deque.peekLast()[0];
                long size = width * topHeight;
                result = Math.max(result, size);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}
