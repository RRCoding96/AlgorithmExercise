import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 1. 요금표 파싱
        int baseTime = fees[0];   // 기본 시간
        int baseFee  = fees[1];   // 기본 요금
        int unitTime = fees[2];   // 단위 시간
        int unitFee  = fees[3];   // 단위 요금

        // 2. 차량별 누적 시간과 현재 IN 상태 관리
        Map<String, Integer> totalTime = new HashMap<>(); // 차량번호 -> 누적 주차 시간(분)
        Map<String, Integer> inTime    = new HashMap<>(); // 차량번호 -> 마지막 입차 시각(분)

        // 3. records 순회하며 입/출차 처리
        for (String rec : records) {
            String[] split = rec.split(" ");
            String timeStr = split[0];   // "HH:MM"
            String carNum  = split[1];
            String status  = split[2];   // "IN" or "OUT"

            // 시각(분 단위)으로 변환
            int time = convertToMinutes(timeStr);

            if ("IN".equals(status)) {
                inTime.put(carNum, time);
            } else {
                // OUT이면 누적 시간 갱신
                int in = inTime.get(carNum);
                int parked = time - in;
                inTime.remove(carNum);

                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parked);
            }
        }

        // 4. 출차 기록 없는 차량(입차 중인 차량) → 23:59(1439분) 출차 처리
        for (Map.Entry<String, Integer> entry : inTime.entrySet()) {
            String carNum = entry.getKey();
            int in = entry.getValue();
            int parked = 1439 - in; // 23:59 - 입차 시각

            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parked);
        }

        // 5. 차량번호 오름차순 정렬
        List<String> carList = new ArrayList<>(totalTime.keySet());
        Collections.sort(carList);

        // 6. 요금 계산
        int[] answer = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            String carNum = carList.get(i);
            int tTime = totalTime.get(carNum);

            // 기본 시간 이하
            if (tTime <= baseTime) {
                answer[i] = baseFee;
            } else {
                int extra = tTime - baseTime;
                // 올림 계산
                int unitCount = (int) Math.ceil((double) extra / unitTime);
                answer[i] = baseFee + unitCount * unitFee;
            }
        }
        return answer;
    }

    // "HH:MM" → 총 분(minutes)
    private int convertToMinutes(String timeStr) {
        String[] hm = timeStr.split(":");
        int hour   = Integer.parseInt(hm[0]);
        int minute = Integer.parseInt(hm[1]);
        return hour * 60 + minute;
    }
}
