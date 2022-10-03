package year2022.day0926.leetcode_165;

public class leetcode_165_jklee {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\."), ver2 = version2.split("\\.");
        int length = Math.max(ver1.length, ver2.length);
        for (int i = 0; i < length; ++i) {
            int ver1Number = ver1.length > i ? Integer.parseInt(ver1[i]) : 0;
            int ver2Number = ver2.length > i ? Integer.parseInt(ver2[i]) : 0;

            if (ver1Number > ver2Number) {
                return 1;
            } else if (ver1Number < ver2Number) {
                return -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String[][] testcase = {
                {"1.01", "1.001"},
                {"1.0", "1.0.0"},
                {"0.1", "1.1"},
                {"1.1", "1.1.9.24"}
        };

        for (String[] tc : testcase) {
            System.out.println(new leetcode_165_jklee().compareVersion(tc[0], tc[1]));
        }
    }
}
