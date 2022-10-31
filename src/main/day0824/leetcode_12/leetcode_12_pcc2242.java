package main.day0824.leetcode_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_12_pcc2242 {
    /**
     * https://leetcode.com/problems/integer-to-roman/
     *
     * 12. Integer to Roman
     * Given an integer, convert it to a roman numeral.
     */

    //6ms, 45.8MB
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int[] valArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int index = 0;
        int crt;
        while (num > 0) {
            crt = valArr[index];
            if (num > crt - 1) {
                appendValue(sb, valArr[index]);
                num -= crt;
            } else {
                index++;
            }
        }
        return sb.toString();
    }

    private static void appendValue(StringBuilder sb, int value){
        switch (value) {
            case 1000 : sb.append("M"); break;
            case 900 : sb.append("CM"); break;
            case 500 : sb.append("D"); break;
            case 400 : sb.append("CD"); break;
            case 100 : sb.append("C"); break;
            case 90 : sb.append("XC"); break;
            case 50 : sb.append("L"); break;
            case 40 : sb.append("XL"); break;
            case 10 : sb.append("X"); break;
            case 9 : sb.append("IX"); break;
            case 5 : sb.append("V"); break;
            case 4 : sb.append("IV"); break;
            case 1 : sb.append("I"); break;
        }
    }

    //11ms, 49.3MB
    public static String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();

        int[] valArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        HashMap<Integer, String> map = new HashMap<>() {{
            put(1, "I"); put(5, "V"); put(10, "X"); put(50, "L"); put(100, "C"); put(500, "D"); put(1000, "M");
            put(4, "IV"); put(9, "IX"); put(40, "XL"); put(90, "XC"); put(400, "CD"); put(900, "CM");
        }};
        int index = 0;
        int crt;
        while (num > 0) {
            crt = valArr[index];
            if (num > crt - 1) {
                sb.append(map.get(crt));
                num -= crt;
            } else {
                index++;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());

        System.out.println(i);
        System.out.println(intToRoman2(i));
    }
}

