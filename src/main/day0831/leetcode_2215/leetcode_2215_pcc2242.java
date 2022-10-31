package main.day0831.leetcode_2215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class leetcode_2215_pcc2242 {
    /**
     * https://leetcode.com/problems/find-the-difference-of-two-arrays/
     *
     * 2215. Find the Difference of Two Arrays
     *  return a list answer of size 2 where:
     *
     * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
     * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
     */

//    Runtime: 29 ms, faster than 32.45%
//    Memory Usage: 54.7 MB, less than 50.64%
    public static List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        Arrays.stream(nums1).forEach(s1::add);
        Arrays.stream(nums2).forEach(s2::add);

        Iterator<Integer> i = s1.iterator();
        while (i.hasNext()) {
            int value = i.next();
            if (s2.contains(value)) {
                i.remove();
                s2.remove(value);
            }
        }
        return List.of(new ArrayList<>(s1), new ArrayList<>(s2));
    }

//    Runtime: 13 ms, faster than 89.67%
//    Memory Usage: 54.5 MB, less than 71.82%
    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> answer1 = new ArrayList<>();
        ArrayList<Integer> answer2 = new ArrayList<>();

        int block = 1001;
        int crt1;
        int prv1 = block;
        int crt2;
        int prv2 = block;

        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            crt1 = nums1[i];

            if (prv1 == crt1) {
                nums1[i] = block;
            }

            while(j < nums2.length &&
                    (nums2[j] <= crt1 || i == nums1.length - 1)) {
                crt2 = nums2[j];
                if (prv2 == crt2) {
                    nums2[j] = block;
                    j++;
                    continue;
                }

                if (crt2 == crt1) {
                    nums1[i] = block;
                    nums2[j] = block;
                }

                if (nums2[j] != block) {
                    answer2.add(nums2[j]);
                }

                prv2 = crt2;
                j++;
            }

            if (nums1[i] != block) {
                answer1.add(nums1[i]);
            }
            prv1 = crt1;
        }

        return List.of(answer1, answer2);
    }

    //Solutions ---
//    Runtime: 24 ms, faster than 46.11%
//    Memory Usage: 55 MB, less than 35.70%
    public static List<List<Integer>> findDifference3(int[] a1, int[] a2) {
        Set<Integer> s1 = Arrays.stream(a1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(a2).filter(n -> !s1.contains(n)).boxed().collect(Collectors.toSet());
        Arrays.stream(a2).forEach(s1::remove);
        return Arrays.asList(new ArrayList<>(s1), new ArrayList<>(s2));
    }




        public static void main(String[] args) throws IOException {
        int[] nums1 = {3,2,1};
        int[] nums2 = {2,4,6};

        System.out.println(findDifference2(nums1, nums2));
    }
}

