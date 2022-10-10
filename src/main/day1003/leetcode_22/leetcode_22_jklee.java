package main.day1003.leetcode_22;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22_jklee {
    private List<String> answer;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        char[] charArray = new char [n * 2];
        dfs(0, n * 2, charArray);
        return answer;
    }
    private void dfs(int index, int length, char[] charArray) {
        if (index == length) {
            answer.add(new String(charArray));
            return ;
        }
        for (int i = index; i < length; ++i) {
            if (possibleOpen(charArray, i, length / 2)) {
                charArray[i] = '(';
                dfs(i + 1, length, charArray);
            }
            if (possibleClose(charArray, i, length / 2)) {
                charArray[i] = ')';
                dfs(i + 1, length, charArray);
            }
            return;
        }
    }
    private boolean possibleOpen(char[] ch, int index, int n) {
        int leftNum = 0;
        for (int i = 0; i < index; ++i) {
            if (ch[i] == '(') {
                leftNum++;
            }
        }
        return leftNum < n;
    }
    private boolean possibleClose(char[] ch, int index, int n) {
        int leftNum = 0, rightNum = 0;
        for (int i = 0; i < index; ++i) {
            if (ch[i] == '(') {
                leftNum++;
            }
            if (ch[i] == ')') {
                rightNum++;
            }
        }
        return leftNum > rightNum;
    }


    public static void main(String[] args) {
        int[] testcase = {3, 1, 8};

        for (int tc : testcase) {
            System.out.println(new leetcode_22_jklee().generateParenthesis(tc));
        }
    }
}
