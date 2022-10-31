package main.day0907.leetcode_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class leetcode_35_pcc2242 {
    /**
     * https://leetcode.com/problems/search-insert-position/
     *
     * 35. Search Insert Position
     *  return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     */

//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 43.9 MB, less than 22.22%
    public static int searchInsert1(int[] nums, int target) {
        // nums.length 호출 시 memory 사용량 증가
        //Memory Usage: 43.4 MB, less than 60.80%
        int length = nums.length;
        int pivot = length / 2;
        int start = 0;
        int end = length - 1;

        while (true) {
            if (nums[pivot] == target) {
                return pivot;
            } else if (start == end) {
                return nums[pivot] > target ? pivot : pivot + 1;
            } else if (nums[pivot] > target) {
                end = Math.max(pivot - 1, 0);
                pivot = start + (end - pivot) / 2;
            } else {
                start = Math.min(pivot + 1, length - 1);
                pivot = start + (end - pivot) / 2;
            }

        }
    }

//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 43.4 MB, less than 60.80%
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle, value;

        while (left <= right) {
            middle = left + (right - left) / 2;
            value = nums[middle];

            if (value == target) {
                return middle;
            } else if (value < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums1 = {1,3,5,6};
        int target1 = 0;

        int[] nums2 = {1, 3};
        int target2 = 0;

        System.out.println(searchInsert2(nums1, target1));
    }
}

