package main.day0926.leetcode_263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_263_pcc2242 {
    /**
     * https://leetcode.com/problems/ugly-number/
     *
     * 263. Ugly Number
     *
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     * Given an integer n, return true if n is an ugly number.
     */

//    Runtime: 1 ms, faster than 100.00%
//    Memory Usage: 39.6 MB, less than 89.07%
    public static boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }

        int i = 2;

        while(n > 1) {
            if (n % i == 0) {
                n /= i;
                continue;
            }

            i++;

            if (i > 5) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(isUgly(Integer.parseInt(br.readLine())));
    }
}

