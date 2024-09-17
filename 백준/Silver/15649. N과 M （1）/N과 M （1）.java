import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static boolean[] isChecked;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        isChecked = new boolean[N + 1];
        sb = new StringBuilder();
        list = new ArrayList<>();

        bt(0, M, N);
        System.out.println(sb.toString());
    }

    private static void bt(int depth, int size, int n) {
        if(depth == size) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(isChecked[i]) continue;

            list.add(i);
            isChecked[i] = true;

            bt(depth + 1, size, n);

            list.remove(list.size() - 1);
            isChecked[i] = false;
        }
    }
}
