import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] data = new int[100001];    // 데이터를 배열로 관리했다.
    static PriorityQueue<Problem> ascPQ = new PriorityQueue<>();    // 난이도 낮은 순
    static PriorityQueue<Problem> descPQ = new PriorityQueue<>(Collections.reverseOrder());    // 난이도 높은 순

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem prob = new Problem(p, l);
            data[p] = l;            // 문제 번호에 해당하는 인덱스에 난이도를 저장
            ascPQ.offer(prob);
            descPQ.offer(prob);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("recommend")){
                if(Integer.parseInt(st.nextToken()) == -1){
                    while(true){
                        Problem p = ascPQ.peek();// peek을 쓰는 이유는 문제를 추천해줬다고 문제가 사라지지 않기 떄문.
                        if(data[p.p] == p.l){            // 문제 번호의 난이도가 맞으면 출력
                            sb.append(p.p).append("\n");
                            break;
                        }
                        ascPQ.poll();        // 이미 바뀌거나 solved 되어서 문제와 일치하지 않을 수 있다.
                    }
                }else{
                    while(true){
                        Problem p = descPQ.peek();
                        if(data[p.p] == p.l){
                            sb.append(p.p).append("\n");
                            break;
                        }
                        descPQ.poll();
                    }
                }
            }else if(command.equals("add")){
                int probNo = Integer.parseInt(st.nextToken());
                int probLev = Integer.parseInt(st.nextToken());
                Problem newProb = new Problem(probNo,probLev);
                data[probNo] = probLev;
                ascPQ.offer(newProb);
                descPQ.offer(newProb);
            }else if(command.equals("solved")){
                data[Integer.parseInt(st.nextToken())] = 0;// 문제 난이도는 1보다 크므로 0은 없는 문제라고 정했다.
            }
        }
        System.out.println(sb.toString());
    }

    static class Problem implements Comparable<Problem> {
        int p, l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.l == o.l) {
                return Integer.compare(this.p ,o.p);
            }
            return Integer.compare(this.l, o.l);
        }
    }

}
