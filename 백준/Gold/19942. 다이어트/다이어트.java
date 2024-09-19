import java.io.*;
import java.util.*;

public class Main {

    private static int[][] inputs;
    private static int mp;
    private static int mf;
    private static int ms;
    private static int mv;
    private static List<Data> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        inputs = new int[N][5];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            inputs[i][0] = p;
            inputs[i][1] = f;
            inputs[i][2] = s;
            inputs[i][3] = v;
            inputs[i][4] = c;
        }

        list = new ArrayList<>();
        bt(0, 0, N, 0, 0, 0, 0, 0, new ArrayList<>());

        list.sort((d1, d2) -> d1.cost - d2.cost);

        if(list.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            Data data = list.get(0);

            sb.append(data.cost).append("\n");
            for(int h : data.history) {
                sb.append(h).append(" ");
            }
            System.out.println(sb.toString());
        }

    }

    private static void bt(int depth, int start, int limit, int p, int f, int s, int v, int c, List<Integer> history) {
        if(depth == limit) {
            if(p >= mp && f >= mf && s >= ms && v >= mv) {
                Data data = new Data(c, history);
                list.add(data);
            }
            return;
        }

        if(p >= mp && f >= mf && s >= ms && v >= mv) {
            Data data = new Data(c, history);
            list.add(data);
            return;
        }

        for(int i = start; i < limit; i++) {
            int[] input = inputs[i];

            List<Integer> newHistory = new ArrayList<>(history);
            newHistory.add(i + 1);

            bt(depth + 1, i + 1, limit, p + input[0], f + input[1], s + input[2], v + input[3], c + input[4], newHistory);

        }
    }

    public static class Data {
        public int cost;
        public List<Integer> history;

        public Data(int cost, List<Integer> history) {
            this.cost = cost;
            this.history = history;
        }
    }
}
