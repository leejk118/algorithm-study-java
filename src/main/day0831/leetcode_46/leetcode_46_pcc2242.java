package main.day0831.leetcode_46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class leetcode_46_pcc2242 {
    /**
     * https://leetcode.com/problems/permutations/
     *
     * 46. Permutations
     *  return all the possible permutations.
     */

    public static List<List<Integer>> answer;
    private static int BLOCK = 11;
//    public static int[] nums;

//    Runtime: 5 ms, faster than 14.47%
//    Memory Usage: 45.5 MB, less than 9.12%
    public static List<List<Integer>> permute1(int[] nums) {
        answer = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.stream(nums).forEach(list::add);
        addNums1(list, new ArrayList<>());
        return answer;
    }

    private static void addNums1(ArrayList<Integer> nums, ArrayList<Integer> target) {
        for (int i = 0; i < nums.size(); i++) {
            ArrayList<Integer> cloneTarget = (ArrayList<Integer>) target.clone();
            ArrayList<Integer> cloneNums = (ArrayList<Integer>) nums.clone();
            cloneTarget.add(cloneNums.get(i));
            cloneNums.remove(i);
            if (cloneNums.size() == 0) {
                answer.add(cloneTarget);
            }
            addNums1(cloneNums, cloneTarget);
        }
    }


//    Runtime: 1 ms, faster than 98.35%
//    Memory Usage: 44.5 MB, less than 71.64%
    public static List<List<Integer>> premute2(int[] nums) {
        answer = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        dfs(new ArrayList<>(), check, nums);
        return answer;
    }

    private static void dfs(ArrayList<Integer> list, boolean[] check, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == nums.length) {
                answer.add(new ArrayList<>(list));
                break;
            }

            if (check[i]) {
                continue;
            }

            list.add(nums[i]);
            check[i] = true;
            dfs(list, check, nums);

            list.remove(list.size() - 1);
            check[i] = false;
        }
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input1 = {1,2,3,3,4};

//        System.out.println(permute1(input1));
        System.out.println(subsets(input1));

    }


}