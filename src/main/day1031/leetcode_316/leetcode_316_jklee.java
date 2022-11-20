package main.day1031.leetcode_316;

import java.util.Stack;

public class leetcode_316_jklee {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] count = new int [26];
        boolean[] isVisited = new boolean[26];

        for (Character ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (Character ch : s.toCharArray()) {
            count[ch - 'a']--;

            if (st.empty()) {
                isVisited[ch - 'a'] = true;
                st.add(ch);
                continue;
            }
            if (isVisited[ch - 'a']) {
                continue;
            }
            while (!st.empty()) {
                char top = st.peek();
                int topIndex = top - 'a';

                if (top < ch || count[topIndex] == 0) {
                    isVisited[ch - 'a'] = true;
                    st.add(ch);
                    break;
                }

                isVisited[topIndex] = false;
                st.pop();

                if (st.empty()) {
                    isVisited[ch - 'a'] = true;
                    st.add(ch);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String[] testcase = {"cbacdcbc", "bcabc"};

        for (String tc : testcase) {
            System.out.println(new leetcode_316_jklee().removeDuplicateLetters(tc));
        }
    }
}
