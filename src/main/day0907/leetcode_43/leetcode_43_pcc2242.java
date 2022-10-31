package main.day0907.leetcode_43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class leetcode_43_pcc2242 {
    /**
     * https://leetcode.com/problems/multiply-strings/
     *
     * 43. Multiply Strings
     */

//    Runtime: 9 ms, faster than 58.60%
//    Memory Usage: 43.1 MB, less than 51.51%
    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int nums = 0;
        int length1 = num1.length();
        int length2 = num2.length();

        while (length2 + length1 - nums - 2 > -1) {
            for (int i = Math.max(nums - length2 - 1, 0) ; i < length2; i++) {
                if (length1 - 1 + i - nums < 0) {
                    continue;
                }
                sum += (num2.charAt(length2 - 1 - i) - '0') * (num1.charAt(length1 - 1 + i - nums) - '0');
                if (nums == i) {
                    break;
                }
            }
            sb.insert(0, sum % 10);
            sum /=  10;
            nums++;
        }
        if (sum > 0) {
            sb.insert(0, sum);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num1 = br.readLine();
        String num2 = br.readLine();
        System.out.println(multiply1(num1, num2));
    }
}

