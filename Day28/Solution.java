package Day28;

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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
       
        int count = countPathsFromNode(root, targetSum);
        
        
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        
        return count;
    }

    private int countPathsFromNode(TreeNode node, long sum) {
        if (node == null) return 0;
        
        int count = 0;
        if (node.val == sum) count++;
        
        count += countPathsFromNode(node.left, sum - node.val);
        count += countPathsFromNode(node.right, sum - node.val);
        
        return count;
    }
}

