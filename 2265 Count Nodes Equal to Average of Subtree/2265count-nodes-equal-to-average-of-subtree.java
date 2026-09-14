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

    int count = 0;

    public int averageOfSubtree(TreeNode root) {

        if(root == null) return 0;

        dfs(root);
        return count;
        
    }

    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0, 0}; // sum , node count
        }

        int[] leftChildVal = dfs(node.left);
        int[] rightChildVal = dfs(node.right);

        int totalSum = node.val + leftChildVal[0] + rightChildVal[0];
        int totalNodes = 1 + leftChildVal[1] + rightChildVal[1];

        if(totalSum / totalNodes == node.val) count++;

        return new int[]{totalSum, totalNodes};
    }
}