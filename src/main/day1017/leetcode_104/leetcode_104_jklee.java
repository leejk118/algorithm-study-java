package main.day1017.leetcode_104;

import main.util.TreeNode;

public class leetcode_104_jklee {
    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }
    private int traverse(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        return Math.max(traverse(node.left, count + 1), traverse(node.right, count + 1));
    }
}
