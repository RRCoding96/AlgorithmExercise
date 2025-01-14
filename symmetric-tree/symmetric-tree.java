/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode left, TreeNode right){
        // 왼, 오 모두 null이면 
        if (left == null && right == null) {
            return true;
        } 
        // 한 쪽 만 null이면
        else if (left == null || right == null) {
            return false;
        }
        
        // 왼, 오 값이 같으면 재귀로 들어감
        if (left.val == right.val) {
            return check(left.right, right.left) && check(left.left, right.right);
        } else {
            return false;
        }
    }
}