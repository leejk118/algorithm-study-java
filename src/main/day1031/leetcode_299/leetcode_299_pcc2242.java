package main.day1031.leetcode_299;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_299_pcc2242 {
    /**
     * https://leetcode.com/problems/bulls-and-cows/
     *
     * 299. Bulls and Cows
     *
     * You are playing the Bulls and Cows game with your friend.
     * You write down a secret number and ask your friend to guess what the number is.
     * When your friend makes a guess, you provide a hint with the following info:
     * The number of "bulls", which are digits in the guess that are in the correct position.
     * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
     * Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
     * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
     * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
     * Note that both secret and guess may contain duplicate digits.
     *
     */

//    Runtime 8 ms Beats 82.45%
//    Memory 43.1 MB Beats 40.11%
    public static String getHint(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;
        char secretChar = ' ';
        char guessChar = ' ';
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            secretChar = secret.charAt(i);
            guessChar = guess.charAt(i);
            if (secretChar == guessChar) {
                aCount++;
            } else {
                secretArr[secretChar - '0']++;
                guessArr[guessChar - '0']++;
            }
        }

        for (int i = 0; i < secretArr.length; i++) {
            bCount += Math.min(secretArr[i], guessArr[i]);
        }

        return aCount + "A" + bCount + "B";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(getHint(br.readLine(), br.readLine()));
    }
}

