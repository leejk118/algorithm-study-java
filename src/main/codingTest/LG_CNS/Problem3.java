package main.codingTest.LG_CNS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public int Solution(String reference, String track) {
        int subLength = reference.length();
        Set<String> subSet = new HashSet<>();
        int[] dp = new int [track.length() + 1];
        dp[1] = 1;

        for (int i = 1; i <= reference.length(); ++i) {
            for (int j = 0; j <= reference.length() - i; ++j) {
                subSet.add(reference.substring(j, j + i));
            }
        }

        for (int i = 2; i < dp.length; ++i) {
            for (int j = 0; j < subLength; ++j) {
                if (subLength > i) break;
                String subStr = reference.substring((reference.length() - subLength + j));
                if (subSet.contains(subStr)) {
                    dp[i] = dp[i - subStr.length()] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[track.length()];
    }

    public static void main(String[] args) {
        String[] reference = {"abc", "vxrvip"};
        String[] track = {"bcab", "xrviprvipvxrv"};
        for (int i = 0; i < reference.length; ++i) {
            System.out.println(new Problem3().Solution(reference[i], track[i]));
        }
    }
}
