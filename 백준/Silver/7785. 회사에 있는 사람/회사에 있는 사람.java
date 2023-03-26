
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<tc; i++) {
            String[] input = br.readLine().split(" ");
            if(input[1].equals("enter")) {
                set.add(input[0]);
            } else if(input[1].equals("leave")) {
                if(set.contains(input[0])) {
                    set.remove(input[0]);
                }
            }
        }

        List<String> list = new ArrayList<>();
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            list.add(itr.next());
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);

    }

}
