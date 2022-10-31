package main.day0912.leetcode_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class leetcode_6_pcc2242 {
    /**
     * https://leetcode.com/problems/zigzag-conversion/
     *
     * 6. Zigzag Conversion
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

//    Runtime: 74 ms, faster than 13.58%
//    Memory Usage: 65 MB, less than 12.27%
    public static String convert(String s, int numRows) {
        int length = s.length();
        int term = numRows > 1 ? 2 * (numRows - 1) : 1;
        int colCount = (length / term + 1) * (1 + numRows - 2) > 0 ? (length / term + 1) * (1 + numRows - 2) : length;
        char[][] strings = new char[numRows][colCount];


        int row, col, characterColIndex;
        row = col = characterColIndex = 0;

        for (int i = 0; i < length; i++) {
            int temp = i % term;
            if (temp < numRows) {
                strings[row][col] = s.charAt(i);
            } else {
                for (int j = 0; j < numRows; j++) {
                    strings[row][col] = j == characterColIndex ? s.charAt(i) : 0;
                    row++;
                }
                characterColIndex--;
            }

            if(temp < numRows - 1) {
                characterColIndex = numRows - 2;
                row++;
            } else {
                row = 0;
                col++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] string : strings) {
            for (char c : string) {
                if (c != 0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

//    --------------solution
//    Runtime: 2 ms, faster than 100.00
//    Memory Usage: 42.5 MB, less than 97.83%
    public static String convert2(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        int len = s.length();
        int x = 2 * (numRows-1);
        int k =0;
        char[] c = new char[len];

        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < len; j = j + x) {
                c[k++] = s.charAt(j);

                if (i == 0 || i == numRows - 1) {
                    continue;
                }

                if(j + x - 2 * i < len) {
                    c[k++] = s.charAt(j + x - 2 * i);
                }

            }
            System.out.println(Arrays.toString(c));
        }
        return new String(c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int numRows = Integer.parseInt(br.readLine());
        System.out.println(convert2(s, numRows));
    }
}

