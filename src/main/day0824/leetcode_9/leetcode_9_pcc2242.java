package main.day0824.leetcode_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_9_pcc2242 {
    /**
     * https://leetcode.com/problems/palindrome-number/
     *
     * 9. Palindrome Number
     * An integer is a palindrome when it reads the same backward as forward.
     */

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String intValue = String.valueOf(x);
        int len = intValue.length();
        int i = 0;
        while (i < len / 2) {
            if (intValue.charAt(i) != intValue.charAt(len - 1 - i)) {
                return false;
            }
            i++;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());

        System.out.println(i);
        System.out.println(isPalindrome(i));
    }
}

