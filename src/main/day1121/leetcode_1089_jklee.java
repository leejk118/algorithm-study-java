package main.day1121;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1089_jklee {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<>();

        for (int a : arr) {
            if (a == 0) {
                q.add(0);
                q.add(0);
                continue;
            }
            q.add(a);
        }

        for (int i = 0, length = arr.length; i < length; ++i) {
            arr[i] = q.poll();
        }
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {1, 0, 2, 3, 0, 4, 5, 0},
                {1, 2, 3}
        };

        for (int[] tc : testcase) {
            new leetcode_1089_jklee().duplicateZeros(tc);
            System.out.println(Arrays.toString(tc));
        }
    }
}
