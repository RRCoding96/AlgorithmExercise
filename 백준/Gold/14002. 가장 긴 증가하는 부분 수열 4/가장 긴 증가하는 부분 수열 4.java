import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answerCnt = -1;
        int answerLastPos = -1;

        Node[] nodes = new Node[N + 1];
        for(int i = 0; i <= N; i++) {
            nodes[i] = new Node(-1, 0);
        }
        nodes[0] = new Node(-1, 0);
        for(int i = 1; i <= N; i++) {
            int now = arr[i];
            int next = nodes[i].before;
            for(int j = i - 1; j >= 0; j--) {
                int temp = arr[j];
                int mCnt = nodes[i].cnt;

                if(temp < now) {
//                    mCnt = Math.max(nodes[i].cnt, nodes[j].cnt + 1);
                    if(mCnt < nodes[j].cnt + 1) {
                        mCnt = nodes[j].cnt + 1;
                        next = j;
                    }
                }
                nodes[i] = new Node(next, mCnt);

                if(nodes[i].cnt >= answerCnt) {
                    answerCnt = nodes[i].cnt;
                    answerLastPos = i;
                }
            }
        }

//        for(int i = 1; i <= N; i++) {
//            System.out.print(nodes[i].cnt + " ");
//        }
//        System.out.println();
//        for(int i = 1; i <= N; i++) {
//            System.out.print(nodes[i].before + " ");
//        }
//        System.out.println();
//        System.out.println(answerCnt);
//        System.out.println(answerLastPos);

        StringBuilder sb = new StringBuilder();
        int nextPos = answerLastPos;
        while (nextPos > 0) {
            sb.insert(0, arr[nextPos] + " ");
            nextPos = nodes[nextPos].before;
        }

        System.out.println(answerCnt);
        System.out.println(sb);

    }

    static class Node {
        int before;
        int cnt;

        public Node(int before, int cnt) {
            this.before = before;
            this.cnt = cnt;
        }
    }


}
