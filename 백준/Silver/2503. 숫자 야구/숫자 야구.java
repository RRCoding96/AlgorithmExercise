import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<Character> set;

        List<String> list = new ArrayList<>();
        for(int i = 123; i <= 987; i++) {
            String str = String.valueOf(i);
            if(str.contains("0")) continue;

            set = new HashSet<>();
            for(int j = 0; j < 3; j++) {
                set.add(str.charAt(j));
            }
            if(set.size() != 3) continue;

            list.add(String.valueOf(i));
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String number = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            int sCnt = 0;
            int bCnt = 0;
            List<String> listA = new ArrayList<>();
            for(String value : list) {
                for(int v = 0; v < 3; v++) {
                    for(int s = 0; s < 3; s++) {
                        if(number.charAt(v) == value.charAt(s)) {
                            if(v == s) {
                                sCnt++;
                            } else {
                                bCnt++;
                            }
                        }
                    }
                }

                if(sCnt == strike && bCnt == ball) {
                    listA.add(value);
                }

                sCnt = 0;
                bCnt = 0;
            }

            list = listA;

//            System.out.println(list);
        }

        System.out.println(list.size());
    }
}
