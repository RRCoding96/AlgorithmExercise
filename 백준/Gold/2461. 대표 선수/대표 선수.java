import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Data> orderPq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        PriorityQueue<Data> reverseOrderPq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        for(int i = 0; i < N; i++) {
            Arrays.sort(arr[i]);
            orderPq.add(new Data(i, 0, arr[i][0]));
            reverseOrderPq.add(new Data(i, 0, arr[i][0]));
        }

        int[] index = new int[N];

        int answer = Integer.MAX_VALUE;
        while (true) {
            Data minData = orderPq.poll();
            Data maxData = reverseOrderPq.peek();

            int diff = maxData.value - minData.value;
            answer = Math.min(answer, diff);

            if(minData.index + 1 >= M) break;

            orderPq.add(new Data(minData.part, minData.index + 1, arr[minData.part][minData.index + 1]));
            reverseOrderPq.add(new Data(minData.part, minData.index + 1, arr[minData.part][minData.index + 1]));
        }

        System.out.println(answer);

    }

    static class Data {
        int part;
        int index;
        int value;

        public Data(int part, int index, int value) {
            this.part = part;
            this.index = index;
            this.value = value;
        }

    }

}
