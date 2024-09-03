import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] locations = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            locations[i][0] = a;
            locations[i][1] = b;
        }

        int[] answer = new int[N]; // 모일 체커 수 별로 값을 저장할 배열
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.MAX_VALUE;
        }

        for (int[] xLocation : locations) { // x 좌표 후보
            for (int[] yLocation : locations) { // y좌표 후보
                int[] costs = new int[N]; // x,y 좌표와 입력받은 좌표의 거리를 비교한 값을 costs 에 입력
                for (int i = 0; i < N; i++) {
                    costs[i] = Math.abs(xLocation[0] - locations[i][0]) + Math.abs(yLocation[1] - locations[i][1]);
                }

                Arrays.sort(costs); // 오름차순으로 정렬
                int cost = 0;
                for (int i = 0; i < N; i++) {
                    cost += costs[i]; // cost에 순차적으로 더하면서
                    answer[i] = Math.min(cost, answer[i]); // 해당 인덱스의 값(answer[i])와 현재 좌표의 거리(cost)와 비교하여 작은 값을 저장
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(i == N - 1) {
                sb.append(answer[i]);
            } else {
                sb.append(answer[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
