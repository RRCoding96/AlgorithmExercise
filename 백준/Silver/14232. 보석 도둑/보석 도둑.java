import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long k = Long.parseLong(br.readLine());

        int count = 0;
        long weight = k;
        long mod = 2;
        while (weight != 1) {
            if(mod >= Math.sqrt(k)) {
                sb.append(weight);
                count++;
                break;
            }

            if(weight % mod == 0) {
                sb.append(mod).append(" ");
                count++;
                weight /= mod;
            } else {
                mod++;
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }
}
