import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<Data> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String input : record) {
            String[] orders = input.split(" ");
            
            String order = "";
            String id = "";
            String nick = "";
                
            if(orders.length == 3) {
                order = orders[0];
                id = orders[1];
                nick = orders[2];
            } else if(orders.length == 2) {
                order = orders[0];
                id = orders[1];
            }       
            
            
            if(order.equals("Enter")) {
                map.put(id, nick);
                list.add(new Data(id, order));
            } else if(order.equals("Leave")) {
                list.add(new Data(id, order));
            } else if(order.equals("Change")) {
                map.put(id, nick);
            }
            
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            Data data = list.get(i);
            String id = data.id;
            String mention = data.mention;
            
            String str = "";
            str += map.get(id);
            str += "님이 ";
            if(mention.equals("Enter")) {
                str += "들어왔습니다.";
            } else if(mention.equals("Leave")) {
                str += "나갔습니다.";
            }
            
            answer[i] = str;
        }
        
        return answer;
    }
    
    static class Data {
        String id;
        String mention; // Enter, Leave
        
        public Data(String id, String mention) {
            this.id = id;
            this.mention = mention;
        }
    }
}