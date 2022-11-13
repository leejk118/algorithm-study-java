package main.day1114;

import main.util.TreeNode;

public class leetcode_112_jklee {
    private boolean isExist;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        isExist = false;
        traverse(root, targetSum, 0);
        return isExist;
    }

    private void traverse(TreeNode node, int targetSum, int sum) {
        if (isExist || node == null) return;

        if (node.left == null && node.right == null) {
            if (targetSum == sum + node.val) {
                isExist = true;
            }
            return;
        }
        if (node.left != null) {
            traverse(node.left, targetSum, sum + node.val);
        }
        if (node.right != null) {
            traverse(node.right, targetSum, sum + node.val);
        }
    }
}
