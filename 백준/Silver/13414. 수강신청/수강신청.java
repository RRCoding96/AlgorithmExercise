import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++) {
            String key = br.readLine();

            if(set.contains(key)) {
                set.remove(key);
            }
            set.add(key);
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(String value : set) {
            if(index >= K) break;

            sb.append(value).append("\n");
            index++;
        }

        System.out.println(sb);

    }

}
