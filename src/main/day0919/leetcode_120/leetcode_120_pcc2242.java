package main.day0919.leetcode_120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class leetcode_120_pcc2242 {
    /**
     * https://leetcode.com/problems/triangle/description/
     *
     * 120. Triangle
     *
     * Given a triangle array, return the minimum path sum from top to bottom.
     *
     * For each step, you may move to an adjacent number of the row below. More formally,
     * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     */


//    Time Limit Exceeded
    private static int min;
    public static int minimumTotal(List<List<Integer>> triangle) {
        min = Integer.MAX_VALUE;
        dfs(triangle, 0, 0, 0);
        return min;
    }

    private static void dfs(List<List<Integer>> triangle, int depth, int index, int sum) {
        if (depth == triangle.size()) {
            min = Math.min(sum, min);
            return;
        }

        sum += triangle.get(depth).get(index);
        dfs(triangle, depth + 1, index, sum);
        dfs(triangle, depth + 1, index + 1, sum);
    }

//    Runtime: 6 ms, faster than 44.11%
//    Memory Usage: 44 MB, less than 58.15%
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int[][] dp = new int[depth][depth];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < depth; i++) {
            List<Integer> row = triangle.get(i);

            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                } else if ( j == row.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + row.get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + row.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : dp[depth - 1]) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> triangle = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(2)),
                        new ArrayList<>(List.of(3,4)),
                        new ArrayList<>(List.of(6,5,7)),
                        new ArrayList<>(List.of(4,1,8,3))
                )
        );

        System.out.println(triangle);
        System.out.println(minimumTotal2(triangle));
        //          1
        //        1, 99
        //       1, 1, 99
        //      1, 1, 1, 99
        //     1, 1, 1, 1, -1000
        // -10000, 1, 1, 1, -1000

    }
}

