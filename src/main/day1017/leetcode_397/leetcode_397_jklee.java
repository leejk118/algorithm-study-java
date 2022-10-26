package main.day1017.leetcode_397;

public class leetcode_397_jklee {
    public int integerReplacement(int n) {
        return recursive(n);
    }

    private int recursive(long number) {
        if (number == 1) return 0;
        if (number % 2 == 0) {
            return recursive(number / 2) + 1;
        }
        return Math.min(recursive(number - 1) + 1, recursive(number + 1) + 1);
    }


    public static void main(String[] args) {
        int[] testcase = {2147483647, 8, 7, 4};
        for (int tc : testcase) {
            System.out.println(new leetcode_397_jklee().integerReplacement(tc));
        }
    }
}
