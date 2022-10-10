package main.day0926.leetcode_231;

public class leetcode_231_jklee {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        long sum = 1;
        while (true) {
            if (sum == n) return true;
            if (sum > n) return false;
            sum *= 2;
        }
    }


    public static void main(String[] args) {
        int[] testcase = {1, 16, 3};
        for (int tc: testcase) {
            System.out.println(new leetcode_231_jklee().isPowerOfTwo(tc));
        }
    }
}
