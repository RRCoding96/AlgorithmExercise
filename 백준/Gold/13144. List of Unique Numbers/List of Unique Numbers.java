import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];

        int start = 0;
        long count = 0;

        for (int end = 0; end < N; end++) {
            // 중복이 있다면 start를 옮겨가며 중복 제거
            while (visited[arr[end]]) {
                visited[arr[start]] = false;
                start++;
            }

            // 현재 수를 포함시킴
            visited[arr[end]] = true;

            // (end - start + 1)만큼 새로운 경우의 수가 추가됨
            count += (end - start + 1);
        }

        System.out.println(count);
    }

}
