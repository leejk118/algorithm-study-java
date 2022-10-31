package main.day0907.leetcode_242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_242_pcc2242 {
    /**
     * https://leetcode.com/problems/valid-anagram/
     *
     * 242. Valid Anagram
     *  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     *  typically using all the original letters exactly once.
     */

//    Runtime: 9 ms, faster than 38.41%
//    Memory Usage: 44.7 MB, less than 39.43%
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] inputS = s.toCharArray();
        char[] inputT = t.toCharArray();
        Arrays.sort(inputS);
        Arrays.sort(inputT);

        for(int i = 0; i < inputS.length; i++) {
            if (inputS[i] != inputT[i]) {
                return false;
            }
        }

        return true;
    }
//    X
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int num = 0;

        for (char c : s.toCharArray()) {
            num += Math.pow(c, 2) + c;
        }

        for (char c : t.toCharArray()) {
            num -= Math.pow(c, 2) + c;

        }

        return num == 0;
    }

//    Runtime: 4 ms, faster than 84.88%
//    Memory Usage: 44.1 MB, less than 48.58%
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }


//        Runtime: 4 ms, faster than 84.88%
//        Memory Usage: 43.9 MB, less than 54.82%
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i) - 'a']++;
//            count[t.charAt(i) - 'a']--;
//        }

        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        System.out.println(isAnagram2(s, t));
    }
}

