package main.day1010.leetcode_222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class leetcode_222_pcc2242 {
    /**
     * https://leetcode.com/problems/count-complete-tree-nodes/
     *
     * 222. Count Complete Tree Nodes
     *
     * Given the root of a complete binary tree, return the number of the nodes in the tree.
     * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
     * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
     * Design an algorithm that runs in less than O(n) time complexity.
     *
     */

//    Runtime 204 ms Beats 5.3%
//    Memory 57 MB Beats 5.51%
    public static int countNodes(TreeNode root) {
        int count = 0;
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while (currentNode != null || !stack.empty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.right;
                count++;
            }

            currentNode = stack.pop().left;
        }

        return count;
    }

    public static int countNodes2(TreeNode root) {
        int count = 0;
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while (currentNode != null || !stack.empty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.right;
                count++;
            }

            currentNode = stack.pop().left;
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

        TreeNode input = TreeNode.formTree(new Integer[]{1,2,3,4,5,6});
        System.out.println(countNodes2(input));
    }

}

