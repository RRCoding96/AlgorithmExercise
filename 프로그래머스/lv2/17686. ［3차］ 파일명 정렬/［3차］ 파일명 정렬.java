import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> list = new ArrayList<>();
        for(int seq = 0; seq < files.length; seq++) {
            String file = files[seq];
            
            String head = "";
            String number = "";
            boolean isHead = true;
            for(int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                
                if(!isHead && !Character.isDigit(c)) break;
                
                if(Character.isDigit(c)) {
                    number += String.valueOf(c);
                    isHead = false;
                } else {
                    head += String.valueOf(c);
                }
            }
            
            if(number.equals("")) {
                number = "0";
            }
            File temp = new File(head.toUpperCase(), 
                                 Long.parseLong(number), 
                                 file, 
                                 seq);
            list.add(temp);
            // System.out.println(temp.toString());
        }
        // System.out.println("===============================");
        // Comparator<File> fileComparator = new File();
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
            // System.out.println(answer[i].toString());
        }
        
        
        return answer;
    }
    
    static class File implements Comparable<File>{
        String head;
        long number;
        String original;
        int inputSeq;
        
        public File() {}
        
        public File(String head, long number, String original, int inputSeq) {
            this.head = head;
            this.number = number;
            this.original = original;
            this.inputSeq = inputSeq;
        }
        
        @Override
       public int compareTo(File other) {
           int result = this.head.compareTo(other.head);
           
           if (result == 0) {
               result = Long.compare(this.number, other.number);
               if (result == 0) {
                   result = Integer.compare(this.inputSeq, other.inputSeq);
               }
           }
           
           return result;
       }
        
        @Override
        public String toString() {
            return "[ " + this.original + ": " + this.head + " " + this.number + " " + this.inputSeq + " ]";
        }
    }
}