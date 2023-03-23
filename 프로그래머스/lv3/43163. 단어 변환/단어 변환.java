import java.util.*;

class Solution {
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        List<String> wordList = new ArrayList<>();
        wordList.add(begin);
        for(String v : words) {
        	wordList.add(v);
        }
        
        // target -> words에 있는지 확인
        boolean isInWords = false;
        for(String word : words) {
        	if(target.equals(word)) {
        		isInWords = true;
        		break;
        	}
        }
        
        // bfs 시작
        if (!isInWords) {
        	return 0;
        }
        
        Queue<String> que = new LinkedList<>();
        int[] isChecked = new int[wordList.size()];
        
        que.add(begin);
        
        while(!que.isEmpty()) {
        	String now = que.poll();
        	int nowCnt = isChecked[wordList.indexOf(now)];
        	
        	if(now.equals(target)) {
        		answer = nowCnt;
        		break;
        	}
        	
        	String next = "";
        	for(String word : words) {
        		next = changeNextWord(now, word);
        		
        		if(next.equals("")) continue;
        		
        		if(isChecked[wordList.indexOf(next)] != 0) continue;
        		
        		que.add(next);
        		isChecked[wordList.indexOf(next)] = nowCnt + 1;
        	}
        }
        
        
        
        return answer;
    }
	
	static String changeNextWord(String root, String target) {
		
		char[] rootArr = root.toCharArray();
		char[] targetArr = target.toCharArray();
		
		int diffCnt = 0;
		for(int i=0; i<root.length(); i++) {
			if(rootArr[i] != targetArr[i]) {
				diffCnt++;
				if(diffCnt > 1) {
					return "";
				}
			}
		}
		
		return target;
	}
}