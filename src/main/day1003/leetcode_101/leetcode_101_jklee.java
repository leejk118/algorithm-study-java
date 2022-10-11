package main.day1003.leetcode_101;

import main.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_101_jklee {
    private List<Integer> left, right;

    public boolean isSymmetric(TreeNode root) {
        left = new ArrayList<Integer>();
        right = new ArrayList<Integer>();

        preorder(root.left);
        postorder(root.right);
        return left.equals(right);
    }
    private void preorder(TreeNode node) {
        if (node == null) {
            left.add(null);
            return;
        }
        preorder(node.left);
        left.add(node.val);
        preorder(node.right);
    }
    private void postorder(TreeNode node) {
        if (node == null) {
            right.add(null);
            return;
        }
        postorder(node.right);
        right.add(node.val);
        postorder(node.left);
    }


    public static void main(String[] args) {

    }
}
