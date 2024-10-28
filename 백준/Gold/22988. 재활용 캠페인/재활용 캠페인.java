import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(arr);

        long answer = 0;
        int s = 0;
        int e = 0;
        for(int i = N - 1; i >= 0; i--) {
            // 큰 것부터 세면서 X 크기인 것 체크
            if(arr[i] >= X) {
                answer++;
                N--; // X 크기인 것은 뺌
            } else {
                e = i;
                break;
            }
        }

        while (true) {
            // 투 포인터 종료 조건
            if(s >= e) {
                break;
            }
            // 가장 작은거(s) + 가장 큰거(e) 합친 값이 (X / 2) 보다 크면
            // -> 이거 2개 가져가면 X크기는 확보 가능
            if(arr[s] + arr[e] >= (double)X / 2.0) {
                answer++;
                N -= 2; // 2개 줄였음
                s++; // 가장 작은거 +1
                e--; // 가장 큰거 +1
                continue; // 다음으로 넘어감
            }
            // 가장 작은거(s) + 가장 큰거(e) 합친 값이 X보다 작으면
            // -> 가장 작은거 +1 하고 넘어감
            // -> 다음 번에 가장 큰거(e)와 합쳐서 체크해보기 위해
            // -> 계속 넘어가다가 s >= e 되면 마지막에 3으로 나누도록
            if(arr[s] + arr[e] < X) {
                s++;
            }
        }

        answer += N / 3;
        System.out.println(answer);
    }

}
