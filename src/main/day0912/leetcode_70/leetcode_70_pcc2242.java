package main.day0912.leetcode_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class leetcode_70_pcc2242 {
    /**
     * https://leetcode.com/problems/climbing-stairs/
     *
     * 70. Climbing Stairs
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

//    Time Limit Exceeded
    public static int count = 0;
    public static int climbStairs(int n) {
        // 1 -> {1}
        // 2 -> {1,1}, {2}
        // 3 -> {1, 1, 1}, {1, 2}, {2, 1}
        // 4 -> {1, 1, 1, 1}, {1, 1, 2}, {1, 2, 1}, {2, 1, 1}, {2, 2}
        // 5 -> {1, 1, 1, 1, 1}, {1, 1, 1, 2}, {1, 1, 2, 1}, {1, 2, 1, 1}, {2, 1, 1, 1}, {1, 2, 2}, {2, 1, 2}, {2, 2, 1}
        rootCount(new int[]{1, 2}, n);
        return count;
    }

    private static void rootCount(int[] nums, int remain) {
        if (remain == 0) {
            count++;
        }

        for (int num : nums) {
            if (remain - num < 0) {
                break;
            }

            rootCount(nums, remain - num);
        }
    }
//    Runtime: 1 ms, faster than 9.96%
//    Memory Usage: 40.9 MB, less than 50.83%
    public static int climbStairs2(int n) {
        int count = 1;
        int i = n / 2;

        // n-i C i
        while (i > 0) {
            int l = n - i;
            int r = 1;
            int multiplyCount = Math.min(i,  n - i);

            //나눗셈일 경우 자료형 확인!
            double multiply = 1;

            while (multiplyCount > 0) {
                multiply = multiply * l / r;
                l--;
                r++;
                multiplyCount--;
            }

            count += multiply;
            i--;
        }

        return count;
    }

//    Time Limit Exceeded
    public static int climbStairs3(int n) {
        if (n < 3) {
            return n;
        }

        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 41.5 MB, less than 11.58%
    public static int climbStairs4(int n) {
        int[] memo = new int[n + 1];

        return climbStairs2(memo, n);
    }

    private static int climbStairs1(int[] memo, int n) {
        if (n < 3) {
            return n;
        }

        if (memo[n] > 0) {
            return memo[n];
        } else {
            return memo[n] = climbStairs1(memo, n-1) + climbStairs1(memo, n-2);
        }

    }
//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 40.6 MB, less than 67.27%
    private static int climbStairs2(int[] memo, int n) {
        if (n < 3) {
            return n;
        }

        int p = 1;
        int c = 2;
        int t;
        for (int i = 3; i <= n; i++) {
            t = p + c;
            p = c;
            c = t;
        }

        return c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(climbStairs4(Integer.parseInt(br.readLine())));
    }
}

