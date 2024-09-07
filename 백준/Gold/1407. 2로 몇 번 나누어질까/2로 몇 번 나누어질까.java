import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // A ~ B 까지의 결과 구하기
        long result = calculate(B) - calculate(A - 1);
        System.out.println(result);
    }

    private static long calculate(long n) {
        long result = 0;
        long divisor = 1; // 2^0 (처음)
        long befDivisor = 0; // 이전 값

        while (true) {
            long value = n / divisor; // 계속 2의 거듭제곱으로 나눠줌 -> 그 때의 몫 구함
            // 나눠졌으면
            if(value > 0) {
                // 지금 ~ 이전 값 사이의 수 만큼 위에서 구한 몫을 곱해서 계속 더해줌
                result += value * (divisor - befDivisor);
            }
            // 안 나눠지면 종료
            else {
                break;
            }

            befDivisor = divisor;
            divisor *= 2; // 다음을 위해 2 곱해줌
        }

        return result;
    }
}
