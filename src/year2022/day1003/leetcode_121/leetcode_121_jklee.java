package year2022.day1003.leetcode_121;

public class leetcode_121_jklee {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        for (int i = 0, length = prices.length; i < length; ++i) {
            if (i != length - 1 && prices[i] < prices[i + 1]) {
                buyPrice = Math.min(buyPrice, prices[i]);
                continue;
            }
            if (buyPrice != Integer.MAX_VALUE && prices[i] - buyPrice > maxProfit) {
                maxProfit = prices[i] - buyPrice;
            }
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1},
                {7, 3, 2, 3, 5, 4, 6, 4, 3, 1, 5, 6, 8, 9, 1, 22},
                {2, 1, 2, 1, 0, 1, 2},
                {2, 1, 2, 0, 1}
        };

        for (int[] tc : testcase) {
            System.out.println(new leetcode_121_jklee().maxProfit(tc));
        }
    }
}
