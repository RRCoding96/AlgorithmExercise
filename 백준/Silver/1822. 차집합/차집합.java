import java.io.*;
import java.util.*;

public class Main {

    static int nA, nB;
    static int[] arrA, arrB;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        arrA = new int[nA];
        arrB = new int[nB];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < nA; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < nB; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);

        result = new ArrayList<>();
        for(int a : arrA) {
            if(!search(a)) {
                result.add(a);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(int v : result) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);
    }

    static boolean search(int a) {
        int sIdx = 0;
        int eIdx = nB - 1;

        while(sIdx <= eIdx) {
            int mIdx = (sIdx + eIdx) / 2;
            int mValue = arrB[mIdx];
            if(a < mValue) {
                eIdx = mIdx - 1;
            } else if(a > mValue) {
                sIdx = mIdx + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
