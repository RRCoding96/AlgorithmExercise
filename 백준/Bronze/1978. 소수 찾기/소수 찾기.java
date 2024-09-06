import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isNotPrime = new boolean[1001];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(1000); i++) {
            if(!isNotPrime[i]) {
                for(int j = i * i; j <= 1000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int answer = 0;
        for(int n : arr) {
            if(!isNotPrime[n]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
