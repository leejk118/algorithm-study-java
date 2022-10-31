package main.day1003.leetcode_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class leetcode_94_pcc2242 {
    /**
     * https://leetcode.com/problems/binary-tree-inorder-traversal/
     *
     * 94. Binary Tree Inorder Traversal
     *
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     */
    public class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        inorderDfs(answer, root);

        return answer;
    }

//    preorder traversal (전위순회)
//    루트 노드부터 왼쪽 노드 순으로 순회
    private void preorderDfs (List<Integer> answer, TreeNode node) {
        answer.add(node.val);
        if (node.left != null) {
            preorderDfs(answer, node.left);
        }

        if (node.right != null) {
            preorderDfs(answer, node.right);
        }
    }

//    Runtime: 1 ms, faster than 47.26%
//    Memory Usage: 42.4 MB, less than 39.00%
    private void inorderDfs (List<Integer> answer, TreeNode node) {
        if (node.left != null) {
            inorderDfs(answer, node.left);
        }
        answer.add(node.val);

        if (node.right != null) {
            inorderDfs(answer, node.right);
        }
    }

    //----------------solution
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }
}

