package main.day1114;

public class leetcode_746_jklee {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int [length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < length; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }


    public static void main(String[] args) {
        int[][] costs = {
                {10, 15, 20},
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        };

        for (int[] cost : costs) {
            System.out.println(new leetcode_746_jklee().minCostClimbingStairs(cost));
        }
    }
}
