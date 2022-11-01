package main.day1031.leetcode_290;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_290_pcc2242 {
    /**
     * https://leetcode.com/problems/word-pattern/
     *
     * 290. Word Pattern
     *
     * Given a pattern and a string s, find if s follows the same pattern.
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
     *
     */

//    Runtime 2 ms Beats 48.79%
//    Memory 41.2 MB Beats 82.60%
    public boolean wordPattern(String pattern, String s) {
        String[] parts = s.split(" ");

        if (parts.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        char[] patterns = pattern.toCharArray();
        for (int i = 0; i < patterns.length; i++) {
            char c = patterns[i];
            boolean containsKey = map.containsKey(c);
            if (!containsKey && !map.containsValue(parts[i])) {
                map.put(c, parts[i]);
                continue;
            }

            if (!containsKey || !map.get(c).equals(parts[i])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
    }
}

