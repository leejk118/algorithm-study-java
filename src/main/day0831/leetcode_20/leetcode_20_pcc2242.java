package main.day0831.leetcode_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_20_pcc2242 {
    /**
     * https://leetcode.com/problems/valid-parentheses/
     *
     * 20. Valid Parentheses
     *  determine if the input string is valid Parentheses.
     */

//    public static boolean isValid(String s) {
//        int start = 0;
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            switch (s.charAt(i)) {
//                case '{' :
//                case '[' :
//                case '(' :
//                    count++;
//                    break;
//                default:
//                    count--;
//            }
//
//            if (count == 0) {
//                if (checkSubString(s, start, i)) {
//                    start = i + 1;
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        if (count != 0) {
//            return false;
//        }
//        return true;
//    }
//
//    private static boolean checkSubString(String s, int start, int end) {
//        while (start < end) {
//            int term = s.charAt(end--) - s.charAt(start++);
//
//            if (term != 2 && term != 1) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    Runtime: 1 ms, faster than 99.63%
//    Memory Usage: 40.4 MB, less than 92.32%
    public static boolean isValid(String s) {
        //stack.peek() -> stack 에서 읽어오기만 함
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')' :
                case ']' :
                case '}' :
                    if (stack.empty()) {
                        return false;
                    }

                    char before = stack.pop();
                    if (c - before != 2 && c - before != 1) {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(isValid(s));
    }
}

