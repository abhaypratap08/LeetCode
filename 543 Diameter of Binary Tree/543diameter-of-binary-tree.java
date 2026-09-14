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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode node)
    {
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        diameter = Math.max(diameter,left+right);

        return 1 + Math.max(left,right);
    }
}