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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> current = new ArrayList<>(level);
            for(int i=0; i<level; i++){
                TreeNode node = queue.poll();
                current.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            ans.add(current);
        }
        return ans;
    }
}
