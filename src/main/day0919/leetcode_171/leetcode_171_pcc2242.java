package main.day0919.leetcode_171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class leetcode_171_pcc2242 {
    /**
     * https://leetcode.com/problems/excel-sheet-column-number/description/
     *
     * 171. Excel Sheet Column Number
     * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
     */

//    Runtime: 2 ms, faster than 81.00%
//    Memory Usage: 42.9 MB, less than 36.32%
    public static int titleToNumber(String columnTitle) {
        int answer = 0;
        int length = columnTitle.length();
        final int TERM = 26;
        for (int i = 0; i < length; i++) {
            answer += Math.pow(TERM, length - i - 1) * (columnTitle.charAt(i) - 'A' + 1) ;
        }

        return answer;
    }

//    Runtime: 2 ms, faster than 81.00%
//    Memory Usage: 43.2 MB, less than 20.79%
    public static int titleToNumber2(String columnTitle) {
        int answer = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            answer *= 26;
            answer += columnTitle.charAt(i) - 'A' + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(titleToNumber2(s));
    }
}

