package main.day1003.leetcode_101;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class leetcode_101_pcc2242 {
    /**
     * https://leetcode.com/problems/symmetric-tree/
     *
     * 101. Symmetric Tree
     *
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//  Runtime: 4 ms, faster than 12.05%
//  Memory Usage: 43 MB, less than 6.00%
    public static boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root.left;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                leftList.add(curr.val);
                stack.push(curr);
                curr = curr.left;
                if (curr == null) {
                    leftList.add(-1);
                }
            }

            curr = stack.pop().right;
            if (curr == null) {
                leftList.add(-1);
            }
        }

        curr = root.right;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                rightList.add(curr.val);
                stack.push(curr);
                curr = curr.right;
                if (curr == null) {
                    rightList.add(-1);
                }
            }

            curr = stack.pop().left;
            if (curr == null) {
                rightList.add(-1);
            }
        }

        if (leftList.size() != rightList.size()) {
            return false;
        }

        for (int i = 0; i < leftList.size(); i++) {
            if(!leftList.get(i).equals(rightList.get(i))) {
                return false;
            }
        }
        return true;
    }

//    Runtime: 2 ms, faster than 12.05%
//    Memory Usage: 42.4 MB, less than 46.55%
    public static boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        while (!leftStack.empty() || !rightStack.empty() || leftNode != null || rightNode != null) {
            while (leftNode != null || rightNode != null) {
                if (leftNode == null || rightNode == null) {
                    return false;
                }

                if (leftNode.val != rightNode.val) {
                    return false;
                }

                leftStack.push(leftNode);
                leftNode = leftNode.left;

                rightStack.push(rightNode);
                rightNode = rightNode.right;
            }

            leftNode = leftStack.pop().right;
            rightNode = rightStack.pop().left;

            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null) {
                return false;
            }

            if (leftNode.val != rightNode.val) {
                return false;
            }
        }

        return true;
    }


        public static void main(String[] args) throws IOException {
        TreeNode node01 = new TreeNode(3);
        TreeNode node02 = new TreeNode(3);
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


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(isSymmetric2(input2));

    }
}

