package main.day0926.leetcode_78;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_78_pcc2242 {
    /**
     * https://leetcode.com/problems/subsets/
     *
     * 78. Subsets
     *
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     */

//    Runtime: 1 ms, faster than 89.63%
//    Memory Usage: 43.4 MB, less than 52.22%
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        backtracking(nums, answer, new ArrayList<>(), 0);
        return answer;
    }

    private static void backtracking(int[] nums, List<List<Integer>> answer, List<Integer> combination, int start) {
        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            answer.add(new ArrayList<>(combination));
            backtracking(nums, answer, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(subsets(new int[]{1,2,3}));
    }
}

