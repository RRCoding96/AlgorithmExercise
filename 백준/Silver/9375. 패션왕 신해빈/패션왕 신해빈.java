import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, List<String>> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                String value = st.nextToken();
                String key = st.nextToken();

                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(value);
            }

            int result = 1;
            for(Map.Entry<String, List<String>> entry : map.entrySet()) {
                int valueSize = entry.getValue().size();
                result *= (valueSize + 1);
            }

            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);

    }

}
