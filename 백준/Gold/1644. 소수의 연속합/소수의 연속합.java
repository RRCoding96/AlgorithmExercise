import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(!isNotPrime[i]) {
                for(int j = i + i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int index = 1;
        int[] sumArr = new int[N];
        for(int i = 2; i <= N; i++) {
            if(!isNotPrime[i]) {
                if(index == 1) {
                    sumArr[1] = i;
                } else {
                    sumArr[index] = sumArr[index - 1] + i;
                }
                index++;
            }
        }

        int answer = 0;

        int start = 0;
        int end = 0;
        while (start <= end) {
            if(end >= index) break;

            int num = sumArr[end] - sumArr[start];
            if(num > N) {
                start++;
            } else if(num < N) {
                end++;
            } else {
                answer++;
                end++;
            }
        }

        System.out.println(answer);
    }

}
