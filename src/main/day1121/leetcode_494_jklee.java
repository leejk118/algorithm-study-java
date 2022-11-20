package main.day1121;

public class leetcode_494_jklee {
    private int answer;

    public int findTargetSumWays(int[] nums, int target) {
        answer = 0;
        dfs(nums, target, 0, 0);
        return answer;
    }
    private void dfs(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            answer += (target == sum) ? 1 : 0;
            return;
        }
        dfs(nums, target, sum + nums[index], index + 1);
        dfs(nums, target, sum - nums[index], index + 1);
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 2},
                {1, 1, 1},
                {1, 1, 1, 1, 1},
                {1},
                {1, 1, 1, 1, 1,   1, 1, 1, 1, 1,   1, 1, 1, 1, 1,   1, 1, 1, 1, 1}
        };
        int[] target = {2, 2, 3, 1, 5};

        for (int i = 0; i < nums.length; ++i) {
            System.out.println(new leetcode_494_jklee().findTargetSumWays(nums[i], target[i]));
        }
    }
}
