import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        String[] arr = input.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int d = Integer.parseInt(arr[3]);
        int e = Integer.parseInt(arr[4]);
        int f = Integer.parseInt(arr[5]);

        for(int x = -999; x <= 999; x++) {
            boolean isFinished = false;
            for(int y = -999; y <= 999; y++) {
                int i = a * x + b * y;
                int j = d * x + e * y;

                if(i == c && j == f) {
                    System.out.println(x + " " + y);
                    isFinished = true;
                    break;
                }
            }
            if(isFinished) break;
        }

    }

}
