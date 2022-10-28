package main.day1031.leetcode_290;

import java.util.HashMap;

public class leetcode_290_jklee {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, String> patternInfo = new HashMap<>(), wordInfo = new HashMap<>();
        String[] wordList = s.split(" ");

        if (pattern.length() != wordList.length) {
            return false;
        }

        for (int i = 0, length = pattern.length(); i < length; ++i) {
            String key = pattern.charAt(i) + "";
            if (patternInfo.containsKey(key)) {
                if (!patternInfo.get(key).equals(wordList[i])) {
                    return false;
                }
            } else {
                if (wordInfo.containsKey(wordList[i])) {
                    return false;
                }
                patternInfo.put(key, wordList[i]);
                wordInfo.put(wordList[i], key);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] patterns = { "abba", "abba", "aaaa", "abba", "abc", "aaa"};
        String[] words = {"dog cat cat dog", "dog cat cat fish", "dog cat cat dog", "dog dog dog dog", "b c a", "aa aa aa aa"};

        for (int i = 0; i < patterns.length; ++i) {
            System.out.println(new leetcode_290_jklee().wordPattern(patterns[i], words[i]));
        }
    }
}
