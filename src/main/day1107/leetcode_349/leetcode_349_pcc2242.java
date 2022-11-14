package main.day1107.leetcode_349;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_349_pcc2242 {
    /**
     * https://leetcode.com/problems/intersection-of-two-arrays/
     *
     * 349. Intersection of Two Arrays
     *
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     */

//    Runtime 3 ms Beats 89.3%
//    Memory 42.1 MB Beats 96.22%
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<>();

        int start = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = start; j < nums2.length; j++) {
                if (nums1[i] > nums2[j]) {
                    start = j;
                } else if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    start = j;
                    break;
                } else {
                    break;
                }
            }
        }

        int i = 0;
        int[] answer = new int[set.size()];
        for (int num : set) {
            answer[i] = num;
            i++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(intersection(new int[]{9,3,7}, new int[]{6,4,1,0,0,4,4,8,7}));
    }
}

