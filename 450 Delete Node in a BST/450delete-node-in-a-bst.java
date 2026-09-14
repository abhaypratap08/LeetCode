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
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer> arr = new ArrayList<>();
        toList(root, arr); // convert to Array
        int idx = Collections.binarySearch(arr, key); //find the index of the key
        if(idx != -1) arr.remove(idx); //remove the key
        System.out.println(arr);
        return build(arr, new TreeNode(), 0, arr.size()-1); //rebuild the tree
    }
    public void toList(TreeNode root, List<Integer>arr){
        if(root == null){
            return;
        }
        toList(root.left, arr);
        arr.add(root.val);
        toList(root.right, arr);
    }
    public TreeNode build(List<Integer> arr, TreeNode root, int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        root.val = arr.get(mid);
        root.left = build(arr, new TreeNode(), start, mid-1);
        root.right = build(arr, new TreeNode(), mid+1, end);
        return root;
    }
}