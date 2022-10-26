package main.day1017.leetcode_274;

import java.util.Arrays;

public class leetcode_274_jklee {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = 1, length = citations.length; i <= length; ++i) {
            if (citations[length - i] < i) break;
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {3, 0, 6, 1, 5},
                {1, 3, 1},
        };
        for (int[] tc : testcase) {
            System.out.println(new leetcode_274_jklee().hIndex(tc));
        }
    }
}
