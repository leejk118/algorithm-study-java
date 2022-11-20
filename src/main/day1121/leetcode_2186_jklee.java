package main.day1121;

public class leetcode_2186_jklee {
    public int minSteps(String s, String t) {
        int answer = 0;
        int[] sCount = new int [26], tCount = new int [26];

        for (char ch : s.toCharArray()) {
            sCount[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCount[ch - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            answer += Math.abs(sCount[i] - tCount[i]);
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] s = {"leetcode", "night"};
        String[] t = {"coats", "thing"};

        for (int i = 0; i < s.length; ++i) {
            System.out.println(new leetcode_2186_jklee().minSteps(s[i], t[i]));
        }
    }
}