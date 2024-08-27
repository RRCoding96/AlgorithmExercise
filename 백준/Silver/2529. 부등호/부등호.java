import java.io.*;
import java.util.*;

public class Main {

    private static int k;
    private static boolean[] numberCheck;
    private static int[] holder;
    private static List<Long> list;
    private static List<String> strList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());
        holder = new int[k + 1];
        for(int i = 0; i < k; i++) {
            holder[i] = -1;
        }


        String[] arr = new String[k];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        numberCheck = new boolean[10];
        list = new ArrayList<>();
        strList = new ArrayList<>();

        dfs(0, arr);

        list.sort(Comparator.naturalOrder());
        strList.sort(Comparator.naturalOrder());

        System.out.println(strList.get(strList.size() - 1).toString());
        System.out.println(strList.get(0).toString());
    }

    private static void dfs(int depth, String[] arr) {
        if(depth == k + 1) {
            String str = "";
            for(int i : holder) {
                str += i;
            }

            long num = Long.parseLong(str);
            list.add(num);
            strList.add(str);

            return;
        }

        for(int i = 0; i < 10; i++) {
            if(numberCheck[i]) continue;

            if(depth == 0) {
                holder[depth] = i;
                numberCheck[i] = true;

                dfs(depth + 1, arr);

                holder[depth] = -1;
                numberCheck[i] = false;

                continue;
            }

            // 부등호 체크
            int beforeNumber = holder[depth - 1];
            int nowNumber = i;
            String delim = arr[depth - 1];

            if("<".equals(delim)) {
                if(beforeNumber < nowNumber) {
                    holder[depth] = i;
                    numberCheck[i] = true;

                    dfs(depth + 1, arr);

                    holder[depth] = -1;
                    numberCheck[i] = false;
                } else {
                    continue;
                }
            } else {
                if(beforeNumber < nowNumber) {
                    continue;
                } else {
                    holder[depth] = i;
                    numberCheck[i] = true;

                    dfs(depth + 1, arr);

                    holder[depth] = -1;
                    numberCheck[i] = false;
                }
            }

        }
    }

}
