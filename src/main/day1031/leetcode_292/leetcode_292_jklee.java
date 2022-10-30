package main.day1031.leetcode_292;

public class leetcode_292_jklee {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }


    public static void main(String[] args) {
        int[] testcase = { 4, 1, 8, 9, 20};
        for (int tc : testcase) {
            System.out.println(new leetcode_292_jklee().canWinNim(tc));
        }
    }
}
