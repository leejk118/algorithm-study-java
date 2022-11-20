package main.day1121;

public class leetcode_2299_jklee {
    private static final Character[] SPECIAL_CHARACTERS = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};

    public boolean strongPasswordCheckerII(String password) {
        boolean isIncludeLowercase = false, isIncludeUpperCase = false,
                isIncludeDigit = false, isIncludeSpecialCharacter = false, isContainAdjacent = false;

        if (password.length() < 8) {
            return false;
        }

        Character ch;
        for (int i = 0, length = password.length(); i < length; ++i) {
            ch = password.charAt(i);

            if (!isIncludeDigit && ('0' <= ch && ch <= '9')) {
                isIncludeDigit = true;
            }
            if (!isIncludeLowercase && ('a' <= ch && ch <= 'z')) {
                isIncludeLowercase = true;
            }
            if (!isIncludeUpperCase && ('A' <= ch && ch <= 'Z')) {
                isIncludeUpperCase = true;
            }
            if (!isIncludeSpecialCharacter) {
                for (Character sc : SPECIAL_CHARACTERS) {
                    if (sc == ch) {
                        isIncludeSpecialCharacter = true;
                        break;
                    }
                }
            }
            if (!isContainAdjacent) {
                if (i == 0) continue;
                if (password.charAt(i - 1) == ch) {
                    isContainAdjacent = true;
                }
            }
        }
        return isIncludeDigit && isIncludeLowercase && isIncludeUpperCase && isIncludeSpecialCharacter && !isContainAdjacent;
    }


    public static void main(String[] args) {
        String[] password = {"IloveLe3tcode!", "Me+You--IsMyDream", "1aB!"};

        for (String pw : password) {
            System.out.println(new leetcode_2299_jklee().strongPasswordCheckerII(pw));
        }
    }
}
