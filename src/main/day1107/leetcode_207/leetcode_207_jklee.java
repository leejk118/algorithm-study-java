package main.day1107.leetcode_207;

import java.util.*;

public class leetcode_207_jklee {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] courseInfo = new ArrayList[numCourses];
        Stack<Integer> st = new Stack<>();
        int[] degree = new int [numCourses];

        for (int i = 0; i < numCourses; ++i) {
            courseInfo[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            courseInfo[pre[1]].add(pre[0]);
            degree[pre[0]]++;
        }

        for (int i = 0; i < degree.length; ++i) {
            if (degree[i] == 0) {
                st.add(i);
            }
        }
        int count = 0;
        while (!st.empty()) {
            int course = st.pop();
            for (int c : courseInfo[course]) {
                degree[c]--;
                if (degree[c] == 0) {
                    st.add(c);
                }
            }
            count++;
        }
        return count == numCourses;
    }


    public static void main(String[] args) {
        int[] numCourses = {2, 2, 4, 4, 3, 5, 7};
        int[][][] prerequisites = {
                {{1, 0}},
                {{1, 0}, {0, 1}},
                {{3, 2}, {2, 1}, {1, 0}},
                {{3, 2}, {2, 1}, {1, 3}},
                {{1, 0}, {1, 2}, {0, 1}},
                {{1, 4}, {2, 4}, {3, 1}, {3, 2}},
                {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}
        };

        for (int i = 0; i < numCourses.length; ++i) {
            System.out.println(new leetcode_207_jklee().canFinish(numCourses[i], prerequisites[i]));
        }
    }
}
