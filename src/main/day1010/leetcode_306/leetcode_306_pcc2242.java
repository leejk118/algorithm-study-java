package main.day1010.leetcode_306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_306_pcc2242 {
    /**
     * https://leetcode.com/problems/additive-number/
     *
     * 306. Additive Number
     *
     * An additive number is a string whose digits can form an additive sequence.
     * A valid additive sequence should contain at least three numbers.
     * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
     * Given a string containing only digits, return true if it is an additive number or false otherwise.
     * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
     *
     */

    public static boolean isAdditiveNumber(String num) {
        int length = num.length();

        if (length < 3) {
            return false;
        }

        ArrayList<Double> al = new ArrayList<>();
        int term = 1;
        int start = 0;

        while (true) {
            double first = Double.parseDouble(num.substring(start, start += term));
            double second = Double.parseDouble(num.substring(start, start +term));
            String sum = (first + second) + "";

            boolean isEqual = true;
            for (int i = 0; i < sum.length(); i++) {
                if(sum.charAt(i) != num.charAt(term + i)) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                break;
            }
        }

        //12358
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.MAX_VALUE);

        System.out.println(isAdditiveNumber(br.readLine()));

    }

}

