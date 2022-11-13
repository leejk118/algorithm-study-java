package main.day1107.leetcode_207;

import java.util.*;

public class leetcode_207_jklee {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean answer = true;
        ArrayList<HashSet<Integer>> courseInfo = new ArrayList<>();
        for (int i = 1; i <= numCourses; ++i) {
            courseInfo.add(new HashSet<>());
        }

        for (int[] pre : prerequisites) {
            HashSet<Integer> set = courseInfo.get(pre[0]);
            set.add(pre[1]);
            courseInfo.set(pre[0], set);
        }

        outerloop: for (int i = 0; i < numCourses; ++i) {
            HashSet<Integer> currentSet = new HashSet<>(), nextSet = new HashSet<>();
            for (int course : courseInfo.get(i)) {
                currentSet.add(course);
            }
            while (currentSet.size() > 0) {
                for (int course : currentSet) {
                    for (int c : courseInfo.get(course)) {
                        nextSet.add(c);
                    }
                }
                for (int course : nextSet) {
                    if (currentSet.contains(course)) {
                        answer = false;
                        break outerloop;
                    }
                }
                currentSet = new HashSet<>(nextSet);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] numCourses = {5}; //{2, 2, 4, 4, 3, 5};
        int[][][] prerequisites = {
//                {{1, 0}},
//                {{1, 0}, {0, 1}},
//                {{3, 2}, {2, 1}, {1, 0}},
//                {{3, 2}, {2, 1}, {1, 3}},
//                {{1, 0}, {1, 2}, {0, 1}},
                {{1, 4}, {2, 4}, {3, 1}, {3, 2}}
        };
        for (int i = 0; i < numCourses.length; ++i) {
            System.out.println(new leetcode_207_jklee().canFinish(numCourses[i], prerequisites[i]));
        }
    }
}
