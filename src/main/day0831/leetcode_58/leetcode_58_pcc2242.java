package main.day0831.leetcode_58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_58_pcc2242 {
    /**
     * https://leetcode.com/problems/length-of-last-word/
     *
     * 58. Length of Last Word
     *  A word is a maximal substring consisting of non-space characters only.
     */

    // 1ms (54.0 %),  42.4MB (42.95%)
    public static int lengthOfLastWord1(String s) {
       String[] strings = s.split(" ");
       return strings[strings.length - 1].length() ;
    }

    // 0ms (100%), 41.9MB (75.69%)
    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }

    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 42.1 MB, less than 62.03%..?
    public static int lengthOfLastWord3(String s) {
        s = s.trim();
        return s.length() - (s.lastIndexOf(" ") + 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(lengthOfLastWord3(s));
    }
}

