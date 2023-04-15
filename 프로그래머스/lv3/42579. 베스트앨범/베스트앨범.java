import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        int N = genres.length;
        
        Map<String, Integer> totalCnt = new HashMap<>();
        Map<String, List<int[]>> priorityCnt = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            String genre = genres[i];
            int playCnt = plays[i];
            
            if(totalCnt.containsKey(genre)) {
                int tmp = totalCnt.get(genre) + playCnt;
                totalCnt.put(genre, tmp);
                
                List<int[]> pList = priorityCnt.get(genre);
                pList.add(new int[]{playCnt, i});
                priorityCnt.put(genre, pList);
            } else {
                totalCnt.put(genre, playCnt);
                
                List<int[]> pList = new ArrayList<>();
                pList.add(new int[]{playCnt, i});
                priorityCnt.put(genre, pList);
            }
        }
        
        List<Integer> tCntList = new LinkedList<>();
        Map<Integer, String> cntToGenre = new HashMap<>();
        for(Map.Entry<String, Integer> entry : totalCnt.entrySet()) {
            String genre = entry.getKey();
            int total = entry.getValue();
            
            tCntList.add(total);
            cntToGenre.put(total, genre);
        }
        
        List<Integer> ansList = new ArrayList<>();
        
        Collections.sort(tCntList, Collections.reverseOrder());
        for(int i = 0; i < tCntList.size(); i++) {
            int total = tCntList.get(i);
            String genre = cntToGenre.get(total);
            
            List<int[]> pList = priorityCnt.get(genre);
            Collections.sort(pList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            
            // for(int k=0; k<pList.size(); k++) {
            //     System.out.print(pList.get(k)[0] + " " + pList.get(k)[1] + "\n");
            // }
            // System.out.println();
            
            
            
            
            int t = 0;
            for(int j = 0; j < pList.size(); j++) {
                if(t > 1) break;
                
                int idx = pList.get(j)[1];
                ansList.add(idx);
                t++;
            }
        }
        
        // System.out.println(tCntList.toString());
        
        // System.out.println(ansList.toString());
        
        int[] answer = new int[ansList.size()];
        for(int t = 0; t < ansList.size(); t++) {
            answer[t] = ansList.get(t);
        }
        
        return answer;
    }
}