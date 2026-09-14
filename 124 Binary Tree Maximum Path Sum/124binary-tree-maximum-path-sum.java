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
import java.util.*;

// Recursion

class Solution {

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        F(root);
        return maxSum;
    }

    private int F(TreeNode root) {

        if (root == null) return 0;

        int left = Math.max(0, F(root.left));
        int right = Math.max(0, F(root.right));

        maxSum = Math.max(
            maxSum,
            left + right + root.val
        );

        return root.val + Math.max(left, right);
    }
}

// Memoization

// class Solution {

// private int maxSum;
// private Map<TreeNode, Integer> dp;

// public int maxPathSum(TreeNode root) {

//     maxSum = Integer.MIN_VALUE;
//     dp = new HashMap<>();

//     F(root);

//     return maxSum;
// }

// private int F(TreeNode root) {

//     if (root == null) return 0;

//     if (dp.containsKey(root)) {
//         return dp.get(root);
//     }

//     int left = Math.max(0, F(root.left));
//     int right = Math.max(0, F(root.right));

//     maxSum = Math.max(
//         maxSum,
//         left + right + root.val
//     );

//     int result = root.val + Math.max(left, right);

//     dp.put(root, result);

//     return result;
// }

// }
