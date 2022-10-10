package main.day0926.leetcode_263;

public class leetcode_263_jklee {
    private final int[] PRIME_NUMBERS = {2, 3, 5};

    public boolean isUgly(int n) {
        if (n == 0) return false;
        for (int i = 0; i < PRIME_NUMBERS.length; ++i) {
            while (n % PRIME_NUMBERS[i] == 0) {
                n /= PRIME_NUMBERS[i];
            }
        }
        return (n == 1);
    }


    public static void main(String[] args) {
        int[] testcase = {6, 1, 14, 0};

        for (int tc : testcase) {
            System.out.println(new leetcode_263_jklee().isUgly(tc));
        }
    }
}
