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
    int count = 1;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public int dfs(TreeNode root, int maximum){
        if(root == null) {
            return 0;
        }
            
        int leftMax = maximum;
        int rightMax = maximum;

        if(root.left != null && root.left.val >= maximum){
            leftMax = root.left.val;
            count++;
        }

        if(root.right != null && root.right.val >= maximum){
            rightMax = root.right.val;
            count++;
        }
        
        int left = dfs(root.left, leftMax);
        int right = dfs(root.right, rightMax);

        return Math.max(left, right);
    }
}