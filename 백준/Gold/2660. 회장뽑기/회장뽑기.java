import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while(true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(a == -1 && b == -1) break;

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] depthCheck = new int[N + 1];
        int minDepth = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int depth = findByBFS(i);
            if(minDepth > depth) {
                minDepth = depth;
            }
            depthCheck[i] = depth;
        }

        List<Integer> candidate = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(depthCheck[i] == minDepth) {
                candidate.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minDepth).append(" ").append(candidate.size()).append("\n");
        for(int c : candidate) {
            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }

    static int findByBFS(int num) {
        boolean[] isVisited = new boolean[N + 1];
        Queue<int[]> que = new LinkedList<>();
        int maxDepth = 0;

        que.add(new int[]{num, 0});
        isVisited[num] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nowNum = now[0];
            int nowDepth = now[1];

            maxDepth = Math.max(maxDepth, nowDepth);

            for(int next : graph[nowNum]) {
                if(isVisited[next]) continue;

                que.add(new int[]{next, nowDepth + 1});
                isVisited[next] = true;
            }
        }

        return maxDepth;
    }

}
