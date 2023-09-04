import java.util.*;

class Solution {
    
    Map<String, Page> pageMap;
    
    public int solution(String word, String[] pages) {
        
        Set<String> set = new HashSet<>();
        int answer = 0;
        
        List<Integer>[] urlList = new ArrayList[pages.length];
        for(int i = 0; i < pages.length; i++) {
            urlList[i] = new ArrayList<>();
        }
        
        String[] urlMapping = new String[pages.length];
        double[] matchPoint = new double[pages.length];
        pageMap = new HashMap<>();
        for(int i = 0; i < pages.length; i++) {
            String page = pages[i];
            String url = getPageUrl(page);
            set.add(url);
            List<String> urls = getExternalUrl(page);
            int basicPoint = getBasicPoint(page, word);
            int externalUrlPoint = urls.size();
            
            urlMapping[i] = url;
            pageMap.put(url, new Page(i, url, urls, basicPoint, externalUrlPoint));
            
            // System.out.println("idx" + " " + i + " basic: " + basicPoint + " external: " + externalUrlPoint);
        }
        
        for(int i = 0; i < pages.length; i++) {
            Page page = pageMap.get(urlMapping[i]);
            List<String> urls = page.externalLink;
            
            for(String str : urls) {
                
                if(!set.contains(str)) continue;
                
                Page target = pageMap.get(str);
                urlList[target.idx].add(i);
            }
        }
        
        
        for(int i = 0; i < pages.length; i++) {
            double p = pageMap.get(urlMapping[i]).basicPoint;
            
            for(int j : urlList[i]) {
                String url = urlMapping[j];
                Page page = pageMap.get(url);
                
                double t = ((double)page.basicPoint / (double)page.externalUrlPoint);
                p += t;
                // System.out.print(j + "번으로 " + t + " ");
            }
            
            matchPoint[i] = p;
            
            // System.out.println(i + "번 매치포인트: " + p);
        }
        
        double temp = -1;
        for(int i = 0; i < pages.length; i++) {
            if(matchPoint[i] > temp) {
                temp = matchPoint[i];
                answer = i;
            }
        }
        
        
        return answer;
    }
    
    String getPageUrl(String page) {
        String a = page.split("<meta property=\"og:url\" content=\"")[1];
        String b = a.split("\"")[0];
        
        return b;
    }
    
    List<String> getExternalUrl(String page) {
        List<String> urls = new ArrayList<>();
        
        String[] temp = page.split("<a href=\"");
        for(int i = 1; i < temp.length; i++) {
            String str = temp[i];
            String b = str.split("\"")[0];
            urls.add(b);
        }
        
        return urls;
    }
    
    int getBasicPoint(String page, String word) {
        int result = 0;
        word = word.toLowerCase();
        page = page.toLowerCase();
        
        for(int i = 0; i < page.length(); i++) {
            int j = i + word.length();
            if(j >= page.length()) break;
            if(word.equals(page.substring(i, j))) {
                char c = page.charAt(j);
                char t = page.charAt(i - 1);
                if(c == ' ' || (!Character.isAlphabetic(c) && !Character.isAlphabetic(t))) {
                    // System.out.println(page.substring(i, j) + " " + i + " " + j);
                   result++; 
                }
                
            }
        }
        return result;
    }
    
    static class Page {
        int idx;
        String url;
        List<String> externalLink = new ArrayList<>();
        int basicPoint;
        int externalUrlPoint;
        
        public Page(int idx, String url, List<String> externalLink, int basicPoint, int externalUrlPoint) {
            this.idx = idx;
            this.url = url;
            this.externalLink = externalLink;
            this.basicPoint = basicPoint;
            this.externalUrlPoint = externalUrlPoint;
        }
    }
}