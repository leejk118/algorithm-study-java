package main.day1017.leetcode_104;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_104_pcc2242 {
    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     *
     * 104. Maximum Depth of Binary Tree
     *
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     */

    //Runtime 0 ms Beats 100%
    //Memory 43 MB Beats 52.88%
    public static int maxDepth(TreeNode root) {
        return count(root, 0);
    }

    public static int count(TreeNode node, int count) {
        if (node != null) {
            count++;
            count = Math.max(count(node.left, count), count(node.right, count));
        }

        return count;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode formTree(Integer[] data) {
            TreeNode root = new TreeNode(data[0]);
            form(root, 0, data);
            return root;
        }

        private static void form(TreeNode root, int rootIndex, Integer[] data) {
            int n = data.length;

            int leftIndex = 2 * rootIndex + 1;
            if (leftIndex < n && null != data[leftIndex]) {
                root.left = new TreeNode(data[leftIndex]);
                form(root.left, leftIndex, data);
            }

            int rightIndex = 2 * rootIndex + 2;
            if (rightIndex < n && null != data[rightIndex]) {
                root.right = new TreeNode(data[rightIndex]);
                form(root.right, rightIndex, data);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeNode input = TreeNode.formTree(new Integer[]{3,9,20,null,null,15,7});

        System.out.println(maxDepth(input));
    }
}

