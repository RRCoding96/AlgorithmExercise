import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int mod = 1_000_000;

        int n = Integer.parseInt(br.readLine());

        long sum = 0L;
        for(int i = 2; i < n; i++) {
            sum += (long) ((n / i) - 1) * i;
        }

        System.out.println(sum % mod);
    }
}
