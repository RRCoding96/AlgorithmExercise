
import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] graph;
    static boolean[] isVisited;
    static int vertexCnt, edgeCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseNum = 0;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            caseNum++;
            isVisited = new boolean[n + 1];
            int treeCnt = 0;
            for (int i = 1; i <= n; i++) {
                if(isVisited[i]) continue;

                vertexCnt = 0;
                edgeCnt = 0;
                dfs(i);

                if(edgeCnt == (vertexCnt- 1) * 2) {
                    treeCnt++;
                }

            }

            if (treeCnt == 0) {
                System.out.printf("Case %d: No trees.\n", caseNum);
            } else if (treeCnt == 1) {
                System.out.printf("Case %d: There is one tree.\n", caseNum);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", caseNum, treeCnt);
            }

            
        }
    }

    static void dfs(int x) {
        vertexCnt++;
        edgeCnt += graph[x].size();
        isVisited[x] = true;

        for(int nxt : graph[x]){
            if(isVisited[nxt]) continue;
            dfs(nxt);
        }
    }
	

}
