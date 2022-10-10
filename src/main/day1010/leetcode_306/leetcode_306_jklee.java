package main.day1010.leetcode_306;

public class leetcode_306_jklee {
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        boolean isAdditive = false;
        for (int i = 0; i <= length / 3; ++i) {
            if (isAdditive) break;
            for (int j = 0; j < (length - i) / 2; ++j) {
                if (isAdditive) break;
                if ((num.charAt(0) == '0' && i > 0)
                        || (num.charAt(i + 1) == '0' && j > 0)) continue;
                long firstNumber = Long.parseLong(num.substring(0, i + 1));
                long secondNumber = Long.parseLong(num.substring(i + 1, i + 1 + j + 1));
                isAdditive = checkAdditiveNumber(firstNumber, secondNumber, num);
            }
        }
        return isAdditive;
    }
    private boolean checkAdditiveNumber(long firstNumber, long secondNumber, String num) {
        int numLength = num.length();
        int startIndex = (int) (Math.log10(firstNumber == 0 ? 1 : firstNumber) + 1) + (int) (Math.log10(secondNumber == 0 ? 1 : secondNumber) + 1);

        if (startIndex >= numLength) {
            return false;
        }

        while (true) {
            if (startIndex >= numLength) break;

            int sumLength = (int) (Math.log10(firstNumber + secondNumber == 0 ? 1 : firstNumber + secondNumber) + 1);
            int endIndex = startIndex + sumLength;
            if (endIndex > numLength || startIndex >= endIndex) {
                return false;
            }
            long thirdNumber = Long.parseLong(num.substring(startIndex, endIndex));
            if (firstNumber + secondNumber != thirdNumber) {
                return false;
            }
            if (endIndex  == numLength - 1) break;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            startIndex = endIndex;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] testcase = {"111", "1999999999999999910000000000000000", "121474836472147483648", "10", "199111992", "000", "101", "112358", "199100199", "1",};
        for (String tc : testcase) {
            System.out.println(new leetcode_306_jklee().isAdditiveNumber(tc));
        }
    }
}
