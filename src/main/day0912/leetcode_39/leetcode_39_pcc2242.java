package main.day0912.leetcode_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class leetcode_39_pcc2242 {
    /**
     * https://leetcode.com/problems/count-and-say/
     *
     * 38. Count and Say
     */
//    Runtime: 4 ms, faster than 80.56%
//    Memory Usage: 39.4 MB, less than 99.98%
    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        String[] dp = new String[n + 1];
        dp[1] = "1";

        for (int i = 2; i <= n; i++) {
            char prv = dp[i-1].charAt(0);
            char cur;
            int count = 1;

            for(int j = 1; j < dp[i - 1].length(); j++) {
                cur = dp[i-1].charAt(j);

                if (prv == cur) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(prv);

                    count = 1;
                    prv = cur;
                }
            }

            sb.append(count);
            sb.append(prv);
            dp[i] = sb.toString();
            sb.setLength(0);
        }

        return dp[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(countAndSay(Integer.parseInt(br.readLine())));
    }
}

