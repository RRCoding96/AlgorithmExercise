import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int t = 0; t < k; t++) {
                st = new StringTokenizer(br.readLine(), " ");

                String order = st.nextToken();

                if("I".equals(order)) {
                    int value = Integer.parseInt(st.nextToken());
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if("D".equals(order)) {
                    if(map.isEmpty()) continue;

                    int type = Integer.parseInt(st.nextToken());

                    int num = 0;
                    if(type == -1) {
                        num = map.firstKey();
                    } else if(type == 1) {
                        num = map.lastKey();
                    }

                    // 이전 num 값의 갯수 == 1
                    // -> 1을 감소 시키기 전의 값
                    // -> 1을 감소시키기 전의 값이 1이라면, 1 감소 시키면 0이 되어서 삭제하는 것임
                    if(map.put(num, map.get(num) - 1) == 1) {
                        map.remove(num);
                    }
                }

            }

            if(map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }

        }

        System.out.println(sb);

    }


}
