package main.day1031.leetcode_279;

public class leetcode_279_jklee {
    public int numSquares(int n) {
        int[] dp = new int [n + 1];
        dp[1] = 1;
        int num;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            num = 1;
            while (true) {
                int pow = (int) Math.pow(num, 2);
                if (pow > i) break;
                dp[i] = Math.min(dp[i], dp[i - pow] + 1);
                num++;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int[] testcase = { 12, 13, 1, 1000};
        for (int tc : testcase) {
            System.out.println(new leetcode_279_jklee().numSquares(tc));
        }
    }
}
