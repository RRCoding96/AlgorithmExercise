import java.util.*;

class Solution {
    
    static int[][] answer;
    static int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        
        answer = new int[2][nodeinfo.length];
        
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            list.add( new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        Collections.sort(list);
        
        Node root = list.get(0);
        for(int i = 1; i < list.size(); i++){
            insertNode(root, list.get(i));
        }
        
        idx = 0;
        preorder(root);
        
        idx = 0;
        postorder(root);  
        
        return answer;
    }
    
    // 전위 순회
    static void preorder(Node root) {
        if(root != null) {
            answer[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    // 후위 순회    
    static void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.num;
        }
    }
    
    static void insertNode(Node parent, Node child){
        if(parent.x > child.x) {    // 왼쪽 자식노드
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {    // 오른쪽 자식노드
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    static class Node implements Comparable<Node>{
        int num;
        int x;
        int y;
        Node left;  // 왼쪽 자식노드
        Node right; // 오른쪽 자식노드
        
        Node(int num, int x, int y, Node left, Node right){
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
        
        // y좌표가 큰 순서대로, 같다면 x좌표가 작은 순서대로
        @Override
        public int compareTo(Node o1){
            if(this.y == o1.y){ 
                return this.x - o1.x; 
            }
            
            return o1.y - this.y;
        }
    }
}