import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Long> pq;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            pq = new PriorityQueue<>();

            while (st.hasMoreTokens()) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            Long answer = (long)0;
            while (pq.size() > 1) {
                Long a = pq.poll();
                Long b = pq.poll();

                answer += (a + b);

                pq.add(a + b);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
