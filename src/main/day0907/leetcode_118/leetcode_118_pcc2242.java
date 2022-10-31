package main.day0907.leetcode_118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class leetcode_118_pcc2242 {
    /**
     * https://leetcode.com/problems/pascals-triangle/
     *
     * 118. Pascal's Triangle
     *
     */

//    Runtime: 1 ms, faster than 73.34%
//    Memory Usage: 42.5 MB, less than 5.50%
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> answer= new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            if (i == 0) {
                row.add(1);
                answer.add(row);
                continue;
            }

            List<Integer> prev = answer.get(i - 1);

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(prev.get(j - 1) + prev.get(j));
            }
            answer.add(row);
        }

        return answer;
    }

//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 42.2 MB, less than 15.27%
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> prevRow = null;

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            answer.add(row);
            prevRow = row;
        }

        return answer;
    }


        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(generate2(Integer.parseInt(br.readLine())));
    }
}

