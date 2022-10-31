package main.day0912.leetcode_136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_136_pcc2242 {
    /**
     * https://leetcode.com/problems/single-number/
     *
     * 136. Single Number
     * every element appears twice except for one. Find that single one.
     */

//    Runtime: 12 ms, faster than 31.75%
//    Memory Usage: 51.3 MB, less than 28.02%
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

//    Runtime: 686 ms, faster than 5.00%
//    Memory Usage: 43.2 MB, less than 86.98%
    public static int singleNumber2(int[] nums) {
//        Runtime: 49 ms, faster than 7.93%
//        Memory Usage: 54.4 MB, less than 13.11%
//        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int num : nums) {
            if (al.contains(num)) {
                al.remove(Integer.valueOf(num));
            } else {
                al.add(num);
            }
        }

        return al.get(0);
    }


//    ------------solution
//    (1) 가환 연산(즉, a xor b = b xor a)입니다.
//    (2) xor 자체는 0입니다. 따라서 xor a = 0입니다.
//    (3) 0 xor a = a입니다. 이 세 가지 속성은 다음을 의미합니다.
//    a xor b xor a
//    = a xor a xor b
//    = 0 xor b = b.
//    Runtime: 2 ms, faster than 66.75%
//    Memory Usage: 50.7 MB, less than 48.60%
    public static int singleNumber3(int[] nums) {
        int result = 0;
        for(int i : nums) {
            System.out.println(Integer.toBinaryString(result));
            System.out.println(Integer.toBinaryString(i));

            result ^= i;

            System.out.println(Integer.toBinaryString(result));
            System.out.println(result);
            System.out.println();
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] nums = {7, 1, 2, 3, 1, 2, -1 , -1, 3};
        int[] nums2 = {1};
        System.out.println(singleNumber3(nums));
    }
}

