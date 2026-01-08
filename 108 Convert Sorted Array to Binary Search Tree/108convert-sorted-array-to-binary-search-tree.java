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
    public TreeNode balancedBST(int nums[], int si, int ei)
    {
        if(si > ei)     return null;    
        
        int midIndex = (si+ei)/2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = balancedBST(nums, si, midIndex-1);
        root.right = balancedBST(nums, midIndex+1, ei);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return balancedBST(nums, 0, nums.length-1);
    }
}