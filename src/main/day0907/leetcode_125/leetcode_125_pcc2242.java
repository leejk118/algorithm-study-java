package main.day0907.leetcode_125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class leetcode_125_pcc2242 {
    /**
     * https://leetcode.com/problems/valid-palindrome/
     *
     * 125. Valid Palindrome
     * Given a string s, return true if it is a palindrome, or false otherwise.
     */

//    Runtime: 726 ms, faster than 31.25%
//    Memory Usage: 47.3 MB, less than 28.63%
    public static boolean isPalindrome1(String s) {

//        Runtime: 32 ms, faster than 40.39%
//        Memory Usage: 47 MB, less than 32.19%
//        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i = 0; i < s.length() / 2 ; i ++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

//    Runtime: 4 ms, faster than 90.47%
//    Memory Usage: 42.4 MB, less than 95.08%
    public static boolean isPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;
        int term = 'a' - 'A';

        while (l < r) {
            char lv = s.charAt(l);
            if (!Character.isAlphabetic(lv) && !Character.isDigit(lv)) {
                l++;
                continue;
            }

            char rv = s.charAt(r);
            if (!Character.isAlphabetic(rv) && !Character.isDigit(rv)) {
                r--;
                continue;
            }

            if ((Character.isAlphabetic(lv) && Character.isDigit(rv)) ||
                    (Character.isDigit(lv) && Character.isAlphabetic(rv))) {
                return false;
            }

            if (Math.abs(lv - rv) != term && Math.abs(lv - rv) != 0) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

//    --------------Solution
//    Runtime: 3 ms, faster than 99.00%
//    Memory Usage: 41.8 MB, less than 99.73%
    public static boolean isPalindrome3(String s) {
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

//    Runtime: 6 ms, faster than 68.18%
//    Memory Usage: 43.3 MB, less than 82.47%
    public static boolean isPalindrome4(String s) {
        int l = 0, r = s.length() - 1;
        char lc, rc;
        while(l <= r) {
            lc = s.charAt(l);
            rc = s.charAt(r);

            if (!Character.isLetterOrDigit(lc)) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(rc)) {
                r--;
                continue;
            }

            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(isPalindrome2(br.readLine()));
    }
}

