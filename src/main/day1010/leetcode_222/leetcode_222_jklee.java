package main.day1010.leetcode_222;

import main.util.TreeNode;

public class leetcode_222_jklee {
    private int answer = 0;

    public int countNodes(TreeNode root) {
        traverse(root);
        return answer;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        answer++;
        traverse(root.right);
    }


    public static void main(String[] args) {

    }
}
