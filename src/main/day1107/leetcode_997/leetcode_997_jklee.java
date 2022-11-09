package main.day1107.leetcode_997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class leetcode_997_jklee {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;

        HashMap<Integer, HashSet<Integer>> trustInfo = new HashMap<>();

        for (int[] t : trust) {
            if (trustInfo.containsKey(t[1])) {
                HashSet<Integer> set = trustInfo.get(t[1]);
                set.add(t[0]);
                trustInfo.put(t[1], set);
            } else {
                trustInfo.put(t[1], new HashSet<Integer>() {{
                    add(t[0]);
                }});
            }
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry : trustInfo.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue().size() == n - 1) {
                boolean isExist = true;
                for (int a : entry.getValue()) {
                    if (trustInfo.containsKey(a) && trustInfo.get(a).contains(key)) {
                        isExist = false;
                        break;
                    }
                }
                if (isExist) {
                    return key;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] n = {2, 3, 3, 4};
        int[][][] trust = {
                {{1, 2}},
                {{1, 3}, {2, 3}},
                {{1, 3}, {2, 3}, {3, 1}},
                {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}
        };
        for (int i = 0; i < n.length; ++i) {
            System.out.println(new leetcode_997_jklee().findJudge(n[i], trust[i]));
        }
    }
}
