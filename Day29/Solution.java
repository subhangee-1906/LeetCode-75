package Day29;

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
    private int maxZigZag = 0;
    
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true, 1);  
        dfs(root.right, false, 1); 
        return maxZigZag;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxZigZag = Math.max(maxZigZag, length);

        if (isLeft) {
            
            dfs(node.right, false, length + 1);
            dfs(node.left, true, 1);  
        } else {
            dfs(node.left, true, length + 1);
            dfs(node.right, false, 1);
        }
    }
}

