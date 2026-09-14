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
    public TreeNode buildTree(int[] in, int[] p) {
        return func(in,p,0,in.length-1,0,p.length-1);
    }
    public TreeNode func(int[] in,int[] p,int ilo,int ihi,int po,int ph){
         if(ilo>ihi || po>ph){
            return null;
        }
        TreeNode root=new TreeNode(p[ph]);
        int index=find(in,ilo,ihi,p[ph]);
        int c=index-ilo;

        root.left=func(in,p,ilo,index-1,po,po+c-1);
        root.right=func(in,p,index+1,ihi,po+c,ph-1);
        return root;
    }
    public static int find(int[] in,int ilo,int ihi,int item){
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==item){
                return i;
            }
        }
        return -1;
    }
}