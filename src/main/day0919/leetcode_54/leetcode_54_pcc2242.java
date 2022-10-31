package main.day0919.leetcode_54;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_54_pcc2242 {
    /**
     * https://leetcode.com/problems/spiral-matrix/description/
     *
     * 54. Spiral Matrix
     *
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     */

//    Runtime: 2 ms, faster than 5.22%
//    Memory Usage: 42.7 MB, less than 7.61%
    private static int x;
    private static int y;
    private static int root;
    private static final int BLOCK = 101;

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        x = y = root = 0;

        do {
            answer.add(matrix[y][x]);
            matrix[y][x] = BLOCK;

        } while (setNextPoint(matrix));


        return answer;
    }

    private static boolean setNextPoint(int[][] matrix) {
        if (setNexStep(matrix)) {
            return true;
        }
        root = (root + 1) % 4 ;

        return setNexStep(matrix);
    }

    private static boolean setNexStep(int[][] matrix) {
        try {
            int nextX = x;
            int nextY = y;

            if (root == 0) {
                nextX++;
            } else if (root == 1) {
                nextY++;
            } else if (root == 2) {
                nextX--;
            } else if (root == 3) {
                nextY--;
            }

            if (matrix[nextY][nextX] == BLOCK) {
                throw new Exception();
            }

            x = nextX;
            y = nextY;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 42.4 MB, less than 18.85%
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int row = 0;
        int col = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while (row <= rowEnd && col <= colEnd) {
            for (int i = col; i <= colEnd; i++) {
                answer.add(matrix[row][i]);
            }

            if (row == rowEnd) {
                break;
            }

            for (int i = row + 1; i <= rowEnd; i++) {
                answer.add(matrix[i][colEnd]);
            }

            for (int i = colEnd - 1; i >= col; i--) {
                answer.add(matrix[rowEnd][i]);
            }

            if (col == colEnd) {
                break;
            }

            for (int i = rowEnd - 1; i > row; i--) {
                answer.add(matrix[i][col]);
            }

            row++;
            col++;
            rowEnd--;
            colEnd--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        int[][] matrix3 = {
                {1, 2, 3},
                {4,5,6},
                {7,8,9},
                {10,11,12}};
        int[][] matrix4 = {
                {1},
                {2},
                {3}
        };

        System.out.println(spiralOrder2(matrix4));
    }
}

