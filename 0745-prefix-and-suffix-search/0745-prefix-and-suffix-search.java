import java.util.*;

class WordFilter {
    
    private Map<String, Integer> hm = new HashMap<>();
    private static final String delim = ":";

    public WordFilter(String[] words) {
        for(int k = 0; k < words.length; k++) {
            String s = words[k];
            int wordLen = s.length();
            for(int i = 0; i <= wordLen; i++) {
                for(int j = 0; j <= wordLen; j++) {
                    String key = s.substring(0, i) + delim + s.substring(wordLen - j);
                    hm.put(key, k);
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        String key = pref + delim + suff;
        return hm.getOrDefault(key, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */