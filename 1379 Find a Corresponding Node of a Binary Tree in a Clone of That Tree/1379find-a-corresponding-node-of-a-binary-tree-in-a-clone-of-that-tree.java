/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode ori, final TreeNode clo, final TreeNode tar){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(clo);
        while (!q.isEmpty()) {
            TreeNode root = q.poll();
            if(root.val == tar.val) {
                return root;
            }
            if(root.left != null) {
                q.offer(root.left);
            }
            if(root.right != null) {
                q.offer(root.right);
            }
        }
        return null;
    }
}