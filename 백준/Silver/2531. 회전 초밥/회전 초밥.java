import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        int[] eated = new int[d + 1];

        // 스시 종류 번호 배열에 넣기
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.valueOf(br.readLine());
        }

        // 처음 0번부터 k 개수 만큼 먹었을 때의 초기화
        int count = 0; // 현재 먹은 초밥 종류 수
        for(int i = 0; i < k; i++) {
            // 이 초밥을 처음 먹으면(한 번도 안 먹었으면)
            if(eated[sushi[i]] == 0) {
                count++;
            }
            eated[sushi[i]]++; // 이 초밥 먹은 수 + 1
        }

        int maxLen = count;
        // 1번부터 n-1번까지 start만 이동시키면 k는 고정이기 때문에 end를 활용할 필요가 없다.
        for(int i = 1; i < N; i++) {
            // i : start
            // 지금 먹은 초밥 종류 수가 최대 이상이면 -> 쿠폰 써도 되는 상황
            if(maxLen <= count) {
                if(eated[c] == 0) { // 아직 쿠폰초밥을 안먹은 상태
                    maxLen = count + 1;
                }
                else { // 아직 쿠폰초밥을 먹은 상태
                    maxLen = count;
                }
            }

            // end 이동
            int end = (i + k - 1) % N;
            // 새로운 초밥 먹었으면
            if(eated[sushi[end]] == 0) {
                count++;
            }
            eated[sushi[end]]++;

            // start 이동
            eated[sushi[i - 1]]--;	// start점 한 칸 이동했으니 이전의 초밥 제거
            if(eated[sushi[i - 1]] == 0) {
                count--;
            }

            // 최대값 갱신
            if (eated[c] == 0) { // 쿠폰 초밥을 안 먹은 상태라면 추가
                maxLen = Math.max(maxLen, count + 1);
            } else { // 쿠폰 초밥을 이미 먹은 상태
                maxLen = Math.max(maxLen, count);
            }
        }

        System.out.println(maxLen);
    }

}
