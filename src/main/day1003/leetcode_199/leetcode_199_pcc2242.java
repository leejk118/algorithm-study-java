package main.day1003.leetcode_199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_199_pcc2242 {
    /**
     * https://leetcode.com/problems/binary-tree-right-side-view/
     *
     * 199. Binary Tree Right Side View
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

    public static List<Integer> rightSideView(TreeNode root) {
        int currentDepth = -1;
        int maxDepth = -1;
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        //          1        -- 0
        //      2,       3   -- 1
        // null, 5,   6      -- 2
        //                   -- 3


        //      1
        //   2     3
        // 4

        //        1    -- 0
        //      2  0   -- 1
        //    3        -- 2
        //  4
        //5

        //           5           0
        //      3         6      1
        //    1   4      *  *    2
        //  *  2
        //
        //         1
        //     2       2
        //   3    4  4   3

        int leftCount = 0;
        while (!stack.empty() || currentNode != null) {
            while (currentNode != null) {
                currentDepth++;
                if (maxDepth < currentDepth) {
                    maxDepth = currentDepth;
                    answer.add(currentNode.val);
                }
                stack.push(currentNode);
                currentNode = currentNode.right;
            }


            currentNode = stack.pop().left;
            if (currentNode == null) {
                currentDepth -= leftCount;
            }
            leftCount++;
        }

        return answer;
    }
//    Runtime: 2 ms, faster than 49.61%
//    Memory Usage: 42.6 MB, less than 66.45%
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        addQueue(queue, answer);

        return answer;
    }

    private static void addQueue(Queue<TreeNode> queue, List<Integer> answer) {
        TreeNode rightNode = queue.peek();

        if (rightNode != null) {
            answer.add(rightNode.val);
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node != null){
                if (node.right != null){
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }

        }
        if (queue.size() > 0) {
            addQueue(queue, answer);
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


        System.out.println(rightSideView2(input4));
    }
}

