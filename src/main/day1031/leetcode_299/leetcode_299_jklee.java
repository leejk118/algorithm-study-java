package main.day1031.leetcode_299;

public class leetcode_299_jklee {
    public String getHint(String secret, String guess) {
        int bullCount = 0, cowCount = 0;
        int[] sCount = new int [10], gCount = new int [10];

        for (Character ch : secret.toCharArray()) {
            sCount[ch - '0']++;
        }
        for (Character ch : guess.toCharArray()) {
            gCount[ch - '0']++;
        }

        for (int i = 0; i < secret.length(); ++i) {
            Character sChar = secret.charAt(i), gChar = guess.charAt(i);
            if (sChar == gChar && sCount[sChar - '0'] > 0 && gCount[gChar - '0'] > 0) {
                sCount[sChar - '0']--;
                gCount[sChar - '0']--;
                bullCount++;
            }
        }
        for (int i = 0; i < 10; ++i) {
            cowCount += Math.min(sCount[i], gCount[i]);
        }
        return bullCount + "A" + cowCount + "B";
    }


    public static void main(String[] args) {
        String[] secret = {"1807", "1123", "11"}, guess = {"7810", "0111", "01"};
        for (int i = 0; i < secret.length; ++i) {
            System.out.println(new leetcode_299_jklee().getHint(secret[i], guess[i]));
        }
    }
}
