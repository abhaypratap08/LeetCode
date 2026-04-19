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

    Set<Integer> set = new HashSet<>();

    boolean helper(TreeNode node, int k) {
        if (node == null) return false;

        if (set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);

        return helper(node.left, k) || helper(node.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k);
    }
}

