import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        Set<String> set = new HashSet<>();
        for(int len = 1; len <= input.length(); len++) {
            for(int s = 0; s < input.length(); s++) {
                int e = s + len;
                if(e > input.length()) break;

                String token = input.substring(s, e);
                set.add(token);
            }
        }

        System.out.println(set.size());
    }

}
