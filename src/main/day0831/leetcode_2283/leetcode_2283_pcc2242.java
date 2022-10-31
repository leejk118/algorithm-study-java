package main.day0831.leetcode_2283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_2283_pcc2242 {
    /**
     * https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
     *
     * 2883. Check if Number Has Equal Digit Count and Digit Value
     *  Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num, otherwise return false.
     */

//    Runtime: 6 ms, faster than 13.02%
//    Memory Usage: 42.1 MB, less than 75.11%
    public static boolean digitCount1(String num) {
        int len = num.length();
        int[] numCounts = new int[len];
        int val;

        for (char c: num.toCharArray()) {
            val = Character.getNumericValue(c);

            if (val < len) {
                numCounts[val]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(numCounts).forEach(sb::append);
        return sb.toString().equals(num);
    }

//    Runtime: 1 ms, faster than 98.92%
//    Memory Usage: 41.9 MB, less than 78.20%
    public static boolean digitCount2(String num) {
        int len = num.length();
        int count;

        for (int i = 0; i < len; i++) {
            count = Character.getNumericValue(num.charAt(i));

            for (int j = 0; j < len; j++) {
                if (i == Character.getNumericValue(num.charAt(j))) {
                    count--;
                }
            }

            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(digitCount2(s));
    }
}

