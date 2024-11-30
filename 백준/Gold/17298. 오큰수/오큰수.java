import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>(); // 인덱스가 들어감
        deque.addLast(0); // 0번째 부터 시작
        for(int i = 1; i < N; i++) {
            // 상단의 값이 현재의 값보다 작으면
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                // 상단 위치의 오큰수는 현재의 값
                answer[deque.pollLast()] = arr[i];
            }
            // 현재 위치 넣음
            deque.addLast(i);
        }

        // 남은 것들은 오큰수 없음
        while (!deque.isEmpty()) {
            answer[deque.pollLast()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : answer) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }

}
