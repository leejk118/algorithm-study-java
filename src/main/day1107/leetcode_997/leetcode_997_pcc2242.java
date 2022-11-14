package main.day1107.leetcode_997;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class leetcode_997_pcc2242 {
    /**
     * https://leetcode.com/problems/find-the-town-judge/
     *
     * 997. Find the Town Judge
     *
     */

//    Runtime 2 ms Beats 99.54%
//    Memory 69.2 MB Beats 69.40%
    public int findJudge(int n, int[][] trust) {
        boolean[] trustCheck = new boolean[n + 1];
        int[] countCheck = new int[n + 1];

        for (int[] ints : trust) {
            trustCheck[ints[0]] = true;
            countCheck[ints[1]]++;
        }

        for (int i = 1; i < trustCheck.length; i++) {
            if (!trustCheck[i] && countCheck[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}

