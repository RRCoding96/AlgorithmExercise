import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new int[]{i, now});
            } else {
                while (true) {
                    if(stack.isEmpty()) {
                        sb.append(0).append(" ");
                        stack.push(new int[]{i, now});
                        break;
                    }

                    int[] top = stack.peek();
                    if(top[1] > now) {
                        sb.append(top[0]).append(" ");
                        stack.push(new int[]{i, now});
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }

}
