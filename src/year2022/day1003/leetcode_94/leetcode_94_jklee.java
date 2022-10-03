package year2022.day1003.leetcode_94;

import year2022.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_94_jklee {
    List<Integer> answer;

    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        TreeNode current = root, parent = root;
        inorder(root);
        return answer;
    }
    private void inorder(TreeNode tree) {
        if (tree == null) {
            return ;
        }
        inorder(tree.left);
        answer.add(tree.val);
        inorder(tree.right);
    }


    public static void main(String[] args) {

    }
}
