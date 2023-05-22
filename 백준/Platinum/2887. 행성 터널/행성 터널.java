import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Edge> edges;
    static List<Node> nodes;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        edges = new ArrayList<>();
        nodes = new ArrayList<>();
        // 입력
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long z = Long.parseLong(st.nextToken());

            Node node = new Node(i, x, y, z);
            nodes.add(node);
        }

        // x로 정렬
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
//                return o1.x - o2.x;
                if(o1.x < o2.x) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i = 0; i < N - 1; i++) {
            Node a = nodes.get(i);
            Node b = nodes.get(i + 1);

            long cost = Math.min(Math.abs(a.x - b.x), Math.min(Math.abs(a.y - b.y), Math.abs(a.z - b.z)));
            edges.add(new Edge(a.num, b.num, cost));
        }

        // y로 정렬
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
//                return o1.y - o2.y;
                if(o1.y < o2.y) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i = 0; i < N - 1; i++) {
            Node a = nodes.get(i);
            Node b = nodes.get(i + 1);

            long cost = Math.min(Math.abs(a.x - b.x), Math.min(Math.abs(a.y - b.y), Math.abs(a.z - b.z)));
            edges.add(new Edge(a.num, b.num, cost));
        }

        // z로 정렬
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
//                return o1.z - o2.z;
                if(o1.z < o2.z) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i = 0; i < N - 1; i++) {
            Node a = nodes.get(i);
            Node b = nodes.get(i + 1);

            long cost = Math.min(Math.abs(a.x - b.x), Math.min(Math.abs(a.y - b.y), Math.abs(a.z - b.z)));
            edges.add(new Edge(a.num, b.num, cost));
        }


//        for(int i = 1; i <= N; i++) {
//            for(int j = i + 1; j <= N; j++) {
//                Node a = nodes.get(i);
//                Node b = nodes.get(j);
//
//                long cost = Math.min(Math.abs(a.x - b.x), Math.min(Math.abs(a.y - b.y), Math.abs(a.z - b.z)));
//
//                edges.add(new Edge(i, j, cost));
//            }
//        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
//                return o1.cost - o2.cost;
                if(o1.cost < o2.cost) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        long answer = 0;
        for(Edge edge : edges) {
            int a = edge.a;
            int b = edge.b;
            long cost = edge.cost;

            if(!sameParent(a, b)) {
                union(a, b);

                answer += cost;
            }
        }

        System.out.println(answer);

    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static boolean sameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }

        return false;
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static class Edge {
        int a, b;
        long cost;

        public Edge(int a, int b, long cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static class Node {
        int num;
        long x, y, z;

        public Node(int num, long x, long y, long z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
