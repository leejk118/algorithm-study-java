package main.day1010.leetcode_507;

import java.util.HashSet;
import java.util.Set;

public class leetcode_507_jklee {
    public boolean checkPerfectNumber(int num) {
        int sum = -num;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
        }
        for (int a : set) {
            sum += a;
        }
        return sum == num;
    }


    public static void main(String[] args) {
        int[] testcase = {99999997, 28, 7};
        for (int tc : testcase) {
            System.out.println(new leetcode_507_jklee().checkPerfectNumber(tc));
        }
    }
}
