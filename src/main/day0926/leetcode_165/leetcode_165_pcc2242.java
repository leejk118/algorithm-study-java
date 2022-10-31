package main.day0926.leetcode_165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_165_pcc2242 {
    /**
     * https://leetcode.com/problems/compare-version-numbers/
     *
     * 165. Compare Version Numbers
     *
     */

//    Runtime: 2 ms, faster than 65.72%
//    Memory Usage: 41.8 MB, less than 75.09%
    public static int compareVersion(String version1, String version2) {
        String[] part1 = version1.split("\\.");
        String[] part2 = version2.split("\\.");
        int limitIndex = Math.max(part1.length, part2.length);

        for (int i = 0; i < limitIndex; i++) {
            int value1 = i > part1.length - 1 ? 0 : Integer.parseInt(part1[i]);
            int value2 = i > part2.length - 1 ? 0 : Integer.parseInt(part2[i]);

            if (value1 > value2) {
                return 1;
            } else if (value1 < value2){
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(compareVersion(br.readLine(), br.readLine()));
    }
}

