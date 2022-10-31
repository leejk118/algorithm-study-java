package main.day0919.leetcode_205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class leetcode_205_pcc2242 {
    /**
     * https://leetcode.com/problems/isomorphic-strings/description/
     *
     * 205. Isomorphic Strings
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t
     */

//    Runtime: 8 ms, faster than 78.13%
//    Memory Usage: 43.1 MB, less than 52.20%
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char n;
        char m;
        Character value;

        for (int i = 0; i < s.length(); i++) {
            n = s.charAt(i);
            m = t.charAt(i);
            value = map.get(n);

            if (value == null) {
                if (map.containsValue(m)) {
                    return false;
                }
                map.put(n, m);
                continue;
            }

            if (value != m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(isIsomorphic(s, t));
    }
}

