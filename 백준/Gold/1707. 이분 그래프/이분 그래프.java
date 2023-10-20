import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] colors;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < N; tc++) {
            String[] ve = br.readLine().split(" ");
            int V = Integer.parseInt(ve[0]);
            int E = Integer.parseInt(ve[1]);

            colors = new int[V + 1];
            graph = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean rst = false;
            // 1. 색칠 되지 않은 모든 정점에 대해서
            for(int vertex = 1; vertex <= V; vertex++) {
                if(colors[vertex] == 0) {
                    rst = isBipartiteGraph(vertex, 1);
                }
                if(!rst) break;
            }
            if(rst) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }


        }
        System.out.println(sb);
    }

    private static boolean isBipartiteGraph(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // 2. 시작 정점 임의의 색상으로 색칠
        colors[start] = color;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph[cur]) {
                // 4. 인접 정점 색이 동일하면 이분 그래프가 아님
                if(colors[cur] == colors[next]) return false;

                // 3. 인접 정점 색칠 안된 경우 현재 정점 반대 색깔로 색칠
                // 색상 배열을 통해 방문 여부 확인 가능
                if(colors[next] == 0) {
                    colors[next] = colors[cur] * -1;
                    queue.add(next);
                }
            }
        }
        return true;
    }


}
