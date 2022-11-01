package main.day1031.leetcode_292;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_292_pcc2242 {
    /**
     * https://leetcode.com/problems/nim-game/
     *
     * 292. Nim Game
     *
     * You are playing the following Nim Game with your friend:
     *
     * Initially, there is a heap of stones on the table.
     * You and your friend will alternate taking turns, and you go first.
     * On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
     * The one who removes the last stone is the winner.
     * Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally,
     * otherwise return false.
     *
     */

//    Runtime 0 ms Beats 100%
//    Memory 40.3 MB Beats 78.38%
    public static boolean canWinNim(int n) {
            return n % 4 != 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(canWinNim(8));
    }
}

