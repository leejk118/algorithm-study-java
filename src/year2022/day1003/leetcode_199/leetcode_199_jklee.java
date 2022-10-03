package year2022.day1003.leetcode_199;

import year2022.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_199_jklee {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        if (root != null) {
            answer.add(root.val);
        }
        while (true) {
            Integer number = null;
            List<TreeNode> tempList = new ArrayList<>();
            for (TreeNode tree : list) {
                if (tree == null) continue;
                if (tree.left != null) {
                    number = tree.left.val;
                    tempList.add(tree.left);
                }
                if (tree.right != null) {
                    number = tree.right.val;
                    tempList.add(tree.right);
                }
            }
            if (tempList.isEmpty()) break;

            answer.add(number);
            list = new ArrayList<>(tempList);
        }
        return answer;
    }


    public static void main(String[] args) {

    }
}
