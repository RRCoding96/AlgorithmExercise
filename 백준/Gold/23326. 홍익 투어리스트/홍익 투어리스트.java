import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 구역의 개수
        int Q = Integer.parseInt(st.nextToken()); // 쿼리의 개수
        TreeSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == 1) {
                set.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int pos = 1;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            if (number == 1) {
                int point = Integer.parseInt(st.nextToken());
                if (set.contains(point)) {
                    set.remove(point);
                } else {
                    set.add(point);
                }
            } else if (number == 2) {
                int move = Integer.parseInt(st.nextToken()) % N;
                pos += move;
                if(pos > N){
                    pos %= N;
                }
            } else {
                if (set.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }

                if (set.contains(pos)) {
                    sb.append("0").append("\n");
                    continue;
                }

                Integer front = set.higher(pos);
                Integer back = set.higher(0);

                if (front != null) {
                    sb.append(front - pos).append("\n");
                } else {
                    sb.append(N - pos + back).append("\n");
                }
            }
        }

        System.out.println(sb);

    }


}
