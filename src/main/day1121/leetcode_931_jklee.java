package main.day1121;

public class leetcode_931_jklee {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int [n][n];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;

                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                }

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i][j]);

                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + matrix[i][j]);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            answer = Math.min(answer, dp[n - 1][i]);
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][][] testcase = {
                {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}},
                {{-19, 57}, {-40, -5}}
        };

        for (int[][] matrix : testcase) {
            System.out.println(new leetcode_931_jklee().minFallingPathSum(matrix));
        }
    }
}
