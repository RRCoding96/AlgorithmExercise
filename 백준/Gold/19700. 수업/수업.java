import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Student s = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            students.add(s);
        }
        Collections.sort(students, (s1, s2) -> s2.h - s1.h); // 키 순으로 내림차순 정렬 : 키 큰 사람이 먼저 나옴

        int result = 1; // 팀의 최소 개수를 셀 변수

        // 현재까지 만들어진 '팀의 사이즈'들을 관리할 자료구조
        TreeSet<Integer> set = new TreeSet<>();
        // 특정 '팀 사이즈'가 몇 개나 있는지 관리할 배열
        int[] countOfGroup = new int[N + 1];

        // 처음으로 가장 키가 큰 학생은 팀이 아예 없으므로 새로운 팀을 하나 만들어서 넣는다
        set.add(1);
        countOfGroup[1]++; // 1명인 그룹이 지금 한개 있다.

        // 나머지 (두 번째로 키가 큰 학생)부터 순회하며 팀 배정
        for (int i = 1; i < N; i++) {
            Student s = students.get(i); // 키 큰 사람이 먼저 나옴

            // ─────────────────────────────────────────────────
            //   지금 보고 있는 학생 s (키는 이미 큰 순서로 정렬됨)
            //   이 학생보다 키가 큰 사람 = 이미 한 팀에 들어간 사람
            // ─────────────────────────────────────────────────

            // (중요) s.k는 "자신보다 큰 사람"이 k명 이상이면 안 된다는 조건.
            // 즉, 자신보다 큰 사람이 k명 미만이어야 하므로,
            // 팀의 현재 크기가 k명 미만인(즉, 팀 크기 < s.k) 팀에 들어가야 함

            // TreeSet에서 lower(x)는 'x보다 작은 원소 중 가장 큰 값'을 찾아줌.
            // => 즉, set.lower(s.k)는 "s.k보다 작은 팀 크기 중 최댓값"을 반환
            Integer findGroupCurSize = set.lower(s.k);
            if (findGroupCurSize == null) {
                // 1) s.k보다 작은 팀 크기가 없다면 (= 조건을 만족하는 기존 팀이 없다면)
                //    => 새로운 팀을 생성한다
                set.add(1);  // 새로 생긴 팀: 크기 1
                countOfGroup[1]++; // 크기 1인 팀 수 증가
                result++; // 팀의 총 개수 1 증가
            } else {
                // 2) s.k보다 작은 팀 크기가 있다면 (= 조건을 만족하는 팀이 존재)
                //    => 그 팀에 학생을 넣어 팀 크기를 1 늘린다

                // findGroupCurSize라는 팀 사이즈를 가진 팀 중 하나에 학생을 추가하므로
                // 그 사이즈의 팀 "하나"는 이제 (findGroupCurSize+1) 크기가 됨
                // => 따라서, 원래 (findGroupCurSize) 크기 팀 1개 사라지고,
                //    (findGroupCurSize+1) 크기 팀 1개 생긴 것과 동일
                
                countOfGroup[findGroupCurSize]--;
                // 만약 (findGroupCurSize) 크기 팀이 0개가 되었다면, set에서도 제거
                if (countOfGroup[findGroupCurSize] == 0) {
                    set.remove(findGroupCurSize);
                }

                // (findGroupCurSize + 1) 팀 사이즈가 새로 생기므로 카운트를 올림
                countOfGroup[findGroupCurSize + 1]++;
                // 만약 기존에 (findGroupCurSize + 1) 사이즈 팀이 없었다면 set에 추가
                if (countOfGroup[findGroupCurSize + 1] == 1) {
                    set.add(findGroupCurSize + 1);
                }
            }
        }

        System.out.println(result);
    }

    static class Student {
        final int h;
        final int k;

        public Student(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }

}
