package main.day1003.leetcode_114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_114_pcc2242 {
    /**
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
     *
     * 114. Flatten Binary Tree to Linked List
     *
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     */
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
    }

//    Runtime: 3 ms, faster than 6.44%
//    Memory Usage: 42.8 MB, less than 34.30%
    public static void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;

        while (!stack.empty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                queue.add(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop().right;
        }

        currentNode = queue.poll();
        while (queue.size() > 0) {
            currentNode.left = null;
            currentNode.right = queue.poll();
            currentNode = currentNode.right;
        }
    }

    public static void flatten2(TreeNode root) {
        TreeNode currentNode = root;
        Stack<TreeNode> rightNode = new Stack<>();
        while (currentNode != null || !rightNode.empty()) {
            while (currentNode != null) {
                if (currentNode.right != null) {
                    rightNode.push(currentNode.right);
                }

                if (currentNode.left != null) {
                    currentNode.right = currentNode.left;
                    currentNode = currentNode.right;
                    currentNode.left = null;
                } else  {

                    currentNode.right = rightNode.size() > 0 ? rightNode.pop() : null;
                    currentNode = currentNode.right;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeNode node0 = new TreeNode(0);
        TreeNode node01 = new TreeNode(3, null, node0);
        TreeNode node02 = new TreeNode(3, null, null);
        TreeNode node03 = new TreeNode(2, null, node01);
        TreeNode node04 = new TreeNode(2, null, node02);
        TreeNode input1 = new TreeNode(1, node03, node04);

        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(4);
        TreeNode node13 = new TreeNode(4);
        TreeNode node14 = new TreeNode(3);
        TreeNode node15 = new TreeNode(2, node11, node12);
        TreeNode node16 = new TreeNode(2, node13, node14);
        TreeNode input2 = new TreeNode(1, node15, node16);



        TreeNode node25 = new TreeNode(5);
        TreeNode node26 = new TreeNode(6);
        TreeNode node23 = new TreeNode(3, node26, null);
        TreeNode node22 = new TreeNode(2, null, node25);
        TreeNode input3 = new TreeNode(1, node22, node23);


        TreeNode node31 = new TreeNode(4);
        TreeNode node32 = new TreeNode(3);
        TreeNode node33 = new TreeNode(2, node31, null);
        TreeNode input4 = new TreeNode(1, node33, node32);


        flatten2(input1);
    }
}

