package main.day0824.leetcode_387;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

class leetcode_387_pcc2242 {
    /**
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     *
     * 387. First Unique Character in a String
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     */


    // 51ms , 54.6MB

    public static int firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            // map.containsKey(c) ? map.get(c) + 1 : 1  >> 51 ms
//             map.getOrDefault(c, 0) + 1 >> 41ms
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .map(s::indexOf)
                .orElse(-1);
    }

    // 67ms, 53.7MB
    public static int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 9ms, 48.3MB
    public static int firstUniqChar3(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(firstUniqChar2(s));
    }
}

