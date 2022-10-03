package year2022.day1003.leetcode_114;

import year2022.TreeNode;

public class leetcode_114_jklee {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (true) {
            if (current == null) {
                break;
            }
            if (current.left != null) {
                TreeNode left = current.left, right = current.right;
                current.left = null;
                current.right = left;

                TreeNode target = current.right;
                while (true) {
                    if (target.right == null) {
                        target.right = right;
                        break;
                    }
                    target = target.right;
                }
                continue;
            }
            current = current.right;
        }
    }


    public static void main(String[] args) {

    }
}
