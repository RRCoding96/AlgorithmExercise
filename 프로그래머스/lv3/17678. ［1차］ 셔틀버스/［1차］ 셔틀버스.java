import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // 버스 횟수
        int arrivedBusCount = 0;
        // 현재 버스가 도착한 시간
        int arrivedBusTime = timeToInt("09:00");
        
        PriorityQueue<Integer> waiters = new PriorityQueue<Integer>();
        setPriorityQueue(timetable, waiters);
        
        while(arrivedBusCount <= n - 1) {
            
            // 버스 간격만큼 도착 시간 늘리기(맨 처음은 통과)
            if(arrivedBusCount != 0) {
                arrivedBusTime +=  t;
            }
            // 버스에 탄 사람 수
            int boardCount = 1;
            
            // 사람 하나씩 현재 버스에 태우기
            while(waiters.size() != 0 && boardCount <= m) {
                // 버스 도착한 시간보다 사람이 도착한 시간이 더 늦으면 그냥 버스 출발
                if(waiters.peek() > arrivedBusTime) break;
                
                // 막찬데 자리가 없을 경우
                if(boardCount == m && arrivedBusCount == n - 1) { 
                    // 1 분 빠른 시간 return
                    return timeToStr(waiters.poll() - 1);
                }
                
                // 사람 하나씩 뺌
                waiters.poll();
                // 사람 count++
                boardCount++;
            }
            // 버스 출발
            arrivedBusCount++;
        }
        
        //막차에 탈 수 있는 경우 
        return timeToStr(arrivedBusTime);
    }
    
    // 시간 -> int
    static public int timeToInt(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        return hour * 60 + min;
    }
    
    // int -> hh:mm
    static public String timeToStr(int time){
        String hour = String.format("%02d", time / 60);
        String min =  String.format("%02d", time % 60);
        return hour + ":" + min;
    }
    
    
    // 우선순위 큐에 다 넣기
    static public void setPriorityQueue(String[] timetable, PriorityQueue<Integer> waiters){
        for(String time : timetable){
            waiters.add(timeToInt(time));
        }
    }
}