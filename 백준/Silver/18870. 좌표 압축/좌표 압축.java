import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        int[] original = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            original[i] = arr[i];
        }

        Arrays.sort(arr);

        List<Integer> unDupList = new ArrayList<>();
        unDupList.add(arr[0]);
        int topIdx = 0;
        for(int i = 1; i < N; i++) {
            if(unDupList.get(topIdx) != arr[i]) {
                unDupList.add(arr[i]);
                topIdx++;
            }
        }

        int[] unDup = new int[unDupList.size()];
        for(int i = 0; i < unDup.length; i++) {
            unDup[i] = unDupList.get(i);
        }

//        System.out.println(Arrays.toString(unDup));

        for (int i = 0; i < N; i++) {
            int rst = findIndex(unDup, 0, unDup.length - 1, original[i]);
            sb.append(rst).append(" ");
        }

        System.out.println(sb);
    }

    static int findIndex(int[] arr, int start, int end, int target) {
        int result = -1;

        int s = start;
        int e = end;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] < target) {
                s = mid + 1;
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                result = mid;
                break;
            }
        }

        return result;
    }


}