package main.day0831.leetcode_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_39_pcc2242 {
    /**
     * https://leetcode.com/problems/combination-sum/
     *
     * 39. Combination Sum
     *  return a list of all unique combinations of candidates where the chosen numbers sum to target
     */

//    Runtime: 3 ms, faster than 95.48%
//    Memory Usage: 45 MB, less than 75.79%
    private static List<List<Integer>> answer;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();

        backtracking(candidates, target, 0, 0, combination);

        return answer;
    }

    private static void backtracking(int[] candidates, int target, int total, int start, ArrayList<Integer> combination) {
        if (total == target) {
            answer.add(new ArrayList<>(combination));
        } else {
            int value;

            for (int i = start; i < candidates.length; i++) {
                value = candidates[i];
                if (total + value > target) {
                    continue;
                }

                combination.add(value);
                backtracking(candidates, target, total + value, i, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }


    private static void test(int[] candidates) {
        List<List<Integer>> newList = new ArrayList<>();
        List<List<Integer>> combList = new ArrayList();
        combList.add(Arrays.asList(candidates[0]));

        newList.add(Arrays.asList(candidates[0]));

        System.out.println(combList);
    }


    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        test(candidates1);
//        System.out.println(combinationSum(candidates2, target2));
    }
}

