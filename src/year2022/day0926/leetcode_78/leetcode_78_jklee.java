package year2022.day0926.leetcode_78;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78_jklee {
    List<List<Integer>> answer;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i <= length; ++i) {
            findSubsets(nums, i);
        }
        return answer;
    }
    private void findSubsets(int[] nums, int count) {
        dfs(nums, 0, count, new ArrayList<>());
    }
    private void dfs(int[] nums,int index, int count, List<Integer> list) {
        if (list.size() == count) {
            answer.add(new ArrayList<>(list));
            return ;
        }
        for (int i = index; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(nums, i + 1, count, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[][] testcase = {{1, 2, 3}, {0}};

        for (int[] tc : testcase) {
            System.out.println(new leetcode_78_jklee().subsets(tc));
        }
    }
}
