import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            int nowHeight = Integer.parseInt(br.readLine());

            while (!deque.isEmpty()) {
                // 지금 빌딩이 더 높다 -> 제거
                if (deque.peekLast() <= nowHeight) {
                    deque.pollLast();
                }
                // 지금 빌딩이 더 낮다 -> 자기 정원 관찰 당하기 가능
                // -> break 한 후 밑에서 현재 덱 사이즈 더해줌
                else {
                    break;
                }
            }

            result += deque.size();
            deque.addLast(nowHeight);
        }

        System.out.println(result);
    }

}
