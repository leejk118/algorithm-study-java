package main.day1114;

public class leetcode_392_jklee {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;

        int sPointer = 0, tPointer = 0;
        while (true) {
            if (tPointer == t.length() || sPointer == s.length()) {
                break;
            }
            if (t.charAt(tPointer) == s.charAt(sPointer)) {
                tPointer++;
                sPointer++;
            } else {
                tPointer++;
            }
        }
        return sPointer == s.length();
    }


    public static void main(String[] args) {
        String[] s = {"abc", "axc", "", "b"};
        String[] t = {"ahbgdc", "ahbgdc", "ahdkof", "abc"};

        for (int i = 0; i < s.length; ++i) {
            System.out.println(new leetcode_392_jklee().isSubsequence(s[i], t[i]));
        }
    }
}
