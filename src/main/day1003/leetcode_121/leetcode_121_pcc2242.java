package main.day1003.leetcode_121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class leetcode_121_pcc2242 {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * 121. Best Time to Buy and Sell Stock
     *
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     */

    //Time Limit Exceeded
    public static int maxProfit(int[] prices) {
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                answer = Math.max(answer, prices[i] - prices[j]);
            }
        }

        return answer;
    }
//    Runtime: 2 ms, faster than 93.74%
//    Memory Usage: 59 MB, less than 93.30%
    public static int maxProfit2(int[] prices) {
        int answer = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            answer = Math.max(answer, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }

        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,6,4,3,2,1}));

    }
}

