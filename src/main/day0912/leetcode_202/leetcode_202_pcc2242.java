package main.day0912.leetcode_202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class leetcode_202_pcc2242 {
    /**
     * https://leetcode.com/problems/happy-number/
     *
     * 202. Happy Number
     * A happy number is a number defined by the following process:
     *
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy
     */
//    Runtime: 1 ms, faster than 98.68%
//    Memory Usage: 39.4 MB, less than 95.45%
    public static boolean isHappy(int n) {
        int sum;
        int remain = n;
        HashSet<Integer> results = new HashSet<>();
        while (true) {
            sum = 0;
            while (remain > 0) {
                sum += Math.pow(remain % 10, 2);
                remain = remain / 10;
            }

            if (sum == 1) {
                return true;
            }

            if (results.contains(sum)) {
                return false;
            }
            results.add(sum);
            remain = sum;
        }
    }

    //--------solution
//    Floyd Cycle Detection 알고리즘(빠르고 느린 포인터)
//    Runtime: 2 ms, faster than 67.71%
//    Memory Usage: 40.6 MB, less than 82.36%
    public static int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy2(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if(fast == 1) {
                return true;
            }
        } while(slow != fast);
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(isHappy(Integer.parseInt(br.readLine())));
    }
}

