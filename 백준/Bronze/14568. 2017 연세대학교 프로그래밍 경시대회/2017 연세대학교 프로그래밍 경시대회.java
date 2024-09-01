import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int young = 1; young < N - 2; young++) {
            for(int nam = young + 2; nam < N; nam++) {
                int taek = N - young - nam;
//                System.out.println("young: " + young + ", nam: " + nam + ", taek: " + taek);
                if(taek <= 0) continue;
                if(taek % 2 == 1) continue;

                answer++;
            }
        }

        System.out.println(answer);
    }

}
