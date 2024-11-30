import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<int[]> deque = new ArrayDeque<>(); // [키, 카운트]
        long answer = 0;
        for(int i = 0; i < N; i++) {
            // 덱에 사람이 있고 && 가장 가까운 키가 현재 키보다 작으면
            // 그 작은 키는 버리고, 그 때의 카운트를 더해줌
            while (!deque.isEmpty() && deque.peekLast()[0] < arr[i]) {
                answer += deque.pollLast()[1];
            }

            // 여기 아래부터는 현재 키보다 크거나 같은 경우만 있음

            // 덱이 비어있으면 현재 키를 넣어줌(매칭할 게 없기 때문)
            if(deque.isEmpty()) {
                deque.addLast(new int[]{arr[i], 1});
            } else {
                // 덱에 키가 있을 때

                // 가장 가까운 키가 현재 키보다 크면
                // 매칭 수 + 1 (바로 마주볼 수 있기 때문)
                // 덱에 현재 키 넣어줌 (뒤에 올 키가 나도 볼 수 있고 바로 앞의 큰 키도 볼 수 있기 때문)
                if(deque.peekLast()[0] > arr[i]) {
                    deque.addLast(new int[]{arr[i], 1});
                    answer++;
                } else if(deque.peekLast()[0] == arr[i]) {
                    // 가장 가까운 키 == 현재 키
                    // 가장 가까운 키의 카운트 값을 더해주고, 1 증가시킴
                    answer += deque.peekLast()[1]++;
                    // 덱의 크기가 2 이상이면, 매칭 수 + 1
                    if(deque.size() > 1) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}
