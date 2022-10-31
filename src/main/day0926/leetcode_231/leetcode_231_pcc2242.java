package main.day0926.leetcode_231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_231_pcc2242 {
    /**
     * https://leetcode.com/problems/power-of-two/
     *
     * 231. Power of Two
     *
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     * An integer n is a power of two, if there exists an integer x such that n == 2x.
     */

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (true) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }

            n /= 2;
        }
    }

    // solutions

    public static boolean isPowerOfTwo2(int n) {
        // 2 = 10
        // 16 = 1000
//        return n>0 && Integer.bitCount(n) == 1;

        // 2 = 10 / 1 = 01 => 00
        // 8 = 1000 / 7 = 0111 => 0000
        return ( (n & (n-1)) == 0 && n>0);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(isPowerOfTwo2(Integer.parseInt(br.readLine())));
    }
}

