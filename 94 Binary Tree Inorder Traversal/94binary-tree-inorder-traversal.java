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
    public static List<Integer> traversal(TreeNode root, ArrayList<Integer> ans){
        if(root==null){
            return ans;
        }
        traversal(root.left, ans);
        ans.add(root.val);
        traversal(root.right, ans);
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }
}