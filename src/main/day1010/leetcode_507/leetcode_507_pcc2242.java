package main.day1010.leetcode_507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_507_pcc2242 {
    /**
     * https://leetcode.com/problems/perfect-number/
     *
     * 507. Perfect Number
     *
     * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
     * A divisor of an integer x is an integer that can divide x evenly.
     * Given an integer n, return true if n is a perfect number, otherwise return false.
     *
     */

//    Runtime 753 ms Beats 18.1%
//    Memory 39.2 MB Beats 86.85%
    public static boolean checkPerfectNumber(int num) {
        // num == x * y;
        int x = 1;
        int y = num;

        if (x == num) {
            return false;
        }
        int remain = num - x;
        while (++x < y) {
            if (num % x == 0) {
                y = num / x;
                remain -= x + y;
            }

            if (remain < 0) {
                return false;
            }
        }

        return remain == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(checkPerfectNumber(Integer.parseInt(br.readLine())));
    }
}

