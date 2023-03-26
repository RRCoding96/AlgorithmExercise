
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String order = br.readLine();
            if(isNumber(order)) {
                sb.append(numToName.get(Integer.parseInt(order)));
            } else {
                sb.append(nameToNum.get(order));
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static boolean isNumber(String str) {
        try {
            int num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
