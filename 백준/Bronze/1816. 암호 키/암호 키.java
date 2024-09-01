import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            if(check(Long.parseLong(br.readLine()))) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean check(long value) {
        boolean result = true;
        for(long i = 2; i < 1_000_000; i++) {
            long mod = value % i;
            if(mod == 0L) {
                return true;
            }
        }
        return false;
    }

}
