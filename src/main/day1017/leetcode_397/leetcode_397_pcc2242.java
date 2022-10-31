package main.day1017.leetcode_397;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_397_pcc2242 {
    /**
     * https://leetcode.com/problems/integer-replacement/
     *
     * 397. Integer Replacement
     *
     * Given a positive integer n, you can apply one of the following operations:
     * If n is even, replace n with n / 2.
     * If n is odd, replace n with either n + 1 or n - 1.
     * Return the minimum number of operations needed for n to become 1.
     *
     */

//    Runtime 0 ms Beats 100%
//    Memory 40.3 MB Beats 79.98%
    public static int integerReplacement(int n) {
        int count = 0;
        double d = n;

        while (d != 1) {
            if (d % 2 != 0) {
                if ( d % 4 == 3 && d > 3) {
                    d++;
                } else {
                    d--;
                }
                count++;
            }
            d = (int) (d / 2);
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(integerReplacement(Integer.parseInt(br.readLine())));
    }
}

