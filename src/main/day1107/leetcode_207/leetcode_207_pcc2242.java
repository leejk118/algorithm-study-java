package main.day1107.leetcode_207;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class leetcode_207_pcc2242 {
    /**
     * https://leetcode.com/problems/course-schedule/
     *
     * 207. Course Schedule
     *
     */

//    Runtime: 39 ms, faster than 10.46%
//    Memory Usage: 42.3 MB, less than 96.76%
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] root = new ArrayList[numCourses];

        for (int i = 0; i < root.length; i++) {
            root[i] = new ArrayList<>();
        }

        for (int[] arr : prerequisites) {
            root[arr[0]].add(arr[1]);
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < root.length; i++) {
            ArrayList<Integer> current = root[i];
            path.add(i);
            while (current.size() > 0) {
                int next = current.get(0);
                current.remove(0);

                if (path.contains(next)) {
                    return false;
                }

                path.add(next);

                if (root[next].size() > 0) {
                    current = root[next];
                } else {
                    path.remove(path.size() - 1);
                }
            }
            path.clear();
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));

//        System.out.println(canFinish(4, new int[][]{{0, 1},{3, 1}, {1, 3}, {3, 2}}));
    }
}

